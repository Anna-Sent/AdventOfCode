package leetcode;

import java.util.Arrays;

class Solution204 {
    class Solution {
        public int countPrimes(int n) {
            if (n <= 0) {
                return 0;
            }
            boolean prime[] = new boolean[n + 1];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;
            for (int i = 2; i * i <= n; ++i) {
                if (prime[i]) {
                    for (int j = i * 2; j <= n; j += i) {
                        prime[j] = false;
                    }
                }
            }
            int[] counts = new int[n + 1];
            counts[0] = counts[1] = 0;
            for (int i = 2; i <= n; ++i) {
                counts[i] = counts[i - 1];
                if (prime[i]) {
                    ++counts[i];
                }
            }
            return counts[n - 1];
        }
    }
}
