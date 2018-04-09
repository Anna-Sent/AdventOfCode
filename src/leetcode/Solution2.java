package leetcode;

class Solution2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode result = null, pr = null;
            int add = 0;
            while (p1 != null || p2 != null || add != 0) {
                int a1 = p1 == null ? 0 : p1.val;
                int a2 = p2 == null ? 0 : p2.val;
                int s = a1 + a2 + add;
                add = s / 10;
                ListNode newNode = new ListNode(s % 10);
                if (pr == null) {
                    pr = newNode;
                    result = pr;
                } else {
                    pr.next = newNode;
                    pr = newNode;
                }
                if (p1 != null) {
                    p1 = p1.next;
                }
                if (p2 != null) {
                    p2 = p2.next;
                }
            }
            return result;
        }
    }
}
