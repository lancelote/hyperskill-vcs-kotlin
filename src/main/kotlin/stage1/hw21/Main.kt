package stage1.hw21

fun main() {
    val numbers = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    numbers[0] = numbers[numbers.lastIndex].also { numbers[numbers.lastIndex] = numbers[0] }

    println(numbers.joinToString(separator = " "))
}
