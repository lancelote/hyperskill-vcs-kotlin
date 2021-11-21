package stage2.project

val COMMANDS_HELP = mapOf(
    "config" to "Get and set a username.",
    "add" to "Add a file to the index.",
    "log" to "Show commit logs.",
    "commit" to "Save changes.",
    "checkout" to "Restore a file.",
)

fun printHelp() {
    println("These are SVCS commands:")

    for ((commandName, helpLine) in COMMANDS_HELP) {
        println("${commandName.padEnd(10)} $helpLine")
    }
}

fun config() {}

fun add() {}

fun main(args: Array<String>) {
    when (val command = args.firstOrNull()) {
        "--help" -> printHelp()
        "config" -> config()
        "add" -> add()
        else -> println("'$command' is not a SVCS command.")
    }
}
