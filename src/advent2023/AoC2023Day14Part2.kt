package advent2023

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            O....#....
            O.OO#....#
            .....##...
            OO.#O....O
            .O.....O#.
            O.#..O.#.#
            ..O..#O..O
            .......O..
            #....###..
            #OO..#....
    """.trimIndent()
    )
    check(64, result)

    result = test(
        """
            .O.O.#........#..#...#..#....#...........#O.#.##.O#....#.......O......#..OO.#.#O....#O..O#...OO.#O..
            .#....O#.#O#....OO....O#OO...O...O#.O.O.#.....O..O#..O..O...O#..........O#....O..#O.....OO....OO..O.
            ..#.#.#....##.#..#....O..O...O.#O.#......OO..#.#.#...OOO.##......#O..O.#.O.....O#....#..#..O.#OO###.
            ....OO...O###.OO...#...O....##..#..O......O......#.....#...O..#..#O.#.#O.#..#..#O...O.O..#OO.....O.#
            .O..O....#O.OOO..O...O..OO.OOO.#.OOO...O...OO....O..#.#.O.#.#.O#.O....O#..##.O.#.O.O....#.....O.....
            .O..O...O.O......O....O..#.O.#.....#....O#...O..O..#....#.#O.....#.#...O.O..OO.#OO.....#...#..O.....
            .O..O.OO.O...O.#OO..#O......O#......OO#OO..#...##....O.....O...O...O..O.O..#O..O.O...O..##O..O....#.
            .O.......#.OO..O.O#...#O..#..#.O.#.O#.##O#......OO..##..O.#.....##..O...#.#.#.......O..OOO.O..OO.##.
            O#OOO.O.O.......##.O..O...O.#O..O.O..O#.##..O.#...#....O#..#O..##....O..##O#O........#...##..#.....O
            ....#.O..O#...OO..O.O.........O#......##........#....O.#OOO.##O##..O...#...........##...#O........O.
            OO#.....OO..#........#..O..O.O#......##.#.#O.#.O.#.O..O..#OO#.#..#...###..OO.O.#...#..#....O...#.OOO
            O..#..#O##.#.O......O..#....O....#..#.O#.#.O.....O.#O.......#...OO#.##O.##...O.O.#O.O..#O..O.#O..O..
            ......#OO......O.##....#...#......OOOOOOO..#..#O..OO.....O...O.#...#O..O..O#O#.....O....#.......O#O.
            ..O##..O.#..#........#O.OO...O....#...O........OO...O.....##......#..###.O..O##....O.#...OO....#..O.
            .O.OO...#..#O#...O#..O...O...O#....#.O.....#O.O.O........#....#.....O...#...O#..#.#O.#......OO.#O#O.
            #.#....O..O........O.#........#..O....O##.....#..O#.##...OO...O#..#.....#..O..#...#.O.#...O.O...#..O
            #..........O#......O#...O.....O........#..##....#.O.#........#.....#.O#O....OO.O..O..#...#...#.O.#O.
            O..OO....O...O.#.#...O...............#O#........OOO.#....O#.O.....OO#OO#.O#.O.O#....O....#..#...O.##
            .#...#..OO.O.O...O.##..OOO...OO.#.OOO..........#....##.##...O...OOO.##O.....#....O.O.O.O...#.##...#.
            .O.#.O....##OOOO..#..O.........O..O#..#.O......O....#.....#....##.O.#.O...#O.OO........#.......OO#..
            .#.#O...#O.O..O#O#..O.......O..OO...O##...OOO.#....OO.O##...O...........O#..#..#O.......#....#..OO.O
            ....#...OO....#.OO.#.O.#..O#..#O..........O....OO.O.#.O.....##OOO.#..#....O.OO.#O.O#.#...#.#.O....##
            O#......O###O..O...O...#O.#...............O......#..O.O.............#.#.O.#.OO.##..OO###....#O.O...O
            .#O...O##.#O.O..OO..#O.OO.........##.O.#.#.OO....O.O..#O#.O...O.........OO#.OOO...#..O..O#..O...O...
            ...#O.O.OO...#.......O...O...O.##.....O.....#..#OOO....#......OO....#.O..........#O.......#.#.O#O...
            ..O..O..OO.....O....O##.O#.......O#....O.O..OOO#......O#.....OOO..O.O#O#O..O.O..#.O#O..O.OO.#O.O....
            .#..O..#..O.O.###.O...#....OO#..O.......O..#.O#O##..O..O#O...O..O....##......O#O.....O....O..##O....
            ...#..O.O#.#O..#..OOO...#.#O...O#...#.#....O....#.#.#...OO#....O###O#..O..#O..O..OO.O#.OOO.OO##..#..
            ..O.##.O..OO#....#..#..O#O...O.#..#.O.#.#O.......OOO.O#O...#O..#....##.O.O........#....#O..O.#.O....
            #OO#.O.OO#..#O..OO#.#OO.O..O..O.#.O...O#.....O#....#.O......OO.#...O..........#.O...#OO.....#.O.O..#
            ..OO#.O#......O......#...###.....#OO#O#OO#.O#..#...##O.O.#...#O..##O.O.......#.#O#....O....#........
            ...OOO......O....O...OO...#..###...OOOO.O.......O...O.......OO.O.....O..O#..##....O.#O....#.O.......
            .OO..O.O..O.OO.O.O.O#O#...O#.....O...OO..O#.O.#.O.O.#.....O##.#..#.O#..#....O...........O#.O..O.....
            ..O....O.....#..#.O.O......O#OO...O..OO.....#O.#.#O#..O#..O.O....#......#.OO...O...#O.O#..O.O.##....
            .#.O....##..O.#.O.#....O.O....OOOO.O......#O.O.OOOO...........OO.OO..O.##.#....#O....O...O.O..O..#..
            #OOOOO.##......O.OO..#O.O.O#O....O.O..#OO#O..OO...O.##..O.O.#.O..OO..O..#.........O......O...#......
            ....O...O...O...........#..##.O.........O..O#...O.OOO...O..#.O..O##.OO.......O..#O#O.#..O..O.O.O.#..
            ..#O.#...O..OOOO#..#....OO..##O....O.#.#..#..O.OO###...#...O.#.#.#O.O..#.O..#........#.O.O##O.O.#..#
            .....#.O.....#..#..#..#.O...OO#.#.O....OO..O...#.#.O.O#......O#....#O.O.#O#.#..##....O.#O.O...O..O#O
            ....#..#..#O.....#.#O..OOOOO...O....#O.....#..#.#..#....O..O#.OOOO........O.....O...O.##..##.O#.....
            ...#.#..OO......O.O.#..###.#.#....#..O.O....OO..OO.......#..O...O#..#....O...O....O..#..#..O.O...#O.
            ...###.....#.O..##...O.#..#.O#.O#.O......O..##.....##O.O..O..O.#.##O#.##...OO....#O.O.....O.#.#OOOO.
            .#..OOO....##...O#O..O....#.......#..#.#.O....#O#.#...O....O.#..O#....#.#......#O.O......OO#.OO..#.O
            ..O.#OO#........#.#OO.##O.....O#O......OO#....OO..OO.O...#.....#..O.OO...#.#..O..#..O..#O.#.........
            O.#OOO.O.#.O.O.#..#O..O...O....OOO..OO.OOO..#OOO.#O#.....O#....#..O...#.O...O.O.....#.O..O##O.O#O#.O
            .....O..O.#.OOO..O..#O.OO..#..#.#O...#............O..O..#.#.....O.#....#.........OO......O.#.O..#.##
            .O..O.O#.O....OO...O..#O.O..........#OO#..O.O...##..OO......O#O.......O.#.#....#OO.....O......O...O.
            ..OOOO.O#..#...O..#.O............#....#..O.#..O.#......##..#..O......##..O.O#OO#....O.OO...#.#.#...#
            .#O....#..O.#....#OO...##..#..O...O.......O....O.#....#...###.O#.....O.......O.#..O####...#.OO##O.#.
            .O..O.#..O......#.O..O......O....#O....O.#....O#OOO#....O..O.....##O....#..OO..O...O#.......O..O#.O.
            #...#....O.....#OO..#.#..O.O.##O#..#O.......#..OOO........#.#O.....#..O.O#O....O#....O.....OOO.....#
            .O#O..O..O#.O..............O#...#.........#.#O....OOOO...##OO..OO.........OOO.......##.##.......O...
            .....##..#O...#OO#......O.O..O.O#.O#.#..O......#...#.#O.....O......#O#........#O...O..OO..#.O....#O.
            O....###..#.............O..O.O..#.O##...O.....#....O..#...O....##.#.O......#..#...O#.O#.##O.O.......
            .#O.......O#OO.##.......#..#.#.....OO.#..#.#..O.....#...##.O#O..O........###....O..O.O.#....O#.#..O.
            .O#.........O...O.....OOOO.....#.O..#.#O.O#.......O.#O.#..O.OO...O....#...O.......#O.#..OO.O#...O..O
            ..O..#..#........O.O.#O..O..#OO#.#.........#....O.O.....O..O..O..OO..OOO.O##......#.##O....#.#O.#...
            .##.O....#.....O..#O#..#..O#...##.OO#..O..O..##.O......#.....O..O.#.O..#...#.O.#..#O.#....#..O#....O
            ....#.......#O...##O......O..#...O.O#O...OOO.#..OO.#.#.#....#..#..#O.O..#.O.O..O#......##...O#O.#...
            O...O...##.O...#.O...#....O.....#.#OO.O...O#.##..#...OO.O....O..O...#.O....O#...O...OO..O..#.....O##
            O.O.......O....O.OO.O....O..O..#...#.O#...O.OO.O.##.O..O........O.#.O#.O..##..OO.#.O..O#....#O....#.
            #..O...O....###O...#O.#.........O.OOO.OO...O.##....OO.O...OO.O..#.#O..#.O.OO..O.#O#.#...#OO....OO...
            .#..#...O...#.O.O....O..#.O......O.....#.....#.......OO.O.......#OO#.O..#.O..O..O......#OO...#O#....
            .O.....OOO#..#.O.O..##.#....O.#.O.#.........O......O..O#......#...#.........#..O.....#.O.#...O..#...
            ...#O..O#..OO.O....#....#.......OO..O..OO..#.O...#..O...........O...O..O.OO..#....#.O...O......###..
            ...##.O...O.##.#..##.....##...##..#....O.#..##.OOO....O#..#.##OO..O............O..#O...O..O..O.#....
            ..O..O..O.O.OO.O.OOO...#..OOO.#..##.#..O.#..O#...O..O.O##O#.OOO...###....O#.....OO.O..........OOO#O#
            O##.O..O.#....O...O......O#.......OO...#O#.O.O..##...............O.#O#.....OO.#..#..#O....###.#O#.O.
            ..O..#...#..OO...#O........###..O#...#..#O...O...O...##......O....O#..OOO#O.........#.#..OO....#....
            ...O..#.O.O...O..#O...O#..O...O#..##..##....O..#O.....#....#.#...#....#...#O.##..O.#O##.....#.......
            .O..#OO.#..O...#OO....O...............O.#.##....###.#.....O..O...O..O...O...OOOO....O##..OO.O...#.OO
            ..#O..O..OO#..#.....O.#O.....#.#...O.#..#.....###.O....#..#.......O..#..O#.......O...#.OO.OO.OOO....
            .......OO..#....O.#....#.O......#...OO##......OO...#O.#.#O#.##..#O.###....OOO...OO...O#.#O.O...#.O.#
            .....#...###...#O..#.O.#OO##O.O#.....##.O......O.O..#.O...#.O.....#.#OO.O#.#O#.#.O.O#..O.O#.#.#..#.O
            .O...#...##..O...#.#O...O...#..O..O....O.#...O....#O..OO..#.O##.......#O.#.OO#O.O..O.....OO.OO....O.
            OO.....O.#...OO...O.O#OO#.O..#...OO......#..O..O.O....O#...O.....#..O.............O#O#.#....##.#....
            #.....O#...#..#..OO.O...#...#..O.#..#.......#..O..#...#O.....O....O#O.O..O.#...#.OO##..#O#.O.#..O...
            .OO.................#.#O....O...#........#.O#.#OOO.O.....#.#O.#....#.O...O.........O.O..#.......O...
            ..O.#....#.O.#....##O....#...O.O......#.#..O......OO.....O....##....O.##O....O.....O.##.O...........
            O.....O....O#...O..#....#O...O.O......O#..##.O.O.O##....#..#.OO###..#.O#OO.O.#.O.O##.OO...O..OO..O..
            #....O#...O...##O.O.O.....#.OO.O.O.#.....O#.OO.#.#..O.OO...O..#O.#..#....O.#O....#.#.#O...O..#O.O...
            .O..#O#..O#................#O#.OO....O#..........O.......OOOO.....#..O..O.#....O##.O....O#...O...O..
            O..O.O..#.....O...O...#....O..OO#.#.O#....O.O...#.......O.#....O....##..##O.O.O....O.#.OO.#..O...O..
            ....O..O...#..O#.###O...O#..#..........O##..O.#.#....OO..O..#..O......OO..#......O#.O...#..OO...#...
            .#..#...#.....O..O..#...#O.O.....##......#.O.#...OO.O..........#O.O..#.#O.O...#OO.#O.O.#.....#......
            ..O..#..O...#......#.OOOOOO..OO..#O...O###...O.....O.#.O..O.OO#..O....#..OO.#O.#.O...#.#....#.O..O..
            O...#........#..OOO...OO..#....O....#O#..#O.....#..O.#.#O..O.......#...OO.O.#....#.#O..#...........O
            O.O..#.....O.O.....O.#.##O..OO..#OOO.#....O.O.###.....O.#..##..#.#.......#.........#O#...#...O....OO
            ...#O...O#...#.OO....#....#.OO#O#OO....O#.O#O.....#.#..O##..O.#OO.#O..O....O....O.OO.#O....O.......#
            O....O.#.....O.#.#O...#O.O..##.#..O...#.#O.....#.#..O..#.....OO.#..OO#..O..OO#..#...OO.....#......#O
            .......#.#.O..OO...#O....O.O#.#.....#.#..O....#.....#.O#..O#..#...O#.O.....##....#....#...O..O...#O#
            .#O....O.#O......O..#..O#.....O.#.#....O.#...O.#...O.O........#O....OOO#...OOO#.OO.O#.O....#.....O..
            O..O.OO..O....#O..#..#.#..OO....O#....O##O.....#......O.O.O.....O..O.......O...O..O#O...OOO..O#O....
            #O.#..O##O....#.....#.#....OO.O##.O.....OO.O.....#...##.O......O#.#.##.O..O###.#..O...O...O.......#.
            #.O.....O...O.#OO#.###....#O.O..O.....##...##..##.#.....O#.#.O#..O#..O.....O.......O.#O...#.O.#..#..
            .#..O...O..O..OOO#...###.O#O....#O#..O.#.#O.OO..O.O.O.#...#.......#.#.O.OO...#OO..#O.....#.#..#..O.#
            .O....O.......OO#.....OO..#O..OOO..#O....#O......O.O.O.O..OO..O.#..O.......O...O.O.#..O.....#O...O..
            .#....##O#..#OO...O..#.O.O.O......#...#...O#.....#...O..#.O.#.O..#.O..##.O.#..#.#..#O...###O.#O.....
            O..O...#...O...O...........#...OO#.##...O..OOO.##.....#..##O.....#....#......#O.#.O..#O.##.#....O.#.
            O.##..#....OO.O....O#O....##.#O......O.....#.....O.....O#.#.#O.#.#..O.#..#.O#...O.OO.O...##.OO...##O
    """.trimIndent()
    )
    check(100310, result)
}

private fun test(input: String): Int {
    val map = mutableMapOf<Point, Char>()
    for ((row, line) in input.split("\n").withIndex()) {
        for ((col, ch) in line.withIndex()) {
            map[Point(col, row)] = ch
        }
    }

    val width = map.maxBy { it.key.x }!!.key.x + 1
    val height = map.maxBy { it.key.y }!!.key.y + 1

    fun print() {
        for (row in 0 until height) {
            for (col in 0 until width) {
                print(map[Point(col, row)])
            }
            println()
        }
        println()
    }

    print()

    fun moveNorth() {
        for (row in 1 until height) {
            for (col in 0 until width) {
                val key = Point(col, row)
                if (map[key] == 'O') {
                    var newRow = row - 1
                    var stop = false
                    while (newRow >= 0) {
                        if (map[Point(col, newRow)] == '.') {
                            --newRow
                            if (newRow < 0) {
                                ++newRow
                                stop = true
                                break
                            }
                        } else {
                            ++newRow
                            stop = true
                            break
                        }
                    }
                    if (stop && newRow != row) {
                        map[Point(col, newRow)] = 'O'
                        map[key] = '.'
                    }
                }
            }
        }
    }

    fun moveWest() {
        for (row in 0 until height) {
            for (col in 1 until width) {
                val key = Point(col, row)
                if (map[key] == 'O') {
                    var newCol = col - 1
                    var stop = false
                    while (col >= 0) {
                        if (map[Point(newCol, row)] == '.') {
                            --newCol
                            if (newCol < 0) {
                                ++newCol
                                stop = true
                                break
                            }
                        } else {
                            ++newCol
                            stop = true
                            break
                        }
                    }
                    if (stop && newCol != col) {
                        map[Point(newCol, row)] = 'O'
                        map[key] = '.'
                    }
                }
            }
        }
    }

    fun moveEast() {
        for (row in 0 until height) {
            for (col in width - 2 downTo 0) {
                val key = Point(col, row)
                if (map[key] == 'O') {
                    var newCol = col + 1
                    var stop = false
                    while (col < width) {
                        if (map[Point(newCol, row)] == '.') {
                            ++newCol
                            if (newCol >= width) {
                                --newCol
                                stop = true
                                break
                            }
                        } else {
                            --newCol
                            stop = true
                            break
                        }
                    }
                    if (stop && newCol != col) {
                        map[Point(newCol, row)] = 'O'
                        map[key] = '.'
                    }
                }
            }
        }
    }

    fun moveSouth() {
        for (row in height - 2 downTo 0) {
            for (col in 0 until width) {
                val key = Point(col, row)
                if (map[key] == 'O') {
                    var newRow = row + 1
                    var stop = false
                    while (newRow < height) {
                        if (map[Point(col, newRow)] == '.') {
                            ++newRow
                            if (newRow >= height) {
                                --newRow
                                stop = true
                                break
                            }
                        } else {
                            --newRow
                            stop = true
                            break
                        }
                    }
                    if (stop && newRow != row) {
                        map[Point(col, newRow)] = 'O'
                        map[key] = '.'
                    }
                }
            }
        }
    }

    fun result(map: Map<Point, Char>): Int {
        var sum = 0
        for (row in 0 until height) {
            for (col in 0 until width) {
                val key = Point(col, row)
                if (map[key] == 'O') {
                    sum += (height - row)
                }
            }
        }
        return sum
    }

    val maps = mutableMapOf<Int, Map<Point, Char>>()
    var cycleParams: Pair<Int, Int>? = null
    for (i in 1..1000000000) {
        moveNorth()
        moveWest()
        moveSouth()
        moveEast()
        if (i <= 3) {
            println("cycle $i result ${result(map)}")
            print()
        }
        if (map in maps.values) {
            println("found cycle at $i")
            val startsFrom = maps.filterValues { it == map }.keys.toList()[0]
            println("cycle starts from $startsFrom")
            println("cycle $i result ${result(map)}")
            print()
            cycleParams = startsFrom to i
            break
        } else {
            val copy = mutableMapOf<Point, Char>()
            copy.putAll(map)
            maps[i] = copy
        }
    }

    if (cycleParams == null) {
        return -1
    }

    // from 3 cycleParams.first
    // found at 10 cycleParams.second
    // 1, 2, _3_, 4, 5, 6, 7, 8, 9, _10_, 11, 12, 13, 14, 15, 16, _17_, 18, 19, 20
    // after 20 -> 6
    // maps[(20 - (3-1)) % (10-3) + (3-1)]

    val index =
        (1_000_000_000 - (cycleParams.first - 1)) % (cycleParams.second - cycleParams.first) + (cycleParams.first - 1)
    return result(maps[index]!!)
}
