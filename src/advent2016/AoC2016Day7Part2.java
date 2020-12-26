package advent2016;

import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AoC2016Day7Part2 {

    public static void main(String[] args) throws IOException {
        int result;

        result = test("aba[bab]xyz");
        assert result == 1;
        System.out.println(result);

        result = test("xyx[xyx]xyx");
        assert result == 0;
        System.out.println(result);

        result = test("aaa[kek]eke");
        assert result == 1;
        System.out.println(result);

        result = test("zazbz[bzb]cdb");
        assert result == 1;
        System.out.println(result);

        result = test(FileUtils.readToString("advent2016", "AoC2016Day7_input.txt"));
        assert result == 260;
        System.out.println(result);
    }

    private static int test(String s) {
        int count = 0;

        String[] parts = s.split("\r\n");
        for (String part : parts) {
            if (supportsSsl(part)) {
                ++count;
            }
        }

        return count;
    }

    private static boolean supportsSsl(String s) {
        List<String> listABA = new ArrayList<>();
        for (int i = 0; i < s.length() - 2; ++i) {
            if (s.charAt(i) == '[') {
                while (i < s.length() && s.charAt(i) != ']') {
                    ++i;
                }
                continue;
            }
            if (s.charAt(i) == s.charAt(i + 2)
                    && s.charAt(i) != s.charAt(i + 1)) {
                StringBuilder sb = new StringBuilder().append(s.charAt(i))
                        .append(s.charAt(i + 1));
                listABA.add(sb.toString());
            }
        }

        if (listABA.size() == 0) {
            return false;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '[') {
                while (i < s.length() && s.charAt(i) != ']') {
                    ++i;
                    if (i < s.length() - 3 && s.charAt(i) == s.charAt(i + 2)
                            && s.charAt(i) != s.charAt(i + 1)) {
                        for (String aba : listABA) {
                            if (aba.charAt(0) == s.charAt(i + 1)
                                    && aba.charAt(1) == s.charAt(i)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}