package test;

import java.util.stream.Stream;

public class SumTest {
    public static void main(String[] args) {
        int res1, res2;

        for (int n = 1; n <= 1000; ++n) {
            res1 = sum1(n);
            res2 = sum2(n);
            System.out.println(res1 + "=" + res2);
            assert res1 == res2 : "failed on n=" + n + " res1=" + res1 + " res2=" + res2;
        }
    }

    public static int sum1(int n) {
        return Stream.iterate(1, i -> i + 1).limit(n).filter(i -> i % 3 == 0 || i % 5 == 0).reduce((s1, s2) -> s1 + s2).orElse(0);
    }

    public static int sum2(int n) {
        return (3 * (n / 3) * (n / 3 + 1) + 5 * (n / 5) * (n / 5 + 1) - 15 * (n / 15) * (n / 15 + 1)) / 2;
    }
}
