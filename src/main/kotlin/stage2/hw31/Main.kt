package stage2.hw31

import java.io.File

fun main() {
    val basedir = File("basedir")

    for (dir in basedir.listFiles()) {
        for (subdir in dir.listFiles()) {
            if (subdir.list().isEmpty()) println(subdir.name)
        }
    }
}
