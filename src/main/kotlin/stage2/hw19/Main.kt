package stage2.hw19

fun concatenate(a: String, b: String, c: String, sep: String = " ") = "$a$sep$b$sep$c"

fun main() {
    val (a, b, c, sep) = Array(4) { readLine()!! }

    println(when (sep) {
        "NO SEPARATOR" -> concatenate(a, b, c)
        else -> concatenate(a, b, c, sep)
    })
}
