package stage4.project

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.CleanupMode
import org.junit.jupiter.api.io.TempDir
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.createFile
import kotlin.io.path.writeText

class StdOutCaptureTest {
    private lateinit var byteArrayOutputStream: ByteArrayOutputStream
    private lateinit var printStream: PrintStream
    private lateinit var originalOut: PrintStream

    @TempDir(cleanup = CleanupMode.ON_SUCCESS)
    private lateinit var tempDir: Path

    private lateinit var originalWorkingDir: String

    @BeforeEach
    fun setUp() {
        // Capture STDOUT
        byteArrayOutputStream = ByteArrayOutputStream()
        printStream = PrintStream(byteArrayOutputStream)
        originalOut = System.out
        System.setOut(printStream)

        // Set up a temporary working directory
        originalWorkingDir = System.getProperty("user.dir")
        System.setProperty("user.dir", tempDir.toString())
    }

    @AfterEach
    fun tearDown() {
        // Restore STDOUT
        System.setOut(originalOut)

        // Restore working directory
        System.setProperty("user.dir", originalWorkingDir)
    }

    @Test
    fun testNoCommits() {
        runCommand("log")
        assertOutputEquals("No commits yet.")
    }

    @Test
    fun testNoCommitMessage() {
        runCommand("commit")
        assertOutputEquals("Message was not passed.")
    }

    @Test
    fun testNothingToCommit() {
        runCommand("commit", "some message")
        assertOutputEquals("Nothing to commit.")
    }

    @Test
    fun testFilesToHash() {
        val tempFile1: File = Files.createTempFile("foo", ".tmp").toFile()
        val tempFile2: File = Files.createTempFile("bar", ".tmp").toFile()

        tempFile1.writeText("foo")
        tempFile2.writeText("bar")

        val expSHA256 = "c3ab8ff13720e8ad9047dd39466b3c8974e592c2fa383d4a3960714caef0c4f2"
        assertEquals(expSHA256, filesToHash(listOf(tempFile1, tempFile2)))
    }

    @Test
    fun hyperskillExample() {
        val file1 = tempDir.resolve("file1.txt").createFile()
        file1.writeText("hello world1")

        val file2 = tempDir.resolve("file2.txt").createFile()
        file2.writeText("hello world2")

        tempDir.resolve("untracked_file.txt").createFile()

        runCommand("config", "Pavel")
        assertOutputEquals("The username is Pavel.")

        runCommand("log")
        assertOutputEquals("No commits yet.")

        runCommand("add", "file1.txt")
        assertOutputEquals("The file 'file1.txt' is tracked.")

        runCommand("commit", "Added several lines of code to the file1.txt")
        assertOutputEquals("Changes are committed.")

        runCommand("log")
        assertOutputEquals("""
            commit 916e14036f2d86a479ab16a3f2cffaf73a5419d12576497cc2d837fb423571a5
            Author: Pavel
            Added several lines of code to the file1.txt
        """.trimIndent())

        runCommand("add", "file2.txt")
        assertOutputEquals("The file 'file2.txt' is tracked.")

        runCommand("commit", "Changed several lines of code in the file2.txt")
        assertOutputEquals("Changes are committed.")

        runCommand("log")
        assertOutputEquals("""
            commit 51f953dfd60527c26071af3d83947815b69b5801a163eeeae34d71c97d2320d4
            Author: Pavel
            Changed several lines of code in the file2.txt

            commit 916e14036f2d86a479ab16a3f2cffaf73a5419d12576497cc2d837fb423571a5
            Author: Pavel
            Added several lines of code to the file1.txt
        """.trimIndent())

        runCommand("commit", "Files were not changed")
        assertOutputEquals("Nothing to commit.")

        runCommand("commit")
        assertOutputEquals("Message was not passed.")

        runCommand("checkout", "916e14036f2d86a479ab16a3f2cffaf73a5419d12576497cc2d837fb423571a5")
        assertOutputEquals("Switched to commit 916e14036f2d86a479ab16a3f2cffaf73a5419d12576497cc2d837fb423571a5.")

        runCommand("checkout", "fb92cc1be7f60c8d9acf74cbd4a67841d8d2e844")
        assertOutputEquals("Commit does not exist.")

        runCommand("checkout")
        assertOutputEquals("Commit id was not passed.")
    }

    private fun runCommand(vararg command: String) {
        main(arrayOf(*command))
    }

    private fun assertOutputEquals(expected: String) {
        printStream.flush()
        val capturedOutput = byteArrayOutputStream.toString().trim()
        assertEquals(expected, capturedOutput)
        byteArrayOutputStream.reset()
    }
}
