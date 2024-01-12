package advent.advent2018;

public class AoC2018Day11Part2Threads {
    private static final int SIZE = 300;
    private static Result maxResult;

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
        maxResult = null;
        Thread[] threads = new Thread[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            int size = i + 1;
            threads[i] = new Thread(() -> {
                for (int y = 1; y <= SIZE - size + 1; ++y) {
                    for (int x = 1; x <= SIZE - size + 1; ++x) {
                        Result result = new Result();
                        result.x = x;
                        result.y = y;
                        result.size = size;
                        result.totalPowerLevel = 0;
                        for (int dy = y; dy < y + size; ++dy) {
                            for (int dx = x; dx < x + size; ++dx) {
                                result.totalPowerLevel += powerLevel(dx, dy, serialNumber);
                            }
                        }
                        synchronized (AoC2018Day11Part2Threads.class) {
                            if (maxResult == null || maxResult.totalPowerLevel < result.totalPowerLevel) {
                                maxResult = result;
                            }
                        }
                    }
                }
            });
            threads[i].start();
        }
        try {
            for (int i = 0; i < SIZE; ++i) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return maxResult.totalPowerLevel + " " + maxResult.x + "," + maxResult.y + "," + maxResult.size;
    }

    private static class Result {
        int x, y, size, totalPowerLevel;
    }
}
