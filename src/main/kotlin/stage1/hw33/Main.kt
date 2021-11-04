package stage1.hw33

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }

    var maxValue = 0
    var maxIndex = 0

    for ((i, num) in nums.withIndex()) {
        if (num > maxValue) {
            maxValue = num
            maxIndex = i
        }
    }

    println(maxIndex)
}
