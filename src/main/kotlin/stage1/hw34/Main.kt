package stage1.hw34

fun main() {
    val size = readLine()!!.toInt()
    val nums = IntArray(size) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    if (nums.indexOf(p) > -1 && nums.indexOf(m) > -1) {
        println("YES")
    } else {
        println("NO")
    }
}
