package advent2016;

public class AoC2016Day19Part2Java8 {
    public static void main(String[] args) {
        int result;

        for (int i = 1; i <= 100; ++i) {
            System.out.println(i + ": " + solve(i));
        }

        result = solve(5);
        assert result == 2;
        System.out.println(result);

        result = solve(3004953);
        assert result == 1410630;
        System.out.println(result);
    }

    private static int solve(int n) {
        int i = 2;
        int r = 1;
        while (i <= n) {
            ++r;
            int k = i / 2 + 1;
            if (r >= k) {
                ++r;
                r = 1 + (r - 1) % i;
            }
            ++i;
        }
        return r;
    }
}