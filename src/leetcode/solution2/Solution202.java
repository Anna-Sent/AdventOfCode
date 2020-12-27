package leetcode.solution2;

import java.util.HashSet;
import java.util.Set;

class Solution202 {
    class Solution {
        public boolean isHappy(int n) {
            if (n <= 0) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            int current = n;
            do {
                set.add(current);
                int num = current;
                current = 0;
                while (num > 0) {
                    int digit = num % 10;
                    current += digit * digit;
                    num /= 10;
                }
            } while (current != 1 && !set.contains(current));
            return current == 1;
        }
    }
}
