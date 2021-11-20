package stage2.hw29

import java.io.File

fun main() {
    val basedir = File("basedir")
    var maxFilesDir = ""
    var maxFilesNum = 0

    val dirs = basedir.listFiles()

    if (dirs != null) {
        for (dir in dirs) {
            val files = dir.list()
            if (files != null) {
                val dirContainsNum = files.count()
                if (dirContainsNum > maxFilesNum) {
                    maxFilesDir = dir.name
                    maxFilesNum = dirContainsNum
                }
            }
        }
    }

    println(maxFilesDir)
    println(maxFilesNum)
}
