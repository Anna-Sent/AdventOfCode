package leetcode;

import java.util.TreeSet;

class Solution264 {
    class Solution {
        public int nthUglyNumber(int n) {
            if (n <= 0) {
                return -1;
            }
            TreeSet<Long> numbers = new TreeSet<>();
            int count = 0;
            long i = 1;
            numbers.add(1l);
            while (count < n) {
                ++count;
                numbers.add(i * 2);
                numbers.add(i * 3);
                numbers.add(i * 5);
                i = numbers.higher(i);
            }
            return numbers.lower(i).intValue();
        }
    }
}
