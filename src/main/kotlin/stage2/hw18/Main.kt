package stage2.hw18

fun great(name: String = "secret user") = println("Hello, $name!")

fun main() {

    when (val name = readLine()!!) {
        "HIDDEN" -> great()
        else -> great(name)
    }
}
