package stage2.hw23

import kotlin.math.pow

fun compound(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    val result = amount.toDouble() * (1.0 + percent.toDouble() / 100.0).pow(years.toDouble())
    return result.toInt()
}

fun main() {
    println(when (readLine()!!) {
        "amount" -> compound(amount = readLine()!!.toInt())
        "percent" -> compound(percent = readLine()!!.toInt())
        "years" -> compound(years = readLine()!!.toInt())
        else -> 0
    })
}
