package stage1.hw13

fun main() {
    var longestStreak = 0
    var currentStreak = 0
    var previousNum = Int.MIN_VALUE

    val totalNums = readLine()!!.toInt()

    repeat(totalNums) {
        val currentNum = readLine()!!.toInt()

        if (currentNum >= previousNum) {
            currentStreak++
            if (currentStreak > longestStreak) longestStreak = currentStreak
        } else {
            currentStreak = 1
        }

        previousNum = currentNum
    }

    println(longestStreak)
}
