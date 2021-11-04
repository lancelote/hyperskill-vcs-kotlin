package stage1.hw32

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }
    val target = readLine()!!.toInt()
    println(nums.count { it == target })
}
