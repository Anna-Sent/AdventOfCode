package advent.advent2016;

public class AoC2016Day19Part1Java8 {
    public static void main(String[] args) {
        int result;

        for (int i = 1; i <= 100; ++i) {
            int res1 = solve1(i);
            int res2 = solve2(i);
            assert res1 == res2 : "res1=" + res1 + ";res2=" + res2;
            System.out.println(i + ": " + res1);
        }

        result = solve1(5);
        assert result == 3;
        System.out.println(result);

        result = solve1(3004953);
        assert result == 1815603;
        System.out.println(result);

        result = solve2(5);
        assert result == 3;
        System.out.println(result);

        result = solve2(3004953);
        assert result == 1815603;
        System.out.println(result);
    }

    private static int solve1(int n) {
        int x = Integer.highestOneBit(n);
        return 2 * (n - x) + 1;
    }

    private static int solve2(int n) {
        final int k = 2;
        int i = 2;
        int r = 1;
        while (i <= n) {
            r += k % i;
            if (r > i) {
                r -= i;
            }
            ++i;
        }
        return r;
    }
}