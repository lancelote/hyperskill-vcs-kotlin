package stage3.hw2

fun hashArray(array: Array<Int>, p: Int) = array.fold(0) { acc, x -> acc * p + x }

fun hasArrayOfArrays(array: Array<Array<Int>>, p: Int) = array.fold(0) { acc, x -> acc * p + hashArray(x, p) }

fun main() {
    println(hasArrayOfArrays(arrayOf(arrayOf(1, 2), arrayOf(2, 3)), 2))
}
