package leetcode;

class Solution21 {
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode c1 = l1, c2 = l2;
            ListNode head = null, current = null, node;
            while (c1 != null && c2 != null) {
                int val1 = c1.val;
                int val2 = c2.val;
                if (val1 < val2) {
                    node = new ListNode(val1);
                    c1 = c1.next;
                } else {
                    node = new ListNode(val2);
                    c2 = c2.next;
                }
                if (head == null) {
                    head = node;
                } else {
                    current.next = node;
                }
                current = node;
            }
            ListNode tail = c1 == null ? (c2 == null ? null : c2) : c1;
            while (tail != null) {
                node = new ListNode(tail.val);
                if (head == null) {
                    head = node;
                } else {
                    current.next = node;
                }
                current = node;
                tail = tail.next;
            }
            return head;
        }
    }
}
