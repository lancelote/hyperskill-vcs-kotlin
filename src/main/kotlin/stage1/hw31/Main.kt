package stage1.hw31

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    var near = false

    for (num in nums) {
        if (num == p || num == m) {
            if (near) {
                println("NO")
                return
            } else {
                near = true
            }
        } else {
            near = false
        }
    }

    println("YES")
}
