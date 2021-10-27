package stage1.hw2

fun divide(a: Long, b: Long) = a.toDouble() / b.toDouble()

fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    println(divide(a, b))
}
