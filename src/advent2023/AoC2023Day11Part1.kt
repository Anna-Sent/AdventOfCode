package advent2023

import utils.Point
import kotlin.math.max
import kotlin.math.min

private var result = 0

fun main() {
    result = test(
        """
            ...#......
            .......#..
            #.........
            ..........
            ......#...
            .#........
            .........#
            ..........
            .......#..
            #...#.....
    """.trimIndent()
    )
    check(374, result)

    result = test(
        """
            ..............................................#......#...............................................#..........................#...........
            .....#......................................................#.............................#.................................................
            ............#...................#........#....................................#..............................#...........#..................
            ...............................................................................................#............................................
            .#....................#...........................#......................................................#...........#.....................#
            ............................................................................................................................................
            ...................................#.......................#...........................#....................................................
            ....#...................................................................#......#..................#.............#...................#.......
            ..............................................#.............................................................................................
            ...........#.............................#......................#...........................................................................
            ...................#.........#..............................................................................................#...............
            .....................................................#.....................#...................#..........#...............................#.
            ...............#................................#.......................................................................#...................
            ....#..............................#......................................................#...........#..........................#..........
            ..............................................................#.............................................................................
            ...........................#.................#...............................................................#.....#..................#.....
            .......#...........#..............................................................#.........................................................
            ..............#...........................................................................................................................#.
            ...............................#..................#.........................................................................................
            ..#............................................................................#............................................#...............
            .........................#..........#.....................................#.................#...................#...........................
            .................#......................................#............................#................................#................#....
            .......................................................................................................#....................................
            .....#................#........................................#............................................................................
            ........................................................................#................................................#..................
            ...........................................#...................................#..............................#.............................
            ..........................#..............................#..........................................................#.....................#.
            ..#............#......................................................................#..........................................#..........
            ................................................#..............................................#............................................
            .......................................#..............................................................................................#.....
            .....#......................#.................................#............................................................#................
            ................................................................................#..........................................................#
            #.........#...........................................................................................#.....................................
            .....................................................................................................................#...........#..........
            ...........................................................#..............................#.................................................
            ..............#.......#.........#........................................#...........................................................#......
            ......................................#.....#.....................#..........................................................#..............
            ...........................#............................#.........................................#......................................#..
            ...#...............#...........................................................#.....#..........................#...........................
            ...................................#........................................................................................................
            ............#....................................#.............#..........................................#..........#..............#.......
            .......................#................................................................#...................................................
            ......#...............................#...............#.................................................................................#...
            #..............#...........................#................................................................................................
            ............................#.............................#................................................................#................
            ..........#........#..............................................#...................#........#...............#............................
            .......................................................................................................................#....................
            .........................................#..............................#.....#.............................................................
            .....................................................................................................................................#......
            .....................................................#......................................................................................
            ........#.....#....................................................#..................................#.....................................
            .....................#.........................#.......................................#...................................#................
            ...#.........................#..........................#..........................................................#............#...........
            ............................................................................................................................................
            ...........#...................................................#.............................#..............................................
            ..................#.........................................................................................#...............................
            ..........................#................................#..........................................#.....................................
            ................................#.....#...................................#............#....................................................
            ..............#............................#.......................#............#............................................#..............
            .....#..................................................#.........................................#............#.....#.....................#
            ............................................................................................................................................
            ........................................#...............................................................#...................................
            .....................................................#......#.................................#.............................................
            ..........#............................................................................................................#........#...........
            ............................................................................................................................................
            .#................#.......#.......................#...................#.....#.........................#................................#....
            ...............................#..................................................#..............................#..........................
            ........#....................................#....................#......................#..................................................
            ............................................................................................................................................
            .........................................................#...................................................#.........#....................
            ..............................................................#..............................................................#..............
            ......................................#...........#.........................#........................#................................#.....
            .....................#......#...............#...............................................................................................
            ............#.......................................................................................................#...........#...........
            ...................................................................#......................................#...............................#.
            ...#................................#..........................................................................#............................
            .........#.....................................................#............................................................................
            ..............................................................................#....................#........................................
            .................#.....................................#.............................#.............................#....................#...
            ........................#......#.............#..............................................................................................
            .....................................................................#.....................................#...............#................
            ............................................................................................................................................
            #..............................................................................................#............................................
            .................................#......................................#..............#....................................................
            .................................................#.....................................................................................#....
            ...#...............#.....................#......................................#........................................#..................
            ........................#......................................#...........................................#.......................#........
            ....................................................#.....................#................#.........#......................................
            ............#...............................................................................................................................
            ...........................................................#.........................#.........................................#............
            .....................................#............................#.........................................................................
            ......#.............................................................................................................#.......................
            ....................#...........#.............#...............#.........................#................................#...........#......
            .........................................#.....................................#............................#...............................
            ...........#............................................#...................................................................................
            .................................................................................................................................#..........
            ...#..............................................................#.............................#.................#.........#............#..
            ......................#..............................................................#................#................#....................
            .........#.....................#......................................#.....................................................................
            .........................................................................................#..................#...............................
            .................#.........................#..............#...............................................................#.................
            .....#...............................................#............................#.........................................................
            ....................................................................................................................#.......................
            ..........#..........#.......#................#......................#........#............#.......#........................................
            ...................................#.....#..................................................................................................
            .............................................................#.........................#.........................#......#...................
            .........................................................................#.......#.......................#........................#.........
            .......................#.........................................................................#...........................#..............
            ........#.........#.........#...................#...........................................................................................
            #.........................................................#............................................................................#....
            ........................................................................................#............#......................................
            ..................................#........................................................................................................#
            ..............#.....#.....................#..............................#.......................................#..........................
            ...#..........................................................#.............................................................................
            .........#.......................................#............................#...............#..........................#........#.........
            ...........................#.................................................................................#..............................
            .........................................................................................#...........................#......................
            .....................................................................#.................................................................#....
            .....#..................#.......#.........#.................#................................................................#..............
            .....................................#................#....................................................#.......................#........
            ...............................................#............................................................................................
            ...........#........#.......#...................................................#...........................................................
            ................................................................#...........................................................................
            ................#............................................................................#..............................................
            #......................#...............................................................................................#....................
            .................................#...............................................................................#............#..........#..
            .....#..........................................#..........#..........................................#.....................................
            ...........................................#...................................#.................#..........................................
            ..........#.......#...........#...............................................................................#.............................
            .......................................#............................................................................................#.......
            ...................................................#.....................................................................#..................
            #......................#........................................#..........................#...............#................................
            .............................................................................................................................#..............
            .............................................#.........................#..............#.....................................................
            .......#.............................................#.......#...................................................................#..........
            ............#.....#.....................#..............................................................#............#.....#.................
            ...#.........................#................................................................................#.............................
            ...............................................#..................#.........................................................................
            ...................................#....................................#.......#........#.........#..........................#.............
            ..........#.....#......................................................................................................#..............#.....
    """.trimIndent()
    )
    check(9965032, result)
}

private fun test(input: String): Int {
    val lines = input.split("\n")
    val emptyRows = mutableListOf<Int>()
    val emptyCols = mutableListOf<Int>()
    for ((row, line) in lines.withIndex()) {
        if (line.all { it == '.' }) {
            emptyRows += row
        }
    }
    val galaxies = mutableListOf<Point>()
    for (col in 0 until lines[0].length) {
        var hasGalaxy = false
        for (row in lines.indices) {
            val ch = lines[row][col]
            if (ch != '.') {
                hasGalaxy = true
                galaxies += Point(col, row)
            }
        }
        if (!hasGalaxy) {
            emptyCols += col
        }
    }
    var sum = 0
    for (i in 0 until galaxies.size - 1) {
        for (j in i + 1 until galaxies.size) {
            sum += galaxies[i].manhattanDistance(galaxies[j])
            for (row in emptyRows) {
                if (row in min(galaxies[i].y, galaxies[j].y)..max(galaxies[i].y, galaxies[j].y)) {
                    ++sum
                }
            }
            for (col in emptyCols) {
                if (col in min(galaxies[i].x, galaxies[j].x)..max(galaxies[i].x, galaxies[j].x)) {
                    ++sum
                }
            }
        }
    }
    return sum
}