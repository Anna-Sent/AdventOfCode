package advent2019;

public class AoC2019Day16Part2 {

    public static void main(String[] args) {
        int result;

        result = test("03036732577212944063491565474664");
        assert result == 84462026 : "unexpected result is " + result;
        System.out.println(result);

        result = test("02935109699940807407585447034323");
        assert result == 78725270 : "unexpected result is " + result;
        System.out.println(result);

        result = test("03081770884921959731165446850517");
        assert result == 53553731 : "unexpected result is " + result;
        System.out.println(result);

        result = test("59734319985939030811765904366903137260910165905695158121249344919210773577393954674010919824826738360814888134986551286413123711859735220485817087501645023012862056770562086941211936950697030938202612254550462022980226861233574193029160694064215374466136221530381567459741646888344484734266467332251047728070024125520587386498883584434047046536404479146202115798487093358109344892308178339525320609279967726482426508894019310795012241745215724094733535028040247643657351828004785071021308564438115967543080568369816648970492598237916926533604385924158979160977915469240727071971448914826471542444436509363281495503481363933620112863817909354757361550");
        // assert result ==  : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        char[] chars = s.toCharArray();
        int[] input = new int[chars.length * 10000];
        for (int i = 0; i < input.length; ++i) {
            input[i] = chars[i % chars.length] - '0';
        }

        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < input.length; ++j) {
                input[j] = calculate(input, j);
            }
        }

        int shift = 0;
        int t = 1;
        for (int i = 6; i >= 0; --i) {
            shift += input[i] * t;
            t *= 10;
        }
        int result = 0;
        t = 1;
        for (int i = 7; i >= 0; --i) {
            result += input[i + shift] * t;
            t *= 10;
        }
        return result;
    }

    private static final int[] pattern = new int[]{1, 0, -1, 0};

    private static int calculate(int[] input, int d) {
        int sum = 0;
        for (int i = d; i < input.length; ) {
            int j = (i - d) / (d + 1) % pattern.length;
            sum += input[i] * pattern[j];
            ++i;
        }
        return Math.abs(sum) % 10;
    }
}
