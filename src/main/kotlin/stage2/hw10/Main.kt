package stage2.hw10

fun main() {
    val num = readLine()!!.toInt()

    println(when (num) {
        1, 3, 4 -> "No!"
        2 -> "Yes!"
        else -> "Unknown number"
    })
}
