package stage2.hw13

fun main() {
    val (first, op, second) = readLine()!!.split(" ")
    val num1 = first.toLong()
    val num2 = second.toLong()

    println(when (op) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "/" -> if (num2 == 0L) "Division by 0!" else num1 / num2
        "*" -> num1 * num2
        else -> "Unknown operator"
    })
}
