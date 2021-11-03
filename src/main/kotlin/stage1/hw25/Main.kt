package stage1.hw25

fun main() {
    val numbers = readLine()!!.split(' ').map{it.toInt()}.toMutableList()
    val sum = numbers.sum()

    for (i in numbers.lastIndex - 1 downTo 1) {
        numbers[i] = numbers[i - 1]
    }
    numbers[0] = sum

    println(numbers.joinToString(" "))
}
