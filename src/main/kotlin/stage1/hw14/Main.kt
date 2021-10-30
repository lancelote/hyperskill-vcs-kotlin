package stage1.hw14

fun main() {
    val start = readLine()!!.toInt()
    val end = readLine()!!.toInt()

    var total = 0

    for (x in start..end) {
        total += x
    }

    println(total)
}
