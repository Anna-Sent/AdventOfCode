package advent2019;

import utils.Point;

import java.util.*;

public class AoC2019Day10Part2 {

    public static void main(String[] args) {
        test(new Point(11, 13), 802, ".#..##.###...#######\n" +
                "##.############..##.\n" +
                ".#.######.########.#\n" +
                ".###.#######.####.#.\n" +
                "#####.##.#.##.###.##\n" +
                "..#####..#.#########\n" +
                "####################\n" +
                "#.####....###.#.#.##\n" +
                "##.#################\n" +
                "#####.##.###..####..\n" +
                "..######..##.#######\n" +
                "####.##.####...##..#\n" +
                ".#####..#.######.###\n" +
                "##...#.##########...\n" +
                "#.##########.#######\n" +
                ".####.#.###.###.#.##\n" +
                "....##.##.###..#####\n" +
                ".#.#.###########.###\n" +
                "#.#.#.#####.####.###\n" +
                "###.##.####.##.#..##");

        test(new Point(20, 19), 404, "##.#..#..###.####...######\n" +
                "#..#####...###.###..#.###.\n" +
                "..#.#####....####.#.#...##\n" +
                ".##..#.#....##..##.#.#....\n" +
                "#.####...#.###..#.##.#..#.\n" +
                "..#..#.#######.####...#.##\n" +
                "#...####.#...#.#####..#.#.\n" +
                ".#..#.##.#....########..##\n" +
                "......##.####.#.##....####\n" +
                ".##.#....#####.####.#.####\n" +
                "..#.#.#.#....#....##.#....\n" +
                "....#######..#.##.#.##.###\n" +
                "###.#######.#..#########..\n" +
                "###.#.#..#....#..#.##..##.\n" +
                "#####.#..#.#..###.#.##.###\n" +
                ".#####.#####....#..###...#\n" +
                "##.#.......###.##.#.##....\n" +
                "...#.#.#.###.#.#..##..####\n" +
                "#....#####.##.###...####.#\n" +
                "#.##.#.######.##..#####.##\n" +
                "#.###.##..##.##.#.###..###\n" +
                "#.####..######...#...#####\n" +
                "#..#..########.#.#...#..##\n" +
                ".##..#.####....#..#..#....\n" +
                ".###.##..#####...###.#.#.#\n" +
                ".##..######...###..#####.#");
    }

    private static void test(Point expectedPoint, int expected, String s) {
        String[] tokens = s.split("\n");
        int height = tokens.length;
        assert height > 0 : "invalid input";
        char[][] chars = new char[height][];
        int width = tokens[0].length();
        for (int i = 0; i < height; ++i) {
            chars[i] = tokens[i].toCharArray();
            assert chars[i].length == width : "invalid input";
        }

        Point best = findBest(expectedPoint, width, height, chars);
        List<Point> route = findRoute(width, height, chars, best);
        Point point = route.get(199).revert();
        int result = point.x * 100 + point.y;
        System.out.println("result is " + result + "; expected " + expected);
        assert result == expected : "expected " + expected + ", but was: " + result;
    }

    private static Point findBest(Point expectedPoint, int w, int h, char[][] chars) {
        Map<Point, Integer> map = fillDetected(w, h, chars, expectedPoint.revert());

        int max = -1;
        Point best = null;
        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                best = entry.getKey();
            }
        }

        assert best != null : "best is null";
        Point reverted = best.revert();
        System.out.println("result is " + reverted + "; expected " + expectedPoint);
        assert Objects.equals(reverted, expectedPoint) : "expected " + expectedPoint + ", but was: " + reverted;
        return best;
    }

    private static Map<Point, Integer> fillDetected(int w, int h, char[][] chars, Point expectedPoint) {
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (chars[i][j] == '#') {
                    Point point = new Point(i, j);
                    int detected = detected(w, h, chars, point, expectedPoint);
                    map.put(point, detected);
                }
            }
        }
        return map;
    }

    private static int detected(int w, int h, char[][] chars, Point p, Point expectedPoint) {
        double[][] angles = new double[h][];
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < h; ++i) {
            angles[i] = new double[w];
            for (int j = 0; j < w; ++j) {
                Point point = new Point(i, j);
                if (p.equals(point)) {
                    angles[i][j] = -1;
                    continue;
                }
                if (chars[i][j] == '.') {
                    angles[i][j] = -2;
                    continue;
                }
                double angle = Math.atan2(-p.y + point.y, -p.x + point.x);
                map.putIfAbsent(angle, 0);
                map.put(angle, map.get(angle) + 1);
                angles[i][j] = angle;
            }
        }
        if (p.equals(expectedPoint)) {
            System.out.println(p);
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    double angle = angles[i][j];
                    if (angle == -1) {
                        System.out.print("  xxxxxxx");
                    } else if (angle == -2) {
                        System.out.print("        .");
                    } else {
                        System.out.print(String.format("%9.5f", angle));
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        return map.size();
    }

    private static List<Point> findRoute(int w, int h, char[][] chars, Point best) {
        double[][] angles = new double[h][];
        Map<Double, List<Point>> map = new TreeMap<>((o1, o2) -> -Double.compare(o1, o2));
        for (int i = 0; i < h; ++i) {
            angles[i] = new double[w];
            for (int j = 0; j < w; ++j) {
                Point point = new Point(i, j);
                if (best.equals(point)) {
                    angles[i][j] = -1;
                    continue;
                }
                if (chars[i][j] == '.') {
                    angles[i][j] = -2;
                    continue;
                }
                double angle = Math.atan2(-best.y + point.y, -best.x + point.x);
                map.putIfAbsent(angle, new ArrayList<>());
                map.get(angle).add(point);
                map.get(angle).sort((p1, p2) -> Double.compare(p1.distance(best), p2.distance(best)));
                angles[i][j] = angle;
            }
        }
        List<Point> route = new ArrayList<>();
        boolean empty = false;
        while (!empty) {
            empty = true;
            for (List<Point> value : map.values()) {
                if (value.isEmpty()) {
                    continue;
                }
                route.add(value.remove(0));
                empty = false;
            }
        }
        return route;
    }
}
