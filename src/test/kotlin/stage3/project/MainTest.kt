package stage3.project

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class StdOutCaptureTest {
    private lateinit var byteArrayOutputStream: ByteArrayOutputStream
    private lateinit var printStream: PrintStream
    private lateinit var originalOut: PrintStream

    @BeforeEach
    fun setUp() {
        byteArrayOutputStream = ByteArrayOutputStream()
        printStream = PrintStream(byteArrayOutputStream)
        originalOut = System.out
        System.setOut(printStream)
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
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

    private fun assertOutputEquals(expected: String) {
        printStream.flush()
        val capturedOutput = byteArrayOutputStream.toString().trim()
        assertEquals(expected, capturedOutput)
    }
}
