package advent.advent2017;

public class AoC2017Day3Part1 {
    public static void main(String[] args) {
        int result;

        result = test(1);
        assert result == 0 : "unexpected result is " + result;
        System.out.println(result);

        result = test(2);
        assert result == 1 : "unexpected result is " + result;
        System.out.println(result);

        result = test(3);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(4);
        assert result == 1 : "unexpected result is " + result;
        System.out.println(result);

        result = test(5);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(6);
        assert result == 1 : "unexpected result is " + result;
        System.out.println(result);

        result = test(7);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(8);
        assert result == 1 : "unexpected result is " + result;
        System.out.println(result);

        result = test(9);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(12);
        assert result == 3 : "unexpected result is " + result;
        System.out.println(result);

        result = test(15);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(23);
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test(26);
        assert result == 5 : "unexpected result is " + result;
        System.out.println(result);

        result = test(49);
        assert result == 6 : "unexpected result is " + result;
        System.out.println(result);

        result = test(1024);
        assert result == 31 : "unexpected result is " + result;
        System.out.println(result);

        result = test(347991);
        assert result == 480 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int from) {
        int side = (int) Math.ceil(Math.sqrt(from));
        side = side % 2 == 1 ? side : side + 1;
        int n = side * side;
        for (int i = 0; i < 4; ++i) {
            n -= side;
            ++n;
            if (from >= n) {
                return side / 2 + Math.abs(n + side / 2 - from);
            }
        }
        return -1;
    }
}
