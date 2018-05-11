package leetcode;

public class Solution342 {
    class Solution {
        public boolean isPowerOfFour(int num) {
            if (num <= 0) {
                return false;
            }
            int ones = 0, zeros = 0, d;
            while (num > 0) {
                d = num & 1;
                ones += d;
                zeros += 1 - d;
                num >>>= 1;
            }
            return ones == 1 && (zeros & 1) == 0;
        }
    }
}
