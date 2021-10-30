package stage1.hw11

fun main() {
    var min = Int.MAX_VALUE
    val total = readLine()!!.toInt()

    repeat(total) {
        val num = readLine()!!.toInt()
        if (num < min) min = num
    }

    println(min)
}
