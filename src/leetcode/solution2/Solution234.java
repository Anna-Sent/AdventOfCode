package leetcode.solution2;

import leetcode.ListNode;

class Solution234 {
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode tail = head;
            int count = 1;
            while (tail.next != null) {
                tail = tail.next;
                ++count;
            }
            int half = count >> 1;
            ListNode secondHead = head;
            int i = 1;
            while (i <= half) {
                secondHead = secondHead.next;
                ++i;
            }
            if ((count & 1) == 1) {
                secondHead = secondHead.next;
            }
            ListNode prev = null, tmp;
            while (secondHead != null) {
                tmp = secondHead.next;
                secondHead.next = prev;
                prev = secondHead;
                secondHead = tmp;
            }
            secondHead = tail;
            while (secondHead != null && head != null) {
                if (secondHead.val != head.val) {
                    return false;
                }
                secondHead = secondHead.next;
                head = head.next;
            }
            return true;
        }
    }
}
