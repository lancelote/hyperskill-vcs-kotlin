package stage2.hw15

fun main() {
    val input = readLine()!!

    println(when (input.firstOrNull()) {
        'i' -> input.substring(1).toInt() + 1
        's' -> input.substring(1).reversed()
        else -> input
    })
}
