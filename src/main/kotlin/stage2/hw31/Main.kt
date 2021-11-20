package stage2.hw31

import java.io.File

/**
 * Find empty subdirs under top-level dirs in basedir
 */
fun main() {
    val basedir = File("basedir")

    basedir.listFiles()?.forEach { dir ->
        dir.listFiles()?.forEach { subdir ->
            subdir.list()?.let {
                if (it.isEmpty()) println(subdir.name)
            }
        }
    }
}
