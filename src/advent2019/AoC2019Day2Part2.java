package advent2019;

import java.util.ArrayList;
import java.util.List;

public class AoC2019Day2Part2 {

    public static void main(String[] args) {
        int result;

        for (int noun = 0; noun < 100; ++noun) {
            for (int verb = 0; verb < 100; ++verb) {
                result = test(noun, verb, "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,9,1,19,1,5,19,23,2,9,23,27,1,27,5,31,2,31,13,35,1,35,9,39,1,39,10,43,2,43,9,47,1,47,5,51,2,13,51,55,1,9,55,59,1,5,59,63,2,6,63,67,1,5,67,71,1,6,71,75,2,9,75,79,1,79,13,83,1,83,13,87,1,87,5,91,1,6,91,95,2,95,13,99,2,13,99,103,1,5,103,107,1,107,10,111,1,111,13,115,1,10,115,119,1,9,119,123,2,6,123,127,1,5,127,131,2,6,131,135,1,135,2,139,1,139,9,0,99,2,14,0,0");
                System.out.println(noun + " " + verb + ": " + result);
                if (result == 19690720) {
                    System.out.println("result: " + (100 * noun + verb));
                    System.exit(0);
                }
            }
        }
    }

    public static int test(int noun, int verb, String s) {
        List<Integer> values = new ArrayList<>();

        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Integer.parseInt(token));
        }

        values.set(1, noun);
        values.set(2, verb);

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

        return values.get(0);
    }
}
