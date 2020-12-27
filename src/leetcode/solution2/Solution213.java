package leetcode.solution2;

class Solution213 {
    static class Solution {
        private static int rob(int[] nums, int start, int end) {
            int prev = 0, curr = 0;
            for (int i = start; i < end; ++i) {
                int tmp = curr;
                curr = Math.max(prev + nums[i], curr);
                prev = tmp;
            }
            return curr;
        }

        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
        }
    }
}
