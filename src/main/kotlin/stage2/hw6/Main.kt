package stage2.hw6

fun main() {
    val num = readLine()!!.toInt()

    println(when (num) {
        in 0..9 -> 1
        in 10..99 -> 2
        in 100..999 -> 3
        in 1000..9999 -> 4
        else -> -1
    })
}
