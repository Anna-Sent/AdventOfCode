package advent.advent2020

import utils.Point3D

private fun test(input: String): Int {
    val tiles = input.split("\n")

    var map = mutableMapOf<Point3D, Int>()
    for (tile in tiles) {

        var current = Point3D(0, 0, 0)
        var last = current
        var i = 0
        while (i < tile.length) {
            val x = current.x
            val y = current.y
            val z = current.z
            var ch = tile[i]
            when (ch) {
                'e' -> {
                    ++i
                    val next = Point3D(x + 1, y - 1, z)
                    last = next
                }
                's' -> {
                    ++i
                    ch = tile[i]
                    when (ch) {
                        'e' -> {
                            ++i
                            val next = Point3D(x, y - 1, z + 1)
                            last = next
                        }
                        'w' -> {
                            ++i
                            val next = Point3D(x - 1, y, z + 1)
                            last = next
                        }
                    }
                }
                'w' -> {
                    ++i
                    val next = Point3D(x - 1, y + 1, z)
                    last = next
                }
                'n' -> {
                    ++i
                    ch = tile[i]
                    when (ch) {
                        'w' -> {
                            ++i
                            val next = Point3D(x, y + 1, z - 1)
                            last = next
                        }
                        'e' -> {
                            ++i
                            val next = Point3D(x + 1, y, z - 1)
                            last = next
                        }
                    }
                }
            }
            current = last
        }

        val oldValue = map.getOrPut(last) { 0 }
        map[last] = oldValue + 1
    }

    for (i in 1..100) {
        val newMap = mutableMapOf<Point3D, Int>()
        newMap += map

        for (point in map.keys) {
            for (p in point.neighbors()) {
                newMap.putIfAbsent(p, 0)
            }
        }

        for (point in newMap.keys.toSet()) {
            val neighbors = point.neighbors()
            val blackNeighbors = neighbors.count { it.isBlack(map) }
            if (point.isBlack(map) && (blackNeighbors == 0 || blackNeighbors > 2) ||
                    point.isWhite(map) && blackNeighbors == 2) {
                newMap[point] = (map[point] ?: 0) + 1
            }
        }

        map = newMap
    }

    return map.keys.count { it.isBlack(map) }
}

private fun Point3D.isBlack(map: Map<Point3D, Int>) = (map[this] ?: 0) % 2 == 1
private fun Point3D.isWhite(map: Map<Point3D, Int>) = !isBlack(map)

private fun Point3D.neighbors(): Set<Point3D> {
    val set = mutableSetOf<Point3D>()
    set += Point3D(x + 1, y - 1, z)
    set += Point3D(x, y - 1, z + 1)
    set += Point3D(x - 1, y, z + 1)
    set += Point3D(x - 1, y + 1, z)
    set += Point3D(x, y + 1, z - 1)
    set += Point3D(x + 1, y, z - 1)
    return set
}

fun main() {
    test()
}

private var result: Int = 0

private fun test() {
    result = test("""
        sesenwnenenewseeswwswswwnenewsewsw
        neeenesenwnwwswnenewnwwsewnenwseswesw
        seswneswswsenwwnwse
        nwnwneseeswswnenewneswwnewseswneseene
        swweswneswnenwsewnwneneseenw
        eesenwseswswnenwswnwnwsewwnwsene
        sewnenenenesenwsewnenwwwse
        wenwwweseeeweswwwnwwe
        wsweesenenewnwwnwsenewsenwwsesesenwne
        neeswseenwwswnwswswnw
        nenwswwsewswnenenewsenwsenwnesesenew
        enewnwewneswsewnwswenweswnenwsenwsw
        sweneswneswneneenwnewenewwneswswnese
        swwesenesewenwneswnwwneseswwne
        enesenwswwswneneswsenwnewswseenwsese
        wnwnesenesenenwwnenwsewesewsesesew
        nenewswnwewswnenesenwnesewesw
        eneswnwswnwsenenwnwnwwseeswneewsenese
        neswnwewnwnwseenwseesewsenwsweewe
        wseweeenwnesenwwwswnew
    """.trimIndent())
    check(2208, result)

    result = test("""
        eweneeewwneeeneneseweeeee
        eenweesewseweene
        nenwnenenenenenenwewnwwwnenwnwnwese
        seseseeneseseseswneeswseseseseseseesese
        nwsewewwwwewwwwwnwnwwwnwwsww
        weseeewwnwwwswnwswnwewneswnwnwswsw
        eeeweneeeeneeeee
        eneswswneswwsenwwsenweswnwswswswsesw
        nwseeeeewneswswsesenweeenweeee
        swswnwnwseswneseswswnwsenenwsenwswwese
        nwswsenesewnwwnwnewnenwwwwwnwwse
        swwsesesesenwseswswswswseseseseeeswnwse
        neneneeneenenenwnenenenwseswnenee
        swnenwnenenwnenwewwswnweenwnwnwnwnese
        swsewseseswseeswswseswsese
        wnewnweneenenenwsenenenesweswwneswnw
        nwenenwnenwnwnwnwswnenw
        esesesesesesesesesesesesesesesenwsese
        nenwnwnwnwenwnenwnwnwnwsenenwnwswnenwse
        eewnenesenwneswenewneneneeeewne
        ewwneseeeeneneeneneneneenenenenene
        eweseseeneneneeswnwwnenewneneenee
        sesweswnenwwnwsewnwnwnweewseeswwe
        seeeseneeweeseee
        swseneneewwnenwwwwnwsesese
        neenweeseneswseseswwwnweneeweese
        eeeseswseseeeeeeeeneeeenwese
        wnenenenewneeneneenenenesenene
        nwnwnewwsesenenwnwwwewwwwwwnw
        wneswswwswswswwswswswwseswsww
        nenenesenwneswwwnwnwnwswswwnwenewse
        neenenenenenenenenwswnenwnwsenenenenewnene
        wwswwsewnenewsewwwwwwwnwswse
        wwwwwwwwwewewwwwwwwsw
        nwneweseeseeneseeeneesewewwe
        swwenwnenwnwewwseeesenwswnwwwsw
        wwswwwsewweswswwneneewswwswwsww
        swnwswenwseswswswswswnwswseswswswswsese
        eeeneeneswnenwneenenesee
        enwnwnenwnesenwnwwenwnwswswnwwe
        nwnenenenenwnwnwswswseneneneswnwnwswnene
        seseeenweweenenwneeneneeeeseene
        nenwnenenenwneeenenwnewswnenw
        wswneewswswneneswsewswseneseswswseswsw
        wewenesweeeeeneneweneneeenese
        senwnwnenwenwnwwnenwsesenwnwnwnwnwsenw
        seneeneeswseneenwenwnwswneeneenwe
        senenwsenesewswwseseswseneseswswnenwswe
        wwswewwenweewwwwwswneswww
        swwnwnwneneneneeneneneneenwswnenenww
        nwwnwwsenwnwnwswnwwwsenwwnewwww
        nwswswnwenwseeeewsenwseenese
        eweeseeeswenwnweswenwnewwsew
        neeswenweseeeeeeseeeee
        nesenwenenwnesenwwneneneneneneneswnene
        swswswswswswseswswneswwswneneswswsewsw
        eeeenweesweeeseeeeee
        nwenesenwneswnewsenenwwnwsewswwnewse
        seeeseseenwseeswwseseswwenesesese
        wewnwnwwwwwwenwwwwwwwwww
        enwswswswnwnwneeeewseeseeeseseese
        newenwnenwewswnenwnwnwnwnwnwnenenwnenw
        wwnwnwnwswnwnwwwnwnwsenwnwewnwnwww
        nwnwswnwnwwwwwwwnwwwnwnewsewww
        swsenweeeseseseweneeeseseswseseenw
        sesenwseeneseseweseseseseesewnweese
        seeneweesewseneeeseseeseseesee
        swswswswswswswswnwsweswswswswswseswswsw
        nwseeeseseseesweeeseenwsweseseeee
        seseseneseseseseseseswnesesesesewsenww
        wwnewwnwwsewnwewwnw
        wwwnwwwwswwswwwswsesenw
        nwnwwwsenwwnwnwnwnwnwnwnwnwwswnwnwe
        newnenwnenenenwseneneswnenwnenene
        esweeeneswneneweneseneewwenese
        sesewnwseseswsesenewseneseeneswsenwe
        seeeeeeeeeenenenweneeesweene
        seeswenwseeswswweeenweneneseenene
        nenwnenenwnenenwnwnenwnwnenwnenenwsw
        nesenewswsewnwswwswweswswswwswnwewse
        nwsweswswswwenewwswswwswwswnewsww
        sewseseswswseseseeseseswseswswesewsw
        nenenenenenwnwsenwnenenewnwsenwnenwnenw
        sewwwsewnewweswsenenwwwswenwnenww
        eewwswwwwwswwwe
        nwsenwswwnwseenwnwnwnwnwnenwnwwnwww
        nenwnwnenwnwnenenwnwwseneenwnwnwne
        neneswswsweswsewswnesewneswwswnenewnw
        wnwewnwwwwwwwwwneswnwnwnwwwse
        eswswswswswswswswswswseswnwswswnwswsesw
        nenenwnenwnenwnenwnwnenenenenenwnwsenenwse
        nwnwnwnwnesenenwswnwnwnenwnwnenwnwnwnwnenw
        swswwwwswwwwweswsww
        enewswwwswwwwswsewwwwwwwswsw
        wsesesesesesesesewneweswewseswseese
        neeneneneneenenenweeneneneeeeesw
        swneneenenenwswewnweneeneneneneneenwsw
        wwwnwwnwwwnwweweewnwwwwsw
        nwwsewwnwwwnwnwewwwnwnenwwww
        enwnenwnenwnenewnwewne
        nwewseneswneeewnwswenwswsenwswwne
        wwswnewswswwwswwnwwswseesww
        swnwnwenwnwnenwswneenwne
        newnwswwswswswswswwseswseswneswswswsw
        wswseeswswneswswwswwsweewwwswe
        neeeeseenwswewweeneneenenenenee
        wswwewneswswwwwwwnwwwsenwwww
        swswneswsewewseneesweenwnwseneee
        swswnwswswwwsewswwwwwwwwww
        wnwsesesesesesesesesenese
        nwseeeseneeswsenenweseseeswsesewe
        esesewewnwseseeeseseeseesee
        neswnweseswswswnwswswswswnwwneseeswnw
        enwnwnwwseenenwnwsenwnwwswnwwwnwne
        swseswseneswneswwnwweswnwwnwseswswse
        nwneneenenwswnwsewsenwswnwnwnesw
        swneswseseseswswseseseswseswsesesesenewse
        swesweeswswswsenwswswnwnwswseswswswsw
        senenwswnwseseseeseswseenwnwwnwenwe
        enweneneneswneeneneneneeneneeene
        sweswseeeeeeeseeesenwnwnwse
        neneneneeneneneeneneneenewneneneneswne
        wnesewnwneswwsenwnesenwwswnwenesenww
        neenewsweweeeeeseeeeeesee
        nwnwnenwnenwswneewnenenwnenenenwnwsewene
        eseweseseeeeeeseseeeeeneese
        swswswswenwwswswswsweswswswswswswnenw
        wsenenewnenenenenenesenenenenenenenwne
        enewnwneswnenesewnesenwne
        wnwwwenwnwnwnwnwnwwnw
        eeseseswswwnweneweneeeneeeswe
        nwnesewswswswwwsww
        eeewnweeeeeeeeneneesesweee
        wnweswnwnwnwneseswnwnwnwnw
        nenenenwnenenwnenesenenwsw
        nwswnewwswsewneswnesewwwwsewswnw
        eneseeneswneneneeeeenwneeneeene
        nenenwenenwneenenenwnwnewnwneswnenenwne
        wseswseswenwneeneseeeseseseesewsenese
        wnwnwwwwnwswnwenwnwswwwnwwewwww
        neneeeneneneseeneneneneeeneneeswnenw
        neneneeeneswneneneeneenenenenesenenew
        nwwwwnwnwnwnwwnwswnwnwnwwenwnwnww
        wsewwwwwwnwwwwewwnenwswwwww
        nwneneesenenenwswnwnewswnenenenenwnenenw
        seseswsesesenewwnwseswseswneeswnesee
        eswneneneswnwnenenwsenwnwnenenwnwnenwnwnenw
        seneesenenweeswwneeneswneswneseenwnw
        wwwnwnwewnwnwnwnwnwnwnwewnwnwnwnwnw
        enenewneneneneseneewnwneeewenese
        enenenenenenenwneneeseneneenenenewswne
        esesenwseseseseseseseseseswsenwsesesese
        nwnwwwnwnwwwnwsewneseseswnwnwnwsewne
        eswnwweeswnenweneseee
        nwnenwnwsenwnwnwnwsewnwnwnwnwnenwnenenw
        eneeneswnenenesenenenenenw
        sesewweseseseeeseseewseneseseee
        swesenwnwwneeenenwswsweswswwnwnwnww
        nwnwnwnenwnenenenwwnwnwnenwnwnwnwsenwswnwnw
        seseseswseswseswswseseswnwseeswswswsenw
        swseswseswswwswseeneseswseseseseseswsesw
        sesewseesewneswneesesesenw
        sesenesweseseseseswwseseswswnwsenesewsw
        nenenwsenwnwwnwwnwnenwnwnwnwnwnwenwnw
        swneswswwswwwswswswseswswswswswwwsw
        seneseseeweeeseeweeseweneese
        sesenwseseseneseseseesesenwneswswnwnwse
        swseswwswseswseseswswswseswswneswsesenwsese
        wnwwwsenewswswswnewswswse
        nwnwenwnenenwnwneenenwwwnwnenwswnwe
        eeesweseeeeeeeeeeenewnee
        swnwnwnwnwneneenenenenwnwnenenenwnenwnw
        nenwwnwnwwsenenwnesenwswnwwwwewww
        senenwswnewnwnwnewwnwsenwneneneneneenene
        swseswseswswswsweswswswswswseswnwswsese
        ewneesweneneeswneeneeneneneenwewne
        wsewwnwwwnewnwnwswwwnwnewwwww
        sewseneswseseeswneesewnweenwsweeese
        swswswweswswwswwnwswneswswswswwwswsw
        neswswswsewswwswswenwswsw
        swswwenesesenwnwswswseenwse
        nwnenwnwnwswenwnwnwnenwnwnwnwnwnwsenwnwsw
        swenwnenwseeenweeeneneeeeeesw
        nwnwnwnwnwsenwnwnwnwnwnwnwwnwwnwsenwnwne
        eseeeseenwewseeeeeesenweeese
        wwwwnwwwnewwwwwwwwwse
        seswnesewwneseseseseseseseswsesesesese
        seswswswswswswswswseseswswwneswswseswsw
        nwnwenenwnenwnwnwenwnwnwnwnwnwnwnwswswnwnw
        sesesesenesenwseseseneswwseswsenesewse
        neswneswswswwseswwswswwwsenwswneswsww
        nwnwwwnwnwwnwsewenwswnenenwnwswsenw
        eseseeseseseeneeseseseseeswsese
        nwwwnwenwnwnwwnwnwwnwwnwswwnenwnwnw
        nwnwnwnwnwnwnwnwnwnwnwnwenwnwwnwwnwsesw
        nwneswneneeeeeneseneeeeeesweene
        seeseseseweseseeeseseeeesenwse
        swneseswswseseeswswneseswswnwswswsewsw
        wwnwnwswnwnwnewewnwwwnwwwwswwnwnw
        nenenenewnenenwenenene
        seseseswswswseseswseswnwsesesesw
        senenesweseseweswswswseswsewneesenww
        nwsewnwnwnwnwnwnwnwnwnwnenwnenwnwnwnwnw
        seeeneenwesweeeese
        wswwswwneswwswwswswwwwwsw
        eeeseeeeeneneeeeweswnwneeswnwse
        senwnenwnenenenwnwnwnwnenenwwnenenw
        wwseswswswewnwwewwwwwwneswsw
        eeeswseswseenweenweseeseswnenee
        eeeeeeeeseeeeeeweneeese
        eewenwneneneneswneneswnwsenenw
        wenenenenwnwnwnenwswnenwnenwnwnwnwnenwnw
        esesesesesenwsewsesesesesesenesesesese
        wwwwweswswswww
        weswswswswswswwswswswswswneswwswesw
        eseseseseswnesesewseseenwswneswseww
        seseesewseneeseseeseeseenewsesee
        eeneeswenweeneeneeneeswseweene
        eneenwnweeeeseeese
        neneneneewneneseneneneeneenenewenene
        eewsesweneweswnwnesese
        ewwswswneswsenwswneswswswseswswwwsw
        wnwsenwnwwnewwnwwseswswwewnwwwe
        wswwwwwswswswswneswwswswswswwswe
        wnwnwnwwwewwwwnwnwnwnw
        nwesesenwwenwnwsewneswnenew
        nenenenwswnenenenwnwnenenwneneneenenene
        nwseswnwwnwnwwnwwnwnwnwnwnwseenwnwnwne
        neneenwswwswnenesenwne
        seswwseswwweswneswnenenwswsenwswwsw
        nwseswswwswswswswnwseswnwwswseswswswsww
        wwnewwwewwwwwwnwnwswwwwww
        neneswnenwnenenenenenenwneneswnenwnenene
        wwnwnwsesenwnwenwnwnwnwnwewnwnwnww
        eneenwneneneneeeeneenesweesweee
        swsewswwseseswswswseswseseeswswneswswsesw
        swewwwwwwnwwswwwewwwnwnwwww
        eeesenesewweseneseswweseeeesee
        wnwweseenwwwwwnwwnwnwnesenewswse
        nenenenenenesewnenenenenenenene
        swseswneswneswsewswsesenwswswseseswswsw
        wnwwwnwwenwnwswnwnwwnwwnwnwnwww
        sewsenweeeseeseeeeeeeesesesee
        enwsweweeeeneneeeeneeneswse
        nwnwnewnwwnwwnwnwnwwnwnwnwsenwnwnwnw
        swswwnesesewnwswswnwswswsewswswnewsw
        swnesenwnwnwnwnenenwnw
        neseeseseswwnwsenwswseswswnw
        swswswneweswnwswwwwwseswwswsw
        neneneswnwneneneneneswnenesenenenwnenwne
        swseseeewneeseswseseeseneenweese
        eseseeeenwseseeesesesee
        wwnwwwwwnwwwwwnwwwswnwweew
        newneeeneneeneene
        swswwwswweswnwswswswswswswswwseswswsw
        nwnwnwnwnwnenwneswnwnwsenwenwnwnwnwwnwnwnw
        seswwwwwwwnwswwswneswswwswswswsw
        neneenesenenweneesewenenweeswee
        seseseseseseseseseseseswesesesesenwswse
        neeneneenenenenenenesenesweneneeneenw
        nwwswseeseewenwnwwewwnwnenwew
        neswneneeneneenwnwnenenenwnwnewnenesw
        nwesewnwnwnwnwnwnenwnwnw
        nwnwnenwewenwnwnesewseswswnwnwenese
        swsweswnwswseswnwswswswsweswswswswsesw
        eweeneseeneeeeeeseeesweeee
        ewsenwnwnwnwswnwnwswsenwnenwswnwnwnwnenw
        enesenewwnwwseseswnwseesenenwseesese
        wwwwnenwewwnwwwwwwnwwsewwesw
        swwswwwseswnesewnew
        neewswwsenwwsenwsewnwwnwnenwnwenw
        eneneneesweeneneeneeneneenwneee
        swswewswswwwswswswswseeswwswswswnwsw
        wnenenewwneneesenesenwwsenwenwwsene
        nweeswnwnwnwnwswnwnwenwwnenwsesenewnw
        enwwwwnwwwwnwwnwnwwwnwwnweswnw
        swnwwswswewwswswswnwwnesewwswswsw
        nwenwnwwnenwswnwnwwnwnwnenenwneenwnw
        neneneneewneneneseneeeneeesweneeee
        swwseswwwswnwswwneneseswswewnewswswnw
        swsenwneseenwnwnwswnwwnenwwswnenwwwse
        nwnenwnwneneswnwnesenenw
        sesweswswwsesesenwsewenweswswsese
        ewswsenwsewnwsesweseneswswswwne
        swseeenweeseneenwsewnw
        nwwwewwwwnwwwnwwwwwwwewnw
        newsenwneswnwnenwnwnwneenwnwnenwnwnenw
        wwwewnwnwnwwwwwnwwwsenwwwnwnw
        eseeseewnenewweneswneneeeneewe
        swswnwswseswswswswswweswswswswswswswswsw
        neeeseeeneeeeweseenwneeeee
        enenwwenwnewswewwnwswwswnwswnew
        wwwsesesewwwwwnwnwwnewwwwwwne
        wwwwwwswswwwwwnenewswswwww
        enweseeeeeeneneweeeeenenee
        senenenenwnenenenenenewneeswnenenenenene
        wnwwwwwwwwwwwswnewnwwwnw
        eswwesenweneneeneenwenenenewswse
        nwnwnwswnwnwneneneneswnwnw
        sewswneswwsenwswwswseswwsweswnwswswsw
        wseeneeneseseeseswsesweeseeeneese
        nwnwnwswnwnwwwnwneswnwnwnwwwweswnew
        seseseseswnwseseseesesesesesesesw
        swswswswswnewswwswswswse
        senwseseseseseswneseswseseseswwsesesesesw
        wenwnwswnenwnwnwsewnwnwesenwwsenenesw
        eneneweneeswneeseeeenee
        sesewswnwseswswswsewswswseeeneswswene
        nwwwnwwwwseewwwenwwwswnwwwwnw
        wwswsewwwsenwwesewnwnwnwwnwnewww
        seswseseewseswseseseswse
        wnwwwnwwwwwswwwnesesewnewnew
        swseswseseswswswswswsenwswsesweseswswnwsw
        neeeseseseneseswseseeseseseswesesesee
        eswnewneseeneenenene
        wneneenweesenewneeeesenenee
        neswnenwwswswswswswwnenwswseswseesww
        nesenwnenwnwswnwnwswnenwnwnenwnw
        nenenwneswnenenenenenenwnwnwnwnenwnwswenw
        eeseseeeesenwsenweeeesee
        esenesesesenesewseswsesesesesesesewsesene
        swneneneneneneenenenenenenwnwneneswneneene
        seswseseswseswseseseseswseneswswnwseswnw
        eswnewneneneeneneneneeneswneswwnwne
        nwnenwnwsenwnwnwsewnwnwnwnwnwnwsewnenwnw
        neneneneswneesewwenwnesesenwswnwnwnenenw
        neneswneenwnewnenenenenenwnenenenenenene
        swwweswswweswwwswwswnwwwswnwswww
        wwwwswnwwwwwswswse
        swswswneswswswswswnwswswswswswswseswswwsw
        newsenweneswenenenewneenwsenwwnewnw
        eeseneeeweneenee
        swswswswswswswsweswswswnwswnwsweswswsw
        nwsenwnwnwwnwnenwnwwnwnwnwwswswnewne
        enewsewneneeeenenenenenenenenesenene
        newneeeeneneeseeenweeeeswee
        seeewswwseswwneneswswswswwwswswesw
        seseenesesesesesesewse
        nwswnwnenwnwnesenwnwnwnenwnenene
        eseseseeeeseenwseseeeswsesesenwesee
        swnwseswseswnwseeenwswswswsewswesesw
        wwwwnwwwswseeswnwwwwwwsw
        wsenwwneewnwsww
        senewswenesesesweseseeswseseseenesese
        nwseseseeseseswseeseesesesenesesenwsw
        nwnenwenenwnwwnenwswnwsenwnenw
        seseeeeeneewweweeseneeeese
        wseswswswnweswwwnwwwswswswwewswswsw
        newenwnwnenwnenenwnwnenenwsenesenwswnwne
        sweeeeeeneneeeeeneweswnwswe
        swnwswenwnwswnenenwneenwnwnwnwnwnwnwnw
        nwnwnwnwnwenwnwswnwswnwnwenwnwnwwnwnesese
        eswneseenewsewwewsenesenesewneesese
        neseeeeseseswsesewseseseewsesenesese
        nenwwnesweeeneneneenenwnesw
        wneeneesweneenene
        eseeweeseseeeneeeeeeeeee
        neenwneeweswnwswnwneneneneswewnwnwnese
        nenenwnenwnenenenenewnwnwnwnesenenenwnw
        neneeneweneseeeneeeneneeeeene
        wseesweeeeseseenweeeseseeee
        eswnwnewwnwswswewswsw
        wewewneswsenenwenewwwwseswww
        eswnwenwnwseseseenwnwwnenwnwweseswnwse
        wswswswswseewneseswswwenwwneswnwswsee
        swswswswenwsenwswswswswseswseswsesesw
        nwswewwseenwswneeee
        swnwwwnwewesewwenwwwnwwswww
        nwnwswnwwnwnwnwwnwnwnwnwenwnwnwnwnwnw
        eweseenweenesesee
        wsenwnwseswwswswwnenwnweswnwseeewswnw
        neeneneneeesweswnenwneneenenweneese
        swswseswswswwwswswnwswswwweswwwnww
        eeeseseneeweeeeeseenweeese
        wswwwwnwnwnwsenenwwnwenw
        nwnwnwnwnenwnwwwnwnwswnwswswnwewwe
        ewewwwnwwswseseseseeeseneeseee
        swwswwwwwwswewwwwwwwwew
        seseseeesweswwenwnw
        nwnwsewweswnwww
        wwnewwwswwwsewswsw
        seswwwwswewswwsewwwwwwnewwnww
        wwwswnwswwnewwsewwwwwwswew
        nwswswnenenwnenwsene
        swswsesenwseswsesesweswswswswseswswsw
        wwsweeswwwswwswswwnesw
        nwnwnwsesesewnwewnwwnewnwwnwnwnwesw
        enwwnwswwsweswneswnwwswnweeswsesw
        neeeneseseeeenwneeneeeweweese
        nwwsenwwnwwnwnwnwnwnwnwnw
        nwnwnenwwswnwswnwnesenwnwwnweneewse
        sweneswnesenenenewnenenenenwenwnwnenesenw
        nwnenweeswnwsesenwnwnwnwnenwwenew
        nweseeeseseseeeseseswneswseeeswsenwse
        eneneeeneweneesene
        nwnwswnenwnwnwnwnenwnwnenwnwsenenwnwwnwnwnw
        swweswnwwswwswswneswwswnenwneswewsw
        wswwwnwswwsewseewswswswwwwswne
        nwnesenenenwewwneneseneneneewnenenese
        neswwswswnwwwwswesweswwswswnewswnw
        newenesenenwnenwwneswneseeenenwnene
        nweswnwneswsenweeeesesesewenwee
        nwsenenenenenenwwnenwnwnenenenenenwneneswne
        swswswswswsenwneseswswswwswseswswswne
        swneswswswswswseswsewswsw
        senwesenwnwnwnwnwwnwwnewnwneswnwnwnw
        seswseswswseswswseseswnwswnwswswseseese
        nenenenenenenenwnwnenwneswnenenwne
        nwnwnenwnenwnenwnenenwnwnenenenwneneesw
        nwswnwnewnenwenenwnwnesenwnwnwnenenenenwnw
        wswnwnewwwnwswsewwnwwswnesene
        nwnenwnwnwenwnenwnewnwsenwswswnwwnwnwwnw
        wwnewwswswwsewwwswwwsewwwnwww
        sewnwenwnwsenewnw
        seseseweswwswenenwswneswwswneswswsese
        wseseseswsenwswwwnwwnenenenewswsww
        nwnwenwnwwnwwwnwnwnwnwnwnwnwnwsenww
        wsenewenenenenwneenwneswseenwswnww
        seseseseseseswseseeseswseseseseswnwsesw
        neenwneeeneseeneseneneeneneenenewe
        eseswseseseseseseseesesesewneswnewsesw
        eswneeesweswneeeeneeenwnweeeee
        seseseswseswwswswswswswneseswnwseswswswswsw
        swwwswnesewwwswswswswswwswswswnesew
        ewsenenwswswwsewsesesenwsenwseneene
        neneneneneenenweneneswnenenenenenewsene
        wwenwseweswnwnwwwswwswwwewnew
        eneeeenwweneeeeneeeneeeneswe
        eenewnwswesenwneeseweeseseeswse
        senwseesweseeswsesesesesenweeseesese
        wswwsenenwewnwwnesewnwswwwsewnwnw
        swneseswswweenwwwwwewwwswwsw
    """.trimIndent())
    check(4214, result)
}
