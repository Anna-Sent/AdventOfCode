package advent2016;

import utils.FileUtils;

import java.io.IOException;

public class AoC2016Day7Part1 {

    public static void main(String[] args) throws IOException {
        int result;

        result = test("abba[mnop]qrst");
        assert result == 1;
        System.out.println(result);

        result = test("abcd[bddb]xyyx");
        assert result == 0;
        System.out.println(result);

        result = test("aaaa[qwer]tyui");
        assert result == 0;
        System.out.println(result);

        result = test("ioxxoj[asdfgh]zxcvbn");
        assert result == 1;
        System.out.println(result);

        result = test(FileUtils.readToString("C:\\Users\\Anna\\workspace\\AdventOfCode\\src\\advent2016\\AoC2016Day7Input.txt"));
        assert result == 118;
        System.out.println(result);
    }

    public static int test(String s) {
        int count = 0;

        String[] parts = s.split("\r\n");
        for (String part : parts) {
            if (supportsTls(part)) {
                ++count;
            }
        }

        return count;
    }

    private static boolean supportsTls(String s) {
        boolean contains = false;
        for (int i = 0; i < s.length() - 3; ++i) {
            if (s.charAt(i) == '[') {
                while (i < s.length() && s.charAt(i) != ']') {
                    ++i;
                    if (i < s.length() - 3 && s.charAt(i) == s.charAt(i + 3)
                            && s.charAt(i + 1) == s.charAt(i + 2)
                            && s.charAt(i) != s.charAt(i + 1)) {
                        return false;
                    }
                }
                continue;
            }
            if (s.charAt(i) == s.charAt(i + 3)
                    && s.charAt(i + 1) == s.charAt(i + 2)
                    && s.charAt(i) != s.charAt(i + 1)) {
                contains = true;
            }
        }

        return contains;
    }
}