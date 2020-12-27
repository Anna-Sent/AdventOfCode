package leetcode.solution3;

import java.util.TreeSet;

class Solution313_Java {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            TreeSet<Long> numbers = new TreeSet<>();
            int count = 0;
            long i = 1;
            numbers.add(1L);
            while (count < n) {
                ++count;
                for (int prime : primes) {
                    numbers.add(i * prime);
                }
                i = numbers.higher(i);
            }
            return numbers.lower(i).intValue();
        }
    }
}
