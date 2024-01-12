package advent.advent2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AoC2019Day5Part2 {

    public static void main(String[] args) {
        test("3,225,1,225,6,6,1100,1,238,225,104,0,1101,86,8,225,1101,82,69,225,101,36,65,224,1001,224,-106,224,4,224,1002,223,8,223,1001,224,5,224,1,223,224,223,102,52,148,224,101,-1144,224,224,4,224,1002,223,8,223,101,1,224,224,1,224,223,223,1102,70,45,225,1002,143,48,224,1001,224,-1344,224,4,224,102,8,223,223,101,7,224,224,1,223,224,223,1101,69,75,225,1001,18,85,224,1001,224,-154,224,4,224,102,8,223,223,101,2,224,224,1,224,223,223,1101,15,59,225,1102,67,42,224,101,-2814,224,224,4,224,1002,223,8,223,101,3,224,224,1,223,224,223,1101,28,63,225,1101,45,22,225,1101,90,16,225,2,152,92,224,1001,224,-1200,224,4,224,102,8,223,223,101,7,224,224,1,223,224,223,1101,45,28,224,1001,224,-73,224,4,224,1002,223,8,223,101,7,224,224,1,224,223,223,1,14,118,224,101,-67,224,224,4,224,1002,223,8,223,1001,224,2,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,7,677,677,224,102,2,223,223,1005,224,329,1001,223,1,223,1008,226,226,224,1002,223,2,223,1005,224,344,1001,223,1,223,1107,677,226,224,1002,223,2,223,1006,224,359,1001,223,1,223,107,677,677,224,102,2,223,223,1005,224,374,101,1,223,223,1108,677,226,224,102,2,223,223,1005,224,389,1001,223,1,223,1007,677,677,224,1002,223,2,223,1005,224,404,101,1,223,223,1008,677,226,224,102,2,223,223,1005,224,419,101,1,223,223,1108,226,677,224,102,2,223,223,1006,224,434,1001,223,1,223,8,677,226,224,1002,223,2,223,1005,224,449,101,1,223,223,1008,677,677,224,1002,223,2,223,1006,224,464,1001,223,1,223,1108,226,226,224,1002,223,2,223,1005,224,479,1001,223,1,223,1007,226,677,224,102,2,223,223,1005,224,494,1001,223,1,223,1007,226,226,224,102,2,223,223,1005,224,509,101,1,223,223,107,677,226,224,1002,223,2,223,1006,224,524,1001,223,1,223,108,677,677,224,102,2,223,223,1006,224,539,101,1,223,223,7,677,226,224,102,2,223,223,1006,224,554,1001,223,1,223,1107,226,677,224,102,2,223,223,1005,224,569,101,1,223,223,108,677,226,224,1002,223,2,223,1006,224,584,101,1,223,223,108,226,226,224,102,2,223,223,1006,224,599,1001,223,1,223,1107,226,226,224,102,2,223,223,1006,224,614,1001,223,1,223,8,226,677,224,102,2,223,223,1006,224,629,1001,223,1,223,107,226,226,224,102,2,223,223,1005,224,644,101,1,223,223,8,226,226,224,102,2,223,223,1006,224,659,101,1,223,223,7,226,677,224,102,2,223,223,1005,224,674,101,1,223,223,4,223,99,226");
        // input 5
        // must output 14195011
    }

    private static final List<Integer> values = new ArrayList<>();

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

    private static int test(String s) {
        values.clear();

        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Integer.parseInt(token));
        }

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
                    Scanner in = new Scanner(System.in);
                    int input = in.nextInt();
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
                    System.out.println(result);
                    i += 2;
                    break;
                }

                case 5: {
                    assert A == 0 : "a not 0";
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
                    assert A == 0 : "a not 0";
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

        return 0;
    }
}
