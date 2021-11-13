package stage2.hw21

fun warn(speed: Int, limit: Int = 60) = when {
    speed <= limit -> println("Within the limit")
    else -> println("Exceeds the limit by ${speed - limit} kilometers per hour")
}

fun main() {
    val speed = readLine()!!.toInt()

    when (val limitStr = readLine()!!) {
        "no limit" -> warn(speed)
        else -> warn(speed, limitStr.toInt())
    }
}
