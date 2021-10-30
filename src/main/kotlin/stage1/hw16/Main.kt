package stage1.hw16

fun main() {
    val (a, b, c, d) = List(4) { readLine()!!.toInt() }

    fun root(x: Int) = a * x * x * x + b * x * x + c * x + d == 0

    for (x in 0..1000) if (root(x)) println(x)
}
