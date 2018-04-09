package leetcode;

class Solution206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode current = head, prev = null, tmp;
            while (current != null) {
                tmp = current.next;
                current.next = prev;
                prev = current;
                current = tmp;
            }
            return prev;
        }
    }
}
