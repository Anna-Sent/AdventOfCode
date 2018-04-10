package leetcode;

class Solution693 {
    class Solution {
        public boolean hasAlternatingBits(int n) {
            int i = n & 1;
            while (n != 0) {
                if ((n & 1) != i) {
                    return false;
                }
                n >>= 1;
                i = ~i & 1;
            }
            return true;
        }
    }
}
