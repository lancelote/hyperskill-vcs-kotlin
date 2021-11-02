package stage1.hw24

fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Invalid number of program arguments")
        return
    }

    for ((i, arg) in args.withIndex()) {
        println("Argument ${i + 1}: $arg. It has ${arg.length} characters",)
    }
}
