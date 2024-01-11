package leetcode;

public class Solution283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int write = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != 0) {
                    nums[write++] = nums[i];
                }
            }
            while (write < nums.length) {
                nums[write++] = 0;
            }
        }
    }
}
