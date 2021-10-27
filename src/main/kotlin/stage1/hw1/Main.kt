package stage1.hw1

import kotlin.math.abs

fun getLastDigit(number: Int): Int {
    return abs(number % 10)
}

fun main() {
    val a = readLine()!!.toInt()
    println(getLastDigit(a))
}
