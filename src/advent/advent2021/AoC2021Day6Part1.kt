package advent.advent2021

private var result = 0

fun main() {
    result = test(
        """
            3,4,3,1,2
    """.trimIndent(), 18
    )
    check(26, result)

    result = test(
        """
            3,4,3,1,2
    """.trimIndent(), 80
    )
    check(5934, result)

    result = test(
        """
            4,1,1,1,5,1,3,1,5,3,4,3,3,1,3,3,1,5,3,2,4,4,3,4,1,4,2,2,1,3,5,1,1,3,2,5,1,1,4,2,5,4,3,2,5,3,3,4,5,4,3,5,4,2,5,5,2,2,2,3,5,5,4,2,1,1,5,1,4,3,2,2,1,2,1,5,3,3,3,5,1,5,4,2,2,2,1,4,2,5,2,3,3,2,3,4,4,1,4,4,3,1,1,1,1,1,4,4,5,4,2,5,1,5,4,4,5,2,3,5,4,1,4,5,2,1,1,2,5,4,5,5,1,1,1,1,1,4,5,3,1,3,4,3,3,1,5,4,2,1,4,4,4,1,1,3,1,3,5,3,1,4,5,3,5,1,1,2,2,4,4,1,4,1,3,1,1,3,1,3,3,5,4,2,1,1,2,1,2,3,3,5,4,1,1,2,1,2,5,3,1,5,4,3,1,5,2,3,4,4,3,1,1,1,2,1,1,2,1,5,4,2,2,1,4,3,1,1,1,1,3,1,5,2,4,1,3,2,3,4,3,4,2,1,2,1,2,4,2,1,5,2,2,5,5,1,1,2,3,1,1,1,3,5,1,3,5,1,3,3,2,4,5,5,3,1,4,1,5,2,4,5,5,5,2,4,2,2,5,2,4,1,3,2,1,1,4,4,1,5
    """.trimIndent(), 80
    )
    check(352195, result)
}

private fun test(input: String, days: Int): Int {
    val fishes = input.split(",").map { it.toInt() }.toMutableList()

    for (day in 1..days) {
        var newCount = 0
        for (i in fishes.indices) {
            if (fishes[i] == 0) {
                newCount += 1
                fishes[i] = 6
            } else {
                fishes[i] -= 1
            }
        }
        for (i in 0 until newCount) fishes += 8
    }

    return fishes.size
}
