package leetcode;

class Solution38 {
    class Solution {
        public String countAndSay(int n) {
            char[] s = new char[]{'1'};
            StringBuilder next = new StringBuilder();
            for (int i = 1; i < n; ++i) {
                next.setLength(0);
                for (int j = 0; j < s.length; ) {
                    char countedSym = s[j];
                    int count = 0;
                    do {
                        ++j;
                        ++count;
                    } while (j < s.length && countedSym == s[j]);
                    next.append(count).append(countedSym);
                }
                s = next.toString().toCharArray();
            }
            return String.valueOf(s);
        }
    }
}
