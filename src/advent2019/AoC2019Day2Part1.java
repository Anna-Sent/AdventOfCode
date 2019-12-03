package advent2019;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AoC2019Day2Part1 {

    public static void main(String[] args) {
        String result;

        result = test("1,9,10,3,2,3,11,0,99,30,40,50");
        assert result.equals("3500,9,10,70,2,3,11,0,99,30,40,50") : "unexpected result is " + result;
        System.out.println(result);

        result = test("1,0,0,0,99");
        assert result.equals("2,0,0,0,99") : "unexpected result is " + result;
        System.out.println(result);

        result = test("2,3,0,3,99");
        assert result.equals("2,3,0,6,99") : "unexpected result is " + result;
        System.out.println(result);

        result = test("2,3,0,3,99");
        assert result.equals("2,3,0,6,99") : "unexpected result is " + result;
        System.out.println(result);

        result = test("2,4,4,5,99,0");
        assert result.equals("2,4,4,5,99,9801") : "unexpected result is " + result;
        System.out.println(result);

        result = test("1,1,1,4,99,5,6,0,99");
        assert result.equals("30,1,1,4,2,5,6,0,99") : "unexpected result is " + result;
        System.out.println(result);

        result = test("1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,5,19,23,2,9,23,27,1,27,5,31,2,31,13,35,1,35,9,39,1,39,10,43,2,43,9,47,1,47,5,51,2,13,51,55,1,9,55,59,1,5,59,63,2,6,63,67,1,5,67,71,1,6,71,75,2,9,75,79,1,79,13,83,1,83,13,87,1,87,5,91,1,6,91,95,2,95,13,99,2,13,99,103,1,5,103,107,1,107,10,111,1,111,13,115,1,10,115,119,1,9,119,123,2,6,123,127,1,5,127,131,2,6,131,135,1,135,2,139,1,139,9,0,99,2,14,0,0");
        assert result.equals("5110675,12,2,2,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,36,1,5,19,37,2,9,23,111,1,27,5,112,2,31,13,560,1,35,9,563,1,39,10,567,2,43,9,1701,1,47,5,1702,2,13,51,8510,1,9,55,8513,1,5,59,8514,2,6,63,17028,1,5,67,17029,1,6,71,17031,2,9,75,51093,1,79,13,51098,1,83,13,51103,1,87,5,51104,1,6,91,51106,2,95,13,255530,2,13,99,1277650,1,5,103,1277651,1,107,10,1277655,1,111,13,1277660,1,10,115,1277664,1,9,119,1277667,2,6,123,2555334,1,5,127,2555335,2,6,131,5110670,1,135,2,5110672,1,139,9,0,99,2,14,0,0") : "unexpected result is " + result;
        System.out.println(result);
    }

    private static String test(String s) {
        List<Integer> values = new ArrayList<>();

        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Integer.parseInt(token));
        }

        boolean completed = false;
        for (int i = 0; !completed; ) {
            int cmd = values.get(i);
            switch (cmd) {

                case 1: {
                    int first = values.get(values.get(i + 1));
                    int second = values.get(values.get(i + 2));
                    int result = values.get(i + 3);
                    int sum = first + second;
                    values.set(result, sum);
                    i += 4;
                    break;
                }

                case 2: {
                    int first = values.get(values.get(i + 1));
                    int second = values.get(values.get(i + 2));
                    int result = values.get(i + 3);
                    int mul = first * second;
                    values.set(result, mul);
                    i += 4;
                    break;
                }

                case 99:
                    completed = true;
                    break;

                default:
                    assert false : "unexpected value " + i;
            }
        }

        return join(",", values);
    }

    private static String join(CharSequence delimiter, Iterable tokens) {
        final Iterator<?> it = tokens.iterator();
        if (!it.hasNext()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(delimiter);
            sb.append(it.next());
        }
        return sb.toString();
    }
}
