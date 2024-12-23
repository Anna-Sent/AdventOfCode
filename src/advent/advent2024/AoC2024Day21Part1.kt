package advent.advent2024

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            029A
            980A
            179A
            456A
            379A
    """.trimIndent()
    )
    check(126384, result)

    result = test(
        """
            965A
            143A
            528A
            670A
            973A
    """.trimIndent()
    )
    check(222670, result)
}

private fun test(input: String): Int {
    fun Point.isInsideTable(table: List<String>): Boolean {
        val height = table.size
        val width = table[0].length
        return x in 0..<height && y in 0..<width
    }

    fun Point.generateNext(table: List<String>): Set<Point> {
        val results = mutableSetOf<Point>()
        val deltas = setOf(
            Point(0, 1),
            Point(1, 0),
            Point(0, -1),
            Point(-1, 0),
        )
        for (delta in deltas) {
            val nextPoint = Point(x + delta.x, y + delta.y)
            if (nextPoint.isInsideTable(table) && table[nextPoint.x][nextPoint.y] != '#') {
                results += nextPoint
            }
        }
        return results
    }

    val paths = mutableListOf<List<Point>>()
    fun dfs(endPoint: Point, table: List<String>, currentPath: List<Point>) {
        val last = currentPath.last()
        if (last == endPoint) {
            paths += currentPath
        } else {
            val next = last.generateNext(table)
            for (nextPoint in next) {
                if (nextPoint !in currentPath) {
                    val newPath = mutableListOf<Point>()
                    newPath += currentPath
                    newPath += nextPoint
                    dfs(endPoint, table, newPath)
                }
            }
        }
    }

    fun findPoint(char: Char, table: List<String>): Point {
        val height = table.size
        val width = table[0].length
        for (x in 0..<height) {
            for (y in 0..<width) {
                if (table[x][y] == char) {
                    return Point(x, y)
                }
            }
        }
        throw IllegalStateException("not found $char in $table")
    }

    fun List<Point>.toDirectionalPath(): List<Char> {
        val result = mutableListOf<Char>()
        var i = 0
        while (i < this.lastIndex) {
            val from = this[i]
            val to = this[i + 1]
            val diff = Point(to.x - from.x, to.y - from.y)
            result += when (diff) {
                Point(0, 1) -> '>'
                Point(1, 0) -> 'v'
                Point(0, -1) -> '<'
                Point(-1, 0) -> '^'
                else -> throw IllegalStateException("Find char between $from and $to")
            }
            ++i
        }
        return result
    }

    fun findAllChars(table: List<String>): Set<Char> {
        val result = mutableSetOf<Char>()
        val height = table.size
        val width = table[0].length
        for (x in 0..<height) {
            for (y in 0..<width) {
                val char = table[x][y]
                if (char != '#') {
                    result += char
                }
            }
        }
        return result
    }

    fun findAllPaths(table: List<String>): Map<Pair<Char, Char>, List<List<Char>>> {
        val chars = findAllChars(table)
        val allPaths = mutableMapOf<Pair<Char, Char>, List<List<Char>>>()
        for (start in chars) {
            for (end in chars) {
                val startPoint = findPoint(start, table)
                val endPoint = findPoint(end, table)
                paths.clear()
                dfs(endPoint, table, listOf(startPoint))
                val pointPaths = paths.filter { it.size == startPoint.manhattanDistance(endPoint) + 1 }
                    .map { mutableListOf<Char>().apply { this += it.toDirectionalPath();this += 'A' } }
                allPaths[start to end] = pointPaths
            }
        }
        return allPaths
    }

    val numericTable = """
            789
            456
            123
            #0A
    """.trimIndent().split("\n")
    val directionalTable = """
            #^A
            <v>
    """.trimIndent().split("\n")

    val allNumericPaths = findAllPaths(numericTable)
    val allDirectionalPaths = findAllPaths(directionalTable)

    fun findMinPath(pth: List<Char>, allPaths: Map<Pair<Char, Char>, List<List<Char>>>, level: Int): List<Char> {
        if (level > 2) return pth
        val path = mutableListOf<Char>().apply {
            this += 'A'
            this += pth
        }
        val sumPath = mutableListOf<Char>()
        var i = 0
        while (i < path.lastIndex) {
            val from = path[i]
            val to = path[i + 1]
            val subPaths = allPaths[from to to]!!
            var minPath: List<Char>? = null
            for (subPath in subPaths) {
                val p = findMinPath(subPath, allDirectionalPaths, level + 1)
                if (minPath == null) {
                    minPath = p
                } else {
                    if (p.size < minPath.size) {
                        minPath = p
                    }
                }
            }
            sumPath += minPath!!
            ++i
        }
        return sumPath
    }

    var result = 0
    for (line in input.split("\n")) {
        result += findMinPath(line.toList(), allNumericPaths, 0).also {
            println("min path for $line is ${it.joinToString("")} with length ${it.size}")
        }.size * line.removeSuffix("A").toInt()
    }

    return result
}
