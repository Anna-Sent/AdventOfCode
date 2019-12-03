package advent2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC2018Day14Part1 {
    public static void main(String[] args) {
        String result;

        result = test(9);
        assert result.equals("5158916779") : "unexpected result is " + result;
        System.out.println(result);

        result = test(5);
        assert result.equals("0124515891") : "unexpected result is " + result;
        System.out.println(result);

        result = test(18);
        assert result.equals("9251071085") : "unexpected result is " + result;
        System.out.println(result);

        result = test(2018);
        assert result.equals("5941429882") : "unexpected result is " + result;
        System.out.println(result);

        result = test(440231);
        assert result.equals("1052903161") : "unexpected result is " + result;
        System.out.println(result);
    }

    private static String test(int number) {
        List<Integer> recipes = new ArrayList<>(Arrays.asList(3, 7));
        int first = 0, second = 1;
        while (recipes.size() < number + 10) {
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
            if (recipes.size() <= 1000) {
                recipes.stream().map(String::valueOf).map(x -> x + " ").forEach(System.out::print);
                System.out.println();
            }
            first = (firstValue + 1 + first) % recipes.size();
            second = (secondValue + 1 + second) % recipes.size();
        }
        return recipes.stream().skip(number).limit(10).map(String::valueOf).reduce("", (x, y) -> x + y);
    }
}
