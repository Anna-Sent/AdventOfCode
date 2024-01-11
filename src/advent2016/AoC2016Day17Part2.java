package advent2016;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class AoC2016Day17Part2 {
    public static void main(String[] args) {
        int result;

        result = test("ihgpwlah");
        assert result == 370 : "result is " + result;
        System.out.println(result);

        result = test("kglvqrro");
        assert result == 492 : "result is " + result;
        System.out.println(result);

        result = test("ulqzkmiv");
        assert result == 830 : "result is " + result;
        System.out.println(result);

        result = test("qtetzkpl");
        assert result == 706 : "result is " + result;
        System.out.println(result);
    }

    static class Point {
        int x, y;
        String path;

        public Point(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        Set<Point> generateNext() {
            // direction is up 0, down 1, left 2, and right 3
            Set<Point> result = new HashSet<>();
            if (x + 1 < SIZE && isOpen(path, 3)) {
                result.add(new Point(x + 1, y, path + "R"));
            }
            if (y + 1 < SIZE && isOpen(path, 1)) {
                result.add(new Point(x, y + 1, path + "D"));
            }
            if (y - 1 >= 0 && isOpen(path, 0)) {
                result.add(new Point(x, y - 1, path + "U"));
            }
            if (x - 1 >= 0 && isOpen(path, 2)) {
                result.add(new Point(x - 1, y, path + "L"));
            }
            return result;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            result = prime * result + path.hashCode();
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
            if (!path.equals(other.path))
                return false;
            return true;
        }
    }

    private static final int SIZE = 4;
    private static String PASSCODE;

    private static int test(String passcode) {
        map.clear();
        PASSCODE = passcode;

        Set<Point> opened = new HashSet<>();

        int max = 0;
        opened.add(new Point(0, 0, ""));

        while (opened.size() > 0) {
            Set<Point> achievable = new HashSet<>();
            for (Point currentPoint : opened) {
                if (currentPoint.x == 3 && currentPoint.y == 3) {
                    int len = currentPoint.path.length();
                    max = max > len ? max : len;
                } else {
                    Set<Point> set = currentPoint.generateNext();
                    achievable.addAll(set);
                }
            }

            opened = achievable;
        }

        return max;
    }

    // direction is up, down, left, and right
    private static boolean isOpen(String path, int direction) {
        String hash = getHash(path);
        char ch = hash.charAt(direction);
        return ch == 'b' || ch == 'c' || ch == 'd' || ch == 'e' || ch == 'f';
    }

    private static Map<String, String> map = new HashMap<>();

    private static String getHash(String path) {
        try {
            String key = path;
            if (map.containsKey(key)) {
                return map.get(key);
            } else {
                String hash = PASSCODE + path;
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(hash.getBytes());
                byte[] bytes = digest.digest();
                hash = String.format(Locale.US, "%032x", new BigInteger(1,
                        bytes));
                map.put(key, hash.substring(0, 5));
                return hash;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}