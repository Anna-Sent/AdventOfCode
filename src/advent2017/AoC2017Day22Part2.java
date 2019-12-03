package advent2017;

import java.util.HashMap;
import java.util.Map;

public class AoC2017Day22Part2 {
    public static void main(String[] args) {
        int result;

        result = test(100, "..#\n" +
                "#..\n" +
                "...");
        System.out.println(result);
        assert result == 26 : "unexpected result is " + result;

        result = test(10000000, "..#\n" +
                "#..\n" +
                "...");
        System.out.println(result);
        assert result == 2511944 : "unexpected result is " + result;

        result = test(10000000, "...##.#.#.####...###.....\n" +
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
        assert result == 2511927 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int iterations, String s) {
        Map<String, NodeType> map = new HashMap<>();
        String[] rows = s.split("\n");
        for (int i = 0; i < rows.length; ++i) {
            for (int j = 0; j < rows[i].length(); ++j) {
                put(map, i, j, rows[i].charAt(j) == '#' ? NodeType.infected : NodeType.clean);
            }
        }
        int x = rows.length / 2;
        int y = rows[0].length() / 2;
        int count = 0;
        boolean up = true, down = false, left = false, right = false;
        for (int i = 0; i < iterations; ++i) {
            NodeType nodeType = get(map, x, y);
            switch (nodeType) {
                case clean:
                    put(map, x, y, NodeType.weakened);
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
                    break;
                case weakened:
                    put(map, x, y, NodeType.infected);
                    ++count;
                    break;
                case infected:
                    put(map, x, y, NodeType.flagged);
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
                    break;
                case flagged:
                    put(map, x, y, NodeType.clean);
                    if (up) {
                        down = true;
                        up = false;
                    } else if (down) {
                        up = true;
                        down = false;
                    } else if (left) {
                        right = true;
                        left = false;
                    } else if (right) {
                        left = true;
                        right = false;
                    }
                    break;
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

    private static void put(Map<String, NodeType> map, int i, int j, NodeType value) {
        String key = key(i, j);
        map.put(key, value);
    }

    private static NodeType get(Map<String, NodeType> map, int i, int j) {
        String key = key(i, j);
        if (!map.containsKey(key)) {
            map.put(key, NodeType.clean);
        }
        return map.get(key);
    }

    private enum NodeType {clean, weakened, infected, flagged}
}
