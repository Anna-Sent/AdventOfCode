package advent.advent2022

import utils.Point

private var result = 0

fun main() {
    result = test("""
        #.######
        #>>.<^<#
        #.<..<<#
        #>v.><>#
        #<^v^^>#
        ######.#
    """.trimIndent())
    check(54, result)

    result = test("""
        #.########################################################################################################################
        #<><v<^<vv<><^vv><><v^.^>.^.>.<v^>v><v^.v^<v<vvvv.^^><>^vv<<<>>v>>^>v>>>v<.vv>v<.<v>><>^<<v^<<v^vv>^^<v<^<>v>^v<^v^..^^<<#
        #<>^<<<^<<vv.<^.^>>>vv.v<<vv^...vvv><><>^<^vv.<v>>v><<^^vvv>v>>^>^<v>^<vv><vv<v^v^.vv<<>vv.^^<>v<<v^>..>v^><v^v<<^^<^.^v<#
        #>^>>^<v<v^<v.>vv^>vv^<vv.<>>^vv.<^^>v^vv>v<<vv<>><<^>.v^^v>v<<v^.^v>v>.<^^vvv><^v.v.<v>^>v<<^v.<vv>^v^v^^<>.<<<v^^^>^^^<#
        #>>v>^><^v<.<>>>>^<v>>v^^^><<^v^<>^><>.v<.>^vv<^^<v>.<vv>v^>.v<v<vv.^><^v>><<<v<vvv.v^^>^.^>v^>^><>^<<^>v<<v^v>^v^>><>v.<#
        #>>vv<^.^<>v<v<^<.>^v^.<>>.v^^^.vv^v.<v<>v.>>>v>>.<<<<v<.^>^v<v^<v^<..^v<v^>^<v<>v<vv>.><<<>^>>>v>>>v^<^v>v^<..v>>>v>^>^>#
        #>^^v>.^>^<v>^^v>>v<^<<>^>^^>v<.v^<<><v^>>>><>.><>>>vv<^v^v.<v<v>v^>><v><<><>>^v<^^<^v<v^>v^<>.<.^v>vv.v><<v.>.^>.^^^.<.>#
        #<<v>><.>v<<vv>v.vv<><vv<>^>>>^v<<v>^<<<<v^<>>vv^^v^>.<.^><>v>>v<^v<.v^<^<>v^v^v^>^v^<>v<.>v<^^^.<><v.^^..^v>^>^><.>v>v.>#
        #<^v>v>^.>>>^vv^<>><>^.<>^^<<<^<><.v>^>.>.vvv><v<<>v^<^^<>^vv<vvv<v<<v<^<<>><v<>vv^v<.^.>^>v<<^<><><<<^<.>.v^^.<>><v^<^<<#
        #>.<^<v^^><<.v^v<>v<^vv>>vv>^>^<.>>^v<vv.>.v<>>v<^^<><^^^v.<.v>>^.v^^^>>v^<>.<v^v^.^^v^vv.>>>^^v^..<^v..<.v<>v^<vv.^>^>v>#
        #>v^^v>^<v>>vv^v^>.<><>v^^v.^^>.<<.>^<^<v^.^<><v.v<<^^^^<v^v>.^v^<.v^<<^^.><>.<v.v<^^>^^>>>^v^^..vv<v><>^>.><v^^..^^<.<..#
        #<^<.v>>vv>v<<v<^<>>v^<v>.v^<>vvv..<^>>v>v^v^<^><^<^^v>v>.>vv>^^^>><.<<>^^>.>.>v><^<^v^^<vv<>>^^v<<v>.^.v.<v.^.^v<<^>^<>>#
        #<.^v>^>.>^^>^>^<>>>.>^^^vv^v<>v.<^vv.vv^>>>^^v>^>v>>vvv^><v.<^><<>^^.v.vv>>vv>^vv<<<^..v<^><<<>>^<<v^<^<<.>^^<><<^^<vv^>#
        #<^><>>>>^.^^v>v>^^.^<>><.<><v<<^>v><^^>><^^v>^>^^><^^>^v^<<><<.v^v>>>vvv^v>v^.^>.>v^vv>>>v^>^^.>>.>>vvv<^<<vvvv<^>><v^v<#
        #<v^<<>^^v<^^<v^<^v><>..^<^>v^^<^<v>v.>>v>><><>v^>^v<vv^v^vv<.^^>>.<<^v>^^<>><<^>v^<^>v>^<>>>v>^.^<.^.^<v>vv.^v>v<vvv^^^<#
        #<>v<v^^v^v<<<v^^><v<>v<^<>v^v<^^>^<v<v^.>^<vv^>^^<>v<>>>.v^v.<<<<.v^v>^<>><.v<>^.<>^.^vv<>.^<v.^v<^>>>^<^v^<.<>>v>^.>>^>#
        #>>^>>vv.>v^v>>.vv>^<^v^>>^^<<<>v<>>><^.<^>^<>^.>>.<^^.^<.v<^vv>><<..<<.<v^>^^<>.>.<>><>>v^>.v.^^>^vv<<^^v>v^>vv>^<^v.v>>#
        #<v.<v^^^<^><<^>v^><<v.^v^^>vv><vvv>^^^<v>^>vv<^^^>.>><<^<^v<>.v><^><>v<<.<^vv>.^^^<v>v>>>v<^.v^>>>^>^<<..v.>vv.>>v>^<^^>#
        #<vvv>^^<<vv.v><^..>v.<v<v<<<v^>v<<>.><v<>.<vv^><^<<^v^..>v<v^v>>>^>><v.>>^<>v<^^.vv>>v>.v^^^><^<>>>^<<<<<...v><v>v><^<v<#
        #>v^>v^<v>>><<^v>>>v^<^v.^.v^v.<^<^>.<<.<<.^^vv<v>v>><^^.><>v.>>..^.<vv><>.v>.^^>^vvv>.v>.<.^<v<>^><^v<>>>.<^^v<<>>>>^v>.#
        #<>^>.v^<<><.v^<^<.>^>..<<vv^v<>>v>vv.<><<>^>><^^<v.<v<^<v^>vv^^<>vv>^<^^<v^.>^<^>v<v><^v>v^<^.v^<<>v>.>vv^^v^>vv>^.v><^<#
        #<>>^.v><^v>^><>v><>.v>vv>^v^^v>.^..>^<^<vv^vv>v<<<v<<v<>.<.>>^^v<^<>v>^<^<v.>^<v.^<^^vvv>.<>^><^v.^>>v<v>^^.^^v>v>vv<<<>#
        #.>>^^>v.v^>v^^>vv<vv<v.vv>.vv<<<<^^<v.<v><vv.v<^<^v<.>..^>v^<^^.<>v^<v..^^<^v^^>^<^.v>v<^^>vvvvv.>>>^vv^^^<>.v>v^..>v^.>#
        #>^>v^.^vv^v.vv>v.>v^<><^<>v^<^v><.v<^v>^v>.v<v>^vvvvv>.<vv>>^^<^^^<.<>v>.<>>.v<^<v<^.v.<><>v^v^^^v^>^^.^^<><><<<v^^<<^v<#
        #<>>v.<<v<^<^<^.vv>>>>>v^..<><<v^>^^.>>^<.<>^v^<^>v<.vv<v<<^vv^.<v<<v^vv<<.v<>^v^<^v<^vv>>><v>vvv><><><.><v>^><<.>><<>^^.#
        #.<^v><>v>^v^v^><^^.v<<>^<^<>v..^>vv>vvvv<<vv>>>><v<^<^v^>v>^<>^^v.>>v>^.v^vvv<><v^.><<vv.>^.^v<>>v.<vv>^<^>>>v^>><v.>>><#
        ########################################################################################################################.#
    """.trimIndent())
    check(859, result)
}

private fun test(input: String): Int {
    val walls = mutableSetOf<Point>()
    var blizzards = arrayListOf<Blizzard242>()

    var row = 1
    for (line in input.split("\n")) {
        var col = 1
        for (char in line) {
            val p = Point(row, col)
            if (char == '#') walls += p
            if (char in setOf('>', 'v', '<', '^')) blizzards += Blizzard242(p, when (char) {
                '>' -> Direction242.R
                '<' -> Direction242.L
                '^' -> Direction242.U
                'v' -> Direction242.D
                else -> throw IllegalStateException("invalid char direction")
            })
            ++col
        }
        ++row
    }

    val minRow = walls.minBy { it.x }!!.x
    val minCol = walls.minBy { it.y }!!.y
    val maxRow = walls.maxBy { it.x }!!.x
    val maxCol = walls.maxBy { it.y }!!.y

    fun nextBlizzardState(): ArrayList<Blizzard242> {
        val next = arrayListOf<Blizzard242>()

        for (blizzard in blizzards) {
            var newP: Point
            when (blizzard.d) {
                Direction242.U -> {
                    newP = Point(blizzard.p.x - 1, blizzard.p.y)
                    if (newP.x == minRow) {
                        newP = Point(maxRow - 1, newP.y)
                    }
                }

                Direction242.D -> {
                    newP = Point(blizzard.p.x + 1, blizzard.p.y)
                    if (newP.x == maxRow) {
                        newP = Point(minRow + 1, newP.y)
                    }
                }

                Direction242.R -> {
                    newP = Point(blizzard.p.x, blizzard.p.y + 1)
                    if (newP.y == maxCol) {
                        newP = Point(newP.x, minCol + 1)
                    }
                }

                Direction242.L -> {
                    newP = Point(blizzard.p.x, blizzard.p.y - 1)
                    if (newP.y == minCol) {
                        newP = Point(newP.x, maxCol - 1)
                    }
                }
            }
            next += Blizzard242(newP, blizzard.d)
        }

        return next
    }

    val startPoint = Point(minRow, minCol + 1)
    val endPoint = Point(maxRow, maxCol - 1)

    fun Point.isValid(): Boolean {
        return x in minRow + 1..maxRow - 1 && y in minCol + 1..maxCol - 1 || this == startPoint || this == endPoint
    }

    fun Point.generateNext(): Set<Point> {
        val next = mutableSetOf<Point>()
        var nextPoint: Point
        nextPoint = Point(x + 1, y)
        if (nextPoint.isValid() && blizzards.count { it.p == nextPoint } == 0) {
            next += nextPoint
        }
        nextPoint = Point(x - 1, y)
        if (nextPoint.isValid() && blizzards.count { it.p == nextPoint } == 0) {
            next += nextPoint
        }
        nextPoint = Point(x, y + 1)
        if (nextPoint.isValid() && blizzards.count { it.p == nextPoint } == 0) {
            next += nextPoint
        }
        nextPoint = Point(x, y - 1)
        if (nextPoint.isValid() && blizzards.count { it.p == nextPoint } == 0) {
            next += nextPoint
        }
        if (blizzards.count { it.p == this } == 0) {
            next += this
        }
        return next
    }

    fun bfs(startPoint: Point, endPoint: Point): Int {
        var opened = mutableSetOf<Point>()

        opened += startPoint
        var steps = 0

        while (opened.size > 0) {
            blizzards = nextBlizzardState()
            val achievable = mutableSetOf<Point>()
            for (current in opened) {
                if (current == endPoint) {
                    return steps
                }
                val set = current.generateNext()
                for (next in set) {
                    achievable += next
                }
            }
            opened = achievable
            ++steps
        }

        return -1
    }

    return bfs(startPoint, endPoint) + bfs(endPoint, startPoint) + bfs(startPoint, endPoint) + 2
}

private enum class Direction242 {
    U, D, R, L
}

private data class Blizzard242(val p: Point, val d: Direction242)
