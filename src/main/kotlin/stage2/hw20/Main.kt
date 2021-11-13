package stage2.hw20

fun greetUser(
    name: String,
    admin: Boolean = false,
    smith: Boolean = false,
    honorific: String = "",
    greet: String = "Greetings"
): String {
    return if (!admin && !smith) {
        "$greet, $honorific $name"
    } else {
        "Matrix Error"
    }
}

fun greetNeo() = greetUser("Anderson", honorific = "Mr.", greet = "Hello")

fun main() {
    println(greetNeo())
}
