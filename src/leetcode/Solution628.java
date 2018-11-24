package leetcode;

import java.util.Arrays;

class Solution628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int product1 = nums[len - 3] * nums[len - 2] * nums[len - 1];
            int product2 = nums[0] * nums[1] * nums[len - 1];
            return Math.max(product1, product2);
        }
    }
}
