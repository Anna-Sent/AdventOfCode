package advent2021

import kotlin.math.max

private var result = 0L

fun main() {
    result = test(4, 8)
    check(444356092776315, result)

    result = test(5, 10)
    check(265845890886828, result)
}

private fun test(initPos1: Int, initPos2: Int): Long {
    val (win1, win2) = dfs(initPos1 - 1, 0, initPos2 - 1, 0, true)
    println("$win1 / $win2")
    return max(win1, win2)
}

private val cache = mutableMapOf<String, Pair<Long, Long>>()

private fun key(pos1: Int, score1: Int, pos2: Int, score2: Int, isFirstTurn: Boolean) = buildString {
    append(pos1)
    append(score1)
    append(pos2)
    append(score2)
    append(isFirstTurn)
}

private fun dfs(pos1: Int, score1: Int, pos2: Int, score2: Int, isFirstTurn: Boolean): Pair<Long, Long> {
    val key = key(pos1, score1, pos2, score2, isFirstTurn)
    if (key in cache) return cache[key]!!
    if (score1 >= 21) return 1L to 0L
    if (score2 >= 21) return 0L to 1L
    var win1 = 0L
    var win2 = 0L
    for (i in 1..3) {
        for (j in 1..3) {
            for (k in 1..3) {
                val (x, y) = if (isFirstTurn) {
                    val p = (pos1 + i + j + k) % 10
                    dfs(p, score1 + p + 1, pos2, score2, false)
                } else {
                    val p = (pos2 + i + j + k) % 10
                    dfs(pos1, score1, p, score2 + p + 1, true)
                }.also { cache[key] = it }
                win1 += x
                win2 += y
            }
        }
    }
    return (win1 to win2).also { cache[key] = it }
}
