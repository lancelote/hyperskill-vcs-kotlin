package stage2.hw31

import java.io.File

/**
 * Find empty subdirs under top-level dirs in basedir
 */
fun main() {
    val basedir = File("basedir")

    for (dir in basedir.listFiles()) {
        for (subdir in dir.listFiles()) {
            subdir.list()?.let {
                if (it.isEmpty()) println(subdir.name)
            }
        }
    }
}
