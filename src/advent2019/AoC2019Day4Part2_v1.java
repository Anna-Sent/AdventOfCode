package advent2019;

public class AoC2019Day4Part2_v1 {

    public static void main(String[] args) {
        int result;

        assert isValid(112233);
        assert !isValid(123444);
        assert isValid(111122);

        result = test(145852, 616942);
        assert result == 1192 : "unexpected result is " + result;
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
        int count = 0;
        for (int divider = 100_000; divider >= 10; divider /= 10) {
            int d1 = n / divider % 10;
            int d2 = n / (divider / 10) % 10;
            if (d1 > d2) {
                return false;
            } else if (d1 == d2) {
                ++count;
            } else {
                if (count == 1) {
                    hasSame = true;
                }
                count = 0;
            }
        }
        return count == 1 || hasSame;
    }
}
