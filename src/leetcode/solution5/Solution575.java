package leetcode.solution5;

import java.util.Arrays;

class Solution575 {
    class Solution {
        public int distributeCandies(int[] candies) {
            Arrays.sort(candies);
            int count = 0, i = 0, prev = 0;
            while (i < candies.length && count < candies.length / 2) {
                if (i == 0 || candies[i] != prev) {
                    ++count;
                }
                prev = candies[i];
                ++i;
            }
            return count;
        }
    }
}
