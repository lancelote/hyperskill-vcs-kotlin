package stage3.hw1

fun hash(array: Array<Int>, p: Int) = array.fold(0) { acc, x -> acc * p + x }

fun main() {
    println(hash(arrayOf(1, 2, 3), 3))
}
