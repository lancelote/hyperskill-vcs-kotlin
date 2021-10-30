package stage1.hw20

fun main() {
    val nums = readLine()!!.toInt()

    var largest1 = 1
    var largest2 = 1

    repeat(nums) {
        val num = readLine()!!.toInt()

        if (num > largest1) {
            if (largest1 > largest2) largest2 = largest1
            largest1 = num
        } else if (num > largest2) {
            largest2 = num
        }
    }

    println(largest1 * largest2)
}
