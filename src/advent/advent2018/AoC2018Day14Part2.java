package advent.advent2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC2018Day14Part2 {
    public static void main(String[] args) {
        int result;

        result = test("51589");
        assert result == 9 : "unexpected result is " + result;
        System.out.println(result);

        result = test("01245");
        assert result == 5 : "unexpected result is " + result;
        System.out.println(result);

        result = test("92510");
        assert result == 18 : "unexpected result is " + result;
        System.out.println(result);

        result = test("59414");
        assert result == 2018 : "unexpected result is " + result;
        System.out.println(result);

        result = test("440231");
        assert result == 20165504 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String substring) {
        List<Integer> recipes = new ArrayList<>(Arrays.asList(3, 7));
        int first = 0, second = 1;
        int len = substring.length();
        while (true) {
            int size = recipes.size();
            int firstValue = recipes.get(first);
            int secondValue = recipes.get(second);
            int sum = firstValue + secondValue;
            if (sum == 0) {
                recipes.add(size, 0);
            } else {
                while (sum > 0) {
                    int digit = sum % 10;
                    recipes.add(size, digit);
                    sum /= 10;
                }
            }
            first = (firstValue + 1 + first) % recipes.size();
            second = (secondValue + 1 + second) % recipes.size();
            int from = recipes.size() - len - 2;
            from = from > 0 ? from : 0;
            String result = recipes.subList(from, recipes.size())
                    .stream().map(String::valueOf).reduce("", (x, y) -> x + y);
            int index = result.indexOf(substring);
            if (index >= 0) {
                return index + from;
            }
        }
    }
}
