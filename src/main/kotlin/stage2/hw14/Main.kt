package stage2.hw14

import kotlin.math.sqrt

val PI = 3.14

fun main() {
    val shape = readLine()!!

    println(when (shape) {
        "triangle" -> {
            val (a, b, c) = Array(3) { readLine()!!.toDouble() }
            val s =  (a + b + c) / 2.0
            sqrt(s * (s - a) * (s - b) * (s - c))
        }
        "rectangle" -> {
            val (a, b) = Array(2) { readLine()!!.toDouble() }
            a * b
        }
        "circle" -> {
            val r = readLine()!!.toDouble()
            PI * r * r
        }
        else -> -1
    })
}
