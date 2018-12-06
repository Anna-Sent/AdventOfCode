package advent2018;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2018Day6Part1 {
    public static void main(String[] args) {
        int result;

        result = test("1, 1\n" +
                "1, 6\n" +
                "8, 3\n" +
                "3, 4\n" +
                "5, 5\n" +
                "8, 9");
        assert result == 17 : "unexpected result is " + result;
        System.out.println(result);

        result = test("181, 47\n" +
                "337, 53\n" +
                "331, 40\n" +
                "137, 57\n" +
                "200, 96\n" +
                "351, 180\n" +
                "157, 332\n" +
                "113, 101\n" +
                "285, 55\n" +
                "189, 188\n" +
                "174, 254\n" +
                "339, 81\n" +
                "143, 61\n" +
                "131, 155\n" +
                "239, 334\n" +
                "357, 291\n" +
                "290, 89\n" +
                "164, 149\n" +
                "248, 73\n" +
                "311, 190\n" +
                "54, 217\n" +
                "285, 268\n" +
                "354, 113\n" +
                "318, 191\n" +
                "182, 230\n" +
                "156, 252\n" +
                "114, 232\n" +
                "159, 299\n" +
                "324, 280\n" +
                "152, 155\n" +
                "295, 293\n" +
                "194, 214\n" +
                "252, 345\n" +
                "233, 172\n" +
                "272, 311\n" +
                "230, 82\n" +
                "62, 160\n" +
                "275, 96\n" +
                "335, 215\n" +
                "185, 347\n" +
                "134, 272\n" +
                "58, 113\n" +
                "112, 155\n" +
                "220, 83\n" +
                "153, 244\n" +
                "279, 149\n" +
                "302, 167\n" +
                "185, 158\n" +
                "72, 91\n" +
                "264, 67");
        // assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test(String s) {
        Pattern pattern = Pattern.compile("(\\d+), (\\d+)");
        String[] parts = s.split("\n");
        List<Point> points = new ArrayList<>();
        int maxX = 0, maxY = 0;
        char name = 'a';
        for (String part : parts) {
            Matcher matcher = pattern.matcher(part);
            assert matcher.matches() : "not matches " + part;
            Point point = new Point();
            point.x = Integer.parseInt(matcher.group(1));
            point.y = Integer.parseInt(matcher.group(2));
            point.name = name;
            ++name;
            points.add(point);
            if (point.x > maxX) {
                maxX = point.x;
            }
            if (point.y > maxY) {
                maxY = point.y;
            }
        }
        ++maxX;
        ++maxY;

        Point[][] table = new Point[maxX][maxY];

        for (int i = 0; i < maxX; ++i) {
            for (int j = 0; j < maxY; ++j) {
                Point point = new Point();
                point.x = i;
                point.y = j;
                table[i][j] = point;
            }
        }

        for (Point point : points) {
            table[point.x][point.y] = point;
        }

        for (int i = 0; i < maxX; ++i) {
            for (int j = 0; j < maxY; ++j) {
                if (table[i][j].name == 0) {
                    Point closestPoint = null;
                    int minD = Integer.MAX_VALUE;
                    for (Point point : points) {
                        int d = Math.abs(point.x - i) + Math.abs(point.y - j);
                        if (d < minD) {
                            closestPoint = point;
                            minD = d;
                        }
                    }
                    if (closestPoint == null) {
                        System.out.println("F");
                    }
                    assert closestPoint != null : "closest point is null";
                    table[i][j].name = closestPoint.name;
                }
            }
        }

        Point biggestPoint = null;
        int maxArea = 0;
        for (Point point : points) {
            name = point.name;
            int area = 0;
            for (int i = 0; i < maxX; ++i) {
                for (int j = 0; j < maxY; ++j) {
                    if (table[i][j].name == name) {
                        ++area;
                    }
                }
            }
            if (area > maxArea) {
                maxArea = area;
                biggestPoint = point;
            }
        }

        System.out.println("biggest point is " + biggestPoint);

        return maxArea;
    }

    private static class Point {
        char name;
        int x, y;

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Point other = (Point) obj;
            return x == other.x && y == other.y && name == other.name;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + x;
            hash = 31 * hash + y;
            hash = 31 * hash + name;
            return hash;
        }

        @Override
        public String toString() {
            return x + ", " + y + " -> " + name;
        }
    }
}
