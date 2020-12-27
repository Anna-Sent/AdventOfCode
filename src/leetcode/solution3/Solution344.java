package leetcode.solution3;

class Solution344 {
    class Solution {
        public String reverseString(String s) {
            char[] chars = s.toCharArray();
            char tmp;
            int len = chars.length;
            for (int i = 0; i < len / 2; ++i) {
                tmp = chars[i];
                chars[i] = chars[len - 1 - i];
                chars[len - 1 - i] = tmp;
            }
            return String.valueOf(chars);
        }
    }
}
