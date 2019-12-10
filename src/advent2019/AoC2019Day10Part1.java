package advent2019;

import utils.Point;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AoC2019Day10Part1 {

    public static void main(String[] args) {
        test(new Point(5, 8), 33, "......#.#.\n" +
                "#..#.#....\n" +
                "..#######.\n" +
                ".#.#.###..\n" +
                ".#..#.....\n" +
                "..#....#.#\n" +
                "#..#....#.\n" +
                ".##.#..###\n" +
                "##...#..#.\n" +
                ".#....####");

        test(new Point(1, 2), 35, "#.#...#.#.\n" +
                ".###....#.\n" +
                ".#....#...\n" +
                "##.#.#.#.#\n" +
                "....#.#.#.\n" +
                ".##..###.#\n" +
                "..#...##..\n" +
                "..##....##\n" +
                "......#...\n" +
                ".####.###.");

        test(new Point(6, 3), 41, ".#..#..###\n" +
                "####.###.#\n" +
                "....###.#.\n" +
                "..###.##.#\n" +
                "##.##.#.#.\n" +
                "....###..#\n" +
                "..#.#..#.#\n" +
                "#..#.#.###\n" +
                ".##...##.#\n" +
                ".....#.#..");

        test(new Point(11, 13), 210, ".#..##.###...#######\n" +
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

        test(new Point(20, 19), 284, "##.#..#..###.####...######\n" +
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

    private static void test(Point expectedPoint, int expectedMax, String s) {
        String[] tokens = s.split("\n");
        int height = tokens.length;
        assert height > 0 : "invalid input";
        char[][] chars = new char[height][];
        int width = tokens[0].length();
        for (int i = 0; i < height; ++i) {
            chars[i] = tokens[i].toCharArray();
            assert chars[i].length == width : "invalid input";
        }

        Map<Point, Integer> map = fillDetected(width, height, chars);

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
        System.out.println("result is " + max + "; expected " + expectedMax);
        assert Objects.equals(reverted, expectedPoint) : "expected " + expectedPoint + ", but was: " + reverted;
        assert max == expectedMax : "expected " + expectedMax + ", but was: " + max;
    }

    private static Map<Point, Integer> fillDetected(int w, int h, char[][] chars) {
        Map<Point, Integer> map = new HashMap<>();
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                if (chars[i][j] == '#') {
                    Point point = new Point(i, j);
                    int detected = detected(w, h, chars, point);
                    map.put(point, detected);
                }
            }
        }
        return map;
    }

    private static int detected(int w, int h, char[][] chars, Point p) {
        double[][] angles = new double[h][];
        Map<Ray, Integer> map = new HashMap<>();
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
                Ray ray = new Ray();
                ray.angle = (p.x - point.x) / (double) (p.y - point.y);
                ray.xSign = p.x == point.x ? 1 : (p.x - point.x) / Math.abs(p.x - point.x);
                ray.ySign = p.y == point.y ? 1 : (p.y - point.y) / Math.abs(p.y - point.y);
                map.putIfAbsent(ray, 0);
                map.put(ray, map.get(ray) + 1);
                angles[i][j] = ray.angle;
            }
        }

        if (false) {
            System.out.println(p);
            for (int i = 0; i < h; ++i) {
                for (int j = 0; j < w; ++j) {
                    System.out.print(String.format("%9.5f", angles[i][j]));
                }
                System.out.println();
            }
            System.out.println();
        }

        return map.size();
    }

    private static class Ray {

        double angle;
        int xSign, ySign;

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Ray other = (Ray) obj;
            return xSign == other.xSign && ySign == other.ySign && Double.compare(angle, other.angle) == 0;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + xSign;
            hash = 31 * hash + ySign;
            hash = 31 * hash + Double.hashCode(angle);
            return hash;
        }
    }
}
