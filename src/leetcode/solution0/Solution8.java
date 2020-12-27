package leetcode.solution0;

class Solution8 {
    class Solution {
        public int myAtoi(String str) {
            str = str.trim();
            if (str.length() == 0)
                return 0;
            char ch = str.charAt(0);
            int sign = 1, i = 0;
            if (ch == '+') {
                i = 1;
            } else if (ch == '-') {
                sign = -1;
                i = 1;
            }
            long result = 0;
            while (i < str.length()) {
                ch = str.charAt(i);
                if (ch < '0' || ch > '9') {
                    break;
                }
                result = result * 10 + (ch - '0');
                if (sign * result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign * result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                ++i;
            }
            return sign * (int) result;
        }
    }
}
