package advent2017;

import java.util.HashMap;
import java.util.Map;

import static advent2017.AoC2017Day25.State.*;

public class AoC2017Day25 {
    public static void main(String[] args) {
        int result;

        result = test();
        assert result == 3362 : "unexpected result is " + result;
        System.out.println(result);
    }

    public static int test() {
        Map<Integer, Integer> tape = new HashMap<>();
        State state = A;
        int cursor = 0;
        for (int i = 0; i < 12481997; ++i) {
            switch (state) {
                case A: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 1);
                        ++cursor;
                        state = B;
                    } else {
                        tape.put(cursor, 0);
                        --cursor;
                        state = C;
                    }
                    break;
                }
                case B: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 1);
                        --cursor;
                        state = A;
                    } else {
                        tape.put(cursor, 1);
                        ++cursor;
                        state = D;
                    }
                    break;
                }
                case C: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 0);
                        --cursor;
                        state = B;
                    } else {
                        tape.put(cursor, 0);
                        --cursor;
                        state = E;
                    }
                    break;
                }
                case D: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 1);
                        ++cursor;
                        state = A;
                    } else {
                        tape.put(cursor, 0);
                        ++cursor;
                        state = B;
                    }
                    break;
                }
                case E: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 1);
                        --cursor;
                        state = F;
                    } else {
                        tape.put(cursor, 1);
                        --cursor;
                        state = C;
                    }
                    break;
                }
                case F: {
                    int value = getValue(tape, cursor);
                    if (value == 0) {
                        tape.put(cursor, 1);
                        ++cursor;
                        state = D;
                    } else {
                        tape.put(cursor, 1);
                        ++cursor;
                        state = A;
                    }
                    break;
                }
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : tape.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }

    private static int getValue(Map<Integer, Integer> tape, int cursor) {
        Integer value = tape.get(cursor);
        return value == null ? 0 : value;
    }

    enum State {
        A, B, C, D, E, F
    }
}
