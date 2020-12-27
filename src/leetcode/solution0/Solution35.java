package leetcode.solution0;

import java.util.Arrays;

class Solution35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int index = Arrays.binarySearch(nums, target);
            return index >= 0 ? index : -index - 1;
        }
    }
}
