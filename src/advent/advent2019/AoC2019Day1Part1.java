package advent.advent2019;

public class AoC2019Day1Part1 {

    public static void main(String[] args) {
        int result;

        result = test("12");
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test("14");
        assert result == 2 : "unexpected result is " + result;
        System.out.println(result);

        result = test("1969");
        assert result == 654 : "unexpected result is " + result;
        System.out.println(result);

        result = test("100756");
        assert result == 33583 : "unexpected result is " + result;
        System.out.println(result);

        result = test("120333\n" +
                "142772\n" +
                "85755\n" +
                "90217\n" +
                "74894\n" +
                "86021\n" +
                "66768\n" +
                "147353\n" +
                "67426\n" +
                "145635\n" +
                "100070\n" +
                "88290\n" +
                "110673\n" +
                "109887\n" +
                "91389\n" +
                "121365\n" +
                "52760\n" +
                "58613\n" +
                "130918\n" +
                "57842\n" +
                "80622\n" +
                "50466\n" +
                "80213\n" +
                "85816\n" +
                "149832\n" +
                "133813\n" +
                "60211\n" +
                "69491\n" +
                "129415\n" +
                "141471\n" +
                "77916\n" +
                "98907\n" +
                "63440\n" +
                "109545\n" +
                "80183\n" +
                "143073\n" +
                "77783\n" +
                "88546\n" +
                "149648\n" +
                "128010\n" +
                "55530\n" +
                "54878\n" +
                "103885\n" +
                "57312\n" +
                "81011\n" +
                "148450\n" +
                "137947\n" +
                "67252\n" +
                "106264\n" +
                "149860\n" +
                "71677\n" +
                "101209\n" +
                "128477\n" +
                "112159\n" +
                "56027\n" +
                "53313\n" +
                "118916\n" +
                "98057\n" +
                "131668\n" +
                "61605\n" +
                "107488\n" +
                "65517\n" +
                "63594\n" +
                "84072\n" +
                "79214\n" +
                "141606\n" +
                "137375\n" +
                "112525\n" +
                "64572\n" +
                "126216\n" +
                "57013\n" +
                "130003\n" +
                "122450\n" +
                "50642\n" +
                "136844\n" +
                "96272\n" +
                "97861\n" +
                "59071\n" +
                "106870\n" +
                "116595\n" +
                "144966\n" +
                "88723\n" +
                "124038\n" +
                "63629\n" +
                "105304\n" +
                "52928\n" +
                "92917\n" +
                "147571\n" +
                "120553\n" +
                "113823\n" +
                "85524\n" +
                "71152\n" +
                "95199\n" +
                "102000\n" +
                "118874\n" +
                "133317\n" +
                "146849\n" +
                "60450\n" +
                "103307\n" +
                "117162");
        assert result == 3295424 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        int sum = 0;

        String[] tokens = s.split("\n");
        for (String token : tokens) {
            int mass = Integer.parseInt(token);
            sum += fuel(mass);
        }

        return sum;
    }

    private static int fuel(int mass) {
        return mass / 3 - 2;
    }
}
