package leetcode;

import java.util.Arrays;

class Solution567 {
    class Solution {
        private static final int CHAR_COUNT = 'z' - 'a' + 1;

        public boolean checkInclusion(String s1, String s2) {
            int substringlen = s1.length();
            int stringlen = s2.length();
            if (substringlen > stringlen) {
                return false;
            }
            if (stringlen == 0) {
                return false;
            }
            if (substringlen == 0) {
                return true;
            }
            char[] string = s2.toCharArray();
            char[] substring = s1.toCharArray();
            int index;

            int[] subfreq = new int[CHAR_COUNT];
            for (int i = 0; i < substringlen; ++i) {
                index = substring[i] - 'a';
                ++subfreq[index];
            }

            int[] freq = new int[CHAR_COUNT];
            for (int i = 0; i < substringlen; ++i) {
                index = string[i] - 'a';
                ++freq[index];
            }

            if (Arrays.equals(subfreq, freq)) {
                return true;
            }

            for (int i = 1; i < stringlen - substringlen + 1; ++i) {

                index = string[i - 1] - 'a';
                --freq[index];

                index = string[i + substringlen - 1] - 'a';
                ++freq[index];

                if (Arrays.equals(subfreq, freq)) {
                    return true;
                }
            }
            return false;
        }
    }
}
