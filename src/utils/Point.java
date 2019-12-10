package utils;

public class Point {
    public int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point point) {
        return Math.sqrt((x - point.x) * (x - point.x) + (y - point.y) * (y - point.y));
    }

    public int manhattanDistance(Point point) {
        return Math.abs(x - point.x)
                + Math.abs(y - point.y);
    }

    public int manhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + x;
        hash = 31 * hash + y;
        return hash;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }

    public Point revert() {
        return new Point(y, x);
    }
}
