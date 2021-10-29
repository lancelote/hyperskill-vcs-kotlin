package stage1.hw10

fun main() {
    val (num, start, end) = List(3) { readLine()!!.toInt() }
    println(num in start..end)
}
