package stage1.hw35

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }

    var triplets = 0

    for (i in 2..nums.lastIndex) {
        if (nums[i - 2] + 1 == nums[i - 1] && nums[i - 1] + 1 == nums[i]) triplets++
    }

    println(triplets)
}
