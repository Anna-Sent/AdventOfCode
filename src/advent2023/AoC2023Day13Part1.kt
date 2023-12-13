package advent2023

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
    check(405, result)

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
    check(30518, result)
}

private fun test(input: String): Int {
    var sum = 0
    val patterns = input.split("\n\n")
    for (pattern in patterns) {
        val lines = pattern.split("\n")

        var colAxis = -1
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
                colAxis = col
                break
            }
        }

        var rowAxis = -1
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
                rowAxis = row
                break
            }
        }

        if (colAxis != -1) sum += colAxis + 1
        if (rowAxis != -1) sum += (rowAxis + 1) * 100
    }
    return sum
}
