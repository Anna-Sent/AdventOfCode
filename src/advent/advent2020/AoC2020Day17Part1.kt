package advent.advent2020

import utils.Point3D

private var points = mutableMapOf<Point3D, Char>()

private fun test(input: String): Int {
    points.clear()

    val initial = input.split("\n").map { it.toCharArray() }
    for ((row, line) in initial.withIndex()) {
        for ((col, ch) in line.withIndex()) {
            points[Point3D(col, row, 0)] = ch
        }
    }

    print(0)
    for (i in 1..6) {
        points = next()
        print(i)
    }

    return points.count { it.value == '#' }
}

private fun print(i: Int) {
    println("i = $i")

    val minX = points.keys.minBy { it.x }!!.x
    val maxX = points.keys.maxBy { it.x }!!.x
    val minY = points.keys.minBy { it.y }!!.y
    val maxY = points.keys.maxBy { it.y }!!.y
    val minZ = points.keys.minBy { it.z }!!.z
    val maxZ = points.keys.maxBy { it.z }!!.z

    for (z in minZ..maxZ) {
        println()
        println("z = $z")
        for (y in minY..maxY) {
            for (x in minX..maxX) {
                print(points[Point3D(x, y, z)])
            }
            println()
        }
    }
    println()
}

private fun next(): MutableMap<Point3D, Char> {
    val next = mutableMapOf<Point3D, Char>()

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

private fun Point3D.neighbors(): Set<Point3D> {
    val neighbors = mutableSetOf<Point3D>()
    for (i in -1..1) {
        for (j in -1..1) {
            for (k in -1..1) {
                neighbors += Point3D(x + i, y + j, z + k)
            }
        }
    }
    neighbors -= this
    return neighbors
}

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
    check(112, result)

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
    check(202, result)
}
