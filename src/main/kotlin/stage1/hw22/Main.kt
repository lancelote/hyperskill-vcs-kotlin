package stage1.hw22

fun main() {
    var backFromTheWall = readLine()!!.split(',').map { it }.toTypedArray()
    val returnedWatchman = readLine()!!.toString()
    println((backFromTheWall + returnedWatchman).joinToString())
}
