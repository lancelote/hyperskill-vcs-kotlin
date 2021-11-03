package stage1.hw26

fun main() {
    val firstList = readLine()!!.split(' ').map { it }.toMutableList()
    val secondList = readLine()!!.split(' ').map { it }.toMutableList()

    println((firstList + secondList).joinToString(separator = ", "))
}
