package advent2015;

import java.util.stream.Stream;

public class AoC2015Day20Part2Java8 {
    public static void main(String[] args) {
        int result;

        result = solve(36000000);
        System.out.println(result);
        assert result == 884520;
    }

    private static int solve(int presents) {
        return Stream.iterate(1, n -> n + 1).filter(n -> presents(n) >= presents).findFirst().orElse(-1);
    }

    private static int presents(int house) {
        if (house == 1) return 11;
        int sum = 0;
        for (int i = 2; i * i <= house; ++i) {
            if (house % i == 0) {
                if (house / i <= 50) {
                    sum += i * 11;
                }
                int second = house / i;
                if (second != i) {
                    if (house / second <= 50) {
                        sum += second * 11;
                    }
                }
            }
        }
        sum += house * 11 + (house <= 50 ? 11 : 0);
        return sum;
    }
}
