package stage2.hw25

import java.io.File

fun main() {
    var longestLen = 0
    val file = File("words_sequence.txt")
    file.forEachLine { if (it.length > longestLen) longestLen = it.length }
    println(longestLen)
}
