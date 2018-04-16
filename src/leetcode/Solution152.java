package leetcode;

public class Solution152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int localMax = nums[0];
            int localMin = nums[0];
            int maxProd = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] > 0) {
                    localMax = Math.max(localMax * nums[i], nums[i]);
                    localMin = Math.min(localMin * nums[i], nums[i]);
                } else {
                    int localMaxNeg = Math.max(localMin * nums[i], nums[i]);
                    localMin = Math.min(localMax * nums[i], nums[i]);
                    localMax = localMaxNeg;
                }
                maxProd = Math.max(maxProd, localMax);
            }
            return maxProd;
        }
    }
}
