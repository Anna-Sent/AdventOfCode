package advent.advent2019;

import utils.Point;

import java.util.*;

public class AoC2019Day15Part1 {

    public static void main(String[] args) {
        int result;

        result = test("3,1033,1008,1033,1,1032,1005,1032,31,1008,1033,2,1032,1005,1032,58,1008,1033,3,1032,1005,1032,81,1008,1033,4,1032,1005,1032,104,99,102,1,1034,1039,1001,1036,0,1041,1001,1035,-1,1040,1008,1038,0,1043,102,-1,1043,1032,1,1037,1032,1042,1105,1,124,102,1,1034,1039,102,1,1036,1041,1001,1035,1,1040,1008,1038,0,1043,1,1037,1038,1042,1105,1,124,1001,1034,-1,1039,1008,1036,0,1041,101,0,1035,1040,1002,1038,1,1043,1001,1037,0,1042,1105,1,124,1001,1034,1,1039,1008,1036,0,1041,102,1,1035,1040,1002,1038,1,1043,102,1,1037,1042,1006,1039,217,1006,1040,217,1008,1039,40,1032,1005,1032,217,1008,1040,40,1032,1005,1032,217,1008,1039,5,1032,1006,1032,165,1008,1040,1,1032,1006,1032,165,1101,0,2,1044,1105,1,224,2,1041,1043,1032,1006,1032,179,1102,1,1,1044,1105,1,224,1,1041,1043,1032,1006,1032,217,1,1042,1043,1032,1001,1032,-1,1032,1002,1032,39,1032,1,1032,1039,1032,101,-1,1032,1032,101,252,1032,211,1007,0,56,1044,1105,1,224,1102,0,1,1044,1106,0,224,1006,1044,247,102,1,1039,1034,1001,1040,0,1035,101,0,1041,1036,102,1,1043,1038,102,1,1042,1037,4,1044,1106,0,0,40,31,67,22,98,81,11,5,82,25,86,22,69,15,21,97,6,6,62,50,91,14,90,37,26,50,98,4,55,61,39,20,93,19,70,47,50,8,85,97,24,91,12,79,38,62,13,99,4,63,48,75,93,2,4,62,72,51,63,23,12,8,80,87,54,13,99,85,2,66,45,93,13,2,87,86,14,25,27,12,87,49,58,51,77,25,5,97,13,35,48,64,63,11,76,32,18,79,37,88,12,85,85,4,69,71,29,27,66,33,7,66,72,51,74,87,13,48,42,34,67,26,13,96,25,65,83,46,72,99,25,62,3,50,72,99,65,37,75,39,68,39,11,75,27,70,90,39,62,69,31,17,57,43,27,28,54,87,7,97,72,25,93,30,59,20,74,59,7,8,94,96,36,86,9,35,81,74,21,73,15,59,6,80,42,5,67,34,55,95,96,31,98,70,50,17,64,36,79,34,31,20,58,60,9,4,55,39,94,49,17,95,81,85,31,26,62,80,4,71,80,17,37,80,97,9,16,25,89,6,46,76,50,99,20,62,73,6,79,66,96,2,42,72,45,96,30,94,73,42,38,63,12,36,68,70,50,54,26,74,49,92,26,33,38,66,65,79,90,55,37,71,48,66,5,57,86,17,42,89,5,97,81,46,99,74,19,69,13,86,60,93,7,16,86,42,81,26,95,91,93,14,94,76,91,33,44,42,58,87,26,41,9,22,63,1,82,63,20,49,50,71,75,5,32,73,14,45,98,50,91,54,69,61,27,60,40,88,16,34,18,64,18,50,81,67,67,28,95,7,89,80,37,26,97,25,29,58,77,60,22,22,43,64,15,66,69,33,20,50,84,70,53,11,64,80,16,80,74,15,90,67,33,12,57,8,52,78,10,18,25,40,82,63,93,93,28,18,51,68,58,6,60,58,14,54,72,68,91,41,70,67,3,74,18,3,27,65,71,11,11,99,49,88,21,42,7,78,35,4,78,2,2,82,26,65,97,67,46,63,1,68,55,85,94,16,1,22,41,67,86,35,10,83,64,11,95,50,46,86,74,5,68,81,62,22,75,68,26,58,40,62,44,38,65,22,69,20,90,5,10,42,99,96,51,63,64,7,64,36,92,89,54,4,68,63,85,9,38,95,89,51,50,75,86,5,41,40,59,31,82,99,8,95,5,43,45,60,60,29,84,15,5,96,64,55,97,44,35,7,93,96,43,22,50,20,70,81,39,8,90,50,66,49,31,29,34,97,90,1,59,3,5,82,85,85,47,29,6,65,31,70,76,33,35,82,43,98,62,29,44,76,70,59,89,30,25,97,83,75,79,43,98,93,40,59,36,55,64,29,31,98,65,47,33,91,75,62,71,68,38,33,81,10,73,83,6,13,88,92,45,94,15,1,88,59,22,7,36,89,59,36,12,80,3,80,78,29,85,75,28,7,15,82,41,1,81,26,7,72,46,85,71,16,40,73,11,81,7,24,10,87,75,9,87,35,40,86,5,16,69,98,45,43,8,68,20,83,73,47,86,77,35,89,71,1,37,62,62,65,44,26,83,52,87,89,40,62,61,97,7,42,79,9,1,64,99,86,5,86,51,23,25,32,71,28,91,26,87,64,47,17,2,90,64,42,10,85,36,31,79,75,79,21,59,5,9,88,12,36,74,59,72,6,82,34,80,10,78,81,33,91,22,94,18,88,10,63,23,87,58,65,20,66,74,65,18,96,22,98,13,86,48,67,14,96,58,73,14,67,2,65,48,92,42,93,18,96,32,81,0,0,21,21,1,10,1,0,0,0,0,0,0");
        assert result == 296 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static int test(String s) {
        List<Long> values = new ArrayList<>();
        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Long.parseLong(token));
        }

        Point initialPoint = new Point(0, 0);
        ProgramState initialProgram = new ProgramState("test", new ArrayList<>(values), Collections.emptyList());
        State initialState = new State();
        initialState.point = initialPoint;
        initialState.program = initialProgram;

        Map<Point, Character> map = new HashMap<>();
        map.put(initialPoint, '.');

        return bfs(map, initialState);
    }

    private static int bfs(Map<Point, Character> map, State initialState) {
        Set<State> closed = new HashSet<>();
        Set<State> opened = new HashSet<>();

        int count = 0;
        opened.add(initialState);
        while (opened.size() > 0) {
            Set<State> achievable = new HashSet<>();
            for (State current : opened) {
                if (map.getOrDefault(current.point, '.') == 'O') {
                    return count;
                }
                Set<State> set = generateNext(current, map);
                for (State next : set) {
                    if (!closed.contains(next)) {
                        achievable.add(next);
                    }
                }

                closed.add(current);
            }

            ++count;
            opened = achievable;
        }
        return count;
    }

    private static Set<State> generateNext(State state, Map<Point, Character> map) {
        Set<State> next = new HashSet<>();
        Point nextPoint = null;
        State nextState;

        for (int i = 1; i <= 4; ++i) {
            switch (i) {
                case 1:
                    // n
                    nextPoint = new Point(state.point.x, state.point.y + 1);
                    break;
                case 2:
                    // s
                    nextPoint = new Point(state.point.x, state.point.y - 1);
                    break;
                case 3:
                    // w
                    nextPoint = new Point(state.point.x - 1, state.point.y);
                    break;
                case 4:
                    // e
                    nextPoint = new Point(state.point.x + 1, state.point.y);
                    break;
            }
            nextState = generateNext(state, map, nextPoint, i);
            if (nextState != null) {
                next.add(nextState);
            }
        }

        return next;
    }

    private static State generateNext(State state, Map<Point, Character> map, Point nextPoint, int i) {
        if (map.getOrDefault(nextPoint, '.') == '.') {
            ProgramState copy = new ProgramState(state.program);
            copy.inputs.add((long) i);
            run(copy);
            int status = copy.outputs.get(copy.outputs.size() - 1).intValue();
            State nextState = new State();
            nextState.point = nextPoint;
            nextState.program = copy;
            switch (status) {
                case 0:
                    map.put(nextPoint, '#');
                    return null;
                case 1:
                    map.put(nextPoint, '.');
                    return nextState;
                case 2:
                    map.put(nextPoint, 'O');
                    return nextState;
            }
        }
        return null;
    }

    private static class State {

        Point point;
        ProgramState program;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state1 = (State) o;
            return Objects.equals(point, state1.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point);
        }
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
