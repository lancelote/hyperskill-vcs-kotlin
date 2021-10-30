package stage1.hw17

fun main() {
    val (start, end, divisor) = List(3) { readLine()!!.toInt() }
    var total = 0

    for (num in start..end) {
        if (num % divisor == 0) total++
    }

    println(total)
}
