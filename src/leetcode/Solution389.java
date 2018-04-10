package leetcode;

class Solution389 {
    class Solution {
        public char findTheDifference(String s, String t) {
            char[] schars = s.toCharArray();
            char[] tchars = t.toCharArray();
            for (int i = 0; i < tchars.length; ++i) {
                char ch = tchars[i];
                boolean found = false;
                for (int j = 0; j < schars.length; ++j) {
                    if (ch == schars[j]) {
                        tchars[i] = '\0';
                        schars[j] = '\0';
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return ch;
                }
            }
            int i = 0;
            while (tchars[i++] == '\0') ;
            return tchars[i - 1];
        }
    }
}
