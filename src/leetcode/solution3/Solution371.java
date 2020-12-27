package leetcode.solution3;

class Solution371 {
    class Solution {
        public int getSum(int a, int b) {
            int d = 1;
            int result = 0;
            int add = 0;
            for (int i = 0; i < 32; ++i) {
                int a1 = a & d;
                int b1 = b & d;
                int sum = a1 ^ b1 ^ (add << i);
                add = a1 != 0 && b1 != 0 || a1 != 0 && add != 0 || b1 != 0 && add != 0 ? 1 : 0;
                result = result | sum;
                d = d << 1;
            }
            return result;
        }
    }
}
