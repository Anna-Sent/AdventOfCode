class Solution {
    public int hammingDistance(int x, int y) {
        int d = 1;
        int count = 0;
        for (int i = 0; i < 32; ++i) {
            int x1 = x & d;
            int y1 = y & d;
            if (x1 != y1) {
                ++count;
            }
            d = d << 1;
        }
        return count;
    }
}
