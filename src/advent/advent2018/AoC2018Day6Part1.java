package advent.advent2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                "8, 9", 1);
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
                "264, 67", 0);
        assert result == 4233 : "unexpected result is " + result;
        System.out.println(result);

        result = test("260, 78\n" +
                "42, 40\n" +
                "87, 276\n" +
                "219, 124\n" +
                "166, 137\n" +
                "341, 138\n" +
                "82, 121\n" +
                "114, 174\n" +
                "218, 289\n" +
                "61, 358\n" +
                "328, 164\n" +
                "279, 50\n" +
                "218, 107\n" +
                "273, 320\n" +
                "192, 349\n" +
                "354, 103\n" +
                "214, 175\n" +
                "128, 196\n" +
                "237, 67\n" +
                "333, 150\n" +
                "98, 260\n" +
                "166, 217\n" +
                "92, 212\n" +
                "55, 165\n" +
                "205, 138\n" +
                "321, 199\n" +
                "285, 148\n" +
                "217, 130\n" +
                "357, 319\n" +
                "160, 67\n" +
                "63, 75\n" +
                "345, 123\n" +
                "316, 220\n" +
                "41, 253\n" +
                "240, 245\n" +
                "201, 124\n" +
                "336, 166\n" +
                "95, 301\n" +
                "55, 181\n" +
                "219, 315\n" +
                "209, 237\n" +
                "317, 254\n" +
                "314, 300\n" +
                "242, 295\n" +
                "295, 293\n" +
                "285, 263\n" +
                "330, 204\n" +
                "112, 106\n" +
                "348, 49\n" +
                "81, 185", 0);
        assert result == 4771 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s, int delta) {
        Pattern pattern = Pattern.compile("(\\d+), (\\d+)");
        String[] parts = s.split("\n");
        List<Point> points = new ArrayList<>();
        Map<Character, Point> pointsMap = new HashMap<>();
        int maxX = 0, maxY = 0;
        char name = 'a';
        for (String part : parts) {
            Matcher matcher = pattern.matcher(part);
            assert matcher.matches() : "not matches " + part;
            Point point = new Point();
            point.x = Integer.parseInt(matcher.group(1));
            point.y = Integer.parseInt(matcher.group(2));
            point.name = name;
            points.add(point);
            pointsMap.put(name, point);
            if (point.x > maxX) {
                maxX = point.x;
            }
            if (point.y > maxY) {
                maxY = point.y;
            }
            ++name;
            if (name > 'z') {
                name = 'A';
            }
        }

        System.out.println("last name is " + (char) (name - 1));

        ++maxX;
        ++maxY;

        maxX += delta;
        maxY += delta;

        Point[][] table = new Point[maxY][maxX];

        for (int i = 0; i < maxY; ++i) {
            for (int j = 0; j < maxX; ++j) {
                Point point = new Point();
                point.x = j;
                point.y = i;
                table[i][j] = point;
            }
        }

        printTable(table);

        for (Point point : points) {
            table[point.y][point.x] = point;
        }

        printTable(table);

        for (int i = 0; i < maxY; ++i) {
            for (int j = 0; j < maxX; ++j) {
                if (table[i][j].name == '0') {

                    int[] d = new int[points.size()];
                    int k = 0;
                    int min = Integer.MAX_VALUE;
                    Point closestPoint = null;
                    for (Point point : points) {
                        d[k] = Math.abs(point.x - j) + Math.abs(point.y - i);
                        if (d[k] < min) {
                            min = d[k];
                            closestPoint = point;
                        }
                        ++k;
                    }
                    int minCount = 0;
                    for (k = 0; k < d.length; ++k) {
                        if (d[k] == min) {
                            ++minCount;
                        }
                    }
                    boolean equallyDistanced = minCount > 1;
                    table[i][j].name = equallyDistanced ? '.' : closestPoint.name;
                }
            }
        }

        printTable(table);

        for (int i = 0; i < maxY; ++i) {
            name = table[i][maxX - 1].name;
            Point point = pointsMap.get(name);
            if (point != null) point.infinite = true;

            name = table[i][0].name;
            point = pointsMap.get(name);
            if (point != null) point.infinite = true;
        }
        for (int j = 0; j < maxX; ++j) {
            name = table[maxY - 1][j].name;
            Point point = pointsMap.get(name);
            if (point != null) point.infinite = true;

            name = table[0][j].name;
            point = pointsMap.get(name);
            if (point != null) point.infinite = true;
        }

        System.out.println();
        for (Point point : points) {
            if (point.infinite) {
                System.out.println("point " + point.name + " is infinite");
            }
        }

        System.out.println();
        Point biggestPoint = null;
        int maxArea = 0;
        for (Point point : points) {
            name = point.name;
            int area = 0;
            for (int i = 0; i < maxY; ++i) {
                for (int j = 0; j < maxX; ++j) {
                    if (table[i][j].name == name) {
                        ++area;
                    }
                }
            }
            System.out.println("area of " + point + " is " + area + (point.infinite ? " infinite" : ""));
            if (area > maxArea && !point.infinite) {
                maxArea = area;
                biggestPoint = point;
            }
        }

        System.out.println("biggest point is " + biggestPoint + ", its area is " + maxArea);

        return maxArea;
    }

    private static void printTable(Point[][] table) {
        System.out.println();
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[i].length; ++j) {
                System.out.print(table[i][j].name);
            }
            System.out.println();
        }
    }

    private static class Point {
        char name = '0';
        int x, y;
        boolean infinite;

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
            return name + " (" + x + ", " + y + ")";
        }
    }
}
