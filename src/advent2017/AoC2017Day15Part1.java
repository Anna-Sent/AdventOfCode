package advent2017;

public class AoC2017Day15Part1 {
    public static void main(String[] args) {
        int result;

        result = test(65, 8921);
        System.out.println(result);
        assert result == 588 : "unexpected result is " + result;

        result = test(679, 771);
        assert result == 626 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(long a, long b) {
        int count = 0;
        for (int i = 0; i < 40000000; ++i) {
            a = generateA(a);
            b = generateB(b);
            if (matches(a, b)) {
                ++count;
            }
        }
        return count;
    }

    private static boolean matches(long a, long b) {
        return (a & 65535) == (b & 65535);
    }

    private static long generateA(long previous) {
        return previous * 16807 % 2147483647;
    }

    private static long generateB(long previous) {
        return previous * 48271 % 2147483647;
    }
}
