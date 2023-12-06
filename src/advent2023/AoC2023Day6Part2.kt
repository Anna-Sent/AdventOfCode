package advent2023

private var result = 0

fun main() {
    result = test(
        """
            Time:      7  15   30
            Distance:  9  40  200
    """.trimIndent()
    )
    check(71503, result)

    result = test(
        """
            Time:        46     80     78     66
            Distance:   214   1177   1402   1024
    """.trimIndent()
    )
    check(36530883, result)
}

//  w * (t-w) >= d, 0 <= w < t
private fun test(input: String): Int {
    val (t1, t2) = input.split("\n")
    val time = t1.removePrefix("Time:").split(SPACES).reduce { acc, s -> acc + s }.toLong()
    val distance = t2.removePrefix("Distance:").split(SPACES).reduce { acc, s -> acc + s }.toLong()
    var winCount = 0
    for (w in 0 until time) {
        val win = w * (time - w) > distance
        if (win) {
            ++winCount
        }
    }
    return winCount
}
