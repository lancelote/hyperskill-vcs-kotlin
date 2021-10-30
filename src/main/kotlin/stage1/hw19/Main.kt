package stage1.hw19

fun main() {
    val (a, b) = List(2) { readLine()!!.toLong() }
    var product = 1L

    for (x in a until b) product *= x

    println(product)
}
