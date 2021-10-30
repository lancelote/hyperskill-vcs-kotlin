package stage1.hw15

fun main() {
    val start = readLine()!!.toInt()
    val end = readLine()!!.toInt()

    for (num in start..end) {
        if (num % 3 == 0 && num % 5 == 0) {
            println("FizzBuzz")
        } else if (num % 3 == 0) {
            println("Fizz")
        } else if (num % 5 == 0) {
            println("Buzz")
        } else {
            println(num)
        }
    }
}
