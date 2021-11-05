package stage1.hw37

fun main() {
    println(summator(mapOf(100 to 10, 55 to 3, 112 to 5)))
}

fun summator(map: Map<Int, Int>): Int {
    var total = 0

    for ((k, v) in map) {
        if (k % 2 == 0) total += v
    }

    return total
}
