package stage2.hw12

fun main() {
    val (first, op, second) = Array(3) { readLine()!! }

    println(when (op) {
        "equals" -> first == second
        "plus" -> first + second
        "endsWith" -> first.endsWith(second)
        else -> "Unknown operation"
    })
}
