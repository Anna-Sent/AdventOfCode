package advent.advent2019;

import utils.Point;

import java.util.*;

public class AoC2019Day20Part2 {

    public static void main(String[] args) {
        int result;

        result = test("         A           \n" +
                "         A           \n" +
                "  #######.#########  \n" +
                "  #######.........#  \n" +
                "  #######.#######.#  \n" +
                "  #######.#######.#  \n" +
                "  #######.#######.#  \n" +
                "  #####  B    ###.#  \n" +
                "BC...##  C    ###.#  \n" +
                "  ##.##       ###.#  \n" +
                "  ##...DE  F  ###.#  \n" +
                "  #####    G  ###.#  \n" +
                "  #########.#####.#  \n" +
                "DE..#######...###.#  \n" +
                "  #.#########.###.#  \n" +
                "FG..#########.....#  \n" +
                "  ###########.#####  \n" +
                "             Z       \n" +
                "             Z      ");
        assert result == 26 : "unexpected result is " + result;
        System.out.println(result);

        result = test("             Z L X W       C                 \n" +
                "             Z P Q B       K                 \n" +
                "  ###########.#.#.#.#######.###############  \n" +
                "  #...#.......#.#.......#.#.......#.#.#...#  \n" +
                "  ###.#.#.#.#.#.#.#.###.#.#.#######.#.#.###  \n" +
                "  #.#...#.#.#...#.#.#...#...#...#.#.......#  \n" +
                "  #.###.#######.###.###.#.###.###.#.#######  \n" +
                "  #...#.......#.#...#...#.............#...#  \n" +
                "  #.#########.#######.#.#######.#######.###  \n" +
                "  #...#.#    F       R I       Z    #.#.#.#  \n" +
                "  #.###.#    D       E C       H    #.#.#.#  \n" +
                "  #.#...#                           #...#.#  \n" +
                "  #.###.#                           #.###.#  \n" +
                "  #.#....OA                       WB..#.#..ZH\n" +
                "  #.###.#                           #.#.#.#  \n" +
                "CJ......#                           #.....#  \n" +
                "  #######                           #######  \n" +
                "  #.#....CK                         #......IC\n" +
                "  #.###.#                           #.###.#  \n" +
                "  #.....#                           #...#.#  \n" +
                "  ###.###                           #.#.#.#  \n" +
                "XF....#.#                         RF..#.#.#  \n" +
                "  #####.#                           #######  \n" +
                "  #......CJ                       NM..#...#  \n" +
                "  ###.#.#                           #.###.#  \n" +
                "RE....#.#                           #......RF\n" +
                "  ###.###        X   X       L      #.#.#.#  \n" +
                "  #.....#        F   Q       P      #.#.#.#  \n" +
                "  ###.###########.###.#######.#########.###  \n" +
                "  #.....#...#.....#.......#...#.....#.#...#  \n" +
                "  #####.#.###.#######.#######.###.###.#.#.#  \n" +
                "  #.......#.......#.#.#.#.#...#...#...#.#.#  \n" +
                "  #####.###.#####.#.#.#.#.###.###.#.###.###  \n" +
                "  #.......#.....#.#...#...............#...#  \n" +
                "  #############.#.#.###.###################  \n" +
                "               A O F   N                     \n" +
                "               A A D   M                     ");
        assert result == 396 : "unexpected result is " + result;
        System.out.println(result);

        result = test("                                         J       F           Z     S   X           H     T                                             \n" +
                "                                         Q       V           V     K   P           K     D                                             \n" +
                "  #######################################.#######.###########.#####.###.###########.#####.###########################################  \n" +
                "  #...#...#.#...........#.#.....#.#.....#...#.#.#.....#.#...#...#...#.#...#.........#.#...................#.#.#.#...#.#.....#.......#  \n" +
                "  ###.###.#.#######.#####.#.#.#.#.###.#.###.#.#.#.###.#.###.#.#####.#.#.#.#######.###.#.#.#.###.###.#.###.#.#.#.###.#.###.#.###.###.#  \n" +
                "  #.#.....#.#.#.#.#...#.#...#.#.....#.#.....#.......#.#.........#...#...#.#.....#.....#.#.#.#.#...#.#.#.#.......#...#.....#.#.....#.#  \n" +
                "  #.#####.#.#.#.#.#.###.#########.#.###.#.#####.#######.#.#########.###.#####.#.#####.#.#####.#########.#.#######.#.###.#####.#.#.#.#  \n" +
                "  #.#...#.....#...#...#.....#...#.#.....#.#.#.......#...#.#...#.....#.#.......#.#.....#.#...........#...#.#.#.....#.#.......#.#.#.#.#  \n" +
                "  #.###.#.###.###.###.###.###.#####.###.###.###.#########.#.#.#.#.###.#######.#####.###.#.#.###########.###.#.#######.###.###.#####.#  \n" +
                "  #...#.#.#.#...#.#.....#...#.........#.....#.#...#.........#.#.#.....#.........#.#.#.#...#...#...#.......#.....#...#.#.#.#.#.#.#.#.#  \n" +
                "  ###.#.###.###.#.###.###.###############.###.#.###.#.###.###.#######.#.###.#####.#.#.#.#.###.#.#######.###.#####.###.#.###.#.#.#.###  \n" +
                "  #.#.................#.#.#...#...#.........#...#.#.#.#...#.....#.#...#.#.....#.#.....#.#.#.......#.#.......#.....#.#.#.............#  \n" +
                "  #.#################.#.#.###.#.#####.#.###.###.#.###.#.#.###.###.#.###.#######.#.###.#####.#######.###.###.###.###.#.#.###.###.#####  \n" +
                "  #.#...#...#...#.#...............#.#.#.#...#.......#.#.#...#.#.......#.......#...#...#...#...............#.......#.......#.#.....#.#  \n" +
                "  #.###.#.#####.#.#.#####.#####.###.#####.#####.#.###########.###.#.#.#.#######.###.#.#.#.###.#####.###.#########.###.#.###########.#  \n" +
                "  #...#.....#.#.....#...#.#.#.#.............#...#.#.#...#.#...#...#.#.#.#...#...#...#.#.#.........#...#.....#...#.#...#...#.#.#.#...#  \n" +
                "  #.###.###.#.#####.###.#.#.#.###.#######.#.###.###.###.#.###.###.###.#.#.#########.#.###.#.###.###.#####.###.#######.#####.#.#.###.#  \n" +
                "  #...#...#.#.#...#.#.....#.............#.#...#.......#...#.....#.#...#.....#...#.#.#.#...#.#.....#.....#.....#.....#.#.#...#.#.....#  \n" +
                "  ###.#.#####.###.###.#.#.###.#.#.#######.###.###.###.#.#.###.#.#####.###.###.###.#.#.#.#######.###.#.###########.###.#.###.#.###.###  \n" +
                "  #.#...#.#...........#.#.#...#.#.#...#...#...#.#...#.#.#.....#.#.#...#...........#.#.#...#.#.....#.#.....#.#...#.#.....#.#...#.#...#  \n" +
                "  #.#.###.#.#####.#.#.###.#########.#####.###.#.#.###########.###.###.#.#.#.###.#####.#.###.###########.###.###.#.###.###.#.###.#.###  \n" +
                "  #.#.....#.#.....#.#.#.......#.....#...#.#...#.....#.....#.#.....#...#.#.#...#.....#.#.#.#...#...#.#.....#.#.......#.........#.#.#.#  \n" +
                "  #.#.###########################.#####.###.#.#.#########.#.#.#######.#.#######.#.###.#.#.#.###.#.#.#.#.###.###.#####.#.###.###.#.#.#  \n" +
                "  #.....#.....#.#...#.....#.#...#.....#.#.#.#.#...#...#.#...#...#.....#.....#.#.#.#...#...#.....#...#.#.#.....#.#.#.#.#...#.#.#.....#  \n" +
                "  #.#.###.#####.#.#.#####.#.###.###.###.#.###.#.###.###.#.#.#.#######.#.#.###.#.#####.###.#.###############.###.#.#.###.#####.###.###  \n" +
                "  #.#.....#...#...#.....#.#.....#...#.#...#...#.......#...#...#.......#.#.#.#...#...#.#.....#.#.#.....#.#.................#...#.#...#  \n" +
                "  ###.#######.#####.#.#.#.#####.#.#.#.###.###.#.#.###.#.#######.###.###.###.###.#.#.#.#.#.###.#.###.###.#######.###.#####.###.#.#.###  \n" +
                "  #...#.#.#...#.#.#.#.#.....#.#.#.#...#.....#.#.#...#.#.....#.#.#...#.....#...#.#.#...#.#.#.#.......#.....#.#.....#.....#.#.....#.#.#  \n" +
                "  #.#.#.#.#.###.#.#########.#.#.#####.###.###.#.#.###.#.#.#.#.#####.###.#.###.#####.###.###.#.###.#.###.#.#.###.#############.###.#.#  \n" +
                "  #.#.#.#...#.#.#.....#.............#.#.....#.#.#.#...#.#.#.....#.....#.#.....#...#...#...#.#.#.#.#...#.#.#...#.#...#.#...#.....#...#  \n" +
                "  #.###.#.###.#.###.#####.###.#####.#.#####.#.###.###.#######.#######.###.###.###.###.#.###.#.#.###.#####.###.#.###.#.###.###.###.#.#  \n" +
                "  #...#.....#...#.#.....#.#.#...#.#.............#.#.....#...#.....#.#...#.#...#...#...#.......#...#.#.#...#.....#.#...#.....#...#.#.#  \n" +
                "  #.#######.###.#.###.#####.#####.#####.#.###.###.###.#####.#.#####.#.#######.#.#.#.#####.###.#.#####.###.#.#####.###.###.#####.###.#  \n" +
                "  #...#.#.....#.....#...#...#...#.#.....#.#...#.#.#...#.......#...#.#...#.....#.#.#...#...#...#...#...#.#.....#.#.#.#.#...#...#...#.#  \n" +
                "  #.###.###.###.#######.#.#####.#.###########.#.#.###.#.###.###.#.#.#.#######.#.#.###.###.#.###.###.###.#.###.#.#.#.#.###.#.###.###.#  \n" +
                "  #.#.#.............#.#...#.#.#...#.#...........#.#...#...#...#.#.........#...#.#.......#.#.......#.........#.....#.#...#...........#  \n" +
                "  #.#.#.#####.#.#.#.#.#.#.#.#.#.###.#####.#########.#####.#####.###########.###.#############.#######.#.###########.###.#######.#.###  \n" +
                "  #...#.#...#.#.#.#.#...#.#.#...#...#    J         R     L     Y           L   I             X    #.#.#.#.#.#.#...#.#...#.....#.#.#.#  \n" +
                "  #.###.#.###########.#####.###.#.###    N         P     P     L           S   B             P    #.###.#.#.#.#.###.#.#######.#.###.#  \n" +
                "  #...#.#...........#.#.#.#...#...#.#                                                             #.#.....#.........#.....#.#...#.#..AA\n" +
                "  #.###.#.#.#########.#.#.###.#.###.#                                                             #.###.#.#.#.###.#.#.###.#.###.#.#.#  \n" +
                "YL..#.....#.#.#.#.#.#.#..............EK                                                           #.....#.#.#.#...#...#.......#.#....UT\n" +
                "  #.###.#.###.#.#.#.#.###.#####.###.#                                                             #.#####.#.#.#.###.###.#######.###.#  \n" +
                "  #.....#.......#.......#.#.#.#.#.#.#                                                           ZV..#...#.#.#.#...#...#.#.....#.....#  \n" +
                "  #####.###.###.#######.###.#.#.#.###                                                             #.#.###.#.###.#######.###.#.#.#.#.#  \n" +
                "  #.......#...#.#.........#.........#                                                             #.#.#.#.....#.#...#.......#...#.#.#  \n" +
                "  #########.#######.###.#.#.###.#####                                                             ###.#.#.#.#.#.#.#########.###.###.#  \n" +
                "  #.#...#...........#...#...#.#.#...#                                                             #.....#.#.#.#.#.........#...#.#.#.#  \n" +
                "  #.###.#####################.#####.#                                                             ###.#.#########.#.#.###.#######.###  \n" +
                "  #.............#...........#...#.#..YS                                                           #...#.#...#.#.#.#.#.#.........#...#  \n" +
                "  #####.###.###.#.#####.###.###.#.#.#                                                             #.#.#.#.###.#.#####.#####.#######.#  \n" +
                "  #.......#...#.......#...#.........#                                                           FV..#.#...#.....#...#...#...#...#...#  \n" +
                "  ###.#.#.#.#.#.#.###.#.###.###.###.#                                                             #####.#####.#.###.###.#.###.#.#.#.#  \n" +
                "JB..#.#.#.#.#.#.#...#.#.#.....#.#.#.#                                                             #...........#.........#.....#...#..ZP\n" +
                "  #.#.###########.#.###.#########.###                                                             #.#.#######################.#######  \n" +
                "ZZ....#.....#.#.#.#.#.....#.........#                                                             #.#.#.#...#.#.............#.#......IB\n" +
                "  #.#####.###.#.#######.###.###.#####                                                             #####.#.#.#.#.#.#.#.#####.###.#.#.#  \n" +
                "  #.#...........#.....#.#...#.#.....#                                                           QR......#.#.#...#.#.#...#.....#.#.#.#  \n" +
                "  ###.#.#####.#####.#########.#.###.#                                                             #####.#.#.#.#####.#########.#.###.#  \n" +
                "  #.#.#...#.#.....#.#.......#.....#.#                                                             #.#.....#.....#...#.#...#...#...#.#  \n" +
                "  #.#####.#.###.###.###.#####.#.#.#.#                                                             #.###.#.###.###.#.#.#.###.###.#####  \n" +
                "  #.#...#.....#...#.#.#.#.#.#.#.#.#..ZP                                                           #...#.#...#...#.#.#.#.#.......#.#.#  \n" +
                "  #.#.#.#####.#.###.#.#.#.#.#####.###                                                             #.#################.#.#.#.#####.#.#  \n" +
                "YS....#.......#...................#.#                                                           TD..#...#.....#.#...#.#.#.#.#.....#..ZJ\n" +
                "  #######.###.#########.###.#.###.#.#                                                             #.###.###.###.#.###.#.###.#.###.#.#  \n" +
                "EK......#.#.#...#.........#.#.#.....#                                                             #.......#...#.....#.#.#...#...#.#.#  \n" +
                "  #####.###.#####.#.#################                                                             ###.#.###.###.#.###.#.#######.#.#.#  \n" +
                "  #.....#.#.#...#.#.#.#.#.....#.#...#                                                             #...#.#.....#.#.#.....#.......#...#  \n" +
                "  ###.#.#.#.#.#######.#.#.###.#.#.###                                                             #####.###.###.#.###.#.###.#.#.#.#.#  \n" +
                "  #...#.#.......#.........#.#.#.#...#                                                             #.#.#.........#.....#.....#.#.#.#.#  \n" +
                "  ###.###.###.#.#####.###.#.#.#.#.###                                                             #.#.#######################.#######  \n" +
                "  #.#.......#.#.......#.#.#.#........QP                                                           #...#...#...........#.....#.#.....#  \n" +
                "  #.###########.#####.#.###.#########                                                             #.#.#.#.#.###.#####.#.#.#####.###.#  \n" +
                "MP........#...#...#...#.......#.....#                                                             #.#...#.....#.#.....#.#.....#...#.#  \n" +
                "  #######.#.#########.#.#####.#.###.#                                                             #.###.#.#.#.#.#####.#.#####.###.#.#  \n" +
                "  #.........#...#...#.#.#.....#...#..TV                                                         NU....#.#.#.#.#.#.........#.....#.#..RP\n" +
                "  #.###.#######.#.#####.###.#####.###                                                             #.###.###############.#######.#.###  \n" +
                "  #.#...#.......#.#.#...#...#.....#.#                                                             #.#.#...#...#.#...#.#.#...#.......#  \n" +
                "  #.#####.#.#####.#.#.#####.###.###.#                                                             ###.#.###.###.###.#.###.#####.#####  \n" +
                "  #.......#...........#...#.....#.#.#                                                           RX....#.#.#.#.....#.#.#...#.#...#....JN\n" +
                "  #######.#######.#.#.#.#########.#.#                                                             #.#####.#.#.#####.#.#.#.#.#######.#  \n" +
                "  #...#.......#...#.#.#.....#...#....MP                                                           #.#.#...#...#.........#.#.....#...#  \n" +
                "  #.###################.###.#.#.#.#.#                                                             #.#.###.###.#####.#.#.#####.#####.#  \n" +
                "OF..#...#...#...#.#.#.....#...#.#.#..NZ                                                           #.#.....#...#...#.#.#.#.#.#.#.#.#.#  \n" +
                "  #.###.###.###.#.#.###.#.#####.#.#.#                                                             #.#.#.###.#.###.###.#.#.#.#.#.#.#.#  \n" +
                "QP..#...#...........#...#.#.....#.#.#                                                             #...#.....#.........#.............#  \n" +
                "  #.#.#.###.###.#.#.#####.#.#####.###                                                             #.#.#.#.###.###.###.#.#.#.#.###.#.#  \n" +
                "  #...#.....#...#.#.......#.......#.#                                                             #.#.#.#...#.#.#.#...#.#.#.#.#.#.#.#  \n" +
                "  #.#####.###.#.#.#.#.#.###.#.#.#.#.#      O           U     J   J       Z         H       S      ###.#####.#.#.#####.#.#.#####.#.###  \n" +
                "  #.....#.#...#.#.#.#.#.#...#.#.#...#      F           T     Q   B       J         K       K      #.....#.#.#.#.......#.#...#.......#  \n" +
                "  #.#.###.#.#.#.###.#.#.###.###.#.#########.###########.#####.###.#######.#########.#######.###########.#.#####.#.#.#.#####.###.#####  \n" +
                "  #.#...#.#.#.#...#.#.#.#.....#.#...#.......#...#.#...#.#.....#.........#...#...#.....#.#...#...#...........#...#.#.#.....#.#.......#  \n" +
                "  #.#.###.#.#.#.###.#.###.#####.#.#######.###.#.#.#.#.#.###.#######.#######.#.#.#.#####.###.#.###.#####.#.###.#.#####.#########.#.#.#  \n" +
                "  #.#.#.#.#.#.#...#.#...#...#...#...#...#.....#...#.#...#.#...#.#...#...#...#.#.#...#.#.#.......#...#...#...#.#.#.......#.#.....#.#.#  \n" +
                "  #.#.#.###.###.#.#######.#.###.#######.#######.#.#.#####.#.#.#.#.#####.#.###.#.#.###.#.#.#####.#########.###.###.#.###.#.#.###.#.###  \n" +
                "  #.#.#.#...#...#.#.......#...#.#...#.#.....#...#.#...#.....#...#.#...........#.#.......#...#.#.....#.....#.....#.#.#.....#...#.#.#.#  \n" +
                "  #.#.#.#.#.###.###.###.###.#######.#.#.#.#.#.#.#####.#####.#####.###.###.#.###.###.###.###.#.#######.#.#.#######.#.#####.#####.###.#  \n" +
                "  #.#...#.#.#...#.....#.#...#...........#.#...#.#.#.....#.....#.#...#.#...#.#.#...#...#.#.......#...#.#.#...#.....#...#...#.#.......#  \n" +
                "  #.#.###.#.#######.#.#####.#.###.###.###.#######.#.#.###.#####.#.#####.#.###.#.#######.#.###.#.#.#####.#.#####.###.#.###.#.###.###.#  \n" +
                "  #.#...#.#.....#.#.#.#...#.#.#.#...#.#...#.......#.#...#.......#.....#.#...#...#...#.#.#...#.#.#.....#.#.#.#.....#.#.#.....#.#...#.#  \n" +
                "  #.#.#####.#.###.#.#.###.#.###.#.#######.#.#.###.#####.###.###.###.#########.#.#.###.#.#.#####.#.#####.###.#.###.###.###.#.#.#.###.#  \n" +
                "  #.#.#.....#...#.#.#.#.....#.....#.........#.#.....#.#...#.#...#.......#.#...#...#.....#...#.........#.#.....#.#...#.#...#...#...#.#  \n" +
                "  ###.###.###.###.#######.#.#####.###########.#####.#.#.#######.#.#.###.#.#####.#####.###.###.###.###########.#.###.#####.#####.#.#.#  \n" +
                "  #.#.#.#...#...#.....#...#...#...#...............#.#...#.......#.#...#...#.#.....#.#...#...#.#.#.#.#.#.#.#.......#...#.....#...#.#.#  \n" +
                "  #.#.#.#.###.###.#.###.###.#######.#.#.#.#.###########.#####.#.#.#.#####.#.#.#.###.###.#.#####.###.#.#.#.#####.#########.#.#####.###  \n" +
                "  #.....#.#.#...#.#.....#.......#.#.#.#.#.#.#.......#...#.....#.#.#.#.#...#.#.#.#...#...#.....#.#.#.#.#.....#.....#.......#.#...#...#  \n" +
                "  #.#.###.#.#.#######.#.#.###.###.#######.#######.###.#######.###.###.#####.#.#.#.#.###.#.#####.#.#.#.#.###########.#.#.#.###.###.###  \n" +
                "  #.#...#...#.#.....#.#.#.#...#.#.#.#...........#.#.....#.....#...#...#.....#.#...#.#...#...#.#...#.....#.#.....#.#.#.#.#.......#.#.#  \n" +
                "  #.#####.#.#####.#####.#.#.###.#.#.#####.#.#####.#.###.###.#.###.###.###.#.###.#######.#.###.#.###.###.#.###.###.#.#.###.#####.#.#.#  \n" +
                "  #...#...#...#.........#.#.#.........#...#.#.....#.#.....#.#.#.#.....#.#.#.......#.#...#.......#.#.#.#.#.....#...#.#.#.......#.#...#  \n" +
                "  #.###.#.#.#.###.###.###.#######.###.###.#.#####.###.#.#####.#.#.#.###.###.###.###.###.###.#.###.#.#.###.#####.###.#####.#######.#.#  \n" +
                "  #...#.#.#.#.#.#...#...#...#.#.....#...#.#.....#.....#...#.....#.#.#.#.....#.#.#.#.....#...#...............#.....#.....#...#.#...#.#  \n" +
                "  #.###.#.#.###.#.###.#######.#.#.#####.#.#######.#.###.###.###.#.###.###.#.#.###.###.#####.#.#.###.#########.#####.#.#####.#.#######  \n" +
                "  #.#.#.#.#.#.....#...#.#.#.....#.#.......#.#.#.#.#...#.#.#.#.#.#.#.....#.#.....#...#.....#.#.#...#...#...#...#...#.#...#.....#.....#  \n" +
                "  ###.#.###.#.#.###.###.#.#.#.#.###.#####.#.#.#.#.#######.###.#.#.#.#.#.#######.###.###.#######.#########.###.#.#.#.#######.###.#.###  \n" +
                "  #.#...#.#.#.#...#.#.......#.#.#...#...........#.#...#.........#.#.#.#...#.....#.........#.#.#...#.....#.....#.#.#.#.#.#.#.....#...#  \n" +
                "  #.###.#.#.###.#.#.#.#.###.###.#.#######.#.###.#.#.#####.#####.#.###.#.###.#.#.#.###.#####.#.#.#######.#.###.###.###.#.#.###.#.#.#.#  \n" +
                "  #.....#...#...#.#.#.#.#...#...#.#...#...#.#.#.#.......#.#.....#.#...#...#.#.#.#...#.#.#.#.......#.#.......#.#.#.......#.#...#.#.#.#  \n" +
                "  #.#.#########.###.#.#####.###.#####.###.###.#.#######.#####.###.#.###.#####.###.###.#.#.#.#.#.###.#####.###.#.#.#######.#####.###.#  \n" +
                "  #.#.#...........#.#.#.....#.#.#.....#.#.#.....#.#.#.....#...#...#.#.#.#.#.#.#...#.#.#.#...#.#.....#.#.....#.#.#.............#.#...#  \n" +
                "  #######.###.#.###.#.#.#####.###.###.#.#.###.###.#.#.#######.###.#.#.#.#.#.#.###.#.###.#.###.#######.###.#####.#.###################  \n" +
                "  #...#...#...#...#.#.#...#.#...#.#.....#.#.#.....#.....#.......#...#.......#...#.......#.#.#...........#.#.#.#.#.#...........#.#.#.#  \n" +
                "  ###.#.#####.#####.#.###.#.###.#.###.#.###.###.#.#.###.###.#.#.#.#.#.#########.#######.###.#.#.#########.#.#.#.#.#.#####.#.###.#.#.#  \n" +
                "  #.........#.#.....#.#...#.......#...#.........#.#.#.....#.#.#.#.#.#...#.......#...........#.#.........................#.#.........#  \n" +
                "  #########################################.#######.###########.#######.###.#####.#############.#####################################  \n" +
                "                                           L       R           N       L   T     N             Q                                       \n" +
                "                                           P       X           Z       S   V     U             R                                       ");
        assert result == 7732 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        Map<Point, Character> map = new HashMap<>();
        Map<Point, String> pointsToPortals = new HashMap<>();
        Map<String, List<Point>> portalsToPoints = new HashMap<>();
        Set<Point> externals = new HashSet<>();

        String[] tokens = s.split("\n");
        for (int i = 0; i < tokens.length; ++i) {
            char[] token = tokens[i].toCharArray();
            for (int j = 0; j < token.length; ++j) {
                char ch = token[j];
                if (ch == '.' || ch == '#') {
                    Point point = new Point(j, i);
                    map.put(point, ch);
                } else if ('A' <= ch && ch <= 'Z' && j < token.length - 1 && i < tokens.length - 1) {
                    Point point = new Point(j, i);
                    map.put(point, ch);
                    char next = token[j + 1];
                    if ('A' <= next && next <= 'Z') {
                        String portal = "" + ch + next;
                        point = j == 0 || token[j - 1] == ' ' ? new Point(j + 2, i) : new Point(j - 1, i);
                        pointsToPortals.put(point, portal);
                        portalsToPoints.putIfAbsent(portal, new ArrayList<>());
                        portalsToPoints.get(portal).add(point);
                        if (j == 0 || j == token.length - 2) {
                            externals.add(point);
                        }
                    }
                    next = tokens[i + 1].charAt(j);
                    if ('A' <= next && next <= 'Z') {
                        String portal = "" + ch + next;
                        point = i == 0 || tokens[i - 1].charAt(j) == ' ' ? new Point(j, i + 2) : new Point(j, i - 1);
                        pointsToPortals.put(point, portal);
                        portalsToPoints.putIfAbsent(portal, new ArrayList<>());
                        portalsToPoints.get(portal).add(point);
                        if (i == 0 || i == tokens.length - 2) {
                            externals.add(point);
                        }
                    }
                }
            }
        }

        return bfs(map, new State(portalsToPoints.get("AA").get(0), 0), pointsToPortals, portalsToPoints, externals);
    }

    private static int bfs(Map<Point, Character> map, State initialState,
                           Map<Point, String> pointsToPortals,
                           Map<String, List<Point>> portalsToPoints,
                           Set<Point> externals) {
        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        int count = 0;
        opened.add(initialState);
        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State current : opened) {
                if (current.point.equals(portalsToPoints.get("ZZ").get(0))
                        && current.level == 0) {
                    return count;
                }
                Set<State> set = generateNext(current, map, pointsToPortals, portalsToPoints, externals);
                for (State next : set) {
                    if (!closed.contains(next)) {
                        achievable.add(next);
                    }
                }

                closed.add(current);
            }

            ++count;
            opened = achievable;
        }
        return -1;
    }

    private static Set<State> generateNext(State current, Map<Point, Character> map,
                                           Map<Point, String> pointsToPortals,
                                           Map<String, List<Point>> portalsToPoints,
                                           Set<Point> externals) {
        Set<State> set = new HashSet<>();

        Point nextPoint;

        nextPoint = new Point(current.point);
        ++nextPoint.x;
        putState(map, set, current.level, current.point, nextPoint, pointsToPortals, portalsToPoints, externals);

        nextPoint = new Point(current.point);
        --nextPoint.x;
        putState(map, set, current.level, current.point, nextPoint, pointsToPortals, portalsToPoints, externals);

        nextPoint = new Point(current.point);
        ++nextPoint.y;
        putState(map, set, current.level, current.point, nextPoint, pointsToPortals, portalsToPoints, externals);

        nextPoint = new Point(current.point);
        --nextPoint.y;
        putState(map, set, current.level, current.point, nextPoint, pointsToPortals, portalsToPoints, externals);

        return set;
    }

    private static void putState(Map<Point, Character> map,
                                 Set<State> set,
                                 int currentLevel,
                                 Point currentPoint,
                                 Point nextPoint,
                                 Map<Point, String> pointsToPortals,
                                 Map<String, List<Point>> portalsToPoints,
                                 Set<Point> externals) {
        if (!map.containsKey(nextPoint)) {
            return;
        }
        char charAtPoint = map.get(nextPoint);
        if (charAtPoint == '#') {
            return;
        }
        if (charAtPoint == '.') {
            set.add(new State(nextPoint, currentLevel));
        } else if ('A' <= charAtPoint && charAtPoint <= 'Z') {
            String portal = pointsToPortals.get(currentPoint);
            List<Point> nextPoints = portalsToPoints.get(portal);
            for (Point p : nextPoints) {
                if (!p.equals(currentPoint)) {
                    currentLevel = !externals.contains(currentPoint) && externals.contains(p) ? currentLevel + 1 : currentLevel - 1;
                    if (currentLevel >= 0) {
                        set.add(new State(p, currentLevel));
                    }
                }
            }
        }
    }

    private static class State {

        Point point;
        int level;

        State(Point point, int level) {
            this.point = point;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(point, state.point) && level == state.level;
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, level);
        }
    }
}
