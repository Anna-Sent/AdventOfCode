package leetcode.solution2;

class Solution275 {
    class Solution {
        public int hIndex(int[] citations) {
            int N = citations.length;
            for (int i = N; i >= 1; --i) {
                boolean accepted = citations[N - 1] >= i && citations[N - i] >= i;
                if (accepted) {
                    return i;
                }
            }
            return 0;
        }
    }
}
