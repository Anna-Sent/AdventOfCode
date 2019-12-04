package advent2019;

public class AoC2019Day4Part1_v2 {

    public static void main(String[] args) {
        int result;

        assert isValid(111111);
        assert !isValid(223450);
        assert !isValid(123789);

        result = test(145852, 616942);
        assert result == 1767 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; ++i) {
            if (isValid(i)) {
                System.out.println(i);
                ++count;
            }
        }
        return count;
    }

    private static boolean isValid(int n) {
        boolean hasSame = false;
        for (int divider = 100_000; divider >= 10; divider /= 10) {
            int d1 = n / divider % 10;
            int d2 = n / (divider / 10) % 10;
            if (d1 > d2) {
                return false;
            } else if (d1 == d2) {
                hasSame = true;
            }
        }
        return hasSame;
    }
}
