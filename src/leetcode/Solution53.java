package leetcode;

public class Solution53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0], currMax = max;
            for (int i = 1; i < nums.length; ++i) {
                currMax = Math.max(nums[i], nums[i] + currMax);
                max = Math.max(currMax, max);
            }
            return max;
        }
    }
}
