package stage1.hw23

fun main() {
    val beyondTheWall = readLine()!!.split(',').map { it }.toTypedArray()
    val backFromTheWall = readLine()!!.split(',').map { it }.toTypedArray()

    outer@ for (beyond in beyondTheWall) {
        for (back in backFromTheWall) {
            if (beyond == back) continue@outer
        }
        println(false)
        return
    }

    println(true)
}
