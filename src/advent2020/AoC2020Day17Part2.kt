package advent2020

private var points = mutableMapOf<Point4D, Char>()

private fun test(input: String): Int {
    points.clear()

    val initial = input.split("\n").map { it.toCharArray() }
    for ((row, line) in initial.withIndex()) {
        for ((col, ch) in line.withIndex()) {
            points[Point4D(col, row, 0, 0)] = ch
        }
    }

    for (i in 1..6) {
        points = next()
    }

    return points.count { it.value == '#' }
}

private fun next(): MutableMap<Point4D, Char> {
    val next = mutableMapOf<Point4D, Char>()

    for (point in points.keys.toSet()) {
        val neighbors = point.neighbors()
        for (neighbor in neighbors) {
            points.putIfAbsent(neighbor, '.')
        }
    }

    for ((point, ch) in points) {
        val neighbors = point.neighbors()
        val active = neighbors.count { points[it] == '#' }
        when (ch) {
            '#' ->
                next[point] = if (active !in 2..3) {
                    '.'
                } else {
                    '#'
                }
            '.' ->
                next[point] = if (active == 3) {
                    '#'
                } else {
                    '.'
                }
            else -> throw IllegalStateException()
        }
    }
    return next
}

private fun Point4D.neighbors(): Set<Point4D> {
    val neighbors = mutableSetOf<Point4D>()
    for (i in -1..1) {
        for (j in -1..1) {
            for (k in -1..1) {
                for (l in -1..1) {
                    neighbors += Point4D(x + i, y + j, z + k, w + l)
                }
            }
        }
    }
    neighbors -= this
    return neighbors
}

private data class Point4D(val x: Int, val y: Int, val z: Int, val w: Int)

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("""
        .#.
        ..#
        ###
    """.trimIndent())
    check(848, result)

    result = test("""
        ..##.#.#
        ##....#.
        ....####
        #..##...
        #..#.##.
        .#..#...
        ##...##.
        .#...#..
    """.trimIndent())
    check(2028, result)
}
