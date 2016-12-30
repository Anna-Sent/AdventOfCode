package advent2015;

import java.util.stream.Stream;

public class AoC2015Day20Part1Java8 {
    public static void main(String[] args) {
        int result;

        result = solve1(10);
        System.out.println(result);
        assert result == 1;

        result = solve1(30);
        System.out.println(result);
        assert result == 2;

        result = solve1(40);
        System.out.println(result);
        assert result == 3;

        result = solve1(70);
        System.out.println(result);
        assert result == 4;

        result = solve1(60);
        System.out.println(result);
        assert result == 4;

        result = solve1(120);
        System.out.println(result);
        assert result == 6;

        result = solve1(80);
        System.out.println(result);
        assert result == 6;

        result = solve1(150);
        System.out.println(result);
        assert result == 8;

        result = solve1(130);
        System.out.println(result);
        assert result == 8;

        result = solve1(280);
        System.out.println(result);
        assert result == 12;

        result = solve1(36000000);
        System.out.println(result);
        assert result == 831600;

        //==========================================

        result = solve2(10);
        System.out.println(result);
        assert result == 1;

        result = solve2(30);
        System.out.println(result);
        assert result == 2;

        result = solve2(40);
        System.out.println(result);
        assert result == 3;

        result = solve2(70);
        System.out.println(result);
        assert result == 4;

        result = solve2(60);
        System.out.println(result);
        assert result == 4;

        result = solve2(120);
        System.out.println(result);
        assert result == 6;

        result = solve2(80);
        System.out.println(result);
        assert result == 6;

        result = solve2(150);
        System.out.println(result);
        assert result == 8;

        result = solve2(130);
        System.out.println(result);
        assert result == 8;

        result = solve2(280);
        System.out.println(result);
        assert result == 12;

        result = solve2(36000000);
        System.out.println(result);
        assert result == 831600;
    }

    private static int solve2(int presents) {
        return Stream.iterate(1, n -> n + 1).filter(n -> presents(n) >= presents).findFirst().get();
    }

    private static int solve1(int presents) {
        for (int i = 1; i <= presents; ++i) {
            int sum = presents(i);
            if (sum >= presents) {
                return i;
            }
        }
        return -1;
    }

    private static int presents(int house) {
        if (house == 1) return 10;
        int sum = 0;
        for (int i = 2; i * i <= house; ++i) {
            if (house % i == 0) {
                sum += i * 10;
                int second = house / i;
                if (second != i) sum += second * 10;
            }
        }
        sum += house * 10 + 1 * 10;
        return sum;
    }
}
