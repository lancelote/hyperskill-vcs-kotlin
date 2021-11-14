package stage2.hw27

import java.io.File

fun main() {
    var words = 0

    File("text.txt").forEachLine {
        words += it.split(" ").size
    }

    println(words)
}
