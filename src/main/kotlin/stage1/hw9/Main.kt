package stage1.hw9

fun main() {
    val (start1, end1, start2, end2, num) = List(5) { readLine()!!.toInt() }
    print(num in start1..end1 && num in start2..end2)
}
