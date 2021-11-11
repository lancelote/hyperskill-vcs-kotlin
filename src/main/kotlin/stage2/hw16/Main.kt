package stage2.hw16

fun f(x: Double) = when {
    x <= 0 -> f1(x)
    0 < x && x < 1 -> f2(x)
    x >= 1 -> f3(x)
    else -> 0
}

fun f1(x: Double) = x * x + 1

fun f2(x: Double) = 1 / (x * x)

fun f3(x: Double) = x * x - 1
