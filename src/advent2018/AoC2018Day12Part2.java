package advent2018;

import java.util.ArrayList;
import java.util.List;

public class AoC2018Day12Part2 {
    public static void main(String[] args) {
        long result;

        result = test("##.###.......#..#.##..#####...#...#######....##.##.##.##..#.#.##########...##.##..##.##...####..####",
                "#.#.# => #\n" +
                        ".##.. => .\n" +
                        "#.#.. => .\n" +
                        "..### => #\n" +
                        ".#..# => #\n" +
                        "..#.. => .\n" +
                        "####. => #\n" +
                        "###.. => #\n" +
                        "#.... => .\n" +
                        ".#.#. => #\n" +
                        "....# => .\n" +
                        "#...# => #\n" +
                        "..#.# => #\n" +
                        "#..#. => #\n" +
                        ".#... => #\n" +
                        "##..# => .\n" +
                        "##... => .\n" +
                        "#..## => .\n" +
                        ".#.## => #\n" +
                        ".##.# => .\n" +
                        "#.##. => #\n" +
                        ".#### => .\n" +
                        ".###. => .\n" +
                        "..##. => .\n" +
                        "##.#. => .\n" +
                        "...## => #\n" +
                        "...#. => .\n" +
                        "..... => .\n" +
                        "##.## => .\n" +
                        "###.# => #\n" +
                        "##### => #\n" +
                        "#.### => .");
        assert result == 1150000000457L : "unexpected result is " + result;
        System.out.println(result);
    }

    public static long test(String initialState, String rulesString) {
        List<Rule> rules = new ArrayList<>();
        String[] tokens = rulesString.split("\n");
        for (String token : tokens) {
            String[] parts = token.split(" => ");
            Rule rule = new Rule();
            rule.left = parts[0].toCharArray();
            rule.right = parts[1].charAt(0);
            rules.add(rule);
        }

        char[] state = initialState.toCharArray();
        int delta = 0;
        int prevSum = 0, prevDeltaSum = 0;
        for (int i = 1; ; ++i) {
            delta += 2;
            char[] newState = new char[state.length + 4];
            for (int j = 0; j < newState.length; ++j) {
                newState[j] = '.';
            }
            for (int j = 0; j < newState.length; ++j) {
                for (Rule rule : rules) {
                    if (rule.matches(state, j - 2)) {
                        newState[j] = rule.right;
                    }
                }
            }
            state = newState;
            int newSum = 0;
            for (int j = 0; j < state.length; ++j) {
                if (state[j] == '#') {
                    newSum += j - delta;
                }
            }
            int deltaSum = newSum - prevSum;
            System.out.println(i + ": " + newSum + " " + deltaSum);
            if (prevDeltaSum == deltaSum) {
                return prevSum + prevDeltaSum * (50000000000L - i + 1);
            }
            prevSum = newSum;
            prevDeltaSum = deltaSum;
        }
    }

    private static class Rule {
        char[] left;
        char right;

        boolean matches(char[] state, int index) {
            for (int i = -2; i <= 2; ++i) {
                char ch1 = index + i >= 0 && index + i < state.length ? state[index + i] : '.';
                char ch2 = left[2 + i];
                if (ch1 != ch2) {
                    return false;
                }
            }
            return true;
        }
    }
}
