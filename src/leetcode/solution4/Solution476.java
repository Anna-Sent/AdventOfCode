package leetcode.solution4;

class Solution476 {
    class Solution {
        public int findComplement(int num) {
            if (num < 0) {
                return 0;
            }
            if (num == 0) {
                return 1;
            }
            int result = 0;
            int p = 1;
            while (num > 0) {
                result += (1 - (num & 1)) * p;
                num >>>= 1;
                p <<= 1;
            }
            return result;
        }
    }
}
