package advent.advent2017;

import java.util.HashMap;
import java.util.Map;

public class AoC2017Day22Part1 {
    public static void main(String[] args) {
        int result;

        result = test(7, "..#\n" +
                "#..\n" +
                "...");
        System.out.println(result);
        assert result == 5 : "unexpected result is " + result;

        result = test(70, "..#\n" +
                "#..\n" +
                "...");
        System.out.println(result);
        assert result == 41 : "unexpected result is " + result;

        result = test(10000, "..#\n" +
                "#..\n" +
                "...");
        System.out.println(result);
        assert result == 5587 : "unexpected result is " + result;

        result = test(10000, "...##.#.#.####...###.....\n" +
                "..#..##.#...#.##.##.#..#.\n" +
                ".#.#.#.###....#...###....\n" +
                ".#....#..####.....##.#..#\n" +
                "##.#.#.#.#..#..#.....###.\n" +
                "#...##....##.##.#.##.##..\n" +
                ".....###..###.###...#####\n" +
                "######.####..#.#......##.\n" +
                "#..###.####..####........\n" +
                "#..######.##....####...##\n" +
                "...#.##.#...#.#.#.#..##.#\n" +
                "####.###..#####.....####.\n" +
                "#.#.#....#.####...####...\n" +
                "##...#..##.##....#...#...\n" +
                "......##..##..#..#..####.\n" +
                ".##..##.##..####..##....#\n" +
                ".#..#..##.#..##..#...#...\n" +
                "#.#.##.....##..##.#####..\n" +
                "##.#.......#....#..###.#.\n" +
                "##...#...#....###..#.#.#.\n" +
                "#....##...#.#.#.##..#..##\n" +
                "#..#....#####.....#.##.#.\n" +
                ".#...#..#..###....###..#.\n" +
                "..##.###.#.#.....###.....\n" +
                "#.#.#.#.#.##.##...##.##.#");
        assert result == 5261 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int iterations, String s) {
        Map<String, Boolean> map = new HashMap<>();
        String[] rows = s.split("\n");
        for (int i = 0; i < rows.length; ++i) {
            for (int j = 0; j < rows[i].length(); ++j) {
                put(map, i, j, rows[i].charAt(j) == '#');
            }
        }
        int x = rows.length / 2;
        int y = rows[0].length() / 2;
        int count = 0;
        boolean up = true, down = false, left = false, right = false;
        for (int i = 0; i < iterations; ++i) {
            if (get(map, x, y)) {
                // infected
                put(map, x, y, false);
                if (up) {
                    right = true;
                    up = false;
                } else if (down) {
                    left = true;
                    down = false;
                } else if (left) {
                    up = true;
                    left = false;
                } else if (right) {
                    down = true;
                    right = false;
                }
            } else {
                put(map, x, y, true);
                ++count;
                if (up) {
                    left = true;
                    up = false;
                } else if (down) {
                    right = true;
                    down = false;
                } else if (left) {
                    down = true;
                    left = false;
                } else if (right) {
                    up = true;
                    right = false;
                }
            }
            if (up) {
                --x;
            } else if (down) {
                ++x;
            } else if (left) {
                --y;
            } else if (right) {
                ++y;
            }
        }
        return count;
    }

    private static String key(int i, int j) {
        return i + "," + j;
    }

    private static void put(Map<String, Boolean> map, int i, int j, boolean value) {
        String key = key(i, j);
        map.put(key, value);
    }

    private static boolean get(Map<String, Boolean> map, int i, int j) {
        String key = key(i, j);
        if (!map.containsKey(key)) {
            map.put(key, false);
        }
        return map.get(key);
    }
}
