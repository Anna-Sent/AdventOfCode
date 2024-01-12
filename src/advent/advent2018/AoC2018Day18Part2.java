package advent.advent2018;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AoC2018Day18Part2 {
    public static void main(String[] args) {
        int result;

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
        assert result == 196310 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s, int size) {
        char[][] map = new char[size][size];
        String[] tokens = s.split("\n");
        for (int i = 0; i < size; ++i) {
            map[i] = tokens[i].toCharArray();
        }

        // find period
        int period = 0;
        int count = 0;
        int delta = 0;
        Map<Integer, Integer> results = new HashMap<>();
        for (int time = 0; time < 1000000000; ++time) {
            char[][] newMap = process(map, size);
            int result = result(map, size);
            System.out.println(time + " " + result);
            if (results.get(result) != null) {
                period = time - results.get(result);
                System.out.println("period is " + period);
                if (count++ > 10) {
                    delta = time;
                    break;
                }
            }
            results.put(result, time);
            map = newMap;
        }

        // calculate
        for (int i = 0; i < size; ++i) {
            map[i] = tokens[i].toCharArray();
        }
        int lastResult = 0;
        for (int time = 0; time < delta + (1000000000 - delta) % period; ++time) {
            char[][] newMap = process(map, size);
            lastResult = result(newMap, size);
            map = newMap;
        }
        return lastResult;
    }

    private static char[][] process(char[][] map, int size) {
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
        return newMap;
    }

    private static int result(char[][] map, int size) {
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
