package stage3.project

import java.io.File
import java.io.FileInputStream
import java.security.MessageDigest

const val VCS_DIR_NAME = "vcs"
const val COMMITS_DIR_NAME = "commits"
const val CONFIG_FILE_NAME = "config.txt"
const val INDEX_FILE_NAME = "index.txt"
const val LOG_FILE_NAME = "log.txt"

val COMMANDS_HELP = mapOf(
    "config" to "Get and set a username.",
    "add" to "Add a file to the index.",
    "log" to "Show commit logs.",
    "commit" to "Save changes.",
    "checkout" to "Restore a file.",
)

fun printHelp() {
    println("These are SVCS commands:")

    for ((commandName, helpLine) in COMMANDS_HELP) {
        println("${commandName.padEnd(10)} $helpLine")
    }
}

fun getFile(fileName: String): File {
    val workDir = File(System.getProperty("user.dir"))
    return workDir.resolve(fileName)
}

fun getOrCreateDir(dirName: String): File {
    val workDir = File(System.getProperty("user.dir"))
    val dir = workDir.resolve(dirName)

    if (!dir.exists()) dir.mkdir()

    assert(dir.isDirectory) { "cannot create '${dir.name}' directory - there's such file" }
    return dir
}

fun getVcsDir() = getOrCreateDir(VCS_DIR_NAME)

fun getCommitsDir() = getOrCreateDir(getVcsDir().resolve(COMMITS_DIR_NAME).path)

fun getVcsSettingsFile(fileName: String): File {
    val file = getVcsDir().resolve(File(fileName))
    if (!file.exists()) file.createNewFile()

    assert(file.isFile) { "cannot create '$fileName' file - there's such directory in '$VCS_DIR_NAME'"}
    return file
}

fun getConfigFile() = getVcsSettingsFile(CONFIG_FILE_NAME)

fun getIndexFile() = getVcsSettingsFile(INDEX_FILE_NAME)

fun getLogFile() = getVcsSettingsFile(LOG_FILE_NAME)

fun config(name: String?) {
    val configFile = getConfigFile()
    val nameInConfig = configFile.readText()

    if (name == null && nameInConfig.isEmpty()) {
        println("Please, tell me who you are.")
    } else if (name == null) {
        println("The username is $nameInConfig.")
    } else {
        configFile.writeText(name)
        println("The username is $name.")
    }
}

fun add(newFilename: String?) {
    val indexFile = getIndexFile()
    val filenamesInIndex = indexFile.readLines()

    if (newFilename == null && filenamesInIndex.isEmpty()) {
        println(COMMANDS_HELP["add"])
    } else if (newFilename == null) {
        println("Tracked files:")
        filenamesInIndex.forEach(::println)
    } else {
        val newFile = getFile(newFilename)
        if (newFile.exists()) {
            indexFile.appendText("$newFilename\n")
            println("The file '$newFilename' is tracked.")
        } else {
            println("Can't find '$newFilename'.")
        }
    }
}

fun log() {
    val logFile = getLogFile()
    val logFileContent = logFile.readText()

    if (logFileContent.isEmpty()) {
        println("No commits yet.")
    } else {
        println(logFileContent)
    }
}

fun bytesToHex(bytes: ByteArray): String {
    val sb = StringBuilder()
    for (byte in bytes) {
        sb.append(String.format("%02x", byte))
    }
    return sb.toString()
}

fun filesToHash(files: List<File>): String? {
    if (files.isEmpty()) return null

    val buffer = ByteArray(1024)
    val digest = MessageDigest.getInstance("SHA-256")

    files.forEach { file ->
        FileInputStream(file).use { fis ->
            var bytesRead = fis.read(buffer)
            while (bytesRead != -1) {
                digest.update(buffer, 0, bytesRead)
                bytesRead = fis.read(buffer)
            }
        }
    }

    return bytesToHex(digest.digest())
}

fun getIndexedFiles(): List<File> {
    val indexFile = getIndexFile()
    val indexFileContent = indexFile.readText()
    return indexFileContent.lines().filter { it.isNotEmpty() } .map { getFile(it) }
}

fun getIndexedFilesHash() = filesToHash(getIndexedFiles())

fun getLatestCommitHash(): String? {
    val logFile = getLogFile()
    val logFileContent = logFile.readText()

    if (logFileContent.isEmpty()) return null

    val latestCommit = logFileContent.split("\n\n").last()
    return latestCommit.lines().first().split(" ").last()
}

fun hasChanges(): Boolean {
    val latestCommitHash = getLatestCommitHash()
    val indexedFilesHash = getIndexedFilesHash() ?: return false

    if (latestCommitHash == null) return true

    return latestCommitHash != indexedFilesHash
}

fun copyIndexedFilesTo(commitDir: File) = getIndexedFiles()
    .forEach {
        val newFile = commitDir.resolve(it.name)
        it.copyTo(newFile)
    }

fun saveChanges(message: String?) {
    val hash = getIndexedFilesHash()!!
    val author = getConfigFile().readText()
    val commit = "commit $hash\nAuthor: $author\n$message\n\n"

    val logFile = getLogFile()
    val oldLog = logFile.readText()

    logFile.writeText(commit)
    logFile.appendText(oldLog)

    val commitsDir = getCommitsDir()
    val newCommitDir = getOrCreateDir(commitsDir.resolve(hash).path)
    copyIndexedFilesTo(newCommitDir)
}

fun commit(message: String?) {
    if (message == null) {
        println("Message was not passed.")
    } else if (hasChanges()) {
        saveChanges(message)
        println("Changes are committed.")
    } else {
        println("Nothing to commit.")
    }
}

fun checkout() = println(COMMANDS_HELP["checkout"])

fun main(args: Array<String>) {
    val command = args.firstOrNull()
    val argument = args.elementAtOrNull(1)

    when (command) {
        "--help", null -> printHelp()
        "config" -> config(argument)
        "add" -> add(argument)
        "log" -> log()
        "commit" -> commit(argument)
        "checkout" -> checkout()
        else -> println("'$command' is not a SVCS command.")
    }
}

// ToDo: introduce CI
