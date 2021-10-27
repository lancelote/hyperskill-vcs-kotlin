package stage1.hw4

fun isRightEquation(a: Int, b: Int, c: Int) = a * b == c

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    println(isRightEquation(a, b, c))
}
