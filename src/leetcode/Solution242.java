package leetcode;

public class Solution242 {
    class Solution {
        private static final int CHAR_COUNT = 'z' - 'a' + 1;

        public boolean isAnagram(String s, String t) {
            int len = s.length();
            if (len != t.length()) {
                return false;
            }
            if (len == 0) {
                return true;
            }
            char[] s1 = s.toCharArray();
            char[] s2 = t.toCharArray();
            int index;
            int[] freq = new int[CHAR_COUNT];
            for (int i = 0; i < len; ++i) {
                index = s1[i] - 'a';
                ++freq[index];
                index = s2[i] - 'a';
                --freq[index];
            }
            for (int i = 0; i < CHAR_COUNT; ++i) {
                if (freq[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
