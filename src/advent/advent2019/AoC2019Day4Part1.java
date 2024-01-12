package advent.advent2019;

public class AoC2019Day4Part1 {

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
        int d1 = getIthDigit(6, n);
        for (int i = 5; i >= 1; --i) {
            int d2 = getIthDigit(i, n);
            if (d1 > d2) {
                return false;
            } else if (d1 == d2) {
                hasSame = true;
            }
            d1 = d2;
        }
        return hasSame;
    }

    private static int getIthDigit(int i, int n) {
        int divider = 1;
        for (i -= 1; i > 0; --i) {
            divider *= 10;
        }
        return n / divider % 10;
    }
}
