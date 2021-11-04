package stage1.hw29

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }

    val last = nums.last()

    for (i in nums.lastIndex downTo  1) {
        nums[i] = nums[i - 1]
    }

    nums[0] = last
    println(nums.joinToString(separator = " "))
}
