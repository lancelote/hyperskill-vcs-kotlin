package stage3.project

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
        main(arrayOf("log"))
        assertOutputEquals("No commits yet.")
    }

    @Test
    fun testNoCommitMessage() {
        main(arrayOf("commit"))
        assertOutputEquals("Message was not passed.")
    }

    @Test
    fun testNothingToCommit() {
        main(arrayOf("commit", "some message"))
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

    private fun assertOutputEquals(expected: String) {
        printStream.flush()
        val capturedOutput = byteArrayOutputStream.toString().trim()
        assertEquals(expected, capturedOutput)
    }
}
