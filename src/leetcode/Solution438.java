package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution438 {
    class Solution {
        private static final int CHAR_COUNT = 'z' - 'a' + 1;

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int substringlen = p.length();
            int stringlen = s.length();
            if (substringlen > stringlen) {
                return result;
            }
            char[] string = s.toCharArray();
            char[] substring = p.toCharArray();
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

            int mismatch = 0;
            for (int i = 0; i < CHAR_COUNT; ++i) {
                if (subfreq[i] != freq[i]) {
                    ++mismatch;
                }
            }

            if (mismatch == 0) {
                result.add(0);
            }

            for (int i = 1; i < stringlen - substringlen + 1; ++i) {

                index = string[i - 1] - 'a';
                boolean hadMatch = freq[index] == subfreq[index];
                --freq[index];
                if (hadMatch && subfreq[index] != freq[index]) {
                    ++mismatch;
                }
                if (!hadMatch && subfreq[index] == freq[index]) {
                    --mismatch;
                }

                index = string[i + substringlen - 1] - 'a';
                hadMatch = freq[index] == subfreq[index];
                ++freq[index];
                if (hadMatch && subfreq[index] != freq[index]) {
                    ++mismatch;
                }
                if (!hadMatch && subfreq[index] == freq[index]) {
                    --mismatch;
                }

                if (mismatch == 0) {
                    result.add(i);
                }
            }
            return result;
        }
    }
}
