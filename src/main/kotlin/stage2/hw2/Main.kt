package stage2.hw2

fun identity(num: Int) = num

fun half(num: Int) = num / 2

fun zero(num: Int) = 0

fun generate(functionName: String): (Int) -> Int {
    return when (functionName) {
        "identity" -> ::identity
        "half" -> ::half
        "zero" -> ::zero
        else -> ::zero
    }
}
