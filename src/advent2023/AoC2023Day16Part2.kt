package advent2023

import utils.Direction
import utils.Point
import kotlin.math.max

private var result = 0

fun main() {
    result = test(
        """
            .|...\....
            |.-.\.....
            .....|-...
            ........|.
            ..........
            .........\
            ..../.\\..
            .-.-/..|..
            .|....-|.\
            ..//.|....
    """.trimIndent()
    )
    check(51, result)

    result = test(
        """
            \.....................\.......................|..../......-.........../.|.....\.............|..........|..\...
            .../...................\..................../...|.......|........||...................../...........\.........
            ././....|......./................\............|..\...........-....../............../|........-................
            ....\..\...........-/..|......|......\............|............../.................-........./...-...|.......\
            ..................................|.\.......|...../.........................-...../......\..|...............\.
            .....\.............................................|../.\............../--.......................\............
            |.......-.|........\.................\..............|........./....\.........|...................\-.-...|.....
            ....\........./....-.........................--.....\..../......................|.\......................\...-
            \..-..../.....|..........\......................-|......|...................../...../........./...........-...
            ........................\.\|......../........../......................\.............|./../....................
            .....\...................|.............................|......-........|.........-./.../.|....................
            ..-................./.........................................\..\........-..-........-.......\../............
            -................-............................\................./..--................-............../.|.......
            ..-.....|.............|................./.......-.-........................-............-...........\.........
            ..........|..........................-...|..\...............................................\-....\...........
            /................../..........|....\..-......................../....\...\..........-....../.........../.....\.
            ................\....-................-|.\...-...........-.....-........\..........................\..........
            ...................................\../..|.../../...........................\.........../.\-......|.........-.
            /....|....|..........................\............./.....|/................./....-......................-.....
            ....-.............../.....|...........|../......\../.............../........................|............./...
            ......./..............|./../.................-.\.........../.....................|.........../........\.......
            ...................-...............\/.......|........|....................../.......................-/......\.
            ................\...../....-/......-.........-.....\/.\...............\....../...-....|......|.........\......
            ....-.........-.........................-......................../.......|...............................\....
            ......../..................|...../......\..\..-|-..../..............|......../............|.-.......-.........
            ......./............-..........-............................../.........................|\..-..-\.\......-..\.
            .\-.....|......................-..\................/.-................|.\..............\..................|...
            -..........................-............../.|.-......\......-..-...../......./................................
            ....|.................................................\....|..........\...................-......|........./..
            ................../...........-..............\......................................|.-........|..............
            ...-............|..............-...........-.\.......................|..|..../......................../.|....-
            .......-..-......./...../.........-.......\.....-.../............-./......../.../............-.....|...|......
            ...............|.........../..........|/..........|..........-.-...../...../..|..........\.....-./.|./....|...
            .........|......................\.|.....|......................-.-........|.............................-...|.
            .-...|..\...-...............\..............\......./........-............/.-..\........../...../....-....\....
            ...........\.-.......|.......|....-.............|-.|........../..../...\....\............|.|..|\..............
            .....................|.\....|......|../...\......|........................\......|.......-./..../.............
            ......................\--................................\.................|................-.................
            -...............\...-.....................................-.\...../....\...........................|..........
            .....|.......\.......................-/...\..-.........-..../\|..................\........-...................
            ..|........./....|..-./..\..\................-|..........\../......\...............\............\............|
            ......-................../.............|.............\................................-..\...../........-.....
            ....................../......../..\.-.........................|....\..|...\...../../.....|............../.....
            ...\................................/..............................\........|.........\.-............\........
            /.................../................-...........-.|.............\.................................|.....-....
            .|...-..|/./../.........-./.............................................../..........-.........-.|./..........
            ..../..................|......................|../..........\........-......../.........\...|.................
            ........./..................|..-..........|\............\......-..-..\...|....|.....................|....-....
            .....|/....|........\.........-................../..........|............|...........-.....|......./......//..
            ..........\.|../...|........................\.........\.|......||....-...............\\.....|.|..............|
            ............-................|.....-....||......../.../.......................|..\...........\................
            ...............-..../......-..../.......|-.....-.....\..................................../..|................
            /......-...............\/...././..................\..................\..........-......................|......
            ...................\.....\.................\...|.................-............/........-..............\./.....
            .-.\....\........\........-../.-............../...../..-..|...................../.-.....\.....-........../..\.
            |...|...............................|............../.............../....................|...../...............
            ....../....../...|..............-.-........-..|.../....................\|.....\......................|....../.
            ...\\.......|...|-............|..........-...........................................\/...../..-.-............
            .........|.............|..|......\............\...............|......\......\.............\...\-.......\.....\
            ...........\..-.|.......|\..\..................-........\/...............................-....................
            ...\.................\..............................................\...............\.......-.../.............
            ..\.............\....---....................//.......................................|./.............../\.....
            .\...........|..................................\........-......|.........\.................-........-........
            ..............-...............-.../....-........|.....-../......................./..../........../../--..\....
            .........-......\......-.........../...\./.|.................\...................--..-........|..\......\....|
            ....../.........................................|...../........../..............\\...-/.......-......\..\.....
            .........../...\.|..................../.\.................|......\.\..|.........../...../.....\.\...........|.
            ..../\..-...../.............................../..../............................-...-......\...........\......
            ..-..\.............................\...........|..........|.........|..........................-......./......
            -..|.................-\.....\...............\/.....|...........................././...\......\.......\...-....
            ......\..............|..|..............-............../....................-....\\........\....|..............
            |.............\....\./.....-|-....\.....\..............\/........-.|..|...........-..\......-..../.......|....
            ............................-.......................|........................../................|.............
            /................|../............\/.....\/....-.....\......\...../|..\..........|............../..............
            .|....../...../....................../..|.....................-................./...../-.........-............
            ......................\|........../......./..\........\.........-......../.........../.|/.......\.../.........
            ...............\......-|............\..\....../.........\.....|...|\............/............\.\..|.......\...
            ......|...........\....../....\./......./-....\../.......\...-...............\./...\.....-.......-..../.......
            ...|..|.............................\.....-.|........./......../......................-......./............\..
            .....|........\.........|...-.-.........\..../....../..-.......-...............\..../.....-..../..............
            ........./.\/........................-..........\.....................|.......-..............\./.\............
            ..../................/................................|.....||..............\........-...............|........
            ....\./.........../\-.....-...\............//.\..............\...../................|.....\..-................
            ..../|........./............|.....................|......................-..|...............................\.
            ..................\............................\.......\.........-.............|...../.-.............-......|.
            ..............|.-...........................\.\./.......\........../...\................/....-................
            .......|................/-............\............/...........-..../...........\......../...\.......\........
            ..............|..../......................-...........-..\.................................................-..
            ..............................-..-................-.......-.................-..........\.../...............|..
            ......-.........-........................./.....................\....|........................................
            .....\........./.....-.................../................|...................|........................|......
            ........../.../........................./.|................-...........\...........-....|.....................
            .....-.......\././/.......|..............|......../..\...........\.............................-......|../-.-.
            ........|-....-....................\.....|\...\/.....\........\......./..........|.\-..|......................
            ../...-...-...|...../............\.......................-..........\...\.....-...\...............|....../...|
            ............|..\....|..................\/...................../../....|...................|.............../...
            .............-................./............|.......|............\....................................\.-.....
            -...../|..............-......\..../..................|..\....-............................................\...
            ........|.........-........\................/....\..................../.|...................................|.
            .....|................./.........-|\...-...................|....-................-......../...............|..-
            .|.........|...........|...-.............................\............................|................\......
            ....|.....-......|......./.-.|...........\..-........|.........................-....-..-.....|................
            ........................................\.....................-.../........................../../..........|..
            -................/....\.......//....-........................../.\.........-......./..|\..........\...........
            -............................./......................................../-...........................\|........
            ........................................../-.....//......\......\...........\........|./....../.......--......
            ../..............-....../......../................../......./....-...........|../.......\.\.......-......./..\
            ..............-............../......|.........-...............|................................-..........\...
            .....................\..........|..\......|...............................................-...................
            ...../..|.../.........|.../.......-...................................\.....................................|.
    """.trimIndent()
    )
    check(7741, result)
}

private fun test(input: String): Int {
    val map = input.split("\n")
    val width = map[0].length
    val height = map.size

    fun start(startPoint: Point, startDirection: Direction): Int {
        var positions = mutableListOf<Pair<Point, Direction>>()
        val pairs = mutableSetOf<Pair<Point, Direction>>()
        val points = mutableSetOf<Point>()

        positions += startPoint to startDirection
        pairs += startPoint to startDirection
        points += startPoint

        fun Point.isValid() = x in 0 until width && y in 0 until height

        while (positions.isNotEmpty()) {
            val newPositions = mutableListOf<Pair<Point, Direction>>()

            fun Pair<Point, Direction>.add() {
                if (this.first.isValid() && this !in pairs) {
                    newPositions += this
                    pairs += this
                    points += this.first
                }
            }

            for (position in positions) {
                when (position.second) {
                    Direction.R -> {
                        when (map[position.first.y][position.first.x]) {
                            '.' -> {
                                (Point(position.first.x + 1, position.first.y) to position.second).add()
                            }

                            '-' -> {
                                (Point(position.first.x + 1, position.first.y) to position.second).add()
                            }

                            '|' -> {
                                (Point(position.first.x, position.first.y - 1) to Direction.U).add()
                                (Point(position.first.x, position.first.y + 1) to Direction.D).add()
                            }

                            '\\' -> {
                                (Point(position.first.x, position.first.y + 1) to Direction.D).add()
                            }

                            '/' -> {
                                (Point(position.first.x, position.first.y - 1) to Direction.U).add()
                            }
                        }
                    }

                    Direction.L -> {
                        when (map[position.first.y][position.first.x]) {
                            '.' -> {
                                (Point(position.first.x - 1, position.first.y) to position.second).add()
                            }

                            '-' -> {
                                (Point(position.first.x - 1, position.first.y) to position.second).add()
                            }

                            '|' -> {
                                (Point(position.first.x, position.first.y - 1) to Direction.U).add()
                                (Point(position.first.x, position.first.y + 1) to Direction.D).add()
                            }

                            '\\' -> {
                                (Point(position.first.x, position.first.y - 1) to Direction.U).add()
                            }

                            '/' -> {
                                (Point(position.first.x, position.first.y + 1) to Direction.D).add()
                            }
                        }
                    }

                    Direction.D -> {
                        when (map[position.first.y][position.first.x]) {
                            '.' -> {
                                (Point(position.first.x, position.first.y + 1) to position.second).add()
                            }

                            '-' -> {
                                (Point(position.first.x - 1, position.first.y) to Direction.L).add()
                                (Point(position.first.x + 1, position.first.y) to Direction.R).add()
                            }

                            '|' -> {
                                (Point(position.first.x, position.first.y + 1) to position.second).add()
                            }

                            '\\' -> {
                                (Point(position.first.x + 1, position.first.y) to Direction.R).add()
                            }

                            '/' -> {
                                (Point(position.first.x - 1, position.first.y) to Direction.L).add()
                            }
                        }
                    }

                    Direction.U -> {
                        when (map[position.first.y][position.first.x]) {
                            '.' -> {
                                (Point(position.first.x, position.first.y - 1) to position.second).add()
                            }

                            '-' -> {
                                (Point(position.first.x - 1, position.first.y) to Direction.L).add()
                                (Point(position.first.x + 1, position.first.y) to Direction.R).add()
                            }

                            '|' -> {
                                (Point(position.first.x, position.first.y - 1) to position.second).add()
                            }

                            '\\' -> {
                                (Point(position.first.x - 1, position.first.y) to Direction.L).add()
                            }

                            '/' -> {
                                (Point(position.first.x + 1, position.first.y) to Direction.R).add()
                            }
                        }
                    }
                }
            }

            positions = newPositions
        }

        return points.size
    }

    var maxx = 0
    for (x in 0 until width) {
        maxx = max(maxx, start(Point(x, 0), Direction.D))
        maxx = max(maxx, start(Point(x, height - 1), Direction.U))
    }
    for (y in 0 until height) {
        maxx = max(maxx, start(Point(0, y), Direction.R))
        maxx = max(maxx, start(Point(width - 1, y), Direction.L))
    }

    return maxx
}
