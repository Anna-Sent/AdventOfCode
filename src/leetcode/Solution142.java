package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution142 {
    private static Solution solution;
    private static int testCaseNumber;

    static abstract class Solution {
        public abstract ListNode detectCycle(ListNode head);

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    static class Solution1 extends Solution {
        @Override
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> opened = new HashSet<>();
            ListNode current = head;
            while (current != null) {
                if (opened.contains(current)) {
                    return current;
                }
                opened.add(current);
                current = current.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        test(new Solution1());
    }

    private static void test(Solution solution) {
        Solution142.solution = solution;
        testCaseNumber = 1;
        test(null, -1);
        test(ListNode.createList(new int[0]), -1);
        test(ListNode.createList(new int[]{1}), -1);
        test(ListNode.createList(new int[]{1, 1}), 1);
        test(ListNode.createList(new int[]{1, 2}), -1);
        test(ListNode.createList(new int[]{1, 2, 1}), 1);
        test(ListNode.createList(new int[]{1, 2, 2}), 2);
        test(ListNode.createList(new int[]{1, 2, 3, 2}), 2);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 3}), 3);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 1}), 1);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 7}), -1);
    }

    private static void test(ListNode head, int expected) {
        ListNode listNode = solution.detectCycle(head);
        int actual = listNode == null ? -1 : listNode.val;
        assert expected == actual : "failed test case " + solution + "-" + testCaseNumber
                + ": expected is " + expected + ", actual is " + actual;
        ++testCaseNumber;
    }
}
