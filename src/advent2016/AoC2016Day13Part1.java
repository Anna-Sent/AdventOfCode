package advent2016;

import java.util.HashSet;
import java.util.Set;

public class AoC2016Day13Part1 {
    public static void main(String[] args) {
        int result;

        assert countOfOne(0) == 0;
        assert countOfOne(1) == 1;
        assert countOfOne(2) == 1;
        assert countOfOne(3) == 2;
        assert countOfOne(4) == 1;
        assert countOfOne(5) == 2;
        assert countOfOne(255) == 8;
        assert countOfOne(256) == 1;
        assert countOfOne(65535) == 16;

        result = test(10, 1, 1, 7, 4);
        assert result == 11;
        System.out.println(result);

        result = test(1352, 1, 1, 31, 39);
        assert result == 90;
        System.out.println(result);
    }

    private static int test(int favoriteNumber, int startX, int startY,
                            int endX, int endY) {
        if (isWall(favoriteNumber, startX, startY)) {
            throw new RuntimeException("invalid state");
        }

        Set<Point> closed = new HashSet<>();
        Set<Point> opened = new HashSet<>();

        int count = 0;
        opened.add(new Point(startX, startY));

        while (opened.size() > 0) {
            Set<Point> achievable = new HashSet<>();
            for (Point currentPoint : opened) {
                if (currentPoint.x == endX && currentPoint.y == endY) {
                    Point point = currentPoint;
                    do {
                        System.out.print(point.x + "," + point.y + " <- ");
                        point = point.previousPoint;
                    } while (point != null);
                    System.out.println();
                    return count;
                }

                Set<Point> set = currentPoint.generateNext(favoriteNumber);
                for (Point nextPoint : set) {
                    if (!closed.contains(nextPoint)) {
                        achievable.add(nextPoint);
                    }
                }

                closed.add(currentPoint);
            }

            ++count;
            opened = achievable;
        }

        return -1;
    }

    private static boolean isWall(int favoriteNumber, int x, int y) {
        int number = x * x + 3 * x + 2 * x * y + y + y * y + favoriteNumber;
        int countOfOne = countOfOne(number);
        return countOfOne % 2 != 0;
    }

    private static int countOfOne(int number) {
        int countOfOne = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                ++countOfOne;
            }
            number = number >> 1;
        }
        return countOfOne;
    }

    static class Point {
        int x, y;
        Point previousPoint;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, Point previousPoint) {
            this.x = x;
            this.y = y;
            this.previousPoint = previousPoint;
        }

        Set<Point> generateNext(int favoriteNumber) {
            Set<Point> result = new HashSet<>();
            if (!isWall(favoriteNumber, x + 1, y)) {
                result.add(new Point(x + 1, y, this));
            }
            if (!isWall(favoriteNumber, x, y + 1)) {
                result.add(new Point(x, y + 1, this));
            }
            if (y - 1 >= 0 && !isWall(favoriteNumber, x, y - 1)) {
                result.add(new Point(x, y - 1, this));
            }
            if (x - 1 >= 0 && !isWall(favoriteNumber, x - 1, y)) {
                result.add(new Point(x - 1, y, this));
            }
            return result;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Point other = (Point) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }
}