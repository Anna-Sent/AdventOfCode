package leetcode;

class Solution70 {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] solutions = new int[n];
            solutions[0] = 1;
            solutions[1] = 2;
            for (int i = 2; i < n; ++i) {
                solutions[i] = solutions[i - 1] + solutions[i - 2];
            }
            return solutions[n - 1];
        }
    }
}
