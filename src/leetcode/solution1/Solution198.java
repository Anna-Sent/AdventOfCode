package leetcode.solution1;

class Solution198 {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] best = new int[nums.length];
            best[0] = nums[0];
            if (nums.length > 1) {
                best[1] = Math.max(nums[0], nums[1]);
            }
            for (int i = 2; i < nums.length; ++i) {
                best[i] = Math.max(nums[i] + best[i - 2], best[i - 1]);
            }
            return best[best.length - 1];
        }
    }
}
