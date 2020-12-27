package leetcode.solution0;

class Solution27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int count = 0;
            int len = nums.length;
            int write = 0;
            for (int i = 0; i < len; ++i) {
                if (nums[i] == val) {
                    ++count;
                } else {
                    nums[write] = nums[i];
                    ++write;
                }
            }
            return len - count;
        }
    }
}
