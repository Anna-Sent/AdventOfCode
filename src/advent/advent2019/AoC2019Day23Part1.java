package advent.advent2019;

import java.util.*;

public class AoC2019Day23Part1 {

    public static void main(String[] args) {
        long result;

        String input = "3,62,1001,62,11,10,109,2219,105,1,0,2083,1299,1561,839,944,1652,672,1202,643,2011,1041,1718,1134,1590,1982,1460,744,1072,1918,1621,1171,571,1328,979,610,1749,775,1425,1780,2155,713,1947,874,2188,1270,1528,915,1010,806,2124,1850,1105,1239,1491,1394,1689,1817,1883,2050,1359,0,0,0,0,0,0,0,0,0,0,0,0,3,64,1008,64,-1,62,1006,62,88,1006,61,170,1106,0,73,3,65,21002,64,1,1,20102,1,66,2,21102,105,1,0,1106,0,436,1201,1,-1,64,1007,64,0,62,1005,62,73,7,64,67,62,1006,62,73,1002,64,2,132,1,132,68,132,1001,0,0,62,1001,132,1,140,8,0,65,63,2,63,62,62,1005,62,73,1002,64,2,161,1,161,68,161,1102,1,1,0,1001,161,1,169,1002,65,1,0,1102,1,1,61,1102,0,1,63,7,63,67,62,1006,62,203,1002,63,2,194,1,68,194,194,1006,0,73,1001,63,1,63,1106,0,178,21101,210,0,0,106,0,69,1201,1,0,70,1102,1,0,63,7,63,71,62,1006,62,250,1002,63,2,234,1,72,234,234,4,0,101,1,234,240,4,0,4,70,1001,63,1,63,1106,0,218,1105,1,73,109,4,21102,0,1,-3,21102,0,1,-2,20207,-2,67,-1,1206,-1,293,1202,-2,2,283,101,1,283,283,1,68,283,283,22001,0,-3,-3,21201,-2,1,-2,1105,1,263,22101,0,-3,-3,109,-4,2106,0,0,109,4,21102,1,1,-3,21102,1,0,-2,20207,-2,67,-1,1206,-1,342,1202,-2,2,332,101,1,332,332,1,68,332,332,22002,0,-3,-3,21201,-2,1,-2,1105,1,312,21201,-3,0,-3,109,-4,2106,0,0,109,1,101,1,68,359,20102,1,0,1,101,3,68,366,21002,0,1,2,21102,376,1,0,1106,0,436,21201,1,0,0,109,-1,2106,0,0,1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741824,2147483648,4294967296,8589934592,17179869184,34359738368,68719476736,137438953472,274877906944,549755813888,1099511627776,2199023255552,4398046511104,8796093022208,17592186044416,35184372088832,70368744177664,140737488355328,281474976710656,562949953421312,1125899906842624,109,8,21202,-6,10,-5,22207,-7,-5,-5,1205,-5,521,21102,1,0,-4,21101,0,0,-3,21102,1,51,-2,21201,-2,-1,-2,1201,-2,385,471,20101,0,0,-1,21202,-3,2,-3,22207,-7,-1,-5,1205,-5,496,21201,-3,1,-3,22102,-1,-1,-5,22201,-7,-5,-7,22207,-3,-6,-5,1205,-5,515,22102,-1,-6,-5,22201,-3,-5,-3,22201,-1,-4,-4,1205,-2,461,1106,0,547,21102,1,-1,-4,21202,-6,-1,-6,21207,-7,0,-5,1205,-5,547,22201,-7,-6,-7,21201,-4,1,-4,1106,0,529,22101,0,-4,-7,109,-8,2105,1,0,109,1,101,1,68,563,21001,0,0,0,109,-1,2106,0,0,1101,69259,0,66,1102,1,5,67,1101,598,0,68,1102,1,253,69,1101,0,1,71,1101,0,608,72,1105,1,73,0,0,0,0,0,0,0,0,0,0,29,35198,1102,1,89977,66,1101,0,2,67,1101,0,637,68,1101,302,0,69,1101,0,1,71,1102,641,1,72,1106,0,73,0,0,0,0,47,14667,1101,53887,0,66,1101,0,1,67,1101,0,670,68,1102,556,1,69,1102,0,1,71,1101,672,0,72,1105,1,73,1,1379,1102,1,7559,66,1102,6,1,67,1101,0,699,68,1101,302,0,69,1101,0,1,71,1102,711,1,72,1106,0,73,0,0,0,0,0,0,0,0,0,0,0,0,38,74114,1101,0,64553,66,1102,1,1,67,1101,0,740,68,1102,1,556,69,1101,0,1,71,1102,742,1,72,1106,0,73,1,1499448,21,207777,1102,1,23761,66,1101,1,0,67,1101,771,0,68,1102,556,1,69,1102,1,1,71,1101,0,773,72,1105,1,73,1,160,6,15118,1102,36599,1,66,1102,1,1,67,1101,0,802,68,1102,1,556,69,1101,1,0,71,1102,1,804,72,1105,1,73,1,325,7,305391,1102,1,37057,66,1102,2,1,67,1102,833,1,68,1101,351,0,69,1102,1,1,71,1102,1,837,72,1105,1,73,0,0,0,0,255,68879,1101,0,95987,66,1101,0,3,67,1102,1,866,68,1102,302,1,69,1101,1,0,71,1101,872,0,72,1106,0,73,0,0,0,0,0,0,43,4546,1101,0,33359,66,1101,1,0,67,1102,901,1,68,1101,556,0,69,1101,0,6,71,1101,0,903,72,1105,1,73,1,1,7,203594,5,37419,28,74471,24,89977,47,4889,49,107102,1101,22651,0,66,1102,1,1,67,1102,942,1,68,1102,556,1,69,1101,0,0,71,1101,944,0,72,1105,1,73,1,1998,1101,23599,0,66,1101,3,0,67,1101,971,0,68,1101,0,253,69,1102,1,1,71,1102,977,1,72,1106,0,73,0,0,0,0,0,0,40,3251,1101,0,45589,66,1101,1,0,67,1102,1006,1,68,1101,556,0,69,1102,1,1,71,1101,0,1008,72,1106,0,73,1,230,47,9778,1101,0,36097,66,1102,1,1,67,1102,1037,1,68,1101,556,0,69,1101,0,1,71,1102,1,1039,72,1105,1,73,1,2782580,21,277036,1102,1,38261,66,1101,0,1,67,1101,1068,0,68,1102,1,556,69,1102,1,1,71,1102,1070,1,72,1106,0,73,1,125,12,234489,1102,101977,1,66,1102,1,1,67,1102,1099,1,68,1102,556,1,69,1101,0,2,71,1101,0,1101,72,1105,1,73,1,1151,5,49892,49,53551,1102,90089,1,66,1101,0,1,67,1102,1132,1,68,1101,556,0,69,1101,0,0,71,1101,0,1134,72,1105,1,73,1,1928,1102,1,78163,66,1102,4,1,67,1102,1,1161,68,1102,302,1,69,1102,1,1,71,1102,1169,1,72,1105,1,73,0,0,0,0,0,0,0,0,6,22677,1101,35677,0,66,1102,1,1,67,1101,1198,0,68,1101,0,556,69,1101,1,0,71,1102,1,1200,72,1106,0,73,1,165,5,12473,1102,101797,1,66,1101,0,4,67,1102,1,1229,68,1102,1,302,69,1102,1,1,71,1102,1237,1,72,1106,0,73,0,0,0,0,0,0,0,0,5,24946,1102,14851,1,66,1102,1,1,67,1102,1,1266,68,1101,0,556,69,1101,1,0,71,1102,1,1268,72,1106,0,73,1,179,7,407188,1102,70957,1,66,1102,1,1,67,1102,1,1297,68,1102,556,1,69,1101,0,0,71,1102,1299,1,72,1106,0,73,1,1918,1102,1,84053,66,1102,1,1,67,1101,0,1326,68,1101,556,0,69,1102,1,0,71,1102,1328,1,72,1105,1,73,1,1379,1102,1,50387,66,1102,1,1,67,1102,1355,1,68,1101,556,0,69,1101,1,0,71,1101,1357,0,72,1105,1,73,1,37,28,297884,1102,53551,1,66,1102,1,3,67,1102,1386,1,68,1101,0,302,69,1101,0,1,71,1102,1392,1,72,1106,0,73,0,0,0,0,0,0,27,58567,1101,0,16061,66,1101,1,0,67,1102,1,1421,68,1101,556,0,69,1101,1,0,71,1101,1423,0,72,1106,0,73,1,-283985,21,346295,1102,58567,1,66,1102,1,3,67,1102,1,1452,68,1101,302,0,69,1101,1,0,71,1102,1,1458,72,1105,1,73,0,0,0,0,0,0,43,6819,1101,69389,0,66,1102,1,1,67,1101,1487,0,68,1102,556,1,69,1102,1,1,71,1101,0,1489,72,1105,1,73,1,-556091,21,138518,1101,2273,0,66,1101,0,4,67,1101,0,1518,68,1101,253,0,69,1101,1,0,71,1102,1526,1,72,1105,1,73,0,0,0,0,0,0,0,0,38,37057,1101,0,33287,66,1102,1,1,67,1101,1555,0,68,1102,1,556,69,1102,1,2,71,1101,0,1557,72,1105,1,73,1,2,6,7559,6,30236,1102,1,43651,66,1102,1,1,67,1101,0,1588,68,1102,1,556,69,1102,1,0,71,1102,1,1590,72,1106,0,73,1,1852,1102,67651,1,66,1101,0,1,67,1101,0,1617,68,1101,556,0,69,1102,1,1,71,1102,1,1619,72,1105,1,73,1,-277,28,148942,1101,51199,0,66,1102,1,1,67,1101,1648,0,68,1102,556,1,69,1101,1,0,71,1102,1,1650,72,1106,0,73,1,-45,49,160653,1101,12473,0,66,1102,1,4,67,1102,1679,1,68,1102,302,1,69,1102,1,1,71,1102,1687,1,72,1106,0,73,0,0,0,0,0,0,0,0,43,2273,1101,14983,0,66,1102,1,1,67,1101,1716,0,68,1101,556,0,69,1101,0,0,71,1101,0,1718,72,1105,1,73,1,1598,1102,86371,1,66,1101,1,0,67,1101,1745,0,68,1102,556,1,69,1101,0,1,71,1101,1747,0,72,1105,1,73,1,3,7,101797,1102,92489,1,66,1102,1,1,67,1102,1,1776,68,1102,1,556,69,1101,0,1,71,1102,1778,1,72,1105,1,73,1,1664365,21,69259,1102,74471,1,66,1102,4,1,67,1102,1807,1,68,1101,0,302,69,1101,0,1,71,1102,1815,1,72,1106,0,73,0,0,0,0,0,0,0,0,4,70797,1102,1,72269,66,1102,1,2,67,1101,1844,0,68,1101,302,0,69,1102,1,1,71,1102,1,1848,72,1105,1,73,0,0,0,0,48,28687,1101,0,3251,66,1102,1,2,67,1102,1877,1,68,1102,302,1,69,1102,1,1,71,1101,1881,0,72,1105,1,73,0,0,0,0,46,72269,1101,4889,0,66,1102,3,1,67,1102,1910,1,68,1101,302,0,69,1102,1,1,71,1101,1916,0,72,1106,0,73,0,0,0,0,0,0,4,23599,1101,0,51071,66,1101,0,1,67,1101,1945,0,68,1101,0,556,69,1102,1,0,71,1101,1947,0,72,1106,0,73,1,1815,1101,15679,0,66,1101,0,1,67,1102,1,1974,68,1102,1,556,69,1101,0,3,71,1102,1976,1,72,1106,0,73,1,10,29,17599,12,312652,6,45354,1102,73477,1,66,1101,0,1,67,1102,1,2009,68,1102,1,556,69,1101,0,0,71,1102,2011,1,72,1105,1,73,1,1463,1101,62873,0,66,1101,0,1,67,1102,1,2038,68,1101,556,0,69,1102,1,5,71,1101,2040,0,72,1106,0,73,1,5,40,6502,46,144538,12,78163,12,156326,6,37795,1101,0,28687,66,1101,0,2,67,1102,1,2077,68,1101,0,302,69,1101,1,0,71,1102,1,2081,72,1106,0,73,0,0,0,0,43,9092,1102,1,68879,66,1101,0,1,67,1101,2110,0,68,1101,0,556,69,1101,6,0,71,1102,2112,1,72,1106,0,73,1,25901,48,57374,27,117134,27,175701,3,95987,3,191974,3,287961,1101,99661,0,66,1102,1,1,67,1102,1,2151,68,1102,1,556,69,1102,1,1,71,1101,2153,0,72,1106,0,73,1,56003,24,179954,1101,17599,0,66,1102,1,2,67,1101,2182,0,68,1102,302,1,69,1102,1,1,71,1101,2186,0,72,1106,0,73,0,0,0,0,4,47198,1101,27793,0,66,1102,1,1,67,1102,1,2215,68,1101,556,0,69,1101,1,0,71,1101,2217,0,72,1106,0,73,1,17,28,223413";

        result = test(input);
        assert result == 23954 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static long test(String s) {
        List<Long> values = new ArrayList<>();
        String[] tokens = s.split(",");
        for (String token : tokens) {
            values.add(Long.parseLong(token));
        }

        List<ProgramState> programs = new ArrayList<>();
        for (int i = 0; i < 50; ++i) {
            ProgramState program = new ProgramState(String.valueOf(i), new ArrayList<>(values), Collections.emptyList());
            programs.add(program);
            program.inputs.add((long) i);
        }

        while (true) {
            for (int i = 0; i < 50; ++i) {
                ProgramState program = programs.get(i);
                if (program.inputs.size() == program.inputCounter) {
                    programs.get(i).inputs.add(-1L);
                }
                List<Long> outputs = program.outputs;
                run(program);
                for (int j = 0; j < outputs.size(); j += 3) {
                    int address = outputs.get(j).intValue();
                    long x = outputs.get(j + 1);
                    long y = outputs.get(j + 2);
                    System.out.println(address + " " + x + " " + y);
                    if (address == 255) {
                        return y;
                    }
                    ProgramState toProgram = programs.get(address);
                    toProgram.inputs.add(x);
                    toProgram.inputs.add(y);
                }
                outputs.clear();
            }
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
