package advent.advent2018;

import utils.Point;

import java.util.HashMap;
import java.util.Map;

public class AoC2018Day11Part2Dynamics {
    private static final int SIZE = 300;

    private static void testPowerLevel() {
        int result;

        result = powerLevel(3, 5, 8);
        assert result == 4 : "unexpected result is " + result;
        System.out.println(result);

        result = powerLevel(122, 79, 57);
        assert result == -5 : "unexpected result is " + result;
        System.out.println(result);

        result = powerLevel(217, 196, 39);
        assert result == 0 : "unexpected result is " + result;
        System.out.println(result);

        result = powerLevel(101, 153, 71);
        assert result == 4 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static void main(String[] args) {
        testPowerLevel();

        String result;

        result = findLargest(18);
        assert result.equals("113 90,269,16") : "unexpected result is " + result;
        System.out.println(result);

        result = findLargest(42);
        assert result.equals("119 232,251,12") : "unexpected result is " + result;
        System.out.println(result);

        result = findLargest(6392);
        assert result.equals("83 233,268,13") : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int powerLevel(int x, int y, int serialNumber) {
        int rackId = x + 10;
        int result = rackId * y;
        result += serialNumber;
        result *= rackId;
        result %= 1000;
        result /= 100;
        result -= 5;
        return result;
    }

    public static String findLargest(int serialNumber) {
        Map<Point, Integer> sums = new HashMap<>();
        for (int x = 1; x <= SIZE; ++x) {
            for (int y = 1; y <= SIZE; ++y) {
                Point key = new Point(x, y);
                int value = powerLevel(key.x, key.y, serialNumber)
                        + (key.x == 1 ? 0 : sums.get(new Point(key.x - 1, key.y)))
                        + (key.y == 1 ? 0 : sums.get(new Point(key.x, key.y - 1)))
                        - (key.x == 1 || key.y == 1 ? 0 : sums.get(new Point(key.x - 1, key.y - 1)));
                sums.put(key, value);
            }
        }

        Result maxResult = null;
        for (int size = 1; size <= SIZE; ++size) {
            for (int x = 1; x <= SIZE - size + 1; ++x) {
                for (int y = 1; y <= SIZE - size + 1; ++y) {
                    Result result = new Result();
                    result.x = x;
                    result.y = y;
                    result.size = size;
                    result.totalPowerLevel = sums.get(new Point(x + size - 1, y + size - 1))//+
                            - (x == 1 ? 0 : sums.get(new Point(x - 1, y + size - 1)))
                            - (y == 1 ? 0 : sums.get(new Point(x + size - 1, y - 1)))
                            + (x == 1 || y == 1 ? 0 : sums.get(new Point(x - 1, y - 1)));
                    if (maxResult == null || maxResult.totalPowerLevel < result.totalPowerLevel) {
                        maxResult = result;
                    }
                }
            }
        }
        return maxResult.totalPowerLevel + " " + maxResult.x + "," + maxResult.y + "," + maxResult.size;
    }

    private static class Result {
        int x, y, size, totalPowerLevel;
    }
}
