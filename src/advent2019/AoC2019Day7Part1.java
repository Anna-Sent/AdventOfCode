package advent2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC2019Day7Part1 {

    public static void main(String[] args) {
        int result;

        result = test("3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0",
                Arrays.asList(4, 3, 2, 1, 0));
        assert result == 43210 : "unexpected result is " + result;
        System.out.println(result);

        result = test("3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,00",
                Arrays.asList(0, 1, 2, 3, 4));
        assert result == 54321 : "unexpected result is " + result;
        System.out.println(result);

        result = test("3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0",
                Arrays.asList(1, 0, 4, 3, 2));
        assert result == 65210 : "unexpected result is " + result;
        System.out.println(result);

        result = testWithPermutations(
                "3,8,1001,8,10,8,105,1,0,0,21,30,55,76,97,114,195,276,357,438,99999,3,9,102,3,9,9,4,9,99,3,9,1002,9,3,9,1001,9,5,9,1002,9,2,9,1001,9,2,9,102,2,9,9,4,9,99,3,9,1002,9,5,9,1001,9,2,9,102,5,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,102,5,9,9,101,4,9,9,1002,9,4,9,4,9,99,3,9,101,2,9,9,102,4,9,9,1001,9,5,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,99",
                Arrays.asList(0, 1, 2, 3, 4));
        assert result == 359142 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int testWithPermutations(String program, List<Integer> phases) {
        List<List<Integer>> variants = new ArrayList<>();
        permutate(phases, 0, variants);
        int max = 0;
        for (List<Integer> variant : variants) {
            int result = test(program, variant);
            max = Math.max(max, result);
        }
        return max;
    }

    private static void permutate(List<Integer> list, int pointer, List<List<Integer>> variants) {
        if (pointer == list.size()) {
            variants.add(list);
            return;
        }
        for (int i = pointer; i < list.size(); i++) {
            List<Integer> permutation = new ArrayList<>(list);
            permutation.set(pointer, list.get(i));
            permutation.set(i, list.get(pointer));
            permutate(permutation, pointer + 1, variants);
        }
    }

    private static int test(String input, List<Integer> phases) {
        int prevOutput = 0;
        for (int i = 0; i < phases.size(); ++i) {
            prevOutput = run(String.valueOf((char) ('A' + i)), input,
                    Arrays.asList(phases.get(i), prevOutput));
        }
        return prevOutput;
    }

    private static final List<Integer> values = new ArrayList<>();

    private static int run(String name, String s, List<Integer> inputs) {
        values.clear();

        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Integer.parseInt(token));
        }

        int inputCounter = 0;
        boolean completed = false;
        for (int i = 0; !completed; ) {
            int cmd = values.get(i);

            int A = cmd / 10000 % 10;
            int B = cmd / 1000 % 10;
            int C = cmd / 100 % 10;

            int DE = cmd % 100;

            switch (DE) {

                case 1: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    int result = getParamValue(i + 3, 1);
                    int sum = first + second;
                    values.set(result, sum);
                    i += 4;
                    break;
                }

                case 2: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    int result = getParamValue(i + 3, 1);
                    int mul = first * second;
                    values.set(result, mul);
                    i += 4;
                    break;
                }

                case 3: {
                    int input = inputs.get(inputCounter);
                    ++inputCounter;
                    System.out.println(name + " in: " + input);
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    int result = getParamValue(i + 1, 1);
                    values.set(result, input);
                    i += 2;
                    break;
                }

                case 4: {
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    int result = getParamValue(i + 1, C);
                    System.out.println(name + " out: " + result);
                    return result;
                }

                case 5: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    if (first == 0) {
                        i += 3;
                    } else {
                        i = second;
                    }
                    break;
                }

                case 6: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    if (first == 0) {
                        i = second;
                    } else {
                        i += 3;
                    }
                    break;
                }

                case 7: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    int result = getParamValue(i + 3, 1);
                    if (first < second) {
                        values.set(result, 1);
                    } else {
                        values.set(result, 0);
                    }
                    i += 4;
                    break;
                }

                case 8: {
                    int first = getParamValue(i + 1, C);
                    int second = getParamValue(i + 2, B);
                    int result = getParamValue(i + 3, 1);
                    if (first == second) {
                        values.set(result, 1);
                    } else {
                        values.set(result, 0);
                    }
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

        return -1;
    }

    private static int getParamValue(int position, int mode) {
        switch (mode) {
            case 0:
                return values.get(values.get(position));
            case 1:
                return values.get(position);
            default:
                assert false : "invalid mode " + mode;
                return -1;
        }
    }
}
