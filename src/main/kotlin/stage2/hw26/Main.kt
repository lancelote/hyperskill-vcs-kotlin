package stage2.hw26

import java.io.File

fun main() {
    var totalNums = 0
    File("words_with_numbers.txt").forEachLine { if (it.toIntOrNull() != null) totalNums += 1 }
    println(totalNums)
}
