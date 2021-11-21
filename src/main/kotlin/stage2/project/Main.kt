package stage2.project

import java.io.File

const val VCS_DIR_NAME = "vcs"
const val CONFIG_FILE_NAME = "config.txt"
const val INDEX_FILE_NAME = "index.txt"

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

fun getVcsDir(): File {
    val vcsDir = File(VCS_DIR_NAME)
    if (!vcsDir.exists()) vcsDir.mkdir()

    assert(vcsDir.isDirectory) { "cannot create '$VCS_DIR_NAME' directory - there's such file" }
    return vcsDir
}

fun getVcsFile(fileName: String): File {
    val file = getVcsDir().resolve(File(fileName))
    if (!file.exists()) file.createNewFile()

    assert(file.isFile) { "cannot create '$fileName' file - there's such directory in '$VCS_DIR_NAME'"}
    return file
}

fun getConfigFile() = getVcsFile(CONFIG_FILE_NAME)

fun getIndexFile() = getVcsFile(INDEX_FILE_NAME)

fun config(name: String?) {
    val configFile = getConfigFile()
    val nameInConfig = configFile.readText()

    if (name == null && nameInConfig.isEmpty()) {
        println("Please, tell me who you are.")
    } else if (name == null && nameInConfig.isNotEmpty()) {
        println("The username is $nameInConfig.")
    } else {
        configFile.writeText(name!!)
        println("The username is $name.")
    }
}

fun add(file: String?) {
    val indexFile = getIndexFile()

    if (file == null) {

    } else {

    }
}

fun main(args: Array<String>) {
    val command = args.firstOrNull()
    val argument = args.elementAtOrNull(1)

    when (command) {
        "--help" -> printHelp()
        "config" -> config(argument)
        "add" -> add(argument)
        else -> println("'$command' is not a SVCS command.")
    }
}
