package advent2016;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AoC2016Day21Part1Java8 {
    public static void main(String[] args) {
        String result;

        result = solve("abcde", "swap position 4 with position 0");
        System.out.println(result);
        assert result.equals("ebcda");

        result = solve("ebcda", "swap letter d with letter b");
        System.out.println(result);
        assert result.equals("edcba");

        result = solve("edcba", "reverse positions 0 through 4");
        System.out.println(result);
        assert result.equals("abcde");

        result = solve("abcde", "rotate left 1 step");
        System.out.println(result);
        assert result.equals("bcdea");

        result = solve("bcdea", "move position 1 to position 4");
        System.out.println(result);
        assert result.equals("bdeac");

        result = solve("bdeac", "move position 3 to position 0");
        System.out.println(result);
        assert result.equals("abdec");

        result = solve("abdec", "rotate based on position of letter b");
        System.out.println(result);
        assert result.equals("ecabd");

        result = solve("ecabd", "rotate based on position of letter d");
        System.out.println(result);
        assert result.equals("decab");

        result = solve("abcde", "swap position 4 with position 0" + "\n" +
                "swap letter d with letter b" + "\n" +
                "reverse positions 0 through 4" + "\n" +
                "rotate left 1 step" + "\n" +
                "move position 1 to position 4" + "\n" +
                "move position 3 to position 0" + "\n" +
                "rotate based on position of letter b" + "\n" +
                "rotate based on position of letter d");
        System.out.println(result);
        assert result.equals("decab");

        result = solve("abcdefgh", "reverse positions 1 through 6\n" +
                "rotate based on position of letter a\n" +
                "swap position 4 with position 1\n" +
                "reverse positions 1 through 5\n" +
                "move position 5 to position 7\n" +
                "swap position 4 with position 0\n" +
                "swap position 4 with position 6\n" +
                "rotate based on position of letter a\n" +
                "swap position 0 with position 2\n" +
                "move position 5 to position 2\n" +
                "move position 7 to position 1\n" +
                "swap letter d with letter c\n" +
                "swap position 5 with position 3\n" +
                "reverse positions 3 through 7\n" +
                "rotate based on position of letter d\n" +
                "swap position 7 with position 5\n" +
                "rotate based on position of letter f\n" +
                "swap position 4 with position 1\n" +
                "swap position 3 with position 6\n" +
                "reverse positions 4 through 7\n" +
                "rotate based on position of letter c\n" +
                "move position 0 to position 5\n" +
                "swap position 7 with position 4\n" +
                "rotate based on position of letter f\n" +
                "reverse positions 1 through 3\n" +
                "move position 5 to position 3\n" +
                "rotate based on position of letter g\n" +
                "reverse positions 2 through 5\n" +
                "rotate right 0 steps\n" +
                "rotate left 0 steps\n" +
                "swap letter f with letter b\n" +
                "rotate based on position of letter h\n" +
                "move position 1 to position 3\n" +
                "reverse positions 3 through 6\n" +
                "rotate based on position of letter h\n" +
                "swap position 4 with position 3\n" +
                "swap letter b with letter h\n" +
                "swap letter a with letter h\n" +
                "reverse positions 1 through 6\n" +
                "swap position 3 with position 6\n" +
                "swap letter e with letter d\n" +
                "swap letter e with letter h\n" +
                "swap position 1 with position 5\n" +
                "rotate based on position of letter a\n" +
                "reverse positions 4 through 5\n" +
                "swap position 0 with position 4\n" +
                "reverse positions 0 through 3\n" +
                "move position 7 to position 2\n" +
                "swap letter e with letter c\n" +
                "swap position 3 with position 4\n" +
                "rotate left 3 steps\n" +
                "rotate left 7 steps\n" +
                "rotate based on position of letter e\n" +
                "reverse positions 5 through 6\n" +
                "move position 1 to position 5\n" +
                "move position 1 to position 2\n" +
                "rotate left 1 step\n" +
                "move position 7 to position 6\n" +
                "rotate left 0 steps\n" +
                "reverse positions 5 through 6\n" +
                "reverse positions 3 through 7\n" +
                "swap letter d with letter e\n" +
                "rotate right 3 steps\n" +
                "swap position 2 with position 1\n" +
                "swap position 5 with position 7\n" +
                "swap letter h with letter d\n" +
                "swap letter c with letter d\n" +
                "rotate based on position of letter d\n" +
                "swap letter d with letter g\n" +
                "reverse positions 0 through 1\n" +
                "rotate right 0 steps\n" +
                "swap position 2 with position 3\n" +
                "rotate left 4 steps\n" +
                "rotate left 5 steps\n" +
                "move position 7 to position 0\n" +
                "rotate right 1 step\n" +
                "swap letter g with letter f\n" +
                "rotate based on position of letter a\n" +
                "rotate based on position of letter b\n" +
                "swap letter g with letter e\n" +
                "rotate right 4 steps\n" +
                "rotate based on position of letter h\n" +
                "reverse positions 3 through 5\n" +
                "swap letter h with letter e\n" +
                "swap letter g with letter a\n" +
                "rotate based on position of letter c\n" +
                "reverse positions 0 through 4\n" +
                "rotate based on position of letter e\n" +
                "reverse positions 4 through 7\n" +
                "rotate left 4 steps\n" +
                "swap position 0 with position 6\n" +
                "reverse positions 1 through 6\n" +
                "rotate left 2 steps\n" +
                "swap position 5 with position 3\n" +
                "swap letter b with letter d\n" +
                "swap letter b with letter d\n" +
                "rotate based on position of letter d\n" +
                "rotate based on position of letter c\n" +
                "rotate based on position of letter h\n" +
                "move position 4 to position 7");
        System.out.println(result);
        assert result.equals("gfdhebac");
    }

    private static String solve(String word, String s) {
        // the letters at indexes X and Y (counting from 0) should be swapped
        Pattern p1 = Pattern.compile("swap position (\\d+) with position (\\d+)");

        // the letters X and Y should be swapped (regardless of where they appear in the string)
        Pattern p2 = Pattern.compile("swap letter ([a-z]) with letter ([a-z])");

        // the whole string should be rotated; for example, one right rotation would turn abcd into dabc
        Pattern p3 = Pattern.compile("rotate (left|right) (\\d+) steps?");

        // the whole string should be rotated to the right based on the index of letter X (counting from 0)
        // as determined before this instruction does any rotations.
        // Once the index is determined, rotate the string to the right one time,
        // plus a number of times equal to that index, plus one additional time if the index was at least 4
        Pattern p4 = Pattern.compile("rotate based on position of letter ([a-z])");

        // the span of letters at indexes X through Y (including the letters at X and Y) should be reversed in order
        Pattern p5 = Pattern.compile("reverse positions (\\d+) through (\\d+)");

        // the letter which is at index X should be removed from the string,
        // then inserted such that it ends up at index Y
        Pattern p6 = Pattern.compile("move position (\\d+) to position (\\d+)");

        String[] commands = s.split("\n");
        for (String command : commands) {
            Matcher m;

            m = p1.matcher(command);
            if (m.matches()) {
                int X = Integer.parseInt(m.group(1));
                int Y = Integer.parseInt(m.group(2));
                word = swapPositions(word, X, Y);
                continue;
            }

            m = p2.matcher(command);
            if (m.matches()) {
                char X = m.group(1).charAt(0);
                char Y = m.group(2).charAt(0);
                word = swapLetters(word, X, Y);
                continue;
            }

            m = p3.matcher(command);
            if (m.matches()) {
                String option = m.group(1);
                int X = Integer.parseInt(m.group(2));
                switch (option) {
                    case "left":
                        word = rotateLeft(word, X);
                        break;
                    case "right":
                        word = rotateRight(word, X);
                        break;
                }
                continue;
            }

            m = p4.matcher(command);
            if (m.matches()) {
                char X = m.group(1).charAt(0);
                int index = word.indexOf(X);
                index = index >= 4 ? index + 2 : index + 1;
                word = rotateRight(word, index);
                continue;
            }

            m = p5.matcher(command);
            if (m.matches()) {
                int X = Integer.parseInt(m.group(1));
                int Y = Integer.parseInt(m.group(2));
                word = reverse(word, X, Y);
                continue;
            }

            m = p6.matcher(command);
            if (m.matches()) {
                int X = Integer.parseInt(m.group(1));
                int Y = Integer.parseInt(m.group(2));
                word = move(word, X, Y);
                continue;
            }

            throw new RuntimeException("invalid input: " + command);
        }

        return word;
    }

    private static String swapPositions(String s, int X, int Y) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            if (X == i) {
                result += s.charAt(Y);
            } else if (Y == i) {
                result += s.charAt(X);
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    private static String swapLetters(String s, char X, char Y) {
        String result = "";
        for (int i = 0; i < s.length(); ++i) {
            if (X == s.charAt(i)) {
                result += Y;
            } else if (Y == s.charAt(i)) {
                result += X;
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    private static String rotateLeft(String s, int X) {
        String tail = "", head = "";
        X = X % s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (i < X) {
                tail += s.charAt(i);
            } else {
                head += s.charAt(i);
            }
        }
        return head + tail;
    }

    private static String rotateRight(String s, int X) {
        String tail = "", head = "";
        X = X % s.length();
        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - X) {
                tail += s.charAt(i);
            } else {
                head += s.charAt(i);
            }
        }
        return head + tail;
    }

    private static String reverse(String s, int X, int Y) {
        String part1 = s.substring(0, X);
        String part2 = new StringBuilder(s.substring(X, Y + 1)).reverse().toString();
        String part3 = s.substring(Y + 1, s.length());
        return part1 + part2 + part3;
    }

    private static String move(String s, int X, int Y) {
        StringBuilder sb = new StringBuilder(s);
        char charAtX = sb.charAt(X);
        sb.deleteCharAt(X);
        sb.insert(Y, charAtX);
        return sb.toString();
    }
}
