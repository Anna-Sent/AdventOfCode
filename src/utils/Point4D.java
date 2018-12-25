package utils;

public class Point4D {
    public int x, y, z, t;

    public Point4D() {
    }

    public Point4D(int x, int y, int z, int t) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.t = t;
    }

    public int manhattanDistance(Point4D point) {
        return Math.abs(x - point.x)
                + Math.abs(y - point.y)
                + Math.abs(z - point.z)
                + Math.abs(t - point.t);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Point4D other = (Point4D) obj;
        return x == other.x && y == other.y && z == other.z && t == other.t;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + x;
        hash = 31 * hash + y;
        hash = 31 * hash + z;
        hash = 31 * hash + t;
        return hash;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + z + "," + t;
    }
}
