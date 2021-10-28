package stage1.hw6

fun main() {
    val string = readLine()!!
    val num = readLine()!!.toInt()

    println("Symbol # $num of the string \"$string\" is '${string[num - 1]}'")
}
