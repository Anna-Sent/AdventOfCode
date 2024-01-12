package advent.advent2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2019Day22Part1 {

    public static void main(String[] args) {
        List<Integer> results;

        results = test(10, "deal with increment 7\n" +
                "deal into new stack\n" +
                "deal into new stack");
        assert results.equals(Arrays.asList(0, 3, 6, 9, 2, 5, 8, 1, 4, 7)) : "unexpected result is " + results;
        System.out.println(results);

        results = test(10, "cut 6\n" +
                "deal with increment 7\n" +
                "deal into new stack");
        assert results.equals(Arrays.asList(3, 0, 7, 4, 1, 8, 5, 2, 9, 6)) : "unexpected result is " + results;
        System.out.println(results);

        results = test(10, "deal with increment 7\n" +
                "deal with increment 9\n" +
                "cut -2");
        assert results.equals(Arrays.asList(6, 3, 0, 7, 4, 1, 8, 5, 2, 9)) : "unexpected result is " + results;
        System.out.println(results);

        results = test(10, "deal into new stack\n" +
                "cut -2\n" +
                "deal with increment 7\n" +
                "cut 8\n" +
                "cut -4\n" +
                "deal with increment 7\n" +
                "cut 3\n" +
                "deal with increment 9\n" +
                "deal with increment 3\n" +
                "cut -1");
        assert results.equals(Arrays.asList(9, 2, 5, 8, 1, 4, 7, 0, 3, 6)) : "unexpected result is " + results;
        System.out.println(results);

        int result;
        result = testNY(10007, "deal with increment 5\n" +
                "cut 9569\n" +
                "deal with increment 22\n" +
                "cut -9977\n" +
                "deal with increment 64\n" +
                "cut -4758\n" +
                "deal with increment 12\n" +
                "cut 8507\n" +
                "deal with increment 7\n" +
                "cut -4724\n" +
                "deal with increment 3\n" +
                "cut 7577\n" +
                "deal with increment 20\n" +
                "cut -1543\n" +
                "deal into new stack\n" +
                "deal with increment 62\n" +
                "deal into new stack\n" +
                "deal with increment 62\n" +
                "cut 4879\n" +
                "deal into new stack\n" +
                "deal with increment 34\n" +
                "cut 3555\n" +
                "deal with increment 8\n" +
                "cut -6954\n" +
                "deal with increment 32\n" +
                "cut -4299\n" +
                "deal into new stack\n" +
                "deal with increment 70\n" +
                "cut -5387\n" +
                "deal with increment 32\n" +
                "deal into new stack\n" +
                "cut -5074\n" +
                "deal into new stack\n" +
                "deal with increment 14\n" +
                "cut -1405\n" +
                "deal with increment 40\n" +
                "cut 4665\n" +
                "deal with increment 42\n" +
                "deal into new stack\n" +
                "deal with increment 20\n" +
                "cut 5945\n" +
                "deal with increment 73\n" +
                "cut 9777\n" +
                "deal with increment 32\n" +
                "cut 4783\n" +
                "deal into new stack\n" +
                "deal with increment 63\n" +
                "cut -3388\n" +
                "deal with increment 18\n" +
                "cut 6364\n" +
                "deal with increment 34\n" +
                "cut -7962\n" +
                "deal into new stack\n" +
                "cut -5937\n" +
                "deal with increment 70\n" +
                "cut -3600\n" +
                "deal with increment 46\n" +
                "deal into new stack\n" +
                "cut -3460\n" +
                "deal with increment 61\n" +
                "cut 8430\n" +
                "deal with increment 33\n" +
                "cut -9068\n" +
                "deal into new stack\n" +
                "deal with increment 75\n" +
                "cut 3019\n" +
                "deal with increment 5\n" +
                "cut -2963\n" +
                "deal with increment 59\n" +
                "cut -2973\n" +
                "deal with increment 64\n" +
                "cut 3203\n" +
                "deal with increment 13\n" +
                "cut -9915\n" +
                "deal with increment 60\n" +
                "cut 5823\n" +
                "deal with increment 26\n" +
                "cut 2255\n" +
                "deal with increment 35\n" +
                "cut -8491\n" +
                "deal with increment 75\n" +
                "cut -8065\n" +
                "deal with increment 38\n" +
                "cut 8417\n" +
                "deal with increment 75\n" +
                "cut 7005\n" +
                "deal into new stack\n" +
                "deal with increment 67\n" +
                "deal into new stack\n" +
                "cut -896\n" +
                "deal into new stack\n" +
                "cut -7243\n" +
                "deal into new stack\n" +
                "deal with increment 29\n" +
                "cut -4407\n" +
                "deal with increment 63\n" +
                "cut -8660\n" +
                "deal into new stack\n" +
                "cut 7411\n" +
                "deal into new stack");
        assert result == 8326 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final Pattern cutPattern = Pattern.compile("cut (-?\\d+)");
    private static final Pattern stackPattern = Pattern.compile("deal into new stack");
    private static final Pattern incrementPattern = Pattern.compile("deal with increment (-?\\d+)");

    private static int testNY(int length, String s) {
        List<Integer> numbers = test(length, s);
        return numbers.indexOf(2019);
    }

    private static List<Integer> test(int length, String s) {
        List<Integer> numbers = new ArrayList<>(length);
        for (int i = 0; i < length; ++i) {
            numbers.add(i);
        }
        for (String token : s.split("\n")) {
            Matcher matcher;
            matcher = cutPattern.matcher(token);
            if (matcher.matches()) {
                int p = Integer.parseInt(matcher.group(1));
                if (p < 0) {
                    p = length + p;
                }
                List<Integer> result = new ArrayList<>(length);
                result.addAll(numbers.subList(p, numbers.size()));
                result.addAll(numbers.subList(0, p));
                numbers = result;
                continue;
            }
            matcher = stackPattern.matcher(token);
            if (matcher.matches()) {
                Collections.reverse(numbers);
                continue;
            }
            matcher = incrementPattern.matcher(token);
            if (matcher.matches()) {
                int p = Integer.parseInt(matcher.group(1));
                assert p > 0 : "invalid input";
                int[] tmp = new int[length];
                int count = 0;
                for (int i = 0; i < length; ++i, count += p) {
                    int number = numbers.get(i);
                    tmp[count % length] = number;
                }
                numbers.clear();
                for (int i = 0; i < length; ++i) {
                    numbers.add(tmp[i]);
                }
                continue;
            }
            assert false : "invalid input " + token;
        }
        return numbers;
    }
}
