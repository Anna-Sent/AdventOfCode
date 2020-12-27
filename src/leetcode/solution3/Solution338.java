package leetcode.solution3;

class Solution338 {
    class Solution {
        public int[] countBits(int num) {
            if (num < 0) {
                num = 0;
            }
            int[] result = new int[num + 1];
            if (num == 0) {
                return result;
            }
            result[1] = 1;
            int interval = 1, len = result.length;
            for (int i = 2; i < len; i += interval) {
                for (int j = 0; j < interval; ++j) {
                    int x = result[i + j - interval];
                    if (i + j < len) result[i + j] = x;
                    if (i + j + interval < len) result[i + j + interval] = x + 1;
                }
                interval *= 2;
            }
            return result;
        }
    }
}
