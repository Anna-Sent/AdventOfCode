package leetcode.solution2;

class Solution233 {
    private static void test(int n, Solution solution) {
        int expected = new Solution1().countDigitOne(n);
        int actual = solution.countDigitOne(n);
        System.out.println(n + " => expected: " + expected);
        assert expected == actual : n + " => expected: " + expected + ", actual: " + actual;
    }

    private static void test(int n, int expected, Solution solution) {
        int actual = solution.countDigitOne(n);
        assert expected == actual : n + " => expected: " + expected + ", actual: " + actual;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        for (int i = -1; i < 10000; ++i) {
            test(i, solution2);
        }
        Solution3 solution3 = new Solution3();
        for (int i = -1; i <= 10000; ++i) {
            test(i, solution3);
        }
        test(50000, solution3);
        test(100000, solution3);
        test(100001, solution3);
        test(1000000, solution3);
        test(1000000000, 900000001, solution3);
        test(2000000000, -1494967296, solution3);
        test(2147483647, -1323939513, solution3);
        test(2147483647 + 1, solution3);
    }

    interface Solution {
        int countDigitOne(int n);
    }

    static class Solution1 {
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }
            int count = 0;
            for (int i = 1; i <= n; ++i) {
                int num = i;
                while (num > 0) {
                    int digit = num % 10;
                    if (digit == 1) {
                        ++count;
                    }
                    num /= 10;
                }
            }
            return count;
        }
    }

    static class Solution2 implements Solution {
        // Решение до 10000 (не включительно)
        @Override
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }

            int count = 0;
            int remainder;

            remainder = n % 10;
            remainder = 9 >= remainder && remainder >= 1 ? 1 : 0; // неполная десятка
            count += remainder;
            count += n / 10; // в каждой десятке по одной единице (1,11,21,...)

            remainder = n % 100;
            remainder = 19 >= remainder && remainder >= 10 ? remainder - 10 + 1 : (remainder > 19 ? 10 : 0);
            count += remainder;
            count += n / 100 * 10; // в каждой сотне по 10 единиц (10,11,12,...,19)

            remainder = n % 1000;
            remainder = 199 >= remainder && remainder >= 100 ? remainder - 100 + 1 : (remainder > 199 ? 100 : 0);
            count += remainder;
            count += n / 1000 * 100; // в каждой тысяче по 100 единиц (100,101,...,199)

            remainder = n % 10000;
            remainder = 1999 >= remainder && remainder >= 1000 ? remainder - 1000 + 1 : (remainder > 1999 ? 1000 : 0);
            count += remainder;
            count += n / 10000 * 1000;

            return count;
        }
    }

    static class Solution3 implements Solution {
        @Override
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }

            long count = 0;
            long remainder;

            long k = 10, l = 1, m = n;
            while (m > 0) {
                remainder = n % k;
                if (k == 10) {
                    remainder = remainder >= 1 ? 1 : 0;
                } else {
                    long left = l * 2 - 1;
                    long right = l;
                    remainder = left >= remainder && remainder >= right
                            ? remainder - right + 1
                            : (remainder > left ? right : 0);
                }
                count += remainder;
                count += n / k * l;
                m /= 10;
                k *= 10;
                l *= 10;
            }

            return (int) count;
        }
    }
}
