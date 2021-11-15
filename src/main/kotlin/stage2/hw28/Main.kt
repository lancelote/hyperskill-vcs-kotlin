package stage2.hw28

import java.io.File

fun main() {
    val text = readLine()!!
    val myFile = File("MyFile.txt")
    myFile.writeText(text)
    myFile.appendText(text)
}
