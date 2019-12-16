package advent2019;

public class AoC2019Day16Part1_v1 {

    public static void main(String[] args) {
        int result;

        result = test(0, "12345678");
        assert result == 12345678 : "unexpected result is " + result;
        System.out.println(result);

        result = test(1, "12345678");
        assert result == 48226158 : "unexpected result is " + result;
        System.out.println(result);

        result = test(2, "12345678");
        assert result == 34040438 : "unexpected result is " + result;
        System.out.println(result);

        result = test(3, "12345678");
        assert result == 3415518 : "unexpected result is " + result;
        System.out.println(result);

        result = test(4, "12345678");
        assert result == 1029498 : "unexpected result is " + result;
        System.out.println(result);

        result = test(100, "80871224585914546619083218645595");
        assert result == 24176176 : "unexpected result is " + result;
        System.out.println(result);

        result = test(100, "19617804207202209144916044189917");
        assert result == 73745418 : "unexpected result is " + result;
        System.out.println(result);

        result = test(100, "69317163492948606335995924319873");
        assert result == 52432133 : "unexpected result is " + result;
        System.out.println(result);

        result = test(100, "59734319985939030811765904366903137260910165905695158121249344919210773577393954674010919824826738360814888134986551286413123711859735220485817087501645023012862056770562086941211936950697030938202612254550462022980226861233574193029160694064215374466136221530381567459741646888344484734266467332251047728070024125520587386498883584434047046536404479146202115798487093358109344892308178339525320609279967726482426508894019310795012241745215724094733535028040247643657351828004785071021308564438115967543080568369816648970492598237916926533604385924158979160977915469240727071971448914826471542444436509363281495503481363933620112863817909354757361550");
        assert result == 37153056 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(int phases, String s) {
        char[] chars = s.toCharArray();
        int[] input = new int[chars.length];
        for (int i = 0; i < input.length; ++i) {
            input[i] = chars[i] - '0';
        }

        for (int i = 0; i < phases; ++i) {
            for (int j = 0; j < input.length; ++j) {
                input[j] = calculate(input, j);
            }
        }

        int result = 0;
        int t = 1;
        for (int i = 7; i >= 0; --i) {
            result += input[i] * t;
            t *= 10;
        }
        return result;
    }

    private static final int[] pattern = new int[]{1, 0, -1, 0};

    private static int calculate(int[] input, int d) {
        int sum = 0;
        for (int i = d; i < input.length; ) {
            for (int j = 0; j < pattern.length && i < input.length; ++j) {
                for (int k = 0; k < d + 1 && i < input.length; ++k) {
                    sum += input[i] * pattern[j];
                    ++i;
                }
            }
        }
        return Math.abs(sum) % 10;
    }
}
