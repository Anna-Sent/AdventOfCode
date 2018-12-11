package advent2018;

public class AoC2018Day11Part1 {
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
        assert result.equals("29 33,45") : "unexpected result is " + result;
        System.out.println(result);

        result = findLargest(42);
        assert result.equals("30 21,61") : "unexpected result is " + result;
        System.out.println(result);

        result = findLargest(6392);
        assert result.equals("30 20,58") : "unexpected result is " + result;
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

    private static final int SIZE = 300;

    public static String findLargest(int serialNumber) {
        Result maxResult = null;
        for (int y = 1; y <= SIZE - 2; ++y) {
            for (int x = 1; x <= SIZE - 2; ++x) {
                Result result = new Result();
                result.x = x;
                result.y = y;
                result.totalPowerLevel = 0;
                for (int dy = y; dy < y + 3; ++dy) {
                    for (int dx = x; dx < x + 3; ++dx) {
                        result.totalPowerLevel += powerLevel(dx, dy, serialNumber);
                    }
                }
                if (maxResult == null || maxResult.totalPowerLevel < result.totalPowerLevel) {
                    maxResult = result;
                }
            }
        }
        return maxResult.totalPowerLevel + " " + maxResult.x + "," + maxResult.y;
    }

    private static class Result {
        int x, y, totalPowerLevel;
    }
}
