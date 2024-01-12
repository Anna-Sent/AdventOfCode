package advent.advent2018;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AoC2018Day18Part1 {
    public static void main(String[] args) {
        int result;

        result = test(".#.#...|#.\n" +
                ".....#|##|\n" +
                ".|..|...#.\n" +
                "..|#.....#\n" +
                "#.#|||#|#|\n" +
                "...#.||...\n" +
                ".|....|...\n" +
                "||...#|.#|\n" +
                "|.||||..|.\n" +
                "...#.|..|.", 10);
        assert result == 1147 : "unexpected result is " + result;
        System.out.println(result);

        result = test("|.....#.....||...#.|###..#..|#...........|...|..|#\n" +
                "||..|.......|.|.|..|.|....#.|#..|..|.|#.....|.|..|\n" +
                ".#........#.|#.|.#.#.|..|...|#........||.#|....|##\n" +
                "....#.#.|.##..|..#.......|##.......|#.#.|..#.##...\n" +
                "..#|...|.|.........||..|........#...##...|.#..||..\n" +
                "....#.....|.#|...#....#.##..#....|#|.|.||.||#|.##.\n" +
                ".#.|..#..####.#|...#.####.|..........|.....|.#|.#|\n" +
                "|||.#|...#|.|..#.#........#....|..##|||.....#.#.#.\n" +
                "#.#....|..#.|##..|..#.#|..|.|.|..|.|#..|...|..|.#.\n" +
                "||.##.|..||.#..#.|.....|.#|.|#....##....|#...#.|#|\n" +
                "#|.|.###.|...|...#.....#||...|.####..#|....#|...#.\n" +
                ".|..#||..#....###|.|..#..#..#..#|#|#.....|...|....\n" +
                "|||#.|.|........|..|#.|..##.#.#..||#..#...#.#.#.|.\n" +
                "|..|..||.#.|##.|#|||..|.#........#..#|.|..#.|..#.|\n" +
                ".#|.#.|.|.#.|.##.....||#....|...#.||||.|......|.#.\n" +
                "..#|.....#..#|.||.|.#|.#..|.........|.#.|..#.|...#\n" +
                "|#....|#.|..#.....#.|||.||......#.........##|.#||#\n" +
                "##.##....|..#.|.||#.|..|...#.##......|...|.#|..#..\n" +
                "....|##......#|##.#|||.|.#.....|.|...|#..|.##.|...\n" +
                ".......##..#|###||....#...||#...#.#...|......#.##.\n" +
                "#|...#..#.|||#..#.......|..|..|.|.|..|.#|#..||....\n" +
                ".#.|.#.......|.....#|.||...|..##|...###.||......##\n" +
                "##..#..|.||.#...#.....#.......|....#..##.#...#..|.\n" +
                "|.#.||...|#.##|#.#.#.||....|##...|#.|.|..##.|..##.\n" +
                "|||....#|#.|##....#.|.....||......|###...#.|.|.#..\n" +
                ".|..#|#......##.|...........||.||.|#.#..#.......#.\n" +
                "#|.....##|#..#...|..#.|.......|#||.#|#.###.....|..\n" +
                "....|.#.|#..|.||.|.#.||#.#.||...|......||.#.....#.\n" +
                "##|.#.|...||.|..#..#|#..#|...#|...#....||##...#...\n" +
                ".|.|#|.#..##|#...#|..#|.....|......#|.............\n" +
                ".|.##....#.##....#.....|.|...##.....#.#||.#.||.|..\n" +
                ".#|#......#..#.|..#..|#.|###........#...#....#||||\n" +
                "|..........#|.|..#|.##..#.|#.|.||.#....||#...#|||.\n" +
                ".#...##.........#.........#.#..#.|##..#.|#.#.#...|\n" +
                "|#...|........|#.....#.||...|.#...#|..|....|##|||.\n" +
                ".|#.|....##.|##.|.|.........|..##.||.#.#...#.#.#|.\n" +
                ".|#..||#.#|#....##......|...|..#...#..|........||#\n" +
                "....||.....#.#..#.|.|#|..|..||..#.|.|.|#...#|..||.\n" +
                "|...||#....|.#.#..#.##...#...#.##|...#|||#|...#...\n" +
                "....#.||...###...|#...|.|####|.|......|.#|..#.#..#\n" +
                "|...|#.#.#.|.##..##........|..|.#.....|#.|.#.||.##\n" +
                "...|..#...|||.#.....|..##..|.#..|......|...||##.#.\n" +
                "||##.|||#.|...#|..||.#.###.#|#...##|#.|.|#..|...||\n" +
                ".|..|..|..|.......|...##.#..##.|.#|...#.|....##|..\n" +
                "#..##|.#.#.##.#|#|...|###..#|..|...#....#.#|..#|.|\n" +
                ".|.##..|...|...#..|...#|......#|.##......#|##.####\n" +
                "........|..||.......||.....#.###|.#...#.#.....|...\n" +
                "|.|.||#|..|..#.....|.#..#..|..|..#|.|.##..|.|..|#.\n" +
                "|.|#........|.#.#..|.|.#|...##.#...|.#|.#..|...#.|\n" +
                "|#.....#...###...##....#|.|#..|.....||......|.#...", 50);
        assert result == 598416 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s, int size) {
        char[][] map = new char[size][size];
        String[] tokens = s.split("\n");
        for (int i = 0; i < size; ++i) {
            map[i] = tokens[i].toCharArray();
        }
        for (int time = 0; time < 10; ++time) {
            char[][] newMap = new char[size][size];
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < newMap[i].length; ++j) {
                    newMap[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < size; ++i) {
                for (int j = 0; j < newMap[i].length; ++j) {
                    switch (map[i][j]) {
                        case '.':
                            if (hasThreeOrMoreAdjacentTrees(map, i, j, size)) {
                                newMap[i][j] = '|';
                            }
                            break;
                        case '|':
                            if (hasThreeOrMoreAdjacentLumberyard(map, i, j, size)) {
                                newMap[i][j] = '#';
                            }
                            break;
                        case '#':
                            if (adjacentToAtLeastOneLumberyardAndAtLeastOneTree(map, i, j, size)) {
                                newMap[i][j] = '#';
                            } else {
                                newMap[i][j] = '.';
                            }
                            break;
                        default:
                            assert false : "unexpected char '" + map[i][j] + "'";
                    }
                }
            }
            map = newMap;
        }
        int wood = 0, lumber = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                switch (map[i][j]) {
                    case '.':
                        break;
                    case '|':
                        ++wood;
                        break;
                    case '#':
                        ++lumber;
                        break;
                    default:
                        assert false : "unexpected char '" + map[i][j] + "'";
                }
            }
        }
        return wood * lumber;
    }

    private static boolean hasThreeOrMoreAdjacentTrees(char[][] map, int i, int j, int size) {
        Map<Character, Integer> result = adjacent(map, i, j, size);
        return result.get('|') >= 3;
    }

    private static boolean hasThreeOrMoreAdjacentLumberyard(char[][] map, int i, int j, int size) {
        Map<Character, Integer> result = adjacent(map, i, j, size);
        return result.get('#') >= 3;
    }

    private static boolean adjacentToAtLeastOneLumberyardAndAtLeastOneTree(char[][] map, int i, int j, int size) {
        Map<Character, Integer> result = adjacent(map, i, j, size);
        return result.get('#') >= 1 && result.get('|') >= 1;
    }

    private static Map<Character, Integer> adjacent(char[][] map, int i, int j, int size) {
        Map<Character, Integer> result = new HashMap<>();
        result.put('|', 0);
        result.put('.', 0);
        result.put('#', 0);
        BiFunction<Character, Integer, Integer> func = (key, val) -> val + 1;
        if (i < size - 1) result.compute(map[i + 1][j], func);
        if (i < size - 1 && j < size - 1) result.compute(map[i + 1][j + 1], func);
        if (i < size - 1 && j > 0) result.compute(map[i + 1][j - 1], func);
        if (j < size - 1) result.compute(map[i][j + 1], func);
        if (j > 0) result.compute(map[i][j - 1], func);
        if (i > 0) result.compute(map[i - 1][j], func);
        if (i > 0 && j < size - 1) result.compute(map[i - 1][j + 1], func);
        if (i > 0 && j > 0) result.compute(map[i - 1][j - 1], func);
        return result;
    }
}
