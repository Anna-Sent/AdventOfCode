package advent.advent2019;

import java.util.HashSet;
import java.util.Set;

public class AoC2019Day24Part1 {

    public static void main(String[] args) {
        int result;

        result = test("....#\n" +
                "#..#.\n" +
                "#..##\n" +
                "..#..\n" +
                "#....");
        assert result == 2129920 : "unexpected result is " + result;
        System.out.println(result);

        result = test(".##.#\n" +
                "###..\n" +
                "#...#\n" +
                "##.#.\n" +
                ".###.");
        assert result == 1151290 : "unexpected result is " + result;
        System.out.println(result);
    }

    private static final int SIZE = 5;
    private static final int LAST = SIZE - 1;

    private static int test(String s) {
        char[][] state = new char[SIZE][];
        for (int i = 0; i < SIZE; ++i) {
            state[i] = new char[SIZE];
        }
        String[] tokens = s.split("\n");
        for (int i = 0; i < SIZE; ++i) {
            char[] chars = tokens[i].toCharArray();
            for (int j = 0; j < SIZE; ++j) {
                state[i][j] = chars[j];
            }
        }

        Set<State> states = new HashSet<>();
        states.add(new State(state));
        for (; ; ) {
            char[][] stateCopy = new char[SIZE][];
            for (int i = 0; i < SIZE; ++i) {
                stateCopy[i] = new char[SIZE];
            }
            for (int i = 0; i < SIZE; ++i) {
                for (int j = 0; j < SIZE; ++j) {
                    char[] adjacents = adjacents(state, i, j);
                    int bugsCount = bugsCount(adjacents);
                    if (state[i][j] == '#') {
                        if (bugsCount == 1) {
                            stateCopy[i][j] = '#';
                        } else {
                            stateCopy[i][j] = '.';
                        }
                    } else {
                        if (bugsCount == 1 || bugsCount == 2) {
                            stateCopy[i][j] = '#';
                        } else {
                            stateCopy[i][j] = state[i][j];
                        }
                    }
                }
            }
            state = stateCopy;
            State newState = new State(state);
            if (states.contains(newState)) {
                break;
            }
            states.add(newState);
        }

        int sum = 0, k = 1;
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                if (state[i][j] == '#') {
                    sum += k;
                }
                k *= 2;
            }
        }
        return sum;
    }

    private static int bugsCount(char[] chars) {
        int count = 0;
        for (char ch : chars) {
            if (ch == '#') {
                ++count;
            }
        }
        return count;
    }

    private static char[] adjacents(char[][] state, int i, int j) {
        char[] result = new char[4];
        result[0] = i < LAST ? state[i + 1][j] : 0;
        result[1] = j < LAST ? state[i][j + 1] : 0;
        result[2] = i > 0 ? state[i - 1][j] : 0;
        result[3] = j > 0 ? state[i][j - 1] : 0;
        return result;
    }

    private static class State {

        char[][] chars;

        State(char[][] chars) {
            this.chars = chars;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            for (int i = 0; i < SIZE; ++i) {
                for (int j = 0; j < SIZE; ++j) {
                    if (chars[i][j] != state.chars[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;

            for (int i = 0; i < SIZE; ++i) {
                for (int j = 0; j < SIZE; ++j) {
                    result = 31 * result + Character.hashCode(chars[i][j]);
                }
            }

            return result;
        }
    }
}
