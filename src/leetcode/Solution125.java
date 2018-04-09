package leetcode;

class Solution125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.length() == 0 || s.length() == 1) {
                return true;
            }
            char[] chars = s.toCharArray();
            int read = 0, write = 0;
            while (read < chars.length) {
                char ch = chars[read++];
                if (ch >= 'a' && ch <= 'z' || ch >= '0' && ch <= '9') {
                    chars[write++] = ch;
                } else if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) ('a' + ch - 'A');
                    chars[write++] = ch;
                }
            }
            int len = write >> 1;
            for (int i = 0; i < len; ++i) {
                if (chars[i] != chars[write - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
