package advent.advent2024

import utils.Point

private var result = 0

fun main() {
    result = test(
        """
            ##########
            #..O..O.O#
            #......O.#
            #.OO..O.O#
            #..O@..O.#
            #O#..O...#
            #O..O..O.#
            #.OO.O.OO#
            #....O...#
            ##########

            <vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^
            vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v
            ><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<
            <<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^
            ^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><
            ^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^
            >^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^
            <><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>
            ^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>
            v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^
    """.trimIndent(), true
    )
    check(9021, result)

    result = test(
        """
            ##################################################
            #O..O......O....OOO..O.OO.#.O#.OO..O.#.#....#..O.#
            ##.O.OO.#.O...O..O.#.O.O.#O..O..OO#..O#O#O#...O..#
            #...O...OOOO.O#OO.#O#.O.#O...#.#..O.O..O........##
            #O.#.O..O.....#O.#.#.#O.....O.....O....O....O..O##
            #O#...O...O#..#.O##O#.O....#OOO..O..O...O...#....#
            #.O....O...###.O..O.O#....O#..O..O...O.OO.OO#...O#
            #O..##...O.......O.O.#.O..O.OOOO...#..OOO.OO.O...#
            #...O....O.O..O....O.......#....#..O.OOO....#O..O#
            ##O....OO.....OOO.#O.#O.#OO#O...........O......#.#
            #O#.......#........#OO.....O.#..#..O...OO.....O.O#
            #O##...OO..#.O...OOOO..O..O.#.O.OO#...O.O.#O...O.#
            #O#O.#O..O.....O#.##.O......O..#...O....OO....O#O#
            #O...O....#.O..##....O.#.....#...##O##...#.O.....#
            #OO...OO#...O#.#.O.O..O..OO..OO.O..O.....#..#.OOO#
            #..#O.#O.#..O.OO.....O#....O.OO...#..O.O.#OO.##..#
            #O..O.##...O....O..#OO..O..O..O...O..O...........#
            ##O....O....O..O...O#..O....O.OO......O.O..O....O#
            #OOOOO.#....O.O#.OO..O...O.......O.#OO...#O..O...#
            #O....O.#.O..O##...OO..##O#....O.........O#.O....#
            #...........O...O.OO.O...O#......O...#OO.O.O.....#
            #..OOO.....O#......O...#..O..O.#..O..OO#O..O.#.O.#
            #.OO...O..O.O.O##OO.O.OO#.................#..O.#.#
            #.#..#O#.O.........O.O...O.#......O.O..O...O.O..O#
            #..O.OOO......#...O.O...@.O..O...O.OO..#...O..O#O#
            #...#O...OO.O...O..OO..###O..O....O......##....O.#
            #....O.#.##...O#.#O.OOO...#.O.......#O.#.##......#
            ##.O..O.OO..O.#.....O..OO..O#....#..O#...#..O....#
            #OOO.O.OOO.O..O..O..O..#OOO....#O..O.......OO..#.#
            #..O......O.O...O....O.OOO#......O.#....O.....OO.#
            #....#..O#......OOOO.O......O.OOOO...O..O.#.....O#
            ##...OO....#.OO....OOO..O.#.OO.#O..O##..O..O.....#
            #..OOO...O....O.....O#O...O...O.....OOOO...O..#.O#
            #...#....#.OO..#.......OO..OOO.O.#.....O....O.O..#
            #O.O.........OO.O..OO##O..OO.O.........OO.O..OO..#
            #...O...#OO#O..O..#..O#OO.....O..#O.....OO.....O.#
            #O..O##O...OOO#OO.O....O#.O.O#..O..OOO..O#.O..##.#
            #.O..O...OO..O#O.#.O.OO.#OO...O..OO..O.O.O..O..OO#
            ##.O.......O.OO..O#.##O.....O....#.....OO.O.#.#OO#
            #O#..O.....OOO#.....O.......O....O...#..O..O##...#
            #.#..O.OO..#.O.OOOO.O..............O...O....O#...#
            #....O..O..#..##..OOO...........O........O....OO##
            #OOO.#...O....O.....#.......OO#.O..OOOO..OO......#
            #......O...........OOOO#OO.......O........O.OOO.O#
            #........O.O.#....#...O.#O..O.#....O.O#..#..#O#..#
            ##................O...OO..O.#O.OO#.O.....O..O..OO#
            #.O...OO.........#OO......O.O.OOO......O#........#
            #............O.#.........O.....O.O...#.O......OO.#
            #O..O......#O...OOO......#..#.#.....O#O.O.....O#.#
            ##################################################

            v>v^<v<^^<v<<>>>>vv<>vvv^><>>vvv><v<v^>><vvv>vv^>vvv^vvv<>><vv^>v>v>>^><>v<<<<vv^>^<^^^<^v>v<v^^v<^<^><v<<>v>^v^<v<^v>v<^><^v<>>v>v<>v^<<^^v^^<vvv<^><<v^v^v><^^v<>><>^<v^>>v<v^v^^v<v<^^v^^^^>^v><>^<v^>^<>><v^>vv>><^vv^v^^v<vvv<>><v^><>>><<^>^<<v>^<^>><^>>v^vv>>>v<^>^<>^<^v>^v<>v<>vv<v>vv^v<v>v<^^>vv>^<^<<^^v><>>^^<>^>>>v^v<v>v<>vvvvvv^<>^><<v<<v<v<>v^<v^^^v><^<v>>vv>v>>v^v^^v<<>v<>v>v>^v^vv^^<v<<v<<<^v><>><>v>>v<^<<^><^^v^<v<>><^>^^<^^>><<vvvv<>vvv<>>>>^<v<v>^^v><v^^>vv><<<v<>^<^^v^>v<v><>>^>><^<<>^<>^^^^vvvv^^>^v<<>^vvv>^<<^><v<v<<>>v<^v<>^>v^<><^><<<>^<vv^>><><<vvv>^<>vv><>>v<^^>>v^^<^^>vv<v><<^<^^vv<^^v>^^>>>>v^v>>vv^>v<>^v>v<<<^<>>vv^>^^<^<<vvvv^<<><<^^>^<v^<<^v<>>^>>^>><vv<^vv<<<<>v><><^<<<><^<v^v<^<vv>v^>>^v<>v<><<>v><^^^v>>^<<>vv<>^^><<^>><v<>^>^><v^<><^<>^<^^^^<^>v<^^<vvv^<^<><v^>>>>>><><>^<>^^>v>>^^<<<>>^v<^>v>^<vv>^><^>v<<><^<v>>^<^>^<v^<v<>><<v<<^vv^vv>v<<^vv^^>><v^^^^<<><>v<^<^^^><<v^>>>>^v^^<v<<<^vv<<vv>>>><>v^vv>v^><>^><>^<^<v<<>v<v^vv>v<<v^^<^<^v^<><^v<^>>>^^<>^vv^vv^<>^
            ><<^v<^v<<>><>^^v>>v^^<v<^>^v^>v<^<^>v^v<<<<<<>vv>^>v<vv^v<><<>>>>>^^vv<^v^v^><>^^v<^^vv>vv^^vv<v<<<^^^^<><><v><><>>v><^^>^^><^>v^><^^<>^<^vv><>>>^^<^>vv>v<v^>v^v<><^<>^^v<>>^v>><v><v^<><v^>vv>^<^>^v<^v<^<^v<>vv<v<>vv<^<<^><v^v^>v^>v<vvvvv><<><>><^<<<vv<^v<^^v<^v^<<>v<><^^>><v<^^^vv<<>^v^v<>^^><<<v^<v>v^vv^^^vv<<<v<v^^>>^v<^^^^^^>v<<v<<>^>><vv>^v>^><^<<^v>^<^>>>^v>>v><<>vv>>v^>^v<<^<v<v<vv<>^><vv<vvvvv<>vvv^<>><><^v^<<>^vv^<>><>v>vvv^<v<>v>^vv<>v^vv><<vv^v^v>^^>^><>v<<<^<^^v^vv><<^v>v^>><^<v<>^<>v^>v>^<^v^<><^>><>^>^v<<v>>^<<v<^<^v^^>>^v<<vvv^v<v<^>^vv<v><v^><v^<>>><<v<^<^>^^>>vv^^v>>v^^v^^v<^vv<>><^>^^^>vv<><^>>><v>^>v^vvv<v><>^>vv>v^v<>>>^>^>v^v>vv<v><><^<<^^v<>>^^<><>><^>v<v<<v^><v^vv>v><<v>v^^<v^^<<v^^<^^<<>v<vv><<^<<v><>^<><v>>^^vv^<>^>^vvv<>^^<>>^><<^^<^v<^^v<^^^^v<<^vv^>>>vv^v>^<>^^<><^^><>^<>v<^>v^<<>^<v>v>v<v>>v^v^v>>^v^^^^>^<>vv^>v^^>><<<>v><^<v<v<^<v>>^vv^<^>>>^<v^><><^<<<^>vvvv<v<v<^^>^v>v>^v^v^>^<^v^>><^<v^vv<>^^<^^v><<^>vv^>vv><<>>><v>^<>vv<^v^>>^><^^v<vv^^>vvv>^^>v>>v<>v
            <<^vv<vv><<<<><<v^vv>>^v>>>v<<><v<v<vv<><<>^v^v<^v^v>^vv^>>>v^v^vv<<v^<^>>>^v><><<<v>v<>>>>^<vv^^vvvv^<>v>v><v<>^vv>v<<<>v<^vv<>^^v>>>v^<<<^>v<v><v><>v^<>>v^><vv<>>^v>>>^<<>^^<v<<^^^<>v>^><>v^>v<v>^<><v<^^vv>^>>^vvv>v^>>^<><v^>v<<^^>>>>^><<v^<^^v>>^><vv^^<v<>v^>v>vv<><^v<v<^>v<<vv<vv>v<>>^>>^><v^^<^<v<v^><><<^v<v>vv^<vv^^>>v^>v^^^>vv>v^<vvvv<<>v>v>^>vv><<>><v^v^^<v>>^^v>>vv^^v>^v>^<vv>^^^<^vvvv><<^^vv<<><^^>><vvv><>><<^v>>^^<v^vvv^vv>v<<><<>^><^v<>^<<v^>>>^v^^v<>v^><^^v^><<>v>^vv<v^^v>v^v^^^><v<<<^>><^v>>><v^>>><v^>^>v<<^vv>>><<<vvv>^<^vvv^>><>>>^<v<>^v<<^v^v<^v^<<<^v>v>v>^v^^<><^<^>^>^v><^>v^^^<<vv<^<v<><^>v<^v^^><v<^><>^v^vv^v<><<<><<^vv^>><>>^^<v<v^v>v<^>^<>vv<>><<<^>^<vv>^>^v<v<<<v<><>>^>><^v><<vv>v<>v>>>><^^v^v<^v<>v^<<^v<v^<>v<v^^<^>^<^>v<^>vv<v<>v><<^v>vv>^^v<^^>^vv^>v^>vv<^^v^^v<^>><v<>^<<<>vv^v^v<>v^^<^>v^>>^>>><>>>^v<^v^^^v^^^v>v>v<^<^vvv^vv<^<<<vvvv^^>v>v^vv^>vv>v<>><^><v<<^><v^<^v>>v^><v>v>>>v><>^^v<><vv^v>^<>>^><^^>^<<<v>^<v^v^>^v^^v^<^^vv<^^v^^<>v^^^<v<<v^v<>><>^v<^^vv>>^
            <^v^<^>v^^<>v<v^>v^><^>^>^><^v^^<^<^>><^>>>><>><v^v^><<<^>^v<<v<><>v>vvvv<<<^^>v>^>>^<<<>^^vvv<>^v^^<<<>v<>>v><>vv^>vvv>v>>>>^<v>>^<v^>v>^><<vv^^v^<><<v>^<<vv^<>^^><^>><^vvv>>v^v<>^<>^v<<<^>v^>^<^v>v^<^<^^>v^v<>v^v>^<<v<^v<v>v><>^>v<^<^>^<vv>v^vvv><v<vv<><^^^v<>v^<<^>^vv>^^<^>>>vvv<^><v<>>^^<^>vvv^<^v^^<>><<v^^>v<v^^<>^<<^<>^vv^v>^v<>>^<^<<<>v^v<v<<>vv<>^v<^<<>^<>^<<^>v<>>><v>>v<<<<^<v>><^^>v<^v>^v<^v^v<v>>><v^>v><<<>^vvv^^v^><^vv<>>^>^^<<v>^^>><v<<<v^<<v>>^^><^vv^<<>v<^<v^>v<>>^^>^vv><<^v<vvv^><v><>^>^<v^^<><v<v><<<<vv>^^<<v<>>^>^>>v^vv<^v><^<v>^v><vvvv>v<<><><>v^<>v>vv<^^>><>v<<>><><^^<><>>^<><<^vv><>^^v>>^>>>v<v>>^^<^v><v>>v^^vv<>><<<vvv^^^^>>^>v<<^>v^^<>>>vv>^^^^vv^^<^v^>^<<<^v<>v><^vvv^>>^<v<>vv>v<vv>>v<<<><<<<>vv>v<<><>>vv^^<><>>v^<<>>^>^>>v<<<vv^v^<<>>>^^<v<><>>><<<>v^<v>^^><v><>><v^>>v>><^>v^>v<v^<>^>^^^v^vv>>><^^v<><^^^v^<v^v^>v^^^vv><^^<^^>v<>v^^><>v>>^v<v<v^^><<>>v>^v^<^<>^vvv>>v<^vvvvvvvvv^^vv<^v<^<<>^<>^>^vv^<<v^>v<v<><><><<<>^^>>>v<>>><^<<>^<><^<>^<>>>^v>vv^^<>^^<>^>^v><v
            ><>v<^v^>>^^^vvv^^^v>^<<v><>>>>>^>>v^<v<^>^<^^<>v>>><vvv>><v<<><>^v<v<v^>>^v>v^>>^<^><<<v^>^<>v^v<<<^v<v<^>>^^^v>>><<><><>vv^>>^v>>^^vv^<><v^^<^v>v^>>vv><v<v>>^><^<<<^^><v^><>^<<<<^><v^<><<<v>^v^><^^^>^vv>v<<v><<^><^<^><<v^<<^^^v^vvv>v>v><><><v<vvv<><vv<v>v^<<^v^v^v>><><v^^^>v>>>^v<>^^v>^>><vv<><><v<>v^<vvv^>v^^<<vv<<v><v<><<>><^<<v<>^vvv^>vv^^v<vv^v^^vvvvv<<v<v<^^^^^<<v>v^v^>>>><v><><v><>^>v>^>>v>vv^<<^v>^>vv<<>>^v>v><>^><^v^>^vv>^>vvv<^<<^>^^<<v>>^vvv<<vvv>^^>v><^<><><v<^><<^v^>>v<>^^>v^v<^v<vv>>vv^v^<vv>^>v<v<vvv<<>>v^>v^><><<<<>>>>^<v<^<^>v>^>^^^^v>^^>^^^<v>^vv^>>>><>><>^>^>v>v^>>>^^^>vv>^v<>v><><^v>>^<^>>>>><>><v^<><<>v^v>v<v^v<>^>v^>>>^>><^>vv>>>><v><^>^v>>^><^>^>vv<v<>>vvv<^<><^<>>^>^^v<vv><>^^<>><>^v>>^v^><<v<<<><^>v>>><v<^^^>>v>>^^^>vv>>v^>>v<<^^>v>vv^>^v<^><<v><^v<^v>v<>>v^<>>^<v<>^>v<v^<>v>^>>v^v><<<><v<>><v^v>>vv<>>v>v^^<>v>^^>^^^<v<^v<<<^v^>>v<^^<<^<<v^^>>^<vvvv><>^v^^<<>>v><>^v<vv<<<v>^<v<<>><v^>v>>^>>>v>^v>^<>^^v><^v<v>v^><<<<^><><>vv<v^>><v<^<<>>^v>><>v<<v>>><<vv><<>><<
            ^<vv<^><>>v^vv<^v<v^^>>>^><v^<v<<<><<><<vvv<<><<<<<v>>><<^>>v^<><>>^<v<>^<vvv<^<v^^<<<v^>>vv^v><>v^^<v<^^^^^><v><>^>>v>v^^><<v<v<<>>vv^<>vvv>^v><>^v><<v^<v^>><>^v><^><<>v^>^v>v>>><>^v<>v<<<<<v<^><v><^><v^<v<<>>v>v><><^v^vv<<>>><v^<v<^>^v>^^>><>^>^^>^^^<^v<v>^<vvv^^^^<v^>v<<>vv<<>^<^>>^v<^<v<<<>^>v^>^<v^<<v<^<v><^^<<>vvv<<>v><>>^^><<^>v^<>vvv<^<^^>>^^<>>^^<^>^^v>^vvv>><^><^vvvv<v>v^v^<v^^>v>>v>^v><<>v>v<<<^>v<><^<<^<>v^><>vvvvvv>vv<><^v>v^<><v<>^><<<<>>^^vv<<^>>v^>>>^^<^<<v^<<^<<<v<v<^vv^v>vv<<^<<<>><<>^v^v<^>>>><><^><<><v<<v^><^<v^<v^>^v<vv>>vvv^>^<^v<<<^^>v<<>><>vv>^<<<<<><^<^^v>^><><v>^^v>vvvv>^^>^>>>vv^^>v><vv^><>v<v<<^><v^v><^v<^<v><>>v><^v>^v^>><vv<>><><>><v>v<vvv>v^<>>^>^>v^>>>>^v<^^<>><v>><<v<v><<vvv<vv<<<<<<^<<>v<>>^vv^><v^<<>^><v^v>><>>vv<<^v>^^^v^><vv<v>>^^>>>v>>^v^v<>>^<<^>^><^<>>vvvvvv>^^<>v>^>v^<<<v<><v<>>^>>^v<^v^<^<><<^<><^^^vvv^^^v^><><^^^<<<>>v<^^vv>vv>^<v^<>v>v^><>>v^^^^<^^>>^<v^<>v>>><v<<<<vv<^v>>v^>vv<>vv>^>vv>><^<>^<vvv>>v<>>v<v<<v>^<v<^<>^^^^^v<<>>^><^v^<>v>v<^>vv
            <>><>^<^v><>^>><^^^>^^^^v<>^<<vv^^><^^^>><><^^^><<<>v^>><<v><v<^v^<<>>>^v<^v<<<^^vv><vv><vv>^v<^>v^<v^v>>>^^v<<^^>^<<><v^><>v><^<>>><>^v^v^v<v>>v><<v>><><>^<v<^><^<vv^^>^<^<vv^v>^^^<<<vv<<^v<v^<vv>>v^^>^v>vvv>v><^^v^v<<<>^><v<v<<^v>>v>vv><><vv<^^^v^<>>^^^>^<v^v>vvv<<><>^>>>>>>vv<vvv<v<>>v><<>v>^<><>^v<v<v<vvv^^^>^^><^<^<>v^<>^vv<^^^<^<^>>vv^v^<^><<^v^v>v<><<>>v<vv><v>v<vv<><^>><>^^vvv<^^^^^^^v>>^><><>v>><vvv<vv^^^^<v<<<^v^v^^v^^vv>vv>^<^>v<<^>^<^vvv<vv^v^v<>>vvvv<<^>vv>vvv<v<v<>^vvvv>v>^^^<<^<<v<^vv<v>^<^<vv><vv<v<v^^^^<^^^<v^^^^<v^<v>v>><^^v>v<v><^vv^>v^v<^<v><vv<v<<<vv<vv^<^<vv<><<v>v<v<>vv^^<>vv^<v^v<^^v^^^^<vv^vv>><<v>v>^v>^><>>>><><<^^><^>>^<^<<>>^v<^v><<<<<^<^><v^v^^>^<<>v^^>^vv^<<v<v>^><^>><>v>^<<v><^v^>^v<<><<<^^<<^><v<^><<v<<^^>><v<^^<v<>v^v<^^>v>><<<v><v>^^>^><<^v^v^>vv<vv>>v<<<<^><v>v<v<^vv^>^<><^v<>^>v^^<^^v^^vv^>>^<^>v><><^<v^>v>^^>>><^<vv>v>>^v<^v>>^>^>^>>^vv><>vv><>v><>vv>><^>vv>v^>vv^>^^v^>v>>^<vv><>^^><^<<^>><<v^^>><<<^^<<^v>v<<^>>>^^<^v<>>v>><v>v<^>v<^^>><<<^^>>^v<^>^
            <><^^><<>^^v>^<^><<^><>^^v^<^><<<<^<v><>v^^>^<<^<v^<v^v>v<<<<>^><<vv><<^vv>v<>>^>^>^vv>>^>^^vv<^><^>>>><^^^>>v>^v<^v>>>^v>><^<^>^^<<vv<><^^vv><>>vv<^<^v^<^>v^<<^v^vvv^v>><v^v<>v><vvv^^^<^>^v^<>v<v^<^<v<<^<^<>vv^^<vv^>>^vv>>v<><vv<><<^^<<>v>^v>^^v<<<>>>>v>v>v^v<<<><<^v^>><>><v<>v>v>>>v<v><vv>^<<>>>^<^^v<^<v><v<^v>^vv>><<v<^vv>^<>vvv><><>><<<<>>^^v><v>^<>><<><^<>>v^vvv<><>v>^>v^vv^<v>vv^v^v<v<v>v^<<^<><v>>^v^^vvv^<v^>vvv^vvv<v>^>><^<<<vvv><<v<^>v^v>>v><v^v>^v^^>^<>v^^v^><<<<v^vv^^v<v<>v>^<^v>^v><>vv<v^^>vv<^>>>^<>>>v^<v><v>vv^<<<><><^>^><>>v^vv^>^<><<>>>v^><v^vv<v<><v<><^<vv<><<^v><v><<>>^vvv>>v^<^>v^><>^vv^><v^><<<v<vv>><^vv^><^^v><>vv^<^v>^^<^<v^<<<>v>>>>><^v>^><>>vvv><><v<>>v><>^<>^^>><v^<<><<vv<>^><v^^v<^^>><v>v<v^^<^<<<^>vv>>v^>v^v^^^^vvvvv<^^v<>>>^v^v>>^<v^<<^>v<^>>^^<<^^^>>><vv>v<<><v><v<<v<vv^^^v<<<>>^>^^<v^^><>^^^>^>>^<v<<v<>^v<<^^^v>><<vv^vv<v<v^^<<v>v><<v>>>v<^<<>v<><>v>^v<>^v>^>^^<^>v^v^>v<^>^>>v^<^^vv<v><v<^^>>>v>>v^v><^<^vvvv>v><^vv^<vv<>><vvv^vv<>v^<<v>>v<^v>^>v>^v^^v>v^v^
            >><>>><>^>^^<>^v>^v>>^vvvvv^vv<><^v^>>><^^<v<<v>>v<<v<>v>>^<<<v>v>>><^<vvv>v^v<^<<<^^^v>^>v>v<>^<v^<v^v<><<v<vv<>>v<v>^<v>^<<><<^>v^^><<>>>v^>v^<^v>v>>v<><>^><<<><^>^>^>>>^><vv>^<v>>>>^<><<<>^^>^<^v>^^<vv<^v^^^vv^<v<v>^v<^v<><>>v^>>>><>^^<^^v^v^<v>>>v<^v^>^>^^^v<^v><<v<^>>^^<^>vv<<<>>^v>^^<v<^v<vv<v<<^v<>vv><v^^<^v><^>^v>><<<<vv^><>^<>>^>vv^v^>v<^><v<<v^>>^>^v^>v^>^<<^^>^><>^^v^<>vv<><><v<<v<v<<<^<^<<><vvv^>>v<<^v>>>>><><v^<v<v<>^^v<>>v>^v^<>^<^v<>^v<<<<>^v<v^v>>>^v<v<^>vv<^><><v^^<^><^>>^^v>^^>^><^>>>v>^^v<^>v>^v>>vv<v^>v<^>vv<<^^v^vv>v^<<v<^>v^vvv>^^><v<<^<^><>^>^^<<<v>^^^^<><>><v<v<<^><^<^v>v^<^v>><^<<>>^<<>>^>><>^><^^vvv^v>>^>vv^>>v<>^^<><>vv>v<>v^<<v^v<v>^<><<v>>v>vv><^^<^>>vv^^^>vvv<^>^^v^v<vv<^^>v^<<><vv<v<vv<<^>^<^<>^>>v<><^<<<>^>>^^^<>^^^<v>^^^^^>^<^vvvv^^v><<^vv<>><^v^v^>v^vv^^>^v^v>>v>>^<>vv<^vv^<^^>v^>^<v^^v<>v<v^<<<>^^>><>^^v<>^<<<>>><>^^<v<<>v>><<^v^<><>>^<vv<^^<><v^><<>>>^v^^v^<^v^v<<v^><v^<^<>>^<v^<<<v><<^><<vvv<^>^>v^<v>^v>v<^<v^vv>^^^<><^v^<>v>><v>v^v^vv><^<>^^>^>^<v^
            ^>^vv<<^^^v^>^<v^v<<^<>v^^><><v^v<v<v<v<^<>>v<<vv^><<<<><>v<>^^^^v^^^vv^v^<^vv>>>><<v<v>^>><^^^><<>v>v^>v>>^>><^^v<<<^<<>v><^>vv^vvvv^>v<^^>><>^><<>>>^^v><<^<^v<><>^<>v<><v<v<v><v<^vv><>v>v<v>v><<^>>v<^^>^>v<vv><^^^<><>v><>>><<v<><^<>vvvv<vv<><^>^><>>^<>^^>^<^v^v^^^^<^><vv<<vv>>v^<<<<><>><>vv^<v^>vv^><^^v^>v^<<>vvv>v<^>><v^^v^>^^<^^v>v^^v>^v<^>v<<^v>^<vv>^<<^<^<v>v<^>^<>>>>vvvv^^^>^^>^>^><^^>>>^<>>v^<<^>^<v^^^^^>><^^<vv<>v>^<v><^>^<^<^<v><v<><><^^>>><<^>^>^^v^<^>^>^vv^v^vvv^><<vv^^<^^v<v^<<^^^v<^<v<^>^^^vvv^^vv<^v><<^^<^<vv>^<<<v<vv^<><vvvv<<^<vv<<<^^><^>>>^v<v^>^<^>^><>vv^^>v><^vv<^<v<^<^><^^<<<>><<v<v><<v^v<><v>vv<v^^>v^<v<^><^>v^^v^^<<vvvv<v^^<><^<>v>v<>>^><^v>vv^^v>>vv<v^>^<>^<^<<v^^vv^vv>^<<<^v>><><^v>><<<v<<^v<<<v<<v>^vv><><><^>v^<vvv^^>^^vvv^v<v<v^<^v<vvv<^v<<vv>^<<^v<>^>vvvv<<^v^>^v<<<<<><^<^^^<vvv<<v^v>^v><>>v<v^v<<<>>>v^<>^>vvv<^<>>^^<><v^>>>>^^v<>^vvv>>^^v^^^<v>^v^^^<<^>>^>^<<v>>>><<>^v^>v^v>>v>v^v>^^^v^><^^<<v>^^<^<<<v^>^v>^^v^>^^^^<v<<>^v^^>^^>^><v>^^>>v>v>><>^^<^^v>>vv><<
            ^v>v>v^>v><><v<^vv^vv>>>^>^>><vv^v><^^>^vv>>^vvvvv<^<v<><<<<<>^<><^<<<^<v^v>><><^^><^v^v<<>>>^<^<<^>v><>v>><<v^v>v><<<v>^v>^^<<^v>^>v>vv>v><^^><v<<v^<v<>v<vv<v^^^v<v^><v>>v^<v^v^<v^v^^v<>vvvv>^^^^>vv><>vv^v<^v>v^v>v<<<<>^^<<^^<><v<v^<v>>vv^<vv^<^>><<v<<v<v^^^<^<^^vv<<^v<<v<v>^^v>^^<^^>>>><<>>vv^<vv^vv^^<<v^<>^><^^<v>vvvv<><>^^v<>v<^><<><v>^^^v<v^>v>>^^v^vv><v>^vv>v>vvv^^v>vv<vv>>>^^^vv^v^<<v^>>><vvv<^v^>^>^v<><>^vv><><<<v><^v>v>^<vv<vv^^<vv>>>^<<v^<^<^^^>>^v^v^<<>v<<v^^<^v^>>^^<>vvvvvv^^<v<v<v>>^v>>vvvv<<^^<v<><^^v<v<<v>v<<>^><v^vv^>vvv>v<<v^<<<><<vv<<v>>>^vvv>^^^>v<><<v<v>vv>^<<vv<^^><vv^>v<<><>><>>>>>><><^<>vv^v>v^v>v^<v>^<<v>v<^^^^v<v<>>v>v<<<^^<<^^<<<<v<^>v<^^^^vv^^>^>>>><<v<>^><>>^<v<<v<>v^>^^^^^<^<^vv^v^^>v>>v>>>>vvv><^^<<v^^v^>^<^<><vv<^^^<^<^<v>v^<<<^v<v^v<^vvv^<v>v>^<^v>^><<^^v>><v<>v<<<^v><^>v>v^v>^>vv^^<>>^>^v^<^^>^^>v>>^v^>>^>^>^>>^^>>>^v<v^v>v^>^v><^>^<v^<<^^>^^<<>>>v^^<><^v<>><<<<v>^vv^<<v^><vv><v><^<<^v^v^^<v<v<v<^<>v^v<^<^>><<v<<>>^><^^>vv>>vvvv>vv>vv<>^v>v>>><<<v<v<>^<
            ^^v^^^^^><v><^v^v^vv^v<^v^^>^vvvv>^^^^^^<v><v<><>v^v<^<>^>^^<<<v^<v<^>^v><^^^><v><^^^<v^vv<^<vv<<^><>><<v^><^v><>v^<^^>^v>^v>><<vv>^^^<^^>^^v<><<<v^v<^^^^^vv>^>>^^>><<<v^<<v^><<^vv^^vvv^<>>v^^v>^<<v<^>^>v^>><>>><<^>><<v>^>v<^<>vv<vv>><^v^<><<><vvvv><v^>^vvvv^^>^>^<><>v^>>^v><>^v<^<<^<><^v^^>><<<><><<<v<^<^v^^vv<^v>v>^<<^^^<>v<>^v^<^vv<v^<^>^v>^^^>^>v^v^^^v<<v>v>v^<v^v<<>v<^>^v><<v<>v^v><<v<^>><><^v<v<vvv<><v<^^^<^<<^^^<vv^<^>v^v><<^v>^^<>^<<v<^v><vv^>v^><v<<<^<^v<^^^^vv^><v><<<^>>^<<^^<<<><><>>vv<vvv^<^<>vv><<v^^><^>>><^v^^>>>^<^^>>^^^<v><<^<^^vv^^<v<v><^<v^<>v>>>^<>vv>^v<^^<^>>v>>><<v^^<<>>>>>v<<^^<v>>^^^vv<^v<<^<v>>><^^><>v^v<>v^<<<>^>>^^^v^vv><^vv<>>^>^>>><v^<<v^v^<>vv^>v<v><^^<>^<^v<>v^><^<<^>v>>^<^^v>^<^>^vvv<><^^^<>><><<><v<>vvvv>^<vv^><<<v<v^<<<>^^<<v<^<v^v^v^v>^v>^<^v^vv>^>><<>>>^vv>^<v>^<v<^vv><v<><>>vvv<^vv<<<>v^>^v>vvv^>^v^v>vv^<v<v^>>><>^^^>^<<>^><>^<<>v<>^^<><v<^<v^<^^v>vv^<>v<v>^^<v>><<><<vvv^<v>^>^^<<<<>>^>vv>^><><^^<>v^v>v<<><>^^>>>^>^>vv>^v^v<v<^^><v^<^<v<<v><<<<v>>^<^
            v^vv><^<^^<>v^<vv<>^v<>>>v><<<<^^<v<<<>>^>vv<^<><<<>^v<<^^^v><>><v<<><<^>^<><vv^^^>>^<>^^v>v>^v<<<>^<><vvv<>>^v>^>v<>>^vvvv^<><>v>vv^<<^>>v>^><<>v<<^v^<<>v^>^>v<>^vv>vv<v<>^v<v^vv>vv^<<>^<^><v<^^v<v^><^^^<^><v<^<v<<>>vvvv><^v^v<v><<<^^^v>^>^^<v^<<vv><>v<<<><vv^>><<v>vv>vv>>vv^v^<><^^v>><<>^v<vv^^vv<<vvv<<v<>v^>^^v>>vv<^<<<<^<>^^><>>>><>vv<<^<>^^vv><v><^v<^>v>>v><^^^><><<v<v<^^<>^v>vvvv><<^v^<>vv^^>^v^v<v<>^>><<>>v<^^><v>>v<^^><^vvv^v<<v>vv^>v<><v^<v^>v^v>vv^<<^^<<<><><^>vv<><^v>v^^>^<>><^<v<^>v<v^^^^vv^>^><>v><<v^^v^>^>^<vv>>^><>v<^v>><>>>^><^<v^^<v^^><^<^>>^<v^<<>vvv<v^vv^v>v>>v>^>^>>><<><vv<>^^v>v^^v>v><^<>^<v>v<><<>>v>^<^<<v<^>v<^^>v^<<v^^<v>^v>>vv^>^>^v>^^<>v<<<><^v^v<v<>>vv>^>^<>>><^^v^<<v^<>^<>>><<^^v<v<vvv>v>v^^<<^>>v^v^>^<v><vv^<^<>vv^<^^v>vv^v>><><^^<v^vv^<<^^<<^vv<>>v<v>>^vv^v<^^v>><<>v<^^>^<<v>>>v>>v<v<>^v^<>v<>^<v^^<^<<v<<^<<^v<^><<<^><<^>^>^v>v^<v<vv>v>^<<^><^^^vv^><v^v>^v<<^v><^^vv<vv^<<><<v<>^>v<v^v>>v^<<><<v><vvv^v>^>v<vv>>>v>><^v<^<>^v^v^<><<vv>v<>v<v^vvvvv^v>v><<^<v<>
            vv>><^<><v^v^>vv^><v^<>>^>>v<^v^^<v^v^>^v<^^><vv^v^^^<v>>><><<v^>v<v^>>v^vv<<^v^<<<<<^v>>v>v>^<<<>^>v^>>><v<^>v<<v>>v^><>^><^^^^^v<v<>^<^v<v^>^v<<>><>vvv<^^>>^<>>^v<>vv<v^v^>><^<vv^v>^<>>^^^^^^><^<v^>>v>v>v^<^^<v^v^><^^><>v>^<^>>vvvv>>>vv<>>><v<^v>v^v^>^>>>>>>>v<^>^<vvv>^^v>v>v<vvv>v<v^^>v^^^v<v^<^^vv<^<v><<^><v^^<<>>vv<>v<^^^^><<v^><<v^<vvv<v^^<vvvv^v^v<^<<>>>^>>^>^>^v^^<^>>^v^^<vv<^>v^vvv>^><^^<v<v>^v^<>^>>^>^^>v<^^v>>^^v>^vv>^v>v>vv^><>^>>>^>^v<^<>v^>>v<v<v^>>^><><<<v^vv^>v>v><<<>vv>v^<v><^^v^>><^v^>v>v^vv^^vv><>vv<v>>><^v>^^^<^^^>>^^^^v>><><<v^<^<vvv^^<vv^<^>v>>^<<^>^vv^<v>>^v^v<><^><<v>>^>^>^<<^vvv>v>>^>^>v<<^v^^^<<^^^<^vv^^^<<^v<^>>^<^<>>^<><>^<><^<^v<^v^<^<^^v<><><<>vv^v>^<>><^<^vvv>>^v>^^^^<^^<>vv<>^v>><<^v^v<^v>^v^^><v<^<<<>><v>v^^>><^<>^>vv^v^^vv<>v<>^v<<>>^><^^>vv^>><^<>vv<><<<>>>><^>><v^><^^<v>^<v><v<>><^^v<^^v>>><<<<>^v><v>^^vv^>>>>^<<vvv^>>v<<>vv><>v><<^<v^>>>v>v^<><>v>>><<v>vv>^^v>>^^^v^v<<^v^^^v>><<^<><>^<vv>vv^<v>^v<v^<vv><v^><v><^v<v><v><vv<<>^<v^<>^>v^<^<v<<>v<<^<>^v
            >^v<v>^^<><<><^v<^<v^<>^^^<>>v><<<>v><>^v>^^^<v<^>^<vvv<^>^v>v<^v^><<>vv<>^v><>^vv<<v^>^<v<<v^v<<<<<<<<v^v>v<^vv^><>^<v^><<>v^>>vv<^vvv>v>^^^vv<v<vv<v^>v^^<<v^^^v<<^<<^^<v>v^^^^<<v>>^^v<<<><>vv<^v^<<^^^>v<vv^<v^>vv^<<v>^<v>^<><vv^^^^<><^^<>>>^<>^<>^^v>>^^vvv<v^>>v<^<vvv><<<>^<<^v^><^>>^>>v^<^vvv>vv>^><^>><<^>^><^>^v<><^v^^v^<>v^v>v<<<<><^<v><^>>v<>v^<v><<>v^^^>>^>v<>^v>^v><^v>^<<^<vv<v^<v<>v><><vv>vv<><><vvv^<>^^v>>^^>v<<<<vv><<vv<^v<v^><<>^<v>><^^vv>vv><v>>v^>>><v<^<>v>^v>v>v>^vv^<v^^><^>v<v<v^^>vv>^<^<>><v<<v<>^<v^^^>^v>v<>^>>^vv<<>v^^v^^^^^^^<v^v><v><>v^^><v>^^<>>>^^<<^^><^<vv^v>v^><v<v^>v<v>v^^>^v><<><>^<>^^<^><>v^><><<><^>>^^>>vvv>>>vvv><>>><^^v^>v<<^v>v^<><v><<^>>v^><>v^^><^^<^>^<v<>vv^>>^^><<^v^<>^>vvv><<^^><>^^v<>^v^^^^^>v<vv>>^>vv<><<<>>vvvv^^>^^v>>>v>vvv<v<^^vv>v>^>><v><^v>^<v><^>^^<^<^<v<^v<v>^^<^v>v^<<><vvv>v^><>v>>v<<<>v^^^><>>><v>^<<v^v^><>v^<>>^v>>v^v^vvv^<><vv>v><<vvv>^v<<^<v<>^^^v^^<<^v^><vv>v^v<v>^<>v<vv<<^v>^<<>v>v<^>^v<>v>><v^><>v^<>>^v^<<<v^>vv<><v<^<<><^^>><v^^>^>
            ^<^v^<v>v^^>v>vv><<<<<^>v>>vvv<<^v<><>^vv>v<>^>vv<>^<^>^v>^>^>v^v<<^v>vv<^^>^^^v<v>>^<^<v^<^<^v<<<>v>v<>vv><>>v><v>vv>v^^<^^<v^v>>v>>>vv>^v^>^^<>v<v^^vv^^<v<<^^v^vv<v>>vv^v^<^vv>v>^>>>><^<^vvvvv<<>>v>>v<v>>><^^<v>^v>v<><v<vv<^<><^^v^>^<^<^<^v>><v>v>^<^^^v><<>v^>v>>^^>^v><^<>^^v<<<v>><><v>vv^^<v>>^>><v<v<^^^^^^<>>v^<^<>v^<>v><^>^^>^>>^>><v^<^><v>v<^>^<<<>>^^<<<>>^^v>^<><^<v^^<v<<^<>v<^<^<>><v^<>>v^^>>v^^<<><^vv^<>^^<v^<v>^>v^><vv>vvv^^^<<v^<<^<vv<<>><>^>v>vv^<>vvv^v>><><<><v^^v^<>v<<v^vv<^^vvv><vv^<<^<^<>>>>>vv<<<vv<v<<>vv<^v<<v<^>^<<>v>v<>^v^v<v<><<<<vv^^<^>^^>v^v<<<<vv>v<>>v>vv^v<<<>v>^^v>^><>^^<>v^<<<v<>v^v<vv>><vv<^vv<<^<<^^>>v^>v><<v^^^^>><^^v^vvv<^^>vv^<>><<<<^>vvv>^>vv<>v^>>^^><>>^<>><><^>>>>>^<>v^>^vv^>>>vv<v>^vvv>>v^<v><^><^^v><><<<<<<vv<><v><v>><>v>><^v<<>^>>>^<v^<<<><>>^vv>><v>^v<<>v>>^v^v<^>^^v<<><^^><>><^v<>>>>^^v<vv<>vv<<>^v<>^<^<>v>v<v^^<^vv^>>><^v^v<^>>>^<<v<><>v><v<vv<>>><>v^><^<^><<>v>>>^<><>v^^^vvv^><<<<v^v^v<^^^<^^<v<^v>v>^^<^><<v<v><>>^>v>v<^<vvv<<<>>^vvv>>v<v<v^>v<
            <>>^<^vv>>><><^v^>^>v<vv><v^v<>><<^^vv<>^<>vvvvv<v><vv^^^<^<<^<v<<v>v^^^^v>v<v^>^<^<<^^>^<v^v<<>^>v^^><v>>><<^v<^<^<<v><><v<^<>>vv>vv<v>^><v^^v^>^vv><^>^^v><^^^<<vv^^^^v>v>^<^><^v<^^v>>v^v>^>^><<<><>^^>v^v<><v<>>^<<v^^v>^>v>v>v^<>>>v^><><>vv<v>^^<>^<v><>v<<vv>>^^<^<<>>v^>^v<v><<<v^><>^<^v><>>^^^v^^v^^<^^<^><^v<>>vv<^^><v^>^<<<v>^>^^>v>v>^><^>>^><<^v^v^<<>v><^>v<>^^^<>v<^>^<v<>^^v^<^<v>>^><^vv<<^^><<<vv<<<>^vvvv>^^^^<vv^<>^>vv<^<^>><<><>v<><v<<<><^v<>vvv<>v<<>>v<^^<v>^>v<<>>^v>^>^vv<>v^>^v^v<^^><<><<<<><<><<<<>v>v<><^>^^><>v^^v<v^vv>^<<><v<v^<v<v<<>^vvvvv^><^>v<v^v><<<vvv<vvv><^<^v^vv^v>>vvv>v^>^>vvv<<>v<^<v^><^v<^>v<^>v^>^>^v<vv<<v<v>v<v><v<<>^<>^<v>^^^<>>>>v<v<>^v<<<<^v<<><<^v<^>^vvv<vv^v<v<<vv><v<^><><<^^><<^>v<^<^^^v^>>^^>vv^v>^>>><vvv<^>>^>><v<<<>>><>>^<v^vv<>v^^^><<v><^vvv>>v^^^<v<^><v>v<>><>v^<^>>>>v^^v^v>^^^v>v<v>^v>><v<^<v<>>^><<^^>v<>^>^^<>>v>vv<v<^<v<>^<>vv<>>v^><^^<<v<^><vv><^v<v>>>v>>^>>^^^v<<<^^><<>vv^<v<^>^>^v>>><^vv<><><>^<v<^^>>>>>v^^<>^v<vvv>>v<><^>^^^v^><<>v<vv>vv<<<v
            ^<v^<>>v^>>><>><>v^<><>>>^vvv^^<<^v^v>^><^>v^^<>><^v>^>^v<v<<vv^<<^^><^^>vv<v>><<^^^v>^v>v<<^^v^^<vvv^v>^^>^^<<^>^v>>><^v^v^v<<v^><v>>^>^v<<v>>v><>><v<^v^^><<^>^<v^<vv>^v>^^<>>v><<^^v<<>>^vvv<^<^^<>^v^<^^>vv<><^^<>v<vvv^>v><<v<<v<<>^v<<>v>><^><<^vv^v><v><vv>^^<<<vvvv<<vv>><>>v<^vv<^<^v<v>>>><>^<vv^><<<v^><^v<<v^^<>^vv<>>vv>>>vv<<^<<>vv><>v>>>v<>>vv^^^^vv<^<^v<>>v>>v^v^^<<^^<<^v>v<^>v^^<><<>>v<v<^v^v^v>><v<<>vv^<>v<vvvv>><vv<>vv>>^>>v<^v>v>><<^>^<>v^^<>v<>>v<<v^vv<^^^^vv^>v>v^>><<^>^^v<v>^v<>^^vv^>^<^>^v^^<<v^>^^<><^<>^<>^^v<<^<<vv<^vv^v^>^<vv<>^v>v>vv<^><<^^^<>v<<v<v><v>v>^>^^^<<>v<^^<^^^<^><^^>vv^<<>v>vv^<>>^^v<>v<^<<^^vvvv<>><v<^vv>^>^^v^>v^v^v>v^>v^>vv>v><v><<v^v^^^<^v>><^v<>v><>>v><v><v<<^>v^^^^>><^^v^^>^vv>>vv>>>>v<v^>><<v>>v^<v^<^<^v<<<v>vv<<^^<><><v><v^v<<^v<<vv<^^<>><<><><<^<<<<v><>>^>v^v>v^^^<>^v>v^>^><v^<^<v^^vv<^><><^^v>v>^^v^>>^<><<^<<v>><v>>^v<><<>>>^v<vvv^v<^><>vv>^^^<<>>>>^><<^<<><<<>>>v>>^>v><^v^<vv>>vv^<v>vv^^<>v>>>v>^>>^v><>>v<vvv<<^<v^>>^><^<^<>v>vv<v^^>v^<>>><^^<<v<
            ><^>v^>>>>^v^>v^>vvvv>><vv^<><v<vv><<<>><v<^<^<<>>v^><<<>v<^<>v<<><^vvv^^>v^<<<><<<><^>v<<<>>>^<^<<<vvv^v>v<^v<<^v^<><^vv^v^>^<<vv^v>vv><>>>>^<>>v><<<<^^^>^<v<vv>>^^><v^<<>><vv<><v<>^v<^^vv<><^>v<>>>>v<>>^^^v<<^><>v<>v><>^><^v>v>>^vv^^vvvv^<<<<<v<<>^>v>^vv<>v^^v>><^v><v>^v><>^v<^v><v^<<vvv^<>^v^^>^^v^^^<vv^v^<^<^v>^<><>>^>><^^>^v<^vv><^^v^<<vv<>^^<v>><^><><<>^^^v>^v>vv^>>>v^v<<<^^^>v><v<v<v><^^vvv<>>vv^<<^v^><<vv<<^v^>vv>^>^><vvv>v^^^vv<v<^v^v^^^<>>^v^v<<v>^^v<<<<v<>^<>>>^^>>v^<<^v>^<^v>>v<^>>vvv<<^><^>>v<>v<><^^^vvv<>^<v^^v>v^>v><<>^<v^^>>v<<<^^<>>^v<><<v><^<>>><v<v^><<v^<<>vv^<^<^>^>v^^<^<vvv^>v>v>^^>>v><^^<><<<v>^<>v>^v><^^<<<>^>>><<<^^<<^^<vv<>^<><vv>>>>v>^>>>^^>><v>vv^><>><v>^^v<vv><<>><v^<>^<>>><><>^^^v<>><>^<<v>v>^><^><v>>vv^^<v>v^v^^<^>v>v^^<><>>^>v>vv>vv>vv^>^>^vvv<v>^>>>>^vvv^<^>v<v<<v<<v<v><vv<>v<>v>>>^vv<<<^><<<vv<<v<^^^>v^>>v<<>^<>>>v^v>v^^<^^^^><v>^^>v<>vv<>^<v^>>>^^<<v>v<^>v^<v<^^<^>>><^<^v<v>v>>^>>^v^^>>vvvv^>v>>v<v<<<vvv<<vv^v<^vv^^^<<^^<^^<>v^^<v<^^v^><>>vvv<^^^^vv>>>
            v<><<^<v^>v^><>v<<><v<>vvvv>>>vv<vv^^<<vv>vv<v^<>v<^v^v<vv^<><<<v>v^>v^^>^vv<<vv^<><<<<>v>v^>v<>^v^><<<>v^vvv><<<vv<>>v>v><<<>^<^>v<<>v><v>^>>v<>>^^<>v><<vv^v>^v>^<<^^<<v<v><v>v^^^<^^<><>v>v>v><<<^><v<>v>^vv><^^^^vv^<v>^vv^><>>v<^<><^<<^>^v>^v>vv>v>><>^v<<>v><>v^<^^>>vv^^vvv<><v^^<^<^>^v<^>>vv^^><v^<<v^>vv^v<<><v^vv<><<vv><v>^<^>>v>^v><<><^<>^>^vv^v><>>>^v^<<v^<^v^>v^<vv^><vv<>^^<^<<^>vvv^v<<^^vv<^<v>>v>v>^^vv><>v^^<v<<<^<v>^v><<>^v><<v>>v^>><v>^v^<v<<>>^^>v^v<^^v<>><v^^v^>v<>>^^>^><<<^v>>^vv<^>^vv^^>^<>^<>v^>>^v^><<^<><>><><^<<v<<v>^<<><v<<>^^^v<<<>v>v<^v>>v<^>^<<>^v^<<>vv<v><^^v>v<<><><<<vv<v<v><v>vvv^<^vv<v<<^v^v^v<^>^^v^^^^v>>vv^vvv><v^>^<^^>v^><><>^^<^^v<<vv^>v>^<>v>vvv<<v>>vv<>^<v<<<^>v<>vv>>><>^<^v<><<>v^<>>v^^^^v^v<v^^^><<><>^>v^>v^^^v>>^>>^<<<<^v^v<>v<<>><<v>>v>v<>>^^>v>^<^^^v^^<<v<>^>>>>><>^<><^v><vv<>vv^<><vv<>><v>v>>v>^>^v<<<>^<>^<^^<^<>v><^^v<><^^<<vv<v><^v><vv^^>>v^^>^<v^>>vvvvv<^^>^v^><<v>><<<^<v<<>>v>v^v<^<<><><>^<v^^><^<v^^>>v>^<v<>v^v<>>v>v^v^><>v^v>v<<><^^<v<^v>><<>v
    """.trimIndent()
    )
    check(1486520, result)
}

private fun test(input: String, print: Boolean = false): Int {
    val (lines, moves) = input.split("\n\n")
    val walls = mutableSetOf<Point>()
    val boxes = mutableMapOf<Point, Point>()
    var robotOrNull: Point? = null
    for ((x, line) in lines.split("\n").withIndex()) {
        var y = 0
        for (char in line) {
            when (char) {
                '#' -> {
                    walls += Point(x, y)
                    ++y
                    walls += Point(x, y)
                    ++y
                }

                'O' -> {
                    boxes[Point(x, y)] = Point(x, y + 1)
                    y += 2
                }

                '@' -> {
                    robotOrNull = Point(x, y)
                    y += 2
                }

                '.' -> {
                    y += 2
                }
            }
        }
    }
    var robot = robotOrNull!!
    fun printMap() {
        if (!print) return
        val width = walls.maxBy { it.y }!!.y
        val height = walls.maxBy { it.x }!!.x
        for (x in 0..height) {
            for (y in 0..width) {
                val p = Point(x, y)
                if (p == robot) {
                    print('@')
                } else if (p in walls) {
                    print('#')
                } else if (p in boxes.keys) {
                    print('[')
                } else if (p in boxes.values) {
                    print(']')
                } else {
                    print('.')
                }
            }
            println()
        }
        println()
    }
    printMap()
    for (move in moves) {
        if (print) println("move $move")
        when (move) {
            '>' -> {
                val next = Point(robot.x, robot.y + 1)
                if (next !in walls) {
                    val movingBoxes = mutableSetOf<Point>()
                    var nextBox = next
                    while (nextBox in boxes) {
                        movingBoxes += nextBox
                        nextBox = Point(nextBox.x, nextBox.y + 2)
                    }
                    if (nextBox !in walls) {
                        robot = next
                        boxes -= movingBoxes
                        for (box in movingBoxes) {
                            boxes[Point(box.x, box.y + 1)] = Point(box.x, box.y + 2)
                        }
                    }
                }
            }

            '<' -> {
                val next = Point(robot.x, robot.y - 1)
                if (next !in walls) {
                    val movingBoxes = mutableSetOf<Point>()
                    var nextBox = next
                    while (nextBox in boxes.values) {
                        movingBoxes += nextBox
                        nextBox = Point(nextBox.x, nextBox.y - 2)
                    }
                    if (nextBox !in walls) {
                        robot = next
                        boxes.filterValues { it in movingBoxes }.forEach { (key, _) -> boxes -= key }
                        for (box in movingBoxes) {
                            boxes[Point(box.x, box.y - 2)] = Point(box.x, box.y - 1)
                        }
                    }
                }
            }

            '^' -> {
                val next = Point(robot.x - 1, robot.y)
                if (next !in walls) {
                    val movingBoxes = mutableSetOf<Point>()
                    val checkIfBoxes = mutableSetOf<Point>()
                    checkIfBoxes += next
                    checkIfBoxes += Point(next.x, next.y - 1)
                    while (checkIfBoxes.any { it in boxes }) {
                        val tmp = checkIfBoxes.filter { it in boxes }.toSet()
                        checkIfBoxes.clear()
                        tmp.forEach {
                            checkIfBoxes += Point(it.x - 1, it.y)
                            checkIfBoxes += Point(it.x - 1, it.y - 1)
                            checkIfBoxes += Point(it.x - 1, it.y + 1)
                            movingBoxes += it
                        }
                    }
                    val canMove =
                        movingBoxes.all { Point(it.x - 1, it.y) !in walls && Point(it.x - 1, it.y + 1) !in walls }
                    if (canMove) {
                        robot = next
                        boxes -= movingBoxes
                        for (box in movingBoxes) {
                            boxes[Point(box.x - 1, box.y)] = Point(box.x - 1, box.y + 1)
                        }
                    }
                }
            }

            'v' -> {
                val next = Point(robot.x + 1, robot.y)
                if (next !in walls) {
                    val movingBoxes = mutableSetOf<Point>()
                    val checkIfBoxes = mutableSetOf<Point>()
                    checkIfBoxes += next
                    checkIfBoxes += Point(next.x, next.y - 1)
                    while (checkIfBoxes.any { it in boxes }) {
                        val tmp = checkIfBoxes.filter { it in boxes }.toSet()
                        checkIfBoxes.clear()
                        tmp.forEach {
                            checkIfBoxes += Point(it.x + 1, it.y)
                            checkIfBoxes += Point(it.x + 1, it.y - 1)
                            checkIfBoxes += Point(it.x + 1, it.y + 1)
                            movingBoxes += it
                        }
                    }
                    val canMove =
                        movingBoxes.all { Point(it.x + 1, it.y) !in walls && Point(it.x + 1, it.y + 1) !in walls }
                    if (canMove) {
                        robot = next
                        boxes -= movingBoxes
                        for (box in movingBoxes) {
                            boxes[Point(box.x + 1, box.y)] = Point(box.x + 1, box.y + 1)
                        }
                    }
                }
            }
        }
        printMap()
    }
    return boxes.keys.map { it.x * 100 + it.y }.sum()
}
