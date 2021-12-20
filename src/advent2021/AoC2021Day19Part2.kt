package advent2021

import kotlin.math.max

private var result = 0

fun main() {
    result = test(INPUT_2021_19_1)
    check(3621, result)

    result = test(INPUT_2021_19_2)
    check(12166, result)

    result = test(INPUT_2021_19_3)
    check(15672, result)
}

private fun test(input: String): Int {
    val (positions, _) = findPositions(input)
    var max = 0
    for (i in 0 until positions.lastIndex) {
        for (j in i + 1..positions.lastIndex) {
            val first = positions[i]
            val second = positions[j]
            max = max(max, first.manhattanDistance(second))
        }
    }
    return max
}
