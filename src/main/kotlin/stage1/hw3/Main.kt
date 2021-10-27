package stage1.hw3

fun isVowel(letter: Char) = when (letter.lowercaseChar()) {
    'a', 'e', 'i', 'o', 'u' -> true
    else -> false
}

fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}
