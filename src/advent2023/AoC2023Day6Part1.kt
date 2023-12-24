package advent2023

import utils.SPACES

private var result = 0

fun main() {
    result = test(
        """
            Time:      7  15   30
            Distance:  9  40  200
    """.trimIndent()
    )
    check(288, result)

    result = test(
        """
            Time:        46     80     78     66
            Distance:   214   1177   1402   1024
    """.trimIndent()
    )
    check(512295, result)
}

//  w * (t-w) >= d, 0 <= w < t
private fun test(input: String): Int {
    val (t1, t2) = input.split("\n")
    val times = t1.removePrefix("Time:").split(SPACES).filter { it.isNotEmpty() }.map { it.toInt() }
    val distances = t2.removePrefix("Distance:").split(SPACES).filter { it.isNotEmpty() }.map { it.toInt() }
    var prod = 1
    for (i in times.indices) {
        val time = times[i]
        val distance = distances[i]
        var winCount = 0
        for (w in 0 until time) {
            val win = w * (time - w) > distance
            if (win) {
                ++winCount
            }
        }
        prod *= winCount
    }
    return prod
}
