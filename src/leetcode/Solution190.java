package leetcode;

class Solution190 {
    public static void main(String[] args) {
        test(0);
        test(1);
        test(5);
        test(13);
        test(100);
        test(43261596, 964176192);
        test(-2147483648, 1);
        test(-2147483648);
        test(-100);
        test(-5);
    }

    private static void test(int n) {
        int reversed = new Solution().reverseBits(n);
        String nAsBits = appendLeadingZeros(Integer.toBinaryString(n));
        String expected = new StringBuilder(nAsBits).reverse().toString();
        String actual = appendLeadingZeros(Integer.toBinaryString(reversed));
        assert expected.equals(actual) : "failed with " + n + ": expected is " + expected + ", actual is " + actual;
    }

    private static String appendLeadingZeros(String s) {
        while (s.length() < 32) {
            s = "0" + s;
        }
        return s;
    }

    private static void test(int n, int expected) {
        int actual = new Solution().reverseBits(n);
        assert expected == actual : "failed with " + n + ": expected is "
                + Integer.toBinaryString(expected) + " (" + expected + "), actual is "
                + Integer.toBinaryString(actual) + " (" + actual + ")";
    }

    static class Solution {
        public int reverseBits(int n) {
            int reversed = 0, i = 1;
            while (n != 0) {
                reversed = (reversed << 1) + (n & 1);
                n >>>= 1;
                ++i;
            }
            while (i <= 32) {
                reversed <<= 1;
                ++i;
            }
            return reversed;
        }
    }
}
