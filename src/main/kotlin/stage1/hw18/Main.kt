package stage1.hw18

fun main() {
    val nums = readLine()!!.toInt()
    var total = 0

    repeat(nums) {
        total += readLine()!!.toInt()
    }

    println(total)
}
