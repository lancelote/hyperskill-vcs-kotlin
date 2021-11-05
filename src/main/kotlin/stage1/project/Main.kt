package stage1.project

val COMMANDS = mapOf(
    "config" to "Get and set a username.",
    "add" to "Add a file to the index.",
    "log" to "Show commit logs.",
    "commit" to "Save changes.",
    "checkout" to "Restore a file.",
)

fun printHelp() {
    println("These are SVCS commands:")

    for ((k, v) in COMMANDS) {
        println("${k.padEnd(10)} $v")
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty() || args[0] == "--help") {
        printHelp()
    } else {
        val command = args[0]
        println(COMMANDS[command] ?: "'$command' is not a SVCS command.")
    }
}
