package advent2019;

import java.util.*;

public class AoC2019Day19Part2 {

    public static void main(String[] args) {
        int result;

        result = test("109,424,203,1,21101,11,0,0,1106,0,282,21102,18,1,0,1105,1,259,1201,1,0,221,203,1,21101,0,31,0,1105,1,282,21102,1,38,0,1106,0,259,21001,23,0,2,22101,0,1,3,21102,1,1,1,21101,57,0,0,1106,0,303,1202,1,1,222,21002,221,1,3,20102,1,221,2,21101,259,0,1,21102,1,80,0,1105,1,225,21101,83,0,2,21101,91,0,0,1105,1,303,2102,1,1,223,20102,1,222,4,21102,259,1,3,21101,225,0,2,21101,225,0,1,21102,1,118,0,1105,1,225,20102,1,222,3,21101,0,51,2,21102,1,133,0,1105,1,303,21202,1,-1,1,22001,223,1,1,21102,1,148,0,1106,0,259,1201,1,0,223,21002,221,1,4,21002,222,1,3,21101,13,0,2,1001,132,-2,224,1002,224,2,224,1001,224,3,224,1002,132,-1,132,1,224,132,224,21001,224,1,1,21102,195,1,0,106,0,108,20207,1,223,2,21002,23,1,1,21102,-1,1,3,21101,0,214,0,1106,0,303,22101,1,1,1,204,1,99,0,0,0,0,109,5,2102,1,-4,249,21202,-3,1,1,21202,-2,1,2,22102,1,-1,3,21101,0,250,0,1105,1,225,22102,1,1,-4,109,-5,2106,0,0,109,3,22107,0,-2,-1,21202,-1,2,-1,21201,-1,-1,-1,22202,-1,-2,-2,109,-3,2106,0,0,109,3,21207,-2,0,-1,1206,-1,294,104,0,99,22101,0,-2,-2,109,-3,2105,1,0,109,5,22207,-3,-4,-1,1206,-1,346,22201,-4,-3,-4,21202,-3,-1,-1,22201,-4,-1,2,21202,2,-1,-1,22201,-4,-1,1,22101,0,-2,3,21101,0,343,0,1106,0,303,1105,1,415,22207,-2,-3,-1,1206,-1,387,22201,-3,-2,-3,21202,-2,-1,-1,22201,-3,-1,3,21202,3,-1,-1,22201,-3,-1,2,21202,-4,1,1,21102,384,1,0,1106,0,303,1105,1,415,21202,-4,-1,-4,22201,-4,-3,-4,22202,-3,-2,-2,22202,-2,-4,-4,22202,-3,-2,-3,21202,-4,-1,-2,22201,-3,-2,1,22101,0,1,-4,109,-5,2105,1,0");
        assert result == 8381082 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        List<Long> values = new ArrayList<>();
        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Long.parseLong(token));
        }

        Map<Integer, Integer> xMinY = new HashMap<>();
        Map<Integer, Integer> yMinX = new HashMap<>();
        for (int x = 0; x < 2000; ++x) {
            for (int y = 0; y < 2000; ++y) {
                ProgramState program = new ProgramState("test", new ArrayList<>(values), Collections.emptyList());
                program.inputs.add((long) x);
                program.inputs.add((long) y);
                run(program);
                int output = program.outputs.get(0).intValue();
                if (output == 1) {
                    Integer minY = xMinY.get(x);
                    if (minY == null || y < minY) {
                        xMinY.put(x, y);
                    }

                    Integer minX = yMinX.get(y);
                    if (minX == null || x < minX) {
                        yMinX.put(y, x);
                    }

                    int dx = x;
                    int dy = xMinY.get(dx);
                    dx -= 99;
                    dy += 99;
                    Integer sx = yMinX.get(dy);
                    if (sx != null && dx == sx) {
                        return sx * 10000 + (dy - 99);
                    }
                } else {
                    assert output == 0 : "invalid output";
                }
            }
        }

        return -1;
    }

    private static void run(ProgramState state) {
        for (; !state.completed; ) {
            assert state.i >= 0 : "invalid i " + state.i;
            assert state.values.containsKey(state.i) : "invalid i " + state.i + ": no value";
            long cmd = state.values.get(state.i);

            int A = (int) (cmd / 10000 % 10);
            int B = (int) (cmd / 1000 % 10);
            int C = (int) (cmd / 100 % 10);

            int DE = (int) (cmd % 100);

            switch (DE) {

                case 1: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    long sum = first + second;
                    state.values.put(result, sum);
                    state.i += 4;
                    break;
                }

                case 2: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    long mul = first * second;
                    state.values.put(result, mul);
                    state.i += 4;
                    break;
                }

                case 3: {
                    if (state.inputCounter == state.inputs.size()) {
                        System.out.println("wait for input");
                        return;
                    }
                    long input = state.inputs.get(state.inputCounter);
                    ++state.inputCounter;
                    System.out.println(state.name + " in: " + input);
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    long result = getParamValue(state.values, state.i + 1, C, state.relativeBase, true);
                    state.values.put(result, input);
                    state.i += 2;
                    break;
                }

                case 4: {
                    assert A == 0 : "a not 0";
                    assert B == 0 : "b not 0";
                    long result = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    System.out.println(state.name + " out: " + result);
                    state.outputs.add(result);
                    state.i += 2;
                    break;
                }

                case 5: {
                    assert A == 0 : "a not 0";
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    if (first == 0) {
                        state.i += 3;
                    } else {
                        state.i = second;
                    }
                    break;
                }

                case 6: {
                    assert A == 0 : "a not 0";
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    if (first == 0) {
                        state.i = second;
                    } else {
                        state.i += 3;
                    }
                    break;
                }

                case 7: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    if (first < second) {
                        state.values.put(result, 1L);
                    } else {
                        state.values.put(result, 0L);
                    }
                    state.i += 4;
                    break;
                }

                case 8: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    long second = getParamValue(state.values, state.i + 2, B, state.relativeBase);
                    long result = getParamValue(state.values, state.i + 3, A, state.relativeBase, true);
                    if (first == second) {
                        state.values.put(result, 1L);
                    } else {
                        state.values.put(result, 0L);
                    }
                    state.i += 4;
                    break;
                }

                case 9: {
                    long first = getParamValue(state.values, state.i + 1, C, state.relativeBase);
                    state.relativeBase += first;
                    state.i += 2;
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

    private static long getParamValue(Map<Long, Long> values, long position, int mode, long relativeBase) {
        return getParamValue(values, position, mode, relativeBase, false);
    }

    private static long getParamValue(Map<Long, Long> values, long position, int mode, long relativeBase, boolean result) {
        switch (mode) {
            case 0:
                // position
                return result ? values.get(position) : values.getOrDefault(values.get(position), 0L);
            case 1:
                // immediate
                return values.get(position);
            case 2:
                // relative
                return result ? values.get(position) + relativeBase : values.getOrDefault(values.get(position) + relativeBase, 0L);
            default:
                assert false : "invalid mode " + mode;
                return -1;
        }
    }

    private static class ProgramState {

        List<Long> inputs = new ArrayList<>();
        List<Long> outputs = new ArrayList<>();

        String name;
        Map<Long, Long> values = new HashMap<>();

        boolean completed;
        long i;
        int inputCounter;
        long relativeBase;

        ProgramState(String name, List<Long> values, List<Long> inputs) {
            this.name = name;
            for (int i = 0; i < values.size(); ++i) {
                this.values.put((long) i, values.get(i));
            }
            this.inputs.addAll(inputs);
        }

        ProgramState(ProgramState program) {
            this.inputs = new ArrayList<>(program.inputs);
            this.outputs = new ArrayList<>(program.outputs);
            this.name = program.name;
            this.values = new HashMap<>(program.values);
            this.completed = program.completed;
            this.i = program.i;
            this.inputCounter = program.inputCounter;
            this.relativeBase = program.relativeBase;
        }
    }
}
