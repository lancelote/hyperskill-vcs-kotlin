package stage1.hw30

import java.util.Collections

fun main() {
    val size = readLine()!!.toInt()
    val nums = List(size) { readLine()!!.toInt() }
    val shift = readLine()!!.toInt()
    Collections.rotate(nums, shift)
    println(nums.joinToString(separator = " "))
}
