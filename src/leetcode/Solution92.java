package leetcode;

class Solution92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode mnode = null, nnode = null, prevmnode = null, nextnnode = null, current = head, prev = null, tmp;
            int i = 1;
            while (current != null && i <= n) {
                if (i == m) {
                    prevmnode = prev;
                    mnode = current;
                }
                if (i == n) {
                    nnode = current;
                    nextnnode = current.next;
                }
                if (i >= m && i <= n) {
                    tmp = current.next;
                    current.next = prev;
                    prev = current;
                    current = tmp;
                } else {
                    prev = current;
                    current = current.next;
                }
                ++i;
            }
            if (prevmnode != null) {
                prevmnode.next = nnode;
            }
            mnode.next = nextnnode;
            return m == 1 ? nnode : head;
        }
    }
}
