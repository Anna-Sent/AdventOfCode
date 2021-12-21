package advent2021

import kotlin.math.min

private var result = 0

fun main() {
    result = test(4, 8)
    check(739785, result)

    result = test(5, 10)
    check(711480, result)
}

private fun test(initPos1: Int, initPos2: Int): Int {
    var die = 1
    var score1 = 0
    var score2 = 0
    var pos1 = initPos1
    var pos2 = initPos2

    while (true) {
        val die11 = tr(die++, 100)
        val die12 = tr(die++, 100)
        val die13 = tr(die++, 100)
        val d1 = die11 + die12 + die13
        pos1 = tr(pos1 + d1, 10)
        score1 += pos1
        println("p1 $die11 $die12 $die13 move to $pos1 for score $score1")
        if (score1 >= 1000) {
            println("final $die")
            break
        }

        val die21 = tr(die++, 100)
        val die22 = tr(die++, 100)
        val die23 = tr(die++, 100)
        val d2 = die21 + die22 + die23
        pos2 = tr(pos2 + d2, 10)
        score2 += pos2
        println("p2 $die21 $die22 $die23 move to $pos2 for score $score2")
        if (score2 >= 1000) {
            println("final $die")
            break
        }
    }

    return (die - 1) * min(score1, score2)
}

private fun tr(v: Int, max: Int): Int {
    var r = v
    while (r > max) r -= max
    return r
}
