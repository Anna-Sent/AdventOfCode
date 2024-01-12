package advent.advent2021

import utils.Point

private var result = 0

fun main() {
    result = test(
            """
            5483143223
            2745854711
            5264556173
            6141336146
            6357385478
            4167524645
            2176841721
            6882881134
            4846848554
            5283751526
    """.trimIndent()
    )
    check(1656, result)

    result = test(
            """
                5665114554
                4882665427
                6185582113
                7762852744
                7255621841
                8842753123
                8225372176
                7212865827
                7758751157
                1828544563
    """.trimIndent()
    )
    check(1617, result)
}

private fun test(input: String): Int {
    val map = input.split("\n").map { it.map { c -> c - '0' }.toMutableList() }

    var count = 0

    for (step in 1..100) {
        for (i in map.indices) {
            for (j in map[i].indices) {
                ++map[i][j]
            }
        }

        val flashed = mutableSetOf<Point>()

        for (i in map.indices) {
            for (j in map[i].indices) {
                count += Point(i, j).checkFlash(map, flashed)
            }
        }

        println("after step $step")
        for (i in map.indices) {
            println(map[i])
        }
        println()
    }

    return count
}

private fun Point.checkFlash(map: List<MutableList<Int>>, flashed: MutableSet<Point>): Int {
    val i = x
    val j = y

    var count = 0

    if (map[i][j] > 9) {
        map[i][j] = 0
        ++count
        flashed += this

        val neighbors = neighbors(map)
        for (n in neighbors) {
            if (n in flashed) continue

            ++map[n.x][n.y]
            count += n.checkFlash(map, flashed)
        }
    }

    return count
}

private fun Point.neighbors(map: List<List<Int>>): List<Point> {
    val i = x
    val j = y

    val items = mutableListOf<Point>()

    if (i > 0)
        items += Point(i - 1, j)

    if (i < map.lastIndex)
        items += Point(i + 1, j)

    if (j > 0)
        items += Point(i, j - 1)

    if (j < map[i].lastIndex)
        items += Point(i, j + 1)

    if (i > 0 && j > 0)
        items += Point(i - 1, j - 1)

    if (i > 0 && j < map[i].lastIndex)
        items += Point(i - 1, j + 1)

    if (i < map.lastIndex && j > 0)
        items += Point(i + 1, j - 1)

    if (i < map.lastIndex && j < map[i].lastIndex)
        items += Point(i + 1, j + 1)

    return items
}
