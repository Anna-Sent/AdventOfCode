package advent2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC2019Day7Part2 {

    public static void main(String[] args) {
        int result;

        result = test("3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5",
                Arrays.asList(9, 8, 7, 6, 5));
        assert result == 139629729 : "unexpected result is " + result;
        System.out.println(result);

        result = test("3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,-5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10",
                Arrays.asList(9, 7, 8, 5, 6));
        assert result == 18216 : "unexpected result is " + result;
        System.out.println(result);

        result = testWithPermutations(
                "3,8,1001,8,10,8,105,1,0,0,21,30,55,76,97,114,195,276,357,438,99999,3,9,102,3,9,9,4,9,99,3,9,1002,9,3,9,1001,9,5,9,1002,9,2,9,1001,9,2,9,102,2,9,9,4,9,99,3,9,1002,9,5,9,1001,9,2,9,102,5,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,102,5,9,9,101,4,9,9,1002,9,4,9,4,9,99,3,9,101,2,9,9,102,4,9,9,1001,9,5,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,2,9,9,4,9,99",
                Arrays.asList(5, 6, 7, 8, 9));
        assert result == 4374895 : "unexpected result is " + result;
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

    private static int test(String program, List<Integer> phases) {
        List<Integer> values = new ArrayList<>();
        String[] tokens = program.split(",");
        for (String token : tokens) {
            values.add(Integer.parseInt(token));
        }

        List<ProgramState> programs = new ArrayList<>();
        for (int i = 0; i < phases.size(); ++i) {
            ProgramState state = new ProgramState(String.valueOf((char) ('A' + i)), false, 0, new ArrayList<>(values), 0);
            programs.add(state);
        }

        int prevOutput = 0;
        for (int i = 0; ; ++i) {
            int j = i % phases.size();
            run(programs.get(j), Arrays.asList(phases.get(j), prevOutput));
            prevOutput = programs.get(j).lastOutput;
            if (isCompleted(programs)) {
                break;
            }
        }
        return prevOutput;
    }

    private static boolean isCompleted(List<ProgramState> programs) {
        for (ProgramState program : programs) {
            if (!program.completed) {
                return false;
            }
        }
        return true;
    }

    private static void run(ProgramState state, List<Integer> inputs) {
        for (; !state.completed; ) {
            int cmd = state.values.get(state.i);

            int A = cmd / 10000 % 10;
            int B = cmd / 1000 % 10;
            int C = cmd / 100 % 10;

            int DE = cmd % 100;

            switch (DE) {

                case 1: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    int result = getParamValue(state.values, state.i + 3, 1);
                    int sum = first + second;
                    state.values.set(result, sum);
                    state.i += 4;
                    break;
                }

                case 2: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    int result = getParamValue(state.values, state.i + 3, 1);
                    int mul = first * second;
                    state.values.set(result, mul);
                    state.i += 4;
                    break;
                }

                case 3: {
                    if (state.inputCounter == inputs.size()) {
                        state.inputCounter = 1;
                        return;
                    }
                    int input = inputs.get(state.inputCounter);
                    ++state.inputCounter;
                    System.out.println(state.name + " in: " + input);
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    int result = getParamValue(state.values, state.i + 1, 1);
                    state.values.set(result, input);
                    state.i += 2;
                    break;
                }

                case 4: {
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    int result = getParamValue(state.values, state.i + 1, C);
                    System.out.println(state.name + " out: " + result);
                    state.lastOutput = result;
                    state.i += 2;
                    break;
                }

                case 5: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    if (first == 0) {
                        state.i += 3;
                    } else {
                        state.i = second;
                    }
                    break;
                }

                case 6: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    if (first == 0) {
                        state.i = second;
                    } else {
                        state.i += 3;
                    }
                    break;
                }

                case 7: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    int result = getParamValue(state.values, state.i + 3, 1);
                    if (first < second) {
                        state.values.set(result, 1);
                    } else {
                        state.values.set(result, 0);
                    }
                    state.i += 4;
                    break;
                }

                case 8: {
                    int first = getParamValue(state.values, state.i + 1, C);
                    int second = getParamValue(state.values, state.i + 2, B);
                    int result = getParamValue(state.values, state.i + 3, 1);
                    if (first == second) {
                        state.values.set(result, 1);
                    } else {
                        state.values.set(result, 0);
                    }
                    state.i += 4;
                    break;
                }

                case 99:
                    state.completed = true;
                    break;

                default:
                    assert false : "unexpected value " + state.i;
            }
        }
    }

    private static int getParamValue(List<Integer> values, int position, int mode) {
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

    private static class ProgramState {

        ProgramState(String name, boolean completed, int i, List<Integer> values, int inputCounter) {
            this.name = name;
            this.completed = completed;
            this.i = i;
            this.values = values;
            this.inputCounter = inputCounter;
        }

        String name;
        boolean completed;
        int i;
        List<Integer> values;
        int inputCounter;
        int lastOutput;
    }
}
