package leetcode;

class Solution9 {
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            long palindrome = 0;
            int xCopy = x;
            while (x > 0) {
                palindrome = palindrome * 10 + (x % 10);
                x /= 10;
            }
            return palindrome == xCopy;
        }
    }
}
