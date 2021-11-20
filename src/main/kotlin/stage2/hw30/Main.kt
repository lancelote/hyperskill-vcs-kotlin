package stage2.hw30

import java.io.File

fun main() {
    val basedir = File("basedir")
    val deepestFile = basedir.walkBottomUp().maxByOrNull { it.path.length }
    println(deepestFile!!.name)
}
