package leetcode;

class Solution260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            //int differentBit = xor & ~(xor - 1);
            int differentBit = 1;
            while ((xor & differentBit) == 0) {
                differentBit <<= 1;
            }
            int x = 0;
            int y = 0;
            for (int num : nums) {
                if ((num & differentBit) == 0) {
                    y ^= num;
                } else {
                    x ^= num;
                }
            }
            return new int[]{x, y};
        }
    }
}
