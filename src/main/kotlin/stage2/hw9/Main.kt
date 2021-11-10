package stage2.hw9

fun main() {
    val num = readLine()!!.toInt()

    println(when (num) {
        0, 1, 2, 3, 5, 8, 13, 21, 34, 55 -> 'F'
        0, 1, 3, 6, 10, 15, 21, 28, 36, 45 -> 'T'
        1, 10, 100, 1000, 10000, 100000 -> 'P'
        else -> 'N'
    })
}
