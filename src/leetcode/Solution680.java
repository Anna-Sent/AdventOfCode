package leetcode;

class Solution680 {
    static class Solution {
        public boolean validPalindrome(String s) {
            if (s.length() <= 2) {
                return true;
            }
            char[] chars = s.toCharArray();
            return validPalindrome(chars, true) || validPalindrome(chars, false);
        }

        private boolean validPalindrome(char[] chars, boolean deleteLeft) {
            int len = chars.length;
            int half = len >> 1;
            boolean deleted = false;
            int left = 0, right = len - 1;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    if (deleted) {
                        return false;
                    } else {
                        if (left + 1 == right || right - 1 == left) {
                            return true;
                        }
                        if (deleteLeft && chars[left + 1] == chars[right]) {
                            deleted = true;
                            ++left;
                        } else if (!deleteLeft && chars[right - 1] == chars[left]) {
                            deleted = true;
                            --right;
                        } else {
                            return false;
                        }
                    }
                }
                ++left;
                --right;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        test("", true);
        test("a", true);
        test("ab", true);
        test("aba", true);
        test("abba", true);

        test("zabba", true);
        test("azbba", true);
        test("abbza", true);
        test("abbaz", true);

        test("azbbaz", false);
        test("abbazz", false);
        test("zzabba", false);

        test("zaba", true);
        test("azba", true);
        test("abza", true);
        test("abazz", false);

        test("zaa", true);
        test("aaz", true);
        test("azaz", true);

        test("cuucu", true);
        test("ucuuc", true);
        test("abbab", true);
        test("babba", true);
        test("ebcbbececabbacecbbcbe", true);
        test("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga", true);
    }

    private static void test(String s, boolean expected) {
        boolean actual = new Solution().validPalindrome(s);
        assert expected == actual : "failed with " + s + ": expected is " + expected + ", actual is " + actual;
    }
}
