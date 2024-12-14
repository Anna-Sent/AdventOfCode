package advent.advent2024

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            p=82,54 v=14,-84
            p=66,12 v=-87,21
            p=91,46 v=44,-45
            p=24,63 v=-92,-60
            p=93,67 v=-12,-73
            p=47,83 v=-94,88
            p=40,67 v=59,-44
            p=76,10 v=45,97
            p=22,15 v=-92,40
            p=34,47 v=-78,25
            p=70,12 v=-40,-63
            p=31,35 v=-58,97
            p=82,28 v=-16,-20
            p=76,81 v=76,75
            p=98,97 v=25,80
            p=16,52 v=76,-1
            p=28,51 v=8,-58
            p=90,80 v=8,54
            p=53,61 v=-54,30
            p=74,50 v=-70,-85
            p=91,71 v=-33,-91
            p=51,87 v=-10,62
            p=66,50 v=60,14
            p=15,2 v=42,-30
            p=18,77 v=-61,-73
            p=59,8 v=-20,-31
            p=7,54 v=76,12
            p=83,56 v=-48,-73
            p=23,98 v=36,-15
            p=0,81 v=-9,-22
            p=31,8 v=56,9
            p=12,23 v=46,64
            p=87,76 v=78,96
            p=53,15 v=84,-50
            p=44,5 v=-96,10
            p=13,98 v=2,-49
            p=40,1 v=-24,-82
            p=18,17 v=33,58
            p=19,16 v=-24,55
            p=39,78 v=-61,-7
            p=34,62 v=77,95
            p=41,11 v=50,-31
            p=34,10 v=97,1
            p=92,56 v=22,95
            p=38,80 v=9,-81
            p=88,34 v=-4,32
            p=60,100 v=-77,-76
            p=96,68 v=-19,24
            p=100,34 v=32,13
            p=60,5 v=52,63
            p=57,62 v=-10,-2
            p=29,85 v=13,-28
            p=54,48 v=-37,-45
            p=51,85 v=67,-80
            p=24,92 v=21,72
            p=10,57 v=-42,-52
            p=67,50 v=-77,-85
            p=44,91 v=81,-87
            p=42,44 v=6,-21
            p=100,16 v=99,53
            p=53,85 v=-56,40
            p=34,60 v=-41,63
            p=36,81 v=23,-54
            p=27,65 v=-38,-34
            p=55,84 v=-44,23
            p=76,7 v=-90,15
            p=16,92 v=18,83
            p=16,80 v=-13,-54
            p=44,88 v=-67,-1
            p=4,8 v=86,-69
            p=10,95 v=69,8
            p=41,39 v=67,83
            p=14,33 v=-1,-1
            p=41,92 v=50,80
            p=80,94 v=-39,-88
            p=82,75 v=-12,-48
            p=21,0 v=8,56
            p=82,90 v=48,-62
            p=84,59 v=-87,12
            p=76,3 v=48,2
            p=11,53 v=76,-91
            p=71,94 v=51,73
            p=27,83 v=-18,90
            p=45,71 v=-47,63
            p=8,92 v=12,22
            p=81,75 v=-77,-67
            p=93,4 v=55,86
            p=5,87 v=-96,87
            p=86,49 v=65,5
            p=8,65 v=96,88
            p=63,1 v=-3,-4
            p=1,48 v=-5,-27
            p=80,46 v=28,-20
            p=7,42 v=4,-34
            p=60,60 v=27,81
            p=49,86 v=64,-29
            p=93,53 v=35,70
            p=61,28 v=-13,71
            p=94,40 v=-53,-65
            p=25,6 v=34,92
            p=57,7 v=-97,-4
            p=9,97 v=35,-91
            p=5,90 v=-69,9
            p=53,1 v=-92,-14
            p=89,55 v=16,-49
            p=62,48 v=20,82
            p=43,92 v=-98,67
            p=22,35 v=-38,-19
            p=43,100 v=16,-95
            p=73,68 v=-6,-80
            p=8,5 v=-8,47
            p=8,59 v=-89,84
            p=95,37 v=-66,-26
            p=83,33 v=65,96
            p=80,96 v=-46,-55
            p=54,102 v=47,-88
            p=46,54 v=-34,57
            p=38,31 v=23,6
            p=88,23 v=-63,91
            p=66,48 v=61,-46
            p=79,17 v=-37,-28
            p=55,44 v=5,-10
            p=68,66 v=71,15
            p=55,96 v=84,3
            p=49,47 v=-81,-39
            p=72,58 v=-6,-27
            p=19,59 v=-65,-66
            p=15,69 v=-8,-35
            p=11,27 v=57,-48
            p=35,25 v=-14,26
            p=44,81 v=57,81
            p=5,46 v=-58,96
            p=68,34 v=14,96
            p=62,40 v=21,38
            p=79,89 v=65,-58
            p=11,84 v=-42,43
            p=60,36 v=-7,77
            p=97,56 v=50,62
            p=42,48 v=-47,-79
            p=46,3 v=48,10
            p=47,29 v=74,27
            p=100,26 v=30,-96
            p=44,7 v=-27,2
            p=27,55 v=63,50
            p=82,15 v=-60,15
            p=31,65 v=63,11
            p=14,6 v=-65,92
            p=50,102 v=30,99
            p=42,83 v=4,46
            p=9,12 v=2,-63
            p=11,56 v=2,-72
            p=46,44 v=-95,-59
            p=54,18 v=81,-63
            p=21,56 v=-11,-8
            p=7,41 v=-99,-13
            p=44,62 v=37,-33
            p=79,3 v=38,49
            p=40,45 v=57,26
            p=45,28 v=35,90
            p=11,52 v=-12,43
            p=72,89 v=55,55
            p=43,39 v=-14,65
            p=18,20 v=-62,72
            p=91,102 v=59,73
            p=80,27 v=-39,-39
            p=93,32 v=18,-51
            p=98,56 v=2,18
            p=30,34 v=-21,26
            p=38,10 v=13,59
            p=15,84 v=-8,-16
            p=62,69 v=-58,-65
            p=96,96 v=-33,-82
            p=65,24 v=61,-29
            p=76,67 v=41,-86
            p=67,47 v=14,17
            p=75,85 v=27,3
            p=36,83 v=97,16
            p=49,38 v=95,-89
            p=48,55 v=79,-31
            p=93,89 v=18,74
            p=72,46 v=65,-17
            p=92,13 v=-10,7
            p=89,30 v=45,28
            p=84,93 v=-70,30
            p=91,24 v=-78,-66
            p=86,42 v=-38,-26
            p=10,40 v=26,-51
            p=92,19 v=-39,78
            p=33,65 v=-17,-67
            p=33,95 v=-52,-3
            p=91,38 v=-12,2
            p=37,67 v=-88,37
            p=9,21 v=-99,26
            p=82,15 v=21,49
            p=86,38 v=82,25
            p=41,51 v=-85,88
            p=50,26 v=60,-19
            p=4,93 v=-25,-68
            p=36,52 v=-28,-20
            p=59,29 v=17,84
            p=13,97 v=2,92
            p=26,59 v=43,-50
            p=42,67 v=87,-66
            p=75,41 v=-16,52
            p=8,0 v=49,-44
            p=58,76 v=71,68
            p=64,100 v=4,-76
            p=35,54 v=53,-46
            p=56,10 v=-44,97
            p=67,81 v=31,-54
            p=77,74 v=74,21
            p=24,13 v=12,99
            p=48,25 v=-44,-57
            p=62,36 v=-94,-45
            p=99,56 v=72,89
            p=45,40 v=44,84
            p=95,11 v=-12,8
            p=4,41 v=-32,38
            p=27,22 v=46,-89
            p=72,28 v=41,52
            p=95,79 v=-66,-22
            p=84,24 v=86,-14
            p=87,21 v=-66,-44
            p=53,34 v=-40,-59
            p=59,27 v=52,61
            p=34,18 v=-4,4
            p=40,91 v=-61,-48
            p=18,3 v=63,47
            p=36,96 v=67,-36
            p=57,82 v=-86,-72
            p=20,86 v=-97,-87
            p=69,99 v=88,-62
            p=51,35 v=-65,-5
            p=51,71 v=64,36
            p=49,27 v=47,90
            p=20,14 v=-45,-76
            p=72,96 v=41,73
            p=25,22 v=-16,-10
            p=84,82 v=23,36
            p=51,5 v=24,91
            p=70,89 v=14,-56
            p=61,75 v=73,-4
            p=98,86 v=89,-23
            p=92,65 v=-76,-99
            p=36,54 v=6,-98
            p=89,12 v=-2,-69
            p=57,10 v=61,-69
            p=39,98 v=60,-62
            p=73,43 v=14,-13
            p=60,44 v=-48,-93
            p=97,49 v=-30,-14
            p=5,25 v=59,-6
            p=11,1 v=90,1
            p=94,81 v=-76,36
            p=79,14 v=98,-24
            p=95,79 v=-93,-80
            p=9,27 v=-39,32
            p=60,99 v=84,25
            p=49,54 v=-46,33
            p=0,98 v=-71,37
            p=40,14 v=44,-45
            p=90,68 v=-36,88
            p=54,79 v=-69,50
            p=49,74 v=-81,4
            p=28,85 v=-93,61
            p=14,91 v=-92,3
            p=78,23 v=85,91
            p=23,85 v=-28,-30
            p=43,34 v=-81,-58
            p=23,70 v=26,23
            p=24,83 v=43,46
            p=46,91 v=91,-16
            p=28,54 v=66,76
            p=30,16 v=90,27
            p=64,77 v=98,3
            p=73,59 v=-23,56
            p=43,61 v=-14,61
            p=85,4 v=48,33
            p=19,77 v=-12,-80
            p=82,14 v=-65,70
            p=44,10 v=-58,99
            p=36,76 v=-41,-87
            p=92,13 v=22,-82
            p=40,49 v=87,-46
            p=41,84 v=-98,-55
            p=53,38 v=-78,26
            p=100,74 v=-79,75
            p=47,67 v=-84,7
            p=89,37 v=45,-39
            p=33,24 v=83,64
            p=31,58 v=56,57
            p=43,90 v=-61,41
            p=39,12 v=-13,-97
            p=28,56 v=9,76
            p=7,3 v=35,59
            p=11,69 v=-99,-27
            p=18,24 v=66,-12
            p=57,78 v=7,-41
            p=26,39 v=36,-45
            p=37,4 v=-14,-4
            p=54,45 v=-30,77
            p=67,91 v=98,80
            p=43,21 v=2,91
            p=94,5 v=-52,15
            p=11,68 v=-87,79
            p=0,47 v=15,-27
            p=64,16 v=10,-45
            p=69,99 v=51,-68
            p=96,68 v=-7,-1
            p=23,15 v=8,34
            p=60,70 v=94,37
            p=18,1 v=-3,31
            p=70,20 v=14,34
            p=14,46 v=23,45
            p=3,83 v=-2,58
            p=25,17 v=16,46
            p=70,83 v=-50,-74
            p=87,4 v=-77,34
            p=42,32 v=-34,90
            p=46,22 v=-41,31
            p=39,45 v=63,96
            p=24,63 v=82,-53
            p=10,11 v=26,14
            p=67,87 v=14,61
            p=16,48 v=5,51
            p=27,14 v=80,-5
            p=3,74 v=-12,-10
            p=48,97 v=-91,-3
            p=77,96 v=4,-36
            p=79,56 v=-90,-85
            p=46,27 v=-47,-63
            p=71,60 v=41,-21
            p=79,15 v=-2,-18
            p=44,51 v=30,-79
            p=70,99 v=-13,99
            p=77,60 v=85,-59
            p=59,1 v=-71,40
            p=58,74 v=54,36
            p=27,18 v=28,9
            p=0,67 v=-49,82
            p=40,84 v=-32,-48
            p=45,34 v=-54,-77
            p=41,79 v=91,55
            p=67,80 v=40,-91
            p=70,61 v=-20,-31
            p=46,99 v=-71,-16
            p=6,16 v=79,27
            p=74,26 v=-19,-26
            p=92,64 v=-56,95
            p=52,101 v=91,-31
            p=55,6 v=-23,22
            p=53,77 v=-44,24
            p=16,53 v=5,95
            p=36,97 v=33,-55
            p=33,83 v=3,-15
            p=67,98 v=17,-63
            p=41,89 v=-32,77
            p=91,66 v=19,18
            p=82,93 v=-36,54
            p=71,6 v=-59,-44
            p=18,82 v=-1,-35
            p=51,62 v=-26,-90
            p=44,21 v=77,-51
            p=95,0 v=62,92
            p=19,61 v=36,56
            p=89,7 v=18,14
            p=97,18 v=-2,-76
            p=1,29 v=-69,84
            p=0,54 v=57,-26
            p=53,17 v=-51,-63
            p=62,27 v=37,-99
            p=99,54 v=-56,-33
            p=64,79 v=44,-92
            p=37,83 v=3,16
            p=74,1 v=-26,3
            p=16,29 v=19,33
            p=47,45 v=84,-39
            p=69,64 v=-87,-27
            p=95,29 v=-90,-64
            p=19,7 v=96,14
            p=87,58 v=75,82
            p=19,101 v=8,97
            p=26,76 v=12,46
            p=37,19 v=50,-44
            p=67,99 v=-76,-81
            p=58,74 v=-95,-60
            p=39,10 v=89,-82
            p=71,96 v=12,62
            p=77,83 v=-16,42
            p=49,35 v=12,37
            p=9,68 v=-71,-86
            p=73,26 v=7,-68
            p=14,42 v=76,77
            p=6,58 v=-38,-61
            p=70,58 v=98,5
            p=80,28 v=-24,87
            p=95,96 v=12,3
            p=61,84 v=58,-9
            p=84,82 v=-26,60
            p=20,5 v=9,86
            p=87,36 v=-72,-41
            p=31,17 v=-41,-70
            p=23,100 v=-92,2
            p=22,61 v=25,51
            p=11,67 v=-62,24
            p=89,30 v=-69,-6
            p=95,44 v=25,89
            p=38,98 v=3,15
            p=4,99 v=-15,-49
            p=51,47 v=-10,-92
            p=44,68 v=-56,16
            p=72,35 v=87,53
            p=75,73 v=45,10
            p=68,82 v=-53,41
            p=28,57 v=-75,49
            p=88,4 v=68,40
            p=89,82 v=31,-73
            p=17,63 v=-45,-98
            p=14,91 v=-92,29
            p=97,68 v=12,31
            p=35,28 v=50,-20
            p=91,96 v=84,-24
            p=96,77 v=75,-81
            p=56,0 v=-74,-23
            p=78,100 v=35,-75
            p=10,24 v=40,-78
            p=63,80 v=-16,61
            p=56,75 v=40,69
            p=94,57 v=-63,49
            p=78,79 v=-36,-41
            p=88,71 v=-83,75
            p=96,52 v=52,30
            p=48,40 v=20,-32
            p=65,87 v=3,64
            p=92,50 v=42,38
            p=11,67 v=-82,24
            p=21,3 v=19,77
            p=54,32 v=1,66
            p=25,59 v=-24,-73
            p=61,11 v=-60,4
            p=69,34 v=20,-97
            p=7,57 v=12,-2
            p=37,75 v=87,-80
            p=52,77 v=-10,62
            p=98,97 v=81,52
            p=2,63 v=24,39
            p=5,71 v=12,-28
            p=47,39 v=54,-40
            p=79,63 v=-90,-15
            p=11,76 v=69,-21
            p=18,100 v=29,-30
            p=12,31 v=-25,-13
            p=25,25 v=-90,74
            p=88,86 v=18,87
            p=71,51 v=11,-65
            p=64,65 v=-77,88
            p=82,83 v=-99,-25
            p=32,45 v=60,-26
            p=25,65 v=73,37
            p=74,6 v=81,-5
            p=61,18 v=-18,-57
            p=51,62 v=-64,-85
            p=77,62 v=45,1
            p=21,25 v=-79,98
            p=46,43 v=7,58
            p=78,13 v=64,-83
            p=2,29 v=-5,36
            p=75,0 v=-80,2
            p=60,88 v=-99,80
            p=22,25 v=-28,58
            p=80,55 v=75,-40
            p=55,43 v=-14,55
            p=87,77 v=-29,94
            p=59,51 v=-13,-20
            p=10,99 v=-94,59
            p=21,66 v=73,24
            p=25,73 v=4,60
            p=84,72 v=-21,-28
            p=38,58 v=3,-85
            p=31,51 v=-71,-15
            p=30,57 v=-31,11
            p=17,80 v=-11,-45
            p=36,9 v=-24,-95
            p=76,88 v=-50,4
            p=6,25 v=-89,-55
            p=95,9 v=-48,66
            p=54,97 v=74,-81
            p=23,56 v=-35,6
            p=79,53 v=50,35
            p=91,11 v=-76,21
            p=10,46 v=-5,6
            p=98,52 v=-81,93
            p=29,66 v=30,31
            p=11,65 v=22,69
            p=63,48 v=74,58
            p=80,79 v=28,10
            p=30,1 v=53,3
            p=34,53 v=93,70
            p=44,98 v=97,93
            p=84,3 v=-73,27
    """.trimIndent(), 101, 103
    )
    check(8050, result)
}

private fun test(input: String, width: Int, height: Int): Int {
    data class Robot(var p: Point, val v: Point) {
        fun move() {
            val px = p.x + v.x
            val pxf = if (v.x > 0) (px % width) else if (px > 0) px else ((width + px) % width)
            val py = p.y + v.y
            val pyf = if (v.y > 0) (py % height) else if (py > 0) py else ((height + py) % height)
            p = Point(pxf, pyf)
        }
    }

    val robots = mutableListOf<Robot>()
    val regex = Regex("p=(\\d{1,3}),(\\d{1,3}) v=(-?\\d{1,2}),(-?\\d{1,2})")
    for (line in input.split("\n")) {
        val result = regex.matchEntire(line)
        val px = result!!.groups[1]!!.value.toInt()
        val py = result.groups[2]!!.value.toInt()
        val vx = result.groups[3]!!.value.toInt()
        val vy = result.groups[4]!!.value.toInt()
        robots += Robot(Point(px, py), Point(vx, vy))
    }

    fun safetyFactor(): Int {
        var q1 = 0
        var q2 = 0
        var q3 = 0
        var q4 = 0
        for (robot in robots) {
            if (robot.p.x < width / 2) {
                if (robot.p.y < height / 2) {
                    ++q1
                } else if (robot.p.y > height / 2) {
                    ++q3
                }
            } else if (robot.p.x > width / 2) {
                if (robot.p.y < height / 2) {
                    ++q2
                } else if (robot.p.y > height / 2) {
                    ++q4
                }
            }
        }
        return q1 * q2 * q3 * q4
    }

    var i = 1
    while (i <= 10000) {
        val map = mutableMapOf<Point, Int>()
        for (robot in robots) {
            robot.move()
            map.putIfAbsent(robot.p, 0)
            map[robot.p] = map[robot.p]!! + 1
        }

        fun printRobots() {
            println("==$i")
            for (y in 0..<height) {
                for (x in 0..<width) {
                    val p = Point(x, y)
                    if (p in map) {
                        print(map[p])
                    } else {
                        print('.')
                    }
                }
                println()
            }
            println("==$i")
        }

        println("$i ${safetyFactor()}")
        // found visually horizontal line anomaly:
        // 16 69009444
        // 119 66570224
        // horizontal period 119-16=103
        // found visually vertical line anomaly:
        // 71 167745598
        // 172 166472280
        // vertical period 172-71=101
        if (i == 16 || i == 119 || i == 71 || i == 172) {
            printRobots()
        }
        if ((i - 16) % 103 == 0 && (i - 71) % 101 == 0) {
            printRobots()
            break
        }
        ++i
    }
    return i
}
