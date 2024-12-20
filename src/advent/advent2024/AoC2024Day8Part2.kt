package advent.advent2024

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            T.........
            ...T......
            .T........
            ..........
            ..........
            ..........
            ..........
            ..........
            ..........
            ..........
    """.trimIndent()
    )
    check(9, result)

    result = test(
        """
            ............
            ........0...
            .....0......
            .......0....
            ....0.......
            ......A.....
            ............
            ............
            ........A...
            .........A..
            ............
            ............
    """.trimIndent()
    )
    check(34, result)

    result = test(
        """
            ..........1.............TE........................
            ....................................R.............
            ..................................................
            .......................j.....Q....................
            ...................A................8.............
            ...........................s.......9...........k..
            q.E..............6...............1R.w.........k...
            ..6...E..............1.........R...............t..
            .....r.Q......6........Re..T..............9.......
            .............................T........9...........
            ...............................................wv.
            .P............A..................8.v....s.k.......
            .q..................A......k.........8............
            ..........o.....1.....W..H............8.......w...
            ..Q........P.........O.........e...N.W............
            P................z.........o.............N.......w
            ..............o.....p..........Z.s..........N.....
            .....O.x......K.....................v..aN.........
            ..O...............U.....H.......t.................
            .E.......q...6.....i..............................
            ..............z..........o...i...........aW.......
            ....O........r.............e.....Wt...............
            ...............U.7i........H......h........t......
            ......Q.......n..2...I...A....i.p.................
            ...........2...9n.................s........j......
            ..q................Ur..........p..................
            .............n.................K..................
            .....S....z.........I.....H.............e.j.......
            ..................7..prD..K...d...................
            S.........V.....7....K............................
            ......................................0...........
            ..................................................
            ..................2..........I....j.Z.............
            ....................X.............J..Z....a.......
            ........SX............................x......0J...
            ................U....n........x...............0...
            .........S......X................x....a...........
            ...5.......X.......................02.............
            ...............V.........................d...J....
            .............................u.......4............
            .....5...........................u.4..............
            ....5.............................................
            ......V................................3..........
            ......D..........................................d
            ....D.................................4...........
            .....h....................................d7......
            ..............................P...................
            .........D......h........3................u...4...
            .............h..5.....3...........u.....I.........
            ..........3......V.............................J..
    """.trimIndent()
    )
    check(1126, result)
}

private fun test(input: String): Int {
    val map = input.split("\n")
    val height = map.size
    val width = map[0].length
    val antennas = mutableListOf<Point>()
    for (x in 0..<height) {
        for (y in 0..<width) {
            if (map[x][y] != '.') antennas += Point(x, y)
        }
    }
    fun isInsideMap(point: Point): Boolean {
        return point.x in 0..<height && point.y in 0..<width
    }

    fun antinodes(a1: Point, a2: Point): List<Point> {
        val results = mutableListOf<Point>()
        if (map[a1.x][a1.y] != map[a2.x][a2.y]) return results
        val dx = a1.x - a2.x
        val dy = a1.y - a2.y
        var antinode = Point(a1.x, a1.y)
        while (isInsideMap(antinode)) {
            results += antinode
            antinode = Point(antinode.x + dx, antinode.y + dy)
        }
        antinode = Point(a2.x, a2.y)
        while (isInsideMap(antinode)) {
            results += antinode
            antinode = Point(antinode.x - dx, antinode.y - dy)
        }
        return results
    }

    val antinodes = mutableSetOf<Point>()
    for (i in 0..<antennas.lastIndex) {
        for (j in i + 1..antennas.lastIndex) {
            val a1 = antennas[i]
            val a2 = antennas[j]
            val results = antinodes(a1, a2)
            antinodes += results
        }
    }
    return antinodes.size
}
