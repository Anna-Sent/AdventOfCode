package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution141 {
    private static Solution solution;
    private static int testCaseNumber;

    public static void main(String[] args) {
        test(new Solution1());
        test(new Solution2());
        test(new Solution3());
    }

    private static void test(Solution solution) {
        Solution141.solution = solution;
        testCaseNumber = 1;
        test(null, false);
        test(ListNode.createList(new int[0]), false);
        test(ListNode.createList(new int[]{1}), false);
        test(ListNode.createList(new int[]{1, 1}), true);
        test(ListNode.createList(new int[]{1, 2}), false);
        test(ListNode.createList(new int[]{1, 2, 1}), true);
        test(ListNode.createList(new int[]{1, 2, 2}), true);
        test(ListNode.createList(new int[]{1, 2, 3, 2}), true);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 3}), true);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 1}), true);
        test(ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 7}), false);
    }

    private static void test(ListNode head, boolean expected) {
        boolean actual = solution.hasCycle(head);
        assert expected == actual : "failed test case " + solution + "-" + testCaseNumber
                + ": expected is " + expected + ", actual is " + actual;
        ++testCaseNumber;
    }

    static abstract class Solution {
        public abstract boolean hasCycle(ListNode head);

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    static class Solution1 extends Solution {
        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            if (head.next == head) {
                return true;
            }
            ListNode current = head.next, prev = head;
            while (current != null) {
                ListNode current2 = head;
                while (current2 != prev) {
                    if (current2 == current || current2.next == current) {
                        return true;
                    }
                    current2 = current2.next;
                }
                prev = current;
                current = current.next;
            }
            return false;
        }
    }

    static class Solution2 extends Solution {
        @Override
        public boolean hasCycle(ListNode head) {
            Set<ListNode> opened = new HashSet<>();
            ListNode current = head;
            while (current != null) {
                if (opened.contains(current)) {
                    return true;
                }
                opened.add(current);
                current = current.next;
            }
            return false;
        }
    }

    static class Solution3 extends Solution {
        @Override
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
