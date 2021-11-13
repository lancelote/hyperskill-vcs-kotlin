package stage2.hw24

fun getPrice(years: Int = 5, kms: Int = 100_000, maxSpeed: Int = 120, autoTransmission: Boolean = false): Int {
    var price = 20_000

    price -= 2_000 * years
    price += 100 * (maxSpeed - 120)
    price -= 200 * (kms / 10_000)
    if (autoTransmission) price += 1500

    return price
}

fun main() {
    println(when (readLine()!!) {
        "old" -> getPrice(years = readLine()!!.toInt())
        "passed" -> getPrice(kms = readLine()!!.toInt())
        "speed" -> getPrice(maxSpeed = readLine()!!.toInt())
        "auto" -> getPrice(autoTransmission = readLine()!!.toInt() == 1)
        else -> 0
    })
}
