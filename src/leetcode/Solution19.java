package leetcode;

class Solution19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow = head, fast = null, current = head;
            int i = 0;
            while (current != null) {
                slow = slow.next;
                ++i;
                if (i == n) {

                }
                current = current.next;
            }
            return head;
        }
    }
}
