package advent.advent2023

private var result = 0

fun main() {
    result = test(
        """
            #.##..##.
            ..#.##.#.
            ##......#
            ##......#
            ..#.##.#.
            ..##..##.
            #.#.##.#.

            #...##..#
            #....#..#
            ..##..###
            #####.##.
            #####.##.
            ..##..###
            #....#..#
    """.trimIndent()
    )
    check(400, result)

    result = test(
        """
            ...##....
            .#.##.#..
            .#....#..
            .##..##..
            ...##....
            ..####.##
            #..##..##

            ##...##..
            .##.#..#.
            .#.......
            ...#.##.#
            ##..#..#.
            .##..##..
            .#...##..
            #.#######
            ....####.
            ..##.##.#
            ..##.##.#
            ....####.
            #.#######
            .#...##..
            .##..##..
            #...#..#.
            ...#.##.#

            ...#...##...###
            ##.#.##.#..#.##
            ####.##.#..#.##
            #.#.##.###.#.##
            #...##.##...#.#
            ##..#.###...#..
            #...####.###...
            #.#####...##.##
            #.#####...##.##
            #...####.###...
            ##..#.###...#..
            #...##.##...#.#
            #.#.##.###.#.##
            ####.##.#..#.##
            ##.#.##.#..#.##

            .....#.
            ###.###
            ##.#.##
            ..#..##
            ..###..
            ..###..
            ..#..##
            ##.#.##
            ###.###
            .....##
            ###..#.
            ..#..##
            ##.####

            ....#....##....
            .##..##.####.##
            #..#.#...##...#
            .##.####....###
            #..#.##.####.##
            #..###.#.##.#.#
            .##.##.##..####

            ..##..##..#.#.#
            .####......#.#.
            .#.#.###...#..#
            .##.#..##.....#
            ..#.#.##..###.#
            ..#.#.##..###.#
            .##.#..##.....#
            .#.#.###...#..#
            .####......#.#.
            ..##..##..#.#.#
            #...#..#...#...
            .#.#.##..##...#
            .#.#.##..###..#

            #...##...#.#.##.#
            #...##...#.#.####
            #.##..##.##.##.#.
            ............###.#
            ....##.....###.##
            #..#..#..#.##....
            #.#....#.#..##.##
            ..######...####.#
            #.#....#.#..#####
            .#.####.#.#.###..
            .##.##.##..#...##

            ##.##....##.##...
            ##....##....##.##
            #.##..##..##.##..
            .##.#.##.#.##.#..
            ..##.....###...##
            ####.#..#.####.##
            .#..........#....
            #####.##.######..
            #..#.####.#..#...

            #.##..###.#..
            .#...###...#.
            ##...####....
            ####..#.#.#..
            #.....##..###
            #.....##..###
            ####..#.#.#..
            ##...####..#.
            .#...###...#.
            #.##..###.#..
            ###.#.####..#
            .##.#.#...###
            #.##.######.#
            #..#.......#.
            #..#.......#.

            ###...##...##
            ...#..#####.#
            ###.##.#.....
            ..#...#...###
            ..##.###.....
            ....#...#...#
            #####...##.##
            ....#.##.####
            ....#.##.##.#

            ..##..###...#....
            ##..#######...###
            ##..###.......#.#
            ..##..#.#....####
            ########...###...
            .####........#...
            .####.#..##...###
            .#..#...###.#.###
            .####.#.###.##...
            #.##.#..####.#...
            #.##.#..##...#...

            #.#....#.##
            ..#....#...
            ..#....#...
            #.#....#.##
            ##......##.
            .#.####.#..
            ####.#####.

            ...##...#..#.
            ########...#.
            .######..#...
            ..#..#.....##
            #.#..#.#####.
            ##....##.####
            ..####...###.
            #.#..#.##.#.#
            #......#.###.
            .#.##.#.####.
            .#.##.#.####.
            #......#.###.
            #.#..#.#..#.#

            ##....#.##.##.##.
            ####......#..#...
            #...###..######..
            #...#.##..#..#..#
            .#.##.#.########.
            .#.##.#.########.
            ....#.##..#..#..#

            ###..##.#
            ##.#..##.
            ##..#....
            ....#....
            ..#......
            ..##..##.
            ##.#.#..#

            .....#...#.
            ..##...#...
            ##..###...#
            .#..#.#.###
            #.##.#.##..
            .#..#.##.##
            #######.##.
            .........##
            ..##....#.#
            .......#..#
            .#..#.####.
            #....#####.
            #.##.#..#.#
            #.##.#..#.#
            #....#####.
            .#..#.####.
            .......#..#

            #.####.
            #.####.
            ...#...
            ##...##
            ....#..
            #....#.
            .#..#..
            #..#.##
            #.#....
            .#..#.#
            .#..#.#
            #.#...#
            #..#.##

            .##..##..#.##
            #..#..#..#.##
            ....####.####
            ....###.##.##
            .####..##.###
            .....#...#.##
            #..##.##...##
            ####.###.....
            .##..#....###
            #..#..#..####
            .##.#####.#..
            ......###.###
            #..#####..#..
            #..##.....###
            #..#..#.#..##

            .###..##..###
            .#.#.#..#.#.#
            ....##..##...
            ....##..##...
            ##.#.#..#.#.#
            .###..##..###
            ###.#....#.##

            ##.########.##.
            ###.#.#..#.####
            ..#...##...#..#
            ###.##..##.###.
            #.#.##..##.#.#.
            .##.#.##.#.##.#
            .##.#.##.#.##.#

            .#..##.
            ..#..##
            ###.###
            ###.###
            ..#..##
            .#..##.
            .#.##..
            #...##.
            #...##.
            .#.##..
            .#..##.
            #.#..##
            ###.###

            ......#.#.#.#
            ......#.#.#.#
            #..##...##..#
            #..##..##..#.
            ..#.##.##.##.
            #..##..#..#.#
            #..#.#..#####
            #..#.##.##..#
            ....####..##.
            .##..#..##.#.
            ####.#...##..
            .....#.####.#
            #..#....###..

            .#...#.#...##..
            #....#.#.......
            ..##.#.....##..
            ####.###..####.
            .#.#.#...#.....
            ##...###.......
            ..##.#.########
            .####.....#..#.
            .#.#..##.......
            ##.#..#.##.##.#
            ..#....#.#....#
            ..#....#.#....#
            ##.#..#.##.##.#
            .#.#..##.......
            .####.....#..#.
            ..##.#.########
            ##...###.......

            .......#.#.####
            .......#.#.####
            ..##..####.##.#
            #...####.####.#
            ##..##.####.##.
            #....##.#.###..
            .####..#...#.#.
            #.##.#.##.##..#
            ..##.......#.#.
            #....##..#..#.#
            ..##...##..##.#
            #######.#....##
            #.##.#..##.#.#.

            ....##..#
            ..#.##..#
            ..#.###.#
            #......##
            ...##....
            .##..#.#.
            #.#.#....
            #..#....#
            .##.###..
            ###.#.##.
            ###.#.##.

            ######.
            .###...
            ##.##.#
            #..##..
            #..##..
            ##.##.#
            .###...
            ######.
            ...#...
            ..##.##
            ##...##
            ##....#
            ..##.##
            ...#...
            ######.
            .###...
            ##.##.#

            ....###.#..
            .##.##.####
            .##.##.####
            ....#####..
            ######.#..#
            #####..#.#.
            ....##...#.
            .##.##.#..#
            .##.##..#.#
            #..#.#.#.##
            .##..###.##
            ....###...#
            .##.##.#...
            ####.#.#.#.
            #..#.##..#.

            ##..#.##.#.#..#..
            ..#....#..##.##.#
            ...##...####..###
            ###..#.#..#.##.##
            ###..#....#.##.##
            ...##...####..###
            ..#....#..##.##.#
            ##..#.##.#.#..#..
            ..#.##..#.#..#..#
            ..##..#...#....##
            ..####..##.....##

            .......####..#..#
            .##.#....###..##.
            ###..#.###.###..#
            ##.##...#########
            ....###......#..#
            .#.########...##.
            #.......###.####.
            #...##..##.##.##.
            #.#.#.#....#.....
            ##....###..###..#
            ..#.##.###.#.####
            ..#.##.###.#.####
            ##....###..###..#
            #.#.#.#....#.....
            #...##..##.##.##.

            ###..##
            ..#.#.#
            ####.#.
            ...#..#
            ##.#..#
            ##.#.##
            ...#..#
            ####.#.
            ..#.#.#

            ####...
            ...##..
            ###..##
            ##.###.
            ##.###.
            ###..##
            ...##..
            ####...
            #.##...
            ....#..
            ##..###

            .###...##
            .###...##
            .##.##.#.
            ....##..#
            ##.###.#.
            .#..##..#
            ###.#..##
            #.#.####.
            #.#.####.
            ###.#..##
            .#...#..#
            ##.###.#.
            ....##..#
            .##.##.#.
            .###...##

            #.##.##.#..#.##.#
            ..##.##.####.##.#
            #.###############
            ..#..............
            #.#..##......##..
            .#.##..##..##..##
            #........##......
            ##.#..#.#..#.#..#
            ....####....####.
            #....##......##..
            ...#.##.#..#.##.#
            ##..####.##.####.
            #..#....#..#....#
            .#..#..#.##.#..#.
            .....##......##..

            .#....#.#...##...
            .#.##.#..#.####.#
            #..##..#.#.#..#.#
            ##.##.##..##..##.
            ###..######.##.##
            ########.#.#..#.#
            ...##...#..####..
            #......#.#......#
            .##..##...##..###

            ..##.#.#.##.#.#
            ..##.#.#.##.#.#
            ##..#....##.###
            ...#..#.#..#...
            .#.####..####..
            ..##.##..####.#
            ##....#.##.#.#.
            ...#.#...#####.
            ...#.#####...#.
            ###...#..###..#
            ..........###..

            ##....##....##.
            ##....##....##.
            #.#.#....#.#.#.
            ##..##...#..##.
            ####......####.
            #.#...##...#.##
            .#####..#####..

            ......###..
            .#..#.####.
            .#..#.###..
            .####...###
            .####...###
            .#..#.###..
            .#..#.####.
            ......###..
            ..##..##...
            ##..###..##
            .####...#..
            ##..###.#.#
            ..##...##..
            ##..#####.#
            ###.##.#...

            ......##.#.#.
            .#.....#...#.
            ###.#..#...##
            #..#.##.#...#
            #..#.####...#
            ###.#..#...##
            .#.....#...#.
            ......##.#.#.
            ##.######...#
            ...#...##.###
            #....#####..#
            ..##..#..##.#
            #.####..#.###
            .##...###.#..
            .#..#.###.##.
            .#..#.###.##.
            .##...###.#..

            .###..###.##.
            ###.###..#.#.
            ..###......#.
            #..#..#.#...#
            .#..#.....#.#
            .#.#...##.#.#
            ##...##..##.#
            ##...##..##.#
            .#.#...##.#.#
            .#.##.....#.#
            #..#..#.#...#
            ..###......#.
            ###.###..#.#.
            .###..###.##.
            .###..###.##.

            ###.####.##
            ##........#
            #..........
            #.########.
            ..##....##.
            .#.#.##.#.#
            .#........#
            #.........#
            .##......##
            ###..##..##
            #####..####
            #####..####
            ###..##..##

            ##.#.#..#..
            ....#...##.
            ##..#.#..#.
            ...######..
            #######..##
            ##.##..#.##
            ..#..####.#
            ###...##...
            ......##.#.
            ###.#..#..#
            ..##..###..
            ...#.#.##.#
            ...#.#.##.#
            ..##.####..
            ###.#..#..#
            ......##.#.
            ###...##...

            #####.#.##...#.
            ......######...
            #...#.#.#.#..##
            ..####.#.#.##.#
            ..######.#.##.#
            #...#.#.#.#..##
            ......######...
            #####.#.##...#.
            .#...##..###...
            .#...##..###...
            #####.#.##...#.

            ####.#.
            #..####
            #..#..#
            #..#..#
            .##.#..
            .##..##
            ...#..#
            ....##.
            #..####
            #..####
            ....##.

            ###...##.###...##
            ###.####...####.#
            ...#..#.##.#.##..
            ...#..#.##.#.##..
            ###.####...####.#
            ###...##.###...##
            .#.#.#.##.#....##
            .#.#.#.##.#....##
            ###...##.#.#...##

            .##.....#
            ........#
            #####..#.
            #####..#.
            ####..###
            ....##...
            ....####.
            #..###..#
            .##..##.#
            .##..##.#
            #..###..#
            ....###..
            ....##...
            ####..###
            #####..#.
            #####..#.
            ........#

            .#...##
            .#...##
            ##.....
            .#.####
            ##.##..
            #....#.
            .####..
            #....#.
            #....#.
            .####.#
            #....#.
            ##.##..
            .#.####

            ..#.#.##...
            ..#.#.###..
            ##.##..###.
            ..####...#.
            ##.#....###
            .#...#####.
            ..#.##.###.
            .#....##...
            .#..#.##..#
            .#..#.##..#
            .#....##...
            ..#.##.###.
            .#...#####.
            ##.#....###
            ..####...#.

            ####.#####....#
            #..#.###..#..#.
            ####.####....##
            #######..###.##
            #..###..##....#
            .##..###.#...##
            .##..###.#...##
            #..###..##....#
            #####.#..###.##
            ####.####....##
            #..#.###..#..#.
            ####.#####....#
            .##.####.##.#.#

            ####.##
            ..##.#.
            ..##...
            .#.....
            ....##.
            ##..#.#
            ###...#
            ##.##.#
            ..##...
            ..##...
            ##.##.#

            #.#.#.#.....##...
            ..#...#...#....#.
            .##..##..##.##.##
            ...#.##.##......#
            ###..##.#.#.##.#.
            .##.####..#....#.
            .###..##.........
            ..#.###..#.####.#
            .#...#.#..#.##.#.
            ###...######..###
            #.#####...######.
            ###.###.#..####..
            ##..##.###..#...#
            ##..#..##.######.
            ##..#..##.######.

            .###.#..#.###..##
            ####.#..#.#######
            .##..#..#..#....#
            ##.#.####.#.####.
            ...#......#......
            ....#....#.......
            ......##.........
            #.##..##..##.##.#
            .##.######.##..##

            ...######...#.#
            ...######...#.#
            ..###..###....#
            .##.####.##..##
            .#.######.#....
            ###.#..#.##..##
            #.#..##..#.###.
            .##......##.###
            ###.####.###.##
            .#..####..#...#
            .###.##.###.###
            ##.######.###.#
            #..##..##..#.#.

            ....##.....##..##
            .##.##.##..#....#
            ..#....#.....##..
            .##.##.##..#....#
            ##########.......
            ###########.####.
            ..#.##.#..#.#..#.
            #..####..###....#
            ..##..##.........
            ..##..##...######
            #........#.#....#
            #.######.####..##
            .###..###..#.##.#
            .##....##...#..#.
            ....##...#.#.##.#

            .##...#..####
            .....####..##
            #######.#..#.
            #..###.#.###.
            #..#.##...###
            #########.#..
            #..#..##...##
            .##..##.#####
            #..#..#..##..
            #######.##.#.
            ####..#......
            #..##.#...##.
            .##...#.#..##
            .##...#.#..#.
            #..##.#...##.

            ###.#........
            ..#.##.......
            ##.##..#.....
            .##.##..#####
            .#....#..####
            ##...#..#....
            ###..########
            .###..#..#..#
            .#.#.#.......
            ######.......
            #...#..######
            .##....######
            #...#.#.#####
            .#.#...######
            ####..#..####

            ###....
            ###....
            .####..
            #.#.##.
            ..##..#
            .##.#.#
            #.####.
            ##.#.##
            #.##.##
            .#....#
            .#.#.#.
            .#..#.#
            #..####
            #..####
            .#..#.#
            .#.#.#.
            .#.#..#

            ####..##.
            .##..#..#
            ....#.###
            ....#.##.
            ....#.#..
            .##..###.
            .##..###.
            ....#.#..
            ....#.##.
            ....#.###
            .##..#..#
            ####..##.
            ##.###...
            #..#...#.
            ####.....

            ##....#####
            .######.#..
            #..##..#...
            #..##..####
            .######....
            .#......#..
            ..#..#..###

            ###.#...###
            ...####...#
            ..#..#..#.#
            ..##.#.#..#
            ###.##..###
            ###..#....#
            ##...#....#
            ###.##..###
            ..##.#.#..#
            ..#..#..#.#
            ...####...#
            ###.#...###
            ..####.#.#.

            ...#.##..#...#...
            #.#...###.##.####
            ....#.#.##.#.##..
            .....#.#.####.#..
            .#.#.#.##..#.####
            .#.#...##..#.####
            .....#.#.####.#..
            ....#.#.##.#.##..
            #.#...###.##.####
            ...#.##..#...#...
            ...#....###...#..
            #..###.......##..
            .#.###.#.###.####

            ...####..
            .##....##
            .########
            ##......#
            #..#..#..
            ....##...
            #..####..

            ####..##.##
            ###.#...##.
            ....#..####
            #...##..#..
            ..#..#...#.
            ..#..#...#.
            #...##..#..
            ....#..####
            ###.#...##.
            ####..##.##
            ..###...##.
            #.#.#.##.#.
            .####..#...
            ..###..#...
            #.#.#.##.#.

            .....####.....#..
            ##.#.#..#.#.##...
            .#.#......#.#.###
            ...###..###...#..
            .#..######..#.#..
            ####.####.#####..
            ...###..###...#..
            #............#.##
            ..#.#.##.#.#.#...
            #..###..###..#...
            ...#......#....##
            ##...####...##.##
            #...##..##...#.##

            .####..###.
            .##.###.#..
            .##.###.#..
            .####..###.
            #.#.#.#.###
            ####.####..
            #.....##.#.
            #.....##.#.
            ####.####..
            #.#.###.###
            .####..###.

            .....#..#..
            #..###..###
            ####......#
            .##.#.##.#.
            #..#######.
            #..#..##..#
            .....#..#..

            ##..#....
            ...#.#.##
            ###...###
            ....###..
            ##..###..
            ###.###..
            ###....##
            #....#...
            ####...##
            ##.###...
            .......##
            ..#.###..
            ##..###..
            ...#..###
            ###...###

            ..#.##.#...####
            ##.#..#.##.####
            .###..###......
            .##....##...#..
            ..##..##...####
            ..#....#.....##
            #.#..#.#.#..#..
            ..#.##.#...#...
            #...##...##..##
            .##....##.#####
            #...##...#..###
            .#..##..#.###..
            #...##...##..##

            #....#.#.
            ###..###.
            ###..###.
            #....#.#.
            #.#.#..#.
            ...##..#.
            .#..###.#
            #...#....
            #...##...
            ##.###..#
            #..##.##.
            #..##.##.
            ##.###..#
            #....#...
            #...#....
            .#..###.#
            ...##..#.

            .#...#.#.
            #.##.##..
            ####..#..
            .#.######
            ...##.###
            ...##.###
            .#.#####.
            ####..#..
            #.##.##..
            .#...#.#.
            .#...#.#.

            ####.#..#.#####.#
            ##.##....##.####.
            #..#.####.#..##..
            #####....########
            ###..####..######
            #####....########
            #.##..##..##.##.#
            ##.#..##..#.####.
            #..#......#..##..
            ..##......##....#
            #............##..
            ##.##....##.####.
            ...#......#......
            ....#.##.#.......
            .####....####..##
            .#..........#..#.
            .##.#.##.#.##..##

            #..#...##..
            ..######.##
            ..######.##
            #..#..###..
            ....#.#....
            ##....##...
            #.#.#.##..#
            #.#.#.##..#
            ##....##...
            ....#.#....
            #..#..###..

            #..#..#..#...
            ..##..##..##.
            ..#.##.#..#.#
            ############.
            #.######.##..
            #.######.#.##
            #.######.#..#
            #.######.##..
            ############.

            ..##..###.#..#.
            ...#......#..#.
            #.##.......##..
            .....##.#.#..#.
            .....##.#.#..#.
            #.##.......##..
            ...#......#..#.
            ..##..###.#..#.
            #.#.##...##..##
            #####.##..#..#.
            #......##......
            #.#..##.###...#
            ##.#......#..#.
            ##..#.#...#..#.
            .#.###...######

            ##..#.#..##..###.
            .##.#.#.#..##..#.
            ...#...##.#..#.##
            .##.##...##..##..
            .##.##...##..##..
            ...#...##.#..#.##
            .##.#.#.#..##..#.

            .#.####..####.#..
            #.###.####.###.##
            ####..#..#..#####
            ..#.##.##.##.#...
            #.##.#.##.#..#.##
            #..#..####..#..##
            #.####.##.####.##
            ##.###....###.###
            ##.#.#....#.#.###
            ..##...##...##...
            ..###..##..###...

            ..#.#...##....#..
            ####..#..#..###.#
            #####.#..#..###.#
            ..#.#...##....#..
            ##.#.##.....###..
            ..####.########..
            ...##.##.#####.#.
            ..#.#......#....#
            ##..####.#.......
            ..##...#...#.##.#
            ....#.##....#..##

            .#.##.##..#
            ####.#..##.
            ##..##.####
            ##..##.####
            ####.#..##.
            ...##.##..#
            .#.........

            ##.#..#.#
            #.#.#..##
            #####.##.
            ##..##...
            ##..##...
            #####..#.
            #.#.#..##
            ##.#..#.#
            .##..##..
            .##..##..
            ##.#..#.#

            ###...##....#.###
            #.#..#.#.#.###..#
            .##.#.#.#.##.#.#.
            .##.#.#.#.##.#.#.
            #.#..#.#.#.###.##
            ###...##....#.###
            ...#.#.#.##..##.#
            #....####..##.#..
            #....####..##.#..
            ...#.#.#.##..##.#
            ###...##....#.###

            ..#####..
            .###.....
            #..###...
            ####.#...
            ###..#...
            #..###...
            .###.....
            ..#####..
            #.#.#####
            ..#.#####
            ##.#.####

            ...#....#####..
            ..###..#...#.##
            ##..#.###.#....
            ##....##.###...
            ..#..#...#.....
            #..#.##.##.##..
            .#.#..##.#.#.##
            ##..###.....#..
            .##.##...##.#..
            ##...##..##.###
            ##.#.##..##.###

            ...####..##.##.
            ...#..#####....
            ##..####.###..#
            ##..#####...##.
            ...#..#.#.#....
            ..#..#.#.......
            ....#....#..##.
            ..####.#.#.####
            ####.#....##...
            ####.#.#.......
            ####.####.##..#
            ..###.....#....
            ##..###.###.##.

            .####.###.#..
            .####.###.#..
            ########.###.
            #.###.##....#
            #...#...#....
            ....##.#.#..#
            .##......####
            #...##.....#.
            #.##...##..##
            ####...##.##.
            ####...##.##.
            #.##...##..##
            ##..##.....#.

            #......#.####
            .######.#...#
            .........####
            ##....##..#..
            .#.##.#..#..#
            ###..###...#.
            ..####..#.#..
            ###..###..##.
            ........#....
            ##....###...#
            ##....###...#
            ........#.#..
            ###..###..##.
            ..####..#.#..
            ###..###...#.

            .##.#.#...#...#
            .##.#.#...#.#.#
            #.##.####..###.
            ....#.#.##.####
            #..#.#.#.#..###
            .##...##.##..##
            ..##.##...##.#.
            ..#.#..###.##.#
            #####.##....#.#
            #...#.#...##.##
            #.###......#..#
            ##..#..###.#.##
            ..#####..#..###
            ..#####..#..###
            ##..#..###.#.##

            .##.##.
            .#.##.#
            #....#.
            #....#.
            .#.##.#
            .##.##.
            ...####
            ##....#
            #.#.###
            .####.#
            ###..#.
            ###....
            .####.#
            #.#.###
            ##....#
            ...####
            .##.##.

            ####.#....####..#
            ####.#....####..#
            #..##...##.#..#.#
            #..#..######..###
            #..#..#.#########
            .##..#.#...#.#...
            #..###......#.##.
            ####.#.###...##.#
            ####.####..#..##.
            ....##.#.#.......
            .##..##..#..#..##
            ###.#.#..#...####
            ####.###.###.#.#.

            .######
            .###..#
            .###..#
            .######
            #..#..#
            .#..###
            .##..#.
            .###...
            ##.#.#.
            .##....
            ..#..##
            .....##
            .##....
            ##.#.#.
            .###...

            ##....#####......
            ##....##.#..####.
            .#....#..##.#..#.
            ##....##.#.##..##
            .#.##.#....#....#
            ##....######.##.#
            ###..###.######.#
            ##....#####.####.
            #......##..#....#
            #.#..#.#..#.#..#.
            .#.##.#...##.##.#
            ..####..#..#.##.#
            .#.##.#.#..#....#

            .#.#..###.###
            .#.#...##.###
            ##......####.
            #...#.##.#...
            ##..#.###..#.
            .####..#.###.
            #...#..#..#..
            .####.##..#..
            .##..#..#...#
            .##..#..#...#
            .####.##..#..
            #...#..#..#..
            .####..#.###.

            #...#....#.#.
            ##.#.#.#.##.#
            ###.##...#.#.
            ###.##...#.#.
            ##.#.#.####.#
            #...#....#.#.
            ..#.######..#
            #...#..####..
            ###..##.##.#.
            ...#.#.#..#..
            ...#.#.#..#..
            ###..##.##.#.
            #...#..####..

            ..#.###
            ######.
            ..####.
            ###...#
            ###...#
            ..##.#.
            ######.
            ..#.###
            ..##.##
            .....#.
            ###..##
            ..####.
            ######.
            ##...#.
            ####...
            ..#.#..
            ##.###.

            .#..#.###.##...##
            ..##...#.##....#.
            ###########....#.
            #######...###...#
            #....##.#..#....#
            #....#.##.#..##.#
            .####.#.#.#.....#
            .####....##.##..#
            ##..##..#..####..
            .#..#.#...####..#
            #.##.##.#.###..#.
            #.##.##.#.#.#..#.
            .#..#.#...####..#
            ##..##..#..####..
            .####....##.##..#

            ##..##.##
            .#..#....
            ..##..###
            #.##.##..
            .......##
            ..##.....
            #....##..
            ..##...##
            #....#.##
            #.##.#.##
            ..##.....
            #.##.#...
            ...#..###

            #..##....##..##.#
            .###.####.###.###
            ###..#..#..#####.
            .#.##.##.##.#...#
            .#.##.##.##.#...#
            ###..#..#..#####.
            .###.####.###.###
            #..##....##..##.#
            .#.##.##.##.#.#..
            ....##..##.....##
            #....#..#.#..####
            .#...####...#.#.#
            #.#.#....#.#.##.#
            #..##.##.##..#...
            #....#..#....##..

            #....####
            ###......
            ###......
            ##...####
            ....#....
            .#.#..##.
            ..###....
            ##.#.....
            ...#..##.
            #.###.##.
            #....####

            #..####..#.##.#..
            .########..##..##
            #........#.##.#..
            ###.##.###.##.###
            ###.##.####..####
            ..##..##........#
            ..######........#
            #.#.##.#.#.##.#.#
            .##.##.##.####.##
            #.##..##.##..#..#
            .#.####.#......#.
            ....##....####...
            .##.##.##......##

            ..####..##..##..#
            ...#..##.####.##.
            .##.#.##..##..##.
            ...#..##.####.##.
            .##..#..#....#..#
            ##.##.##########.
            #########.##.####

            .###..###.#.#.###
            ###....###..##.#.
            ###.##.###.#.#.##
            ###.##.###.#.#.##
            ###....###..##.#.
            .###..###.#.#.###
            .#.####.#...#.#..
            ##.#..#.###...#..
            ####..###..#.###.
            #..####..##.#..#.
            #.######.##..#.##
            .##.##.##.##..##.
            ####..######.####
            ....##.....#.##..
            ####..#####...###

            #...#.#.#...#
            #.####.#..#..
            #.####.#..#..
            #...#.#.#...#
            #.#.##...#.##
            #####.#.#..#.
            #.#....####.#
            ##.#.#.#####.
            #####.##.#..#
            ....##.#...#.
            .#..#...#.#..
            #.#.###...##.
            ...#..##...#.
            ..##..##...#.
            #.#.###...##.
            .#..#...#.#..
            ....##.#...#.
    """.trimIndent()
    )
    check(36735, result)
}

private fun test(input: String): Int {
    var sum = 0
    val patterns = input.split("\n\n")
    for (pattern in patterns) {
        val lines = pattern.split("\n")

        fun findColAxis(lines: List<String>): List<Int> {
            val colAxis = mutableListOf<Int>()
            for (col in 0..lines[0].length - 2) {
                fun vertical(index: Int): String {
                    var s = ""
                    for (i in lines.indices) {
                        s += lines[i][index]
                    }
                    return s
                }

                var i = col
                var j = col + 1
                var symmetric = true
                while (i >= 0 && j <= lines[0].lastIndex) {
                    if (vertical(i) != vertical(j)) {
                        symmetric = false
                        break
                    }
                    --i
                    ++j
                }
                if (symmetric) {
                    colAxis += col
                }
            }
            return colAxis
        }

        fun findRowAxis(lines: List<String>): List<Int> {
            val rowAxis = mutableListOf<Int>()
            for (row in 0..lines.size - 2) {
                var i = row
                var j = row + 1
                var symmetric = true
                while (i >= 0 && j <= lines.lastIndex) {
                    if (lines[i] != lines[j]) {
                        symmetric = false
                        break
                    }
                    --i
                    ++j
                }
                if (symmetric) {
                    rowAxis += row
                }
            }
            return rowAxis
        }

        var colAxis = findColAxis(lines)
        var rowAxis = findRowAxis(lines)

        var exit = false
        for (i in lines.indices) {
            for (j in lines[0].indices) {
                val ch = when (lines[i][j]) {
                    '.' -> '#'
                    '#' -> '.'
                    else -> throw IllegalStateException("impossible")
                }
                val newLines = mutableListOf<String>()
                for (ii in lines.indices) {
                    val builder = StringBuilder()
                    for (jj in lines[0].indices) {
                        if (ii == i && jj == j) {
                            builder.append(ch)
                        } else {
                            builder.append(lines[ii][jj])
                        }
                    }
                    newLines += builder.toString()
                }
                val newColAxis = findColAxis(newLines).filter { it !in colAxis }
                val newRowAxis = findRowAxis(newLines).filter { it !in rowAxis }
                if (newColAxis.isNotEmpty()) {
                    colAxis = newColAxis
                    rowAxis = emptyList()
                    exit = true
                }
                if (newRowAxis.isNotEmpty()) {
                    rowAxis = newRowAxis
                    colAxis = emptyList()
                    exit = true
                }
                if (exit) break
            }
            if (exit) break
        }

        if (colAxis.isNotEmpty()) sum += colAxis[0] + 1
        if (rowAxis.isNotEmpty()) sum += (rowAxis[0] + 1) * 100
    }
    return sum
}