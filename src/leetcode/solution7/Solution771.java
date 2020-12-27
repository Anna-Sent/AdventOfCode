package leetcode.solution7;

class Solution771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            int count = 0;
            for (int i = 0; i < S.length(); ++i) {
                char sS = S.charAt(i);
                for (int j = 0; j < J.length(); ++j) {
                    char jJ = J.charAt(j);
                    if (jJ == sS) {
                        ++count;
                        break;
                    }
                }
            }
            return count;
        }
    }
}
