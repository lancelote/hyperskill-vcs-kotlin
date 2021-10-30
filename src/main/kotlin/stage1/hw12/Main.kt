package stage1.hw12

fun main() {
    var previous = Int.MIN_VALUE

    repeat(readLine()!!.toInt()) {
        val current = readLine()!!.toInt()

        if (current < previous) {
            println("NO")
            return
        }

        previous = current
    }

    println("YES")
}
