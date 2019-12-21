package advent2019;

import java.util.*;

public class AoC2019Day21Part2 {

    public static void main(String[] args) {
        long result;

        result = test("109,2050,21102,1,966,1,21101,0,13,0,1106,0,1378,21102,1,20,0,1105,1,1337,21102,1,27,0,1105,1,1279,1208,1,65,748,1005,748,73,1208,1,79,748,1005,748,110,1208,1,78,748,1005,748,132,1208,1,87,748,1005,748,169,1208,1,82,748,1005,748,239,21101,1041,0,1,21102,1,73,0,1106,0,1421,21102,1,78,1,21102,1041,1,2,21102,1,88,0,1106,0,1301,21102,68,1,1,21101,0,1041,2,21102,103,1,0,1105,1,1301,1102,1,1,750,1105,1,298,21102,82,1,1,21102,1,1041,2,21102,1,125,0,1106,0,1301,1102,1,2,750,1105,1,298,21102,1,79,1,21101,1041,0,2,21101,147,0,0,1105,1,1301,21101,84,0,1,21102,1,1041,2,21102,1,162,0,1106,0,1301,1101,3,0,750,1106,0,298,21102,65,1,1,21101,0,1041,2,21102,1,184,0,1105,1,1301,21101,0,76,1,21102,1041,1,2,21102,1,199,0,1106,0,1301,21102,75,1,1,21101,1041,0,2,21101,0,214,0,1106,0,1301,21102,1,221,0,1106,0,1337,21102,1,10,1,21101,0,1041,2,21101,236,0,0,1106,0,1301,1105,1,553,21102,85,1,1,21101,1041,0,2,21102,254,1,0,1105,1,1301,21101,0,78,1,21101,0,1041,2,21102,1,269,0,1106,0,1301,21102,276,1,0,1106,0,1337,21102,1,10,1,21101,0,1041,2,21101,0,291,0,1105,1,1301,1101,1,0,755,1106,0,553,21102,1,32,1,21102,1041,1,2,21102,313,1,0,1105,1,1301,21102,320,1,0,1105,1,1337,21102,1,327,0,1105,1,1279,1201,1,0,749,21101,0,65,2,21101,73,0,3,21102,1,346,0,1105,1,1889,1206,1,367,1007,749,69,748,1005,748,360,1102,1,1,756,1001,749,-64,751,1105,1,406,1008,749,74,748,1006,748,381,1102,-1,1,751,1106,0,406,1008,749,84,748,1006,748,395,1101,-2,0,751,1105,1,406,21101,0,1100,1,21101,0,406,0,1106,0,1421,21102,32,1,1,21101,1100,0,2,21102,1,421,0,1105,1,1301,21101,0,428,0,1106,0,1337,21102,1,435,0,1105,1,1279,2101,0,1,749,1008,749,74,748,1006,748,453,1101,0,-1,752,1105,1,478,1008,749,84,748,1006,748,467,1101,-2,0,752,1105,1,478,21102,1,1168,1,21101,0,478,0,1106,0,1421,21102,1,485,0,1106,0,1337,21101,0,10,1,21102,1168,1,2,21102,1,500,0,1106,0,1301,1007,920,15,748,1005,748,518,21102,1,1209,1,21101,518,0,0,1106,0,1421,1002,920,3,529,1001,529,921,529,1001,750,0,0,1001,529,1,537,1002,751,1,0,1001,537,1,545,101,0,752,0,1001,920,1,920,1106,0,13,1005,755,577,1006,756,570,21101,0,1100,1,21101,570,0,0,1105,1,1421,21102,987,1,1,1105,1,581,21102,1001,1,1,21101,0,588,0,1106,0,1378,1101,0,758,593,1002,0,1,753,1006,753,654,21001,753,0,1,21101,0,610,0,1106,0,667,21102,0,1,1,21102,621,1,0,1105,1,1463,1205,1,647,21102,1,1015,1,21101,635,0,0,1106,0,1378,21101,0,1,1,21102,646,1,0,1105,1,1463,99,1001,593,1,593,1106,0,592,1006,755,664,1102,0,1,755,1106,0,647,4,754,99,109,2,1101,0,726,757,22101,0,-1,1,21102,1,9,2,21101,0,697,3,21101,0,692,0,1105,1,1913,109,-2,2105,1,0,109,2,1002,757,1,706,1201,-1,0,0,1001,757,1,757,109,-2,2105,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,255,63,127,159,95,191,223,0,183,137,122,152,170,220,185,115,56,250,69,85,218,138,186,101,174,125,87,50,79,214,84,166,187,71,245,70,233,47,93,156,99,242,107,254,153,110,77,167,181,116,175,182,46,68,171,154,163,126,189,141,200,102,106,212,76,227,249,235,207,78,60,203,173,251,188,216,204,196,222,248,252,197,198,238,61,117,49,124,168,179,103,108,139,184,39,121,234,120,241,243,219,221,94,199,205,123,92,178,155,54,143,172,229,226,109,162,206,140,98,142,35,177,62,230,246,118,86,215,213,232,237,158,228,136,247,57,113,114,100,253,236,111,59,244,38,55,231,157,201,190,42,217,51,43,34,53,239,169,202,58,119,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,73,110,112,117,116,32,105,110,115,116,114,117,99,116,105,111,110,115,58,10,13,10,87,97,108,107,105,110,103,46,46,46,10,10,13,10,82,117,110,110,105,110,103,46,46,46,10,10,25,10,68,105,100,110,39,116,32,109,97,107,101,32,105,116,32,97,99,114,111,115,115,58,10,10,58,73,110,118,97,108,105,100,32,111,112,101,114,97,116,105,111,110,59,32,101,120,112,101,99,116,101,100,32,115,111,109,101,116,104,105,110,103,32,108,105,107,101,32,65,78,68,44,32,79,82,44,32,111,114,32,78,79,84,67,73,110,118,97,108,105,100,32,102,105,114,115,116,32,97,114,103,117,109,101,110,116,59,32,101,120,112,101,99,116,101,100,32,115,111,109,101,116,104,105,110,103,32,108,105,107,101,32,65,44,32,66,44,32,67,44,32,68,44,32,74,44,32,111,114,32,84,40,73,110,118,97,108,105,100,32,115,101,99,111,110,100,32,97,114,103,117,109,101,110,116,59,32,101,120,112,101,99,116,101,100,32,74,32,111,114,32,84,52,79,117,116,32,111,102,32,109,101,109,111,114,121,59,32,97,116,32,109,111,115,116,32,49,53,32,105,110,115,116,114,117,99,116,105,111,110,115,32,99,97,110,32,98,101,32,115,116,111,114,101,100,0,109,1,1005,1262,1270,3,1262,20101,0,1262,0,109,-1,2106,0,0,109,1,21102,1288,1,0,1105,1,1263,21002,1262,1,0,1102,1,0,1262,109,-1,2105,1,0,109,5,21102,1310,1,0,1106,0,1279,22102,1,1,-2,22208,-2,-4,-1,1205,-1,1332,21201,-3,0,1,21101,0,1332,0,1105,1,1421,109,-5,2105,1,0,109,2,21101,0,1346,0,1105,1,1263,21208,1,32,-1,1205,-1,1363,21208,1,9,-1,1205,-1,1363,1105,1,1373,21102,1,1370,0,1106,0,1279,1105,1,1339,109,-2,2105,1,0,109,5,2101,0,-4,1386,20102,1,0,-2,22101,1,-4,-4,21102,1,0,-3,22208,-3,-2,-1,1205,-1,1416,2201,-4,-3,1408,4,0,21201,-3,1,-3,1105,1,1396,109,-5,2105,1,0,109,2,104,10,21201,-1,0,1,21101,0,1436,0,1106,0,1378,104,10,99,109,-2,2105,1,0,109,3,20002,593,753,-1,22202,-1,-2,-1,201,-1,754,754,109,-3,2106,0,0,109,10,21102,1,5,-5,21102,1,1,-4,21101,0,0,-3,1206,-9,1555,21102,1,3,-6,21102,1,5,-7,22208,-7,-5,-8,1206,-8,1507,22208,-6,-4,-8,1206,-8,1507,104,64,1105,1,1529,1205,-6,1527,1201,-7,716,1515,21002,0,-11,-8,21201,-8,46,-8,204,-8,1105,1,1529,104,46,21201,-7,1,-7,21207,-7,22,-8,1205,-8,1488,104,10,21201,-6,-1,-6,21207,-6,0,-8,1206,-8,1484,104,10,21207,-4,1,-8,1206,-8,1569,21102,1,0,-9,1105,1,1689,21208,-5,21,-8,1206,-8,1583,21102,1,1,-9,1106,0,1689,1201,-5,716,1588,21002,0,1,-2,21208,-4,1,-1,22202,-2,-1,-1,1205,-2,1613,22102,1,-5,1,21101,1613,0,0,1105,1,1444,1206,-1,1634,21201,-5,0,1,21102,1627,1,0,1106,0,1694,1206,1,1634,21102,2,1,-3,22107,1,-4,-8,22201,-1,-8,-8,1206,-8,1649,21201,-5,1,-5,1206,-3,1663,21201,-3,-1,-3,21201,-4,1,-4,1105,1,1667,21201,-4,-1,-4,21208,-4,0,-1,1201,-5,716,1676,22002,0,-1,-1,1206,-1,1686,21102,1,1,-4,1106,0,1477,109,-10,2106,0,0,109,11,21102,0,1,-6,21102,0,1,-8,21101,0,0,-7,20208,-6,920,-9,1205,-9,1880,21202,-6,3,-9,1201,-9,921,1725,20101,0,0,-5,1001,1725,1,1733,20102,1,0,-4,22102,1,-4,1,21102,1,1,2,21101,9,0,3,21101,1754,0,0,1106,0,1889,1206,1,1772,2201,-10,-4,1767,1001,1767,716,1767,20102,1,0,-3,1105,1,1790,21208,-4,-1,-9,1206,-9,1786,22102,1,-8,-3,1105,1,1790,22102,1,-7,-3,1001,1733,1,1795,21001,0,0,-2,21208,-2,-1,-9,1206,-9,1812,22102,1,-8,-1,1105,1,1816,21202,-7,1,-1,21208,-5,1,-9,1205,-9,1837,21208,-5,2,-9,1205,-9,1844,21208,-3,0,-1,1106,0,1855,22202,-3,-1,-1,1106,0,1855,22201,-3,-1,-1,22107,0,-1,-1,1106,0,1855,21208,-2,-1,-9,1206,-9,1869,21202,-1,1,-8,1106,0,1873,21201,-1,0,-7,21201,-6,1,-6,1106,0,1708,21201,-8,0,-10,109,-11,2106,0,0,109,7,22207,-6,-5,-3,22207,-4,-6,-2,22201,-3,-2,-1,21208,-1,0,-6,109,-7,2105,1,0,0,109,5,1202,-2,1,1912,21207,-4,0,-1,1206,-1,1930,21102,1,0,-4,21201,-4,0,1,21202,-3,1,2,21101,0,1,3,21102,1,1949,0,1105,1,1954,109,-5,2106,0,0,109,6,21207,-4,1,-1,1206,-1,1977,22207,-5,-3,-1,1206,-1,1977,21202,-5,1,-5,1106,0,2045,21202,-5,1,1,21201,-4,-1,2,21202,-3,2,3,21102,1,1996,0,1106,0,1954,22102,1,1,-5,21102,1,1,-2,22207,-5,-3,-1,1206,-1,2015,21101,0,0,-2,22202,-3,-2,-3,22107,0,-4,-1,1206,-1,2037,21201,-2,0,1,21101,0,2037,0,105,1,1912,21202,-3,-1,-3,22201,-5,-3,-5,109,-6,2106,0,0");
        assert result == 1141236756 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static long test(String s) {
        List<Long> values = new ArrayList<>();
        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Long.parseLong(token));
        }

        ProgramState program = new ProgramState("test", new ArrayList<>(values), Collections.emptyList());
        run(program);

        List<String> commands = Arrays.asList(
                "OR A T",
                "AND B T",
                "AND C T",
                "NOT T T",
                "AND D T",
                "NOT T T",
                "NOT T J",

                "NOT J T",
                "OR E T",
                "OR H T",
                "AND T J",

                "RUN"
        );

        for (String command : commands) {
            for (int i = 0; i < command.length(); ++i) {
                program.inputs.add((long) command.charAt(i));
            }
            program.inputs.add((long) '\n');
        }

        run(program);

        return program.outputs.get(program.outputs.size() - 1);
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
                    System.out.print((char) result);
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
                    System.out.println();
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
