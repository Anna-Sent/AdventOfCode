package advent2022

import utils.Point

private var result = 0

fun main() {
    result = test("""
                ...#
                .#..
                #...
                ....
        ...#.......#
        ........#...
        ..#....#....
        ..........#.
                ...#....
                .....#..
                .#......
                ......#.
        
        10R5L5R10L4R5L5
    """.trimIndent(), 4,
            mapOf(
                    0 to Triple(7, Direction2.DOWN, false),
                    1 to Triple(13, Direction2.DOWN, true),
                    2 to Triple(11, Direction2.UP, true),
                    3 to Triple(5, Direction2.LEFT, true),
                    4 to Triple(9, Direction2.DOWN, true),
                    5 to Triple(3, Direction2.LEFT, true),
                    6 to Triple(8, Direction2.DOWN, true),
                    7 to Triple(0, Direction2.RIGHT, false),
                    8 to Triple(6, Direction2.DOWN, true),
                    9 to Triple(4, Direction2.LEFT, true),
                    10 to Triple(12, Direction2.UP, true),
                    11 to Triple(2, Direction2.RIGHT, true),
                    12 to Triple(10, Direction2.UP, true),
                    13 to Triple(1, Direction2.RIGHT, true)
            )
    )
    check(5031, result)

    result = test("""
                                                          ..........#.#...........#.#...#..#......#.#.............#.....#...#...............#.....#......#..#.
                                                          ##..#..........#........#....#..............#...........#.....#............#...........#..#.........
                                                          .....#..........................#.........#..##...#..#.....#..................#.....................
                                                          .....#..................................................#.#..........#...................#.........#
                                                          ....#.....................#..#.........#..#.................##......................................
                                                          ...........................#..........#..#....#......................#.......#..#......#...........#
                                                          .......#..........#...................#...............#....##........#....#.#.........#....#..#.....
                                                          ......#.....#.......#.............#.........................#............................#.#....#...
                                                          ..#......#...#........................#............#.......#...................#..#.....#...........
                                                          .##........##..#......#..........#.......#...#..#...........................#....#...#.........#....
                                                          .#................##........#..............#.#..#.#........#.........#.........#......##............
                                                          ......................##......#....#........#.##....................#.#....##....##...............#.
                                                          #..................###...#........#..................#......#..#..#...#...#...#.....................
                                                          ....#.....#....#..#..#......#.......#...............#......#........................................
                                                          ........#.....#.......#......##..........#..........#........#....#..#....................#.......##
                                                          ........#.............#..........#..##.....#..............##...............................#.#.#....
                                                          .........................#.............#......#.....#.........#..........#.................#........
                                                          #.............#.........................................##......#...#..........#....................
                                                          ........#.#......#........................#....#.....#.........#.#......#.....##....................
                                                          ................................#.................#......##..#...#..#..#........##...##......#..#...
                                                          .......#........#..#....#.....#.#..........................#........................................
                                                          .........#.........#...............................#.......#.....................#...............#..
                                                          .................#....#..........................##............................#........#...........
                                                          .#...#........................#...#..#.....................#....#.........................##.#......
                                                          .......##....#.#....................#...#.....#..#..#.#.........#.........#.............#....#......
                                                          ......#..#......................#.#...#.#.......................#...#..#...................#...#....
                                                          ............#....##...........#..........#.......#..#..#....#......................................#
                                                          ..#....................#...#.........#.#.....#........#.#...#........................##.............
                                                          ..............#..#......##.......#....#.......#.....#........#........##..##.............#..........
                                                          ......##..#..........#........#...................#....................................#....#....#.#
                                                          .........................#.....##...##....#........#...#........#........#..................#.#.....
                                                          ......#.....#..................#.....#.......#.#...........#....##................#..#.....#.#......
                                                          ......#.#..#.................#..............................................#...............#....#..
                                                          ...#.....#.....#............#..............................#...#..#..............##.................
                                                          ......#........##.#..#..........#....##.#......#.........#................................#....#....
                                                          ...#.#...........................#....#.....#..........................#.............#.....#.....#..
                                                          .....................#.#.#.........................#............#....#.........#.........#.........#
                                                          ....#....#...................................#.........................#......#.........#...........
                                                          ................#...#............#.#...#..#.............#.#......................#...#......##....#.
                                                          ...........................#....#.............#..................#....###..........#...............#
                                                          ...#.................#..#.....#.............#.......#................#..#......................#.#..
                                                          ................#.......#.........#....#.......#......#..............#..#.#.......#...#......#......
                                                          ....##.#........#...#.........#.......................#...........##........##..#...................
                                                          .#......#...............#.....#.............#...........................#..#..#....#.........#......
                                                          ................#.....##.......#...........#..#........#.#....#......#..........................#..#
                                                          ...#......#..#......#....#........................#............#...#..............##................
                                                          .#...........#................#..#.....................#...............#........#...................
                                                          .....#...........#..............#...#......#.##........#...........#....#..................#........
                                                          #..#.............................#......#.....#........#.............#..#.#.#...#.#.................
                                                          #.................#....#..........#.....#.............................#.#.........#.................
                                                          .......#.....#..#........#..#....#...#..#.........
                                                          ........................#.............##.........#
                                                          ...#.....#........#......#.......#.#...#..........
                                                          .......#..........#...............................
                                                          ....#..#......................................#...
                                                          .....#..........#..##...#.............#..........#
                                                          #....#......#..#.#....#.......#.......#...........
                                                          ..................................................
                                                          ...#.....#..............#.............#....#.....#
                                                          ..............#.................#............#...#
                                                          ..................................................
                                                          ................#..............##..##........#..#.
                                                          ....#.............................#...............
                                                          .....##......#...##.................#.......#.....
                                                          .....#...#.................#...#......#...........
                                                          ........#.............#..............#.#..........
                                                          ........#.........#.....................#.........
                                                          .....#....#.......#..##....#............#.........
                                                          .....................#....###...#..#.#.....#......
                                                          ...#...........#................#.................
                                                          .##...#..#...#....#..#..#.........................
                                                          .....#.........#.#.....#...#..##.......##....#....
                                                          .....#..#.................#.........#.......#.....
                                                          ................#...#....................#........
                                                          ...#....#.............#..#......#.................
                                                          .........#..###.............................#..#..
                                                          .........#...#.........#..........................
                                                          ........#.......#..........#...#...#......#.......
                                                          ...##..#.#.....##...............#.#............#..
                                                          ..#.....................##......#.............#...
                                                          ....#...................#.........................
                                                          ..............#...............................#...
                                                          .....#.#.....#..........................#.##.#....
                                                          .....................#..........#....#....#......#
                                                          .....................#.....................##.....
                                                          ........#........#.#............#.##..#..#.......#
                                                          .....#...............#...#..............#.........
                                                          ................#....#.....#......................
                                                          .............##..............#....................
                                                          ..#.......#................#.......#...........#..
                                                          ...#............#.............#...................
                                                          #........#...............#....##..............#...
                                                          .................................#.#.#......#.....
                                                          .........................#.........##......#....#.
                                                          ...#..#........#.#...........#..........#...##.#..
                                                          ...........##..##......#.................#......#.
                                                          ......##.#...........................#.......#...#
                                                          ............#..#..................................
                                                          .............#..................#.......#...#.....
                                                          .......................#......................#...
        .............#.#...#......##..#..##...#.....#...#....##......#.................#...........##...#...
        ....#....#....................#..........##..#........#...#.....#.................................#.
        ...............................#..........#.....#.....................#......#...##........#....#...
        .....#............................#......#.......................#..............................##..
        .#....#.#.........................#........#........##...#..........................###.............
        .#...#.........#..................#..........#.............#....................#...................
        ..................#.#............#...#..##.....................#.........#........#....#............
        #................#.............................#.#.................#................................
        .........................#..................#.#..###................................................
        .....................................#........##..#.#....##.................................##......
        .........#...........#......................##.#.................#.....#....#........###............
        ........#.....#...........##......#.....#....#.##.##.#..##..................#......#................
        .......##....#...................#...#...........#......#........#........#...........#.....#.......
        .#.....#......#............#......................#......................#......................#...
        .........................#.........##...........................#..#.....#..#...#.#..........#......
        ...............#..............................#...........#.......................#...............#.
        .....#............................#....#........#...................#....#..#.................#.....
        ..#....................#.........#......#............................#..#..............#........#...
        ..#.#...#................................................##......#......#.#..............#..........
        ..#..#...#....#........#.........#.....#.........#....#...#.......#....#..........#...#.............
        .................##......##.....#.....##..#....#...#.................................#.#...#...#....
        .........#.#....................................#..#.......##.....................#......#.#..#.....
        #.#..........#.........##..#............#..............#.....#...#.........................#........
        .....#.....................#......#...................##...........#.............#........#.#....#.#
        ....#.........#.#.....#..#..................#................................#.........#....#......#
        ...........#....#.....#......#.#.........................#....#.....................................
        ...#....#.#.....#........#....#..........#..............#...#...#........#.............#..#.........
        ..............#......#.....##.............#......#............................#............#..#.....
        .#....................#.........#........#................#......##....#...................#........
        ...........#........#........#.....................................##......#.......#................
        ...........#...#...#..........##............##......#.....#....#.....................#........#.....
        .....................#.................#....................#...............#.................#.....
        ....................................##...........#.#..#.##.......#..#.........#.....................
        ............#..............................................#..##................#.#..#............#.
        ...##....#.#...#.....#..........#....#........#.###....#...##...##..#....##....#...#.........##....#
        .......................#....#....#...#....##...............................#....#...###.............
        ........#....#..##.............................##.....#....##..#...........#.#......#...............
        ...........#....#...................#........##...##...............#.#..................#.........#.
        .....................#..#..........................#.............#......#.............#...........#.
        ...........#.................#..........##....................................#.......#....#..#..#..
        ..................#.....#.#....#.......#.#.........#...................#...##................#.#....
        ........#..................#.................#.....#.....#...........#.......#........#.#...........
        #.......#......#.........#....#..................#..#...........#........#..#....#..................
        .............#.......#..................#......#...#............#.#.#.#...........#.....##.#........
        #....#.#................#....#...........#.#......................#................................#
        ....#.#...........................#.###...#...#.....#...................#....#....##...#............
        ....#.#.........#........#.........#........#.#.......##.......##.....#........#....................
        ......#.....#...#...........#..#..........#......................#....................#.............
        ....#..........................#...........##....#..#...............#....#......#.................#.
        ..##.................#........#.....#..................#...#...#...................#................
        .....#....##............#.......#.....#...........
        ....#.#.......#......#.#...........##.......#.#...
        .................................................#
        #.........#.....#...#..........#...............#..
        ......#.............#.......#.......#............#
        #........#....#....#....#............#....#....#..
        .......#.#......#.#.........#.........#.......#.#.
        ...#......................#....................#.#
        .............................#....................
        #..........#..#............#..#.#............#....
        ..#..............................#....#...........
        #...............................#...#......#......
        ...............#........#.........................
        ..................#......#..............#.........
        ...........#................#.......#..#...#..#...
        .........#......#...........#....#..............#.
        ...#........#..#.........#...#.......#...#........
        .....................#.........................#..
        #..................#.........#..#..#..#...........
        ..........#.#.#.........#..............#.....##...
        ...........#........#............................#
        ...................#.#...#............#...........
        .........#.#.....#..#.#....#.........#............
        ................#...#.............................
        .............#..#.#.......#.#..................#.#
        ..#.................#...........#...........#.....
        ..........#.#...........................#........#
        ......................#.................#.........
        ....#.#.................................#.........
        ..................#.#..........#..................
        .................##.....#.........................
        ......................................#...........
        ......#...............#.........#.............#...
        ..............#..........................#......#.
        ...........#.............###...............##.....
        .....................##.#..........#..#........#..
        ....................##.......#....................
        .......#....#........#.#....#....#...#.#....##....
        ..#............#..............#..#.....##......#..
        .........................#..............#.........
        ...................##.........#...#...............
        ....##............#......#..........#....#........
        ..#.....#..........#...........#...........#...#..
        ....#.........#........#.#.#.........#........#..#
        ............#...........................#.......#.
        ..##.#...#..................................#..#..
        .........#.........#........#..........#..........
        .##.......#...........#.#..#...#...#..............
        ..#..............#.##.#.#.....#...#.#...........#.
        .......#......#...............#..#..............##
        
        15R31L20R16L45L47R24L3L43R35R33L50R19L24L2R48L42R23R27L36R8L25L18L32L45L45R1L6L44R16L14L15L48L11R35L42L26R35R15R28L16R41L7L30L3R17R41L6L36R37L40L25L44L16R4L29R14R19L31R31R49R49L20R36L50R7L5R23R42L19L11L42R13R5L1R24R14R4L42L31R13R41L16R46R38L20R34R38L22R11L38R38R41R39R37L23L26R35R20L13R50R13L21R11L16L11L48L40L39L11L48L39L44R4R28L27L50L37R8L46L13L15L31L22R33R12R46R41R7R2L38R24R27L24R7R45L15L25L41R11L44L37L35R11R3R13L32R4R28R47R42R14L48R35R10L36R14L9L40R31R34R17R44L37L23L29R40R12L13L6L22R18R3L37R42R12L9R37L37L47L49L1R24L50L30L48R8L18R38L26L48R26L2L5L23R29R17L25L5R16L6R21R30L12R33R24R3L22R25L6L27L40L49R19R32L41L33L38R48R22L11R22L38L50L21L44L44R16L40L38R30R40L18L41L15R16L45L33R8L28L25L44L4R28L41R12L12L3L43R34L12L23R3L37L21R9L37L10R9R50L14L43R17L50R50R33R11R21L10R43L9L37L22L28R43R25R14L4R23L42R16R19L23R24R16L23R25R11R15L31R7L38L42L50L43R8R41L20L27L9R32L14R50L37L7R45R8R37R30L26R38R23L42R40L36R32L16L37R20L35R35R9L42L16L29L48L21R4L44L10L43L34L37R39L7R35L1L20R26L40L48R18R16L7L32R44R48R43R29R47R25L26R49R4L15L38R44L18L22L45R10R22L25R10R26R4L39L49R20L9R30R32L49L43R25L49L5L16R14L42R44L2L5L40R8R26R19L34R12R1R13R8R41L46L2R19L34R13R50R14L3R42R16R36L25L15R43L3L48L35L30R13R38R10R46L7L37L47L1L14R9L32L6L9R49R42R47R31L12L28R18L2L3L44L1L24R39R40L3L1R30R39R25R16R6R32L41R12L38R13L34L7L24R40R14L28L32L21R34L28L9L13R34R4R35L10R8L49L35R20R20L35L35R8L20R20L2L41R29L26R49R36L50R40L30R2R30R4L8R28R47R3R26R2R50R23L47L39L2R40L23L17R12L1R4L1R44R3R2L38L8L10R7R32L37R47R18R19R12L34R18L40L6R10R29R20R1R32R43L41L46L14R17R28L48R15R43R14R16L14L20L31R1L29L41L30R49L30R50L49R29L42L36R25R5L34R25R21L23L43R23L48R17L42L37L31L1L30L36R45R41L44L41L32L43L25L14R47L29R38L12L50L24R8L41R19R9L24R1L39L47L37L39R39R31L32R31L32R16R24R31L25L13L19L13L12L24L6R31L11L40R4L43R46L37R8L8R8L22R28R21R48R49R12L7L31L37L32L49R37R36R45R29R9L37L41R11L18R49L44R11R15R15L49L17R40R40R15L5R27R6R7L47L38R15R33L32R31R18R29R39L22L50R25R43L28L7R5L49R4L3R45L22R18R19R48R41L5L38R22R5R24L24R46L4R1L17L10L4L45L8L27L44L28L44R46L11R11L2L20R15L26R40R15L25L22R11R2R16R28L27R12R9L27L37L36R30R35R2R23L47R11R19R24L27R15L18R30R32R9L43L47R18L49L28R6R34L44R41L32R8R18R20R6L35R33L15L19R18L48L44L16L31L31L33R14L44R23L18R34R7R41L9R45L40R10L1L10L36L23R38R31R35L29L32R13L16L8R17R40L34L40R7L11R7R27R4L40L37R2L27R11R41R45L20R37R11R3R35L29R26R19L22L24R15R44R26R48L14R43R25L16R40R38L26L18R38R3R25L19L38L4R20L30R17L48R32R31R37L25R29L41R1R34R27R1L25R19L30R6L39L31R43L17R35R43R37R22R9R20R5R22R37R33L30L15L23R43L41L5L46L25L1L49L23R49L34R1L23L47R5L12L41R1R14R7L3R47L41L27R36R38R10L20R8L10R29R37L46R30R2R10R46L27L44R22L34R14R21L19R35R26R31R13L7R16R40L48L30L2L5R10L47R14R16R46L3R5L21L29L25L25R14R27L42L12R48L14R46R10L16L16R3R41L11R6L24L34L24L23R27R13L50L43R23L16R24R11R4R22L46R5R25R22L8R43R23R6R35L34R31L12R26R49L42R17L26L7L50L30L16R9R18R34L31L25L45R2R41R40L43L5R45R44L10L25R6R40L50R43L47L42L35L32L17R9L16R22L11L47L7L34L29R25L42L29L47L21L15L5R18R15R25L2R43L42L41L37L42L37L19L27R13R40L46L2L13R25R22R41L42R23R23L26L12L35R17L50R48R26R27R39R4R39L24R45R40L17L32L20L41R9R26R17R13L41L28L41L3L25L39L10L31L19R48R50L38R16R15L25R15R30L15L6R9R49L38R36L16L33L15R4R11L6R3L19R15L45L19L21L18L17R34R13R41L27R29L34L4L38L1L1R48L48R47R29L40R7R50R3R47R37L20R24R4L40L9R41L14L22R36R48L8L25L41L40R8R45R44R27L45R6R31L15L20R19R46L36R32L40R12R17R36R2R23L6L31L36R40R13R50R16L1R11R45R43R40R8R25L25R2R47R6R16L18L11L38R9L14R14R6L49L34R14R6R40R46L25L43R41L46R17L18R10L19L35L31R1L9R47R44L44R6R42L32R23R10L32R21L33L25R22L38R33R40R41R2L23L28L20L29R49R17R31R7L44L31R6L19R36R34L46R35L30L27L13L17L20L24L18L39L33L22R15R28L20L32R5R11R19R6L25R19R39L22L36R44R11R15R48R45L40L28R10R8R1R39R49L19R32L46R17L15L26L39L36L1R13L19R41R39L39L4L9R50R20L22L30R1R3R14L22L32R4L20R34L3L24R22L24R29R19L1L13L39R8L22R17R2L48L12L37R8L44R46R29R6R45R34R13R18R26L15L33R43L39R2L36L34L26L18R11L17L45R22R9L44R24L22L40R16R14R23L26L4L23L15L4R3L35R17R31L30R23L47R47L3L48R38R3L3R25L11R2L24L9L43R29R44L1L49L14L47L40R36R41R1R21R39R34L49R14R16R29L20L13R38R28L39L18R36L1R24L21R11R45R30R37R45R32L39R40L34R16L3L34L31R25L35R42L35L50R13R10R18L20R21R45R42L28R20L22R37R48L5L49L3R42L27R35R25L33L28L24R5R41R6L49R32R12L49L6R11L15R6R14R20L17L39R4L12L48L24R33L8L43L1R44R10R7R5L9L16L40R32R37L32L15L5L49R5L19R1L23R35L42L26R4R17L26R35R43R8R9R1L2R7R18R23R23R16L46L6R46L33R9L37R46L26R20R50R42L27R45L23R25R17R21R10L35L40L3L21L16L46L30L16L44R50L44L11L21L4R34L33L3L14L49R47R45R4L37L41R28R14L38R8L16R50L14R9R33L15L19L18R33R25R27R38R45L1L2R21R1R5R19L27L17L41L1L42L10L16L43L25R6L15R22L49R31L17R7R12L9R35R44R24L17L8R16R8L23L19L23L21L14L10R30R3R16L14L27L10R21L37L27L12L46R13R41R47L8L10R28R49R32L41R42L2L37L20R40L3R7R16R23L8L30R41L1L3L8L36R4L34L42L19R16L7R19L42L6R21R22R6L27R37R18L15L21R18R40R4L45L25L25L31R25L25R30L43R7R3L14R20L40L44R16R2R12R46R48R18L14R46L35L16R15R8L23R37L7R6R2R45R27R47L6L15R22R48R8L31L12L45R30L45R48R32L21R48L45R2R12R27R26R42L4L37R22R35L11L7L21R35L45L1L42L21L46R30L12L40L38L50R26L19L44L39L33L26R39L25R36L1L16R33R3R25R2R18R11L25L24R26L27L42R8L1L20R4L34R6L49L4L3L2R36R17R11R12R41L33L38L13R26L49R30L40R17R31L5R47R9L30L20R39L32R25L37L4L6R35L41L19R47R14R35L30R32R40L1L9L22L35R18R15R7L21L28R26L6L42R40R38L49L12R19L45R9L8R35L19L47L40L23L19R4R45R17R22L14R32L4R24L5L11R13R42L34R19L2R30R10L26R40R39R21L25L19L14R28L3L26R38L2L37L36L36R36R24R4R16R46L8L43R24L34R5L17R42R28R33R26R8L9L47L24R50L45L12R16R19L45R48L28R32R15L8L10R31R22R42R47R30R31R9R8L39L18R22L9R13R12R21R48L50R23L30L24L3R44L4L43L33R12R2L44R14R45R34R42R29L17R27R36L47R1R17L49R10R45R25R1L11R42R50R28R6L30R37L37L4R41R47R16R36L46L49R8R5L10L44L48L44L18L27R2L12R6R23L28R9R2R3L45R30L11L49L1L32R43R17L35L43L9R29L50L30L4L25L6L18R45L21R22R35R1L13R37R48L34L21R40L5L19L44R47L40R16R23L44R41R3R2L33R5R40L22L26R28L33R44R40R8L24L26R22L11L19R37L16L25R29R4L41R10R12L26R8L45
    """.trimIndent(), 50,
            mapOf(
                    0 to Triple(2, Direction2.RIGHT, true),
                    1 to Triple(8, Direction2.DOWN, false),
                    2 to Triple(0, Direction2.RIGHT, true),
                    3 to Triple(9, Direction2.DOWN, false),
                    4 to Triple(6, Direction2.LEFT, true),
                    5 to Triple(13, Direction2.UP, false),
                    6 to Triple(4, Direction2.LEFT, true),
                    7 to Triple(12, Direction2.UP, false),
                    8 to Triple(1, Direction2.RIGHT, false),
                    9 to Triple(3, Direction2.RIGHT, false),
                    10 to Triple(11, Direction2.UP, false),
                    11 to Triple(10, Direction2.DOWN, false),
                    12 to Triple(7, Direction2.LEFT, false),
                    13 to Triple(5, Direction2.LEFT, false)
            )
    )
    check(36540, result)
}

private fun test(input: String, cubeSide: Int, sideToSide: Map<Int, Triple<Int, Direction2, Boolean>>): Int {
    val (mapStr, path) = input.split("\n\n")
    val map = mutableMapOf<Point, Char>()
    var startPos: Point? = null
    var row = 1
    for (line in mapStr.split("\n")) {
        var col = 1
        for (char in line) {
            if (char == '.' || char == '#') {
                val p = Point(row, col)
                if (startPos == null) startPos = p
                map[p] = char
            }
            ++col
        }
        ++row
    }

    var sideIndex = 0
    var lastSideIndex = 0
    val positionToSide = mutableMapOf<Pair<Point, Direction2>, Int>()
    val sides = Array(14) { arrayListOf<Point>() }

    val rowCount = map.keys.maxBy { it.x }!!.x
    for (row in 1..rowCount) {
        val minCol = map.keys.filter { it.x == row }.minBy { it.y }!!.y
        val p = Point(row, minCol)
        val side = sideIndex + (row - 1) / cubeSide
        //println("$side left $p")
        positionToSide[p to Direction2.LEFT] = side
        sides[side] += p
        lastSideIndex = sideIndex + ((row - 1) / cubeSide)
    }
    sideIndex = lastSideIndex + 1
    for (row in 1..rowCount) {
        val maxCol = map.keys.filter { it.x == row }.maxBy { it.y }!!.y
        val p = Point(row, maxCol)
        val side = sideIndex + (row - 1) / cubeSide
        //println("$side right $p")
        positionToSide[p to Direction2.RIGHT] = side
        sides[side] += p
        lastSideIndex = sideIndex + ((row - 1) / cubeSide)
    }
    sideIndex = lastSideIndex + 1
    val colCount = map.keys.maxBy { it.y }!!.y
    for (col in 1..colCount) {
        val minRow = map.keys.filter { it.y == col }.minBy { it.x }!!.x
        val p = Point(minRow, col)
        val side = sideIndex + (col - 1) / cubeSide
        //println("$side up $p")
        positionToSide[p to Direction2.UP] = side
        sides[side] += p
        lastSideIndex = sideIndex + ((col - 1) / cubeSide)
    }
    sideIndex = lastSideIndex + 1
    for (col in 1..colCount) {
        val maxRow = map.keys.filter { it.y == col }.maxBy { it.x }!!.x
        val p = Point(maxRow, col)
        val side = sideIndex + (col - 1) / cubeSide
        //println("$side down $p")
        positionToSide[p to Direction2.DOWN] = side
        sides[side] += p
    }

    var currentPos = startPos!!
    var currentDirection = Direction2.RIGHT

    fun makeSteps(count: Int) {
        for (i in 1..count) {
            val candidate = when (currentDirection) {
                Direction2.RIGHT -> Point(currentPos.x, currentPos.y + 1)
                Direction2.LEFT -> Point(currentPos.x, currentPos.y - 1)
                Direction2.UP -> Point(currentPos.x - 1, currentPos.y)
                Direction2.DOWN -> Point(currentPos.x + 1, currentPos.y)
            }
            var value = map[candidate]
            if (value == '.') {
                currentPos = candidate
            } else if (value == '#') {
                // leave currentPos same
            } else {
                val onTheSide = positionToSide[currentPos to currentDirection]
                        ?: throw IllegalStateException("positionToSide -- not found")
                val (otherSide, newDirection, reverse) = sideToSide[onTheSide]
                        ?: throw IllegalStateException("sideToSide -- not found")
                val positionIndex = sides[onTheSide].indexOf(currentPos)
                if (positionIndex < 0) throw IllegalStateException("sides index -- not found")
                val newPosition = if (reverse) {
                    sides[otherSide].asReversed()[positionIndex]
                } else {
                    sides[otherSide][positionIndex]
                }
                value = map[newPosition]
                if (value == '.') {
                    currentPos = newPosition
                    currentDirection = newDirection
                } else if (value == '#') {
                    // leave currentPos same
                } else {
                    throw IllegalStateException("invalid candidate")
                }
            }
        }
    }

    fun turnTo(direction: Direction2) {
        currentDirection = when (direction) {
            Direction2.RIGHT -> when (currentDirection) {
                Direction2.RIGHT -> Direction2.DOWN
                Direction2.LEFT -> Direction2.UP
                Direction2.UP -> Direction2.RIGHT
                Direction2.DOWN -> Direction2.LEFT
            }

            Direction2.LEFT -> when (currentDirection) {
                Direction2.RIGHT -> Direction2.UP
                Direction2.LEFT -> Direction2.DOWN
                Direction2.UP -> Direction2.LEFT
                Direction2.DOWN -> Direction2.RIGHT
            }

            else -> throw IllegalArgumentException("invalid direction")
        }
    }

    val buffer = StringBuilder()
    for (char in path) {
        when {
            char.isDigit() -> {
                buffer.append(char)
            }

            char == 'L' -> {
                if (buffer.isNotEmpty()) {
                    makeSteps(buffer.toString().toInt())
                    buffer.clear()
                }
                turnTo(Direction2.LEFT)
            }

            char == 'R' -> {
                if (buffer.isNotEmpty()) {
                    makeSteps(buffer.toString().toInt())
                    buffer.clear()
                }
                turnTo(Direction2.RIGHT)
            }

            else -> {
                assert(false) { "invalid char" }
            }
        }
    }
    if (buffer.isNotEmpty()) {
        makeSteps(buffer.toString().toInt())
        buffer.clear()
    }
    return currentPos.x * 1000 + currentPos.y * 4 + currentDirection.value
}

private enum class Direction2(val value: Int) {
    RIGHT(0), DOWN(1), LEFT(2), UP(3)
}
