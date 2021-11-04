package stage1.hw27

fun main() {
    val size = readLine()!!.toInt()
    val numbers = IntArray(size)

    for (i in 0 until size) {
        numbers[i] = readLine()!!.toInt()
    }

    val target = readLine()!!.toInt()

    for (num in numbers) {
        if (num == target) {
            println("YES")
            return
        }
    }

    println("NO")
}
