package leetcode;

import java.util.HashMap;
import java.util.Map;

class ListNode {

    private static final Map<Integer, ListNode> NODES = new HashMap<>();

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int[] array) {
        NODES.clear();
        ListNode head = null, prev = null;
        for (int i = 0; i < array.length; ++i) {
            ListNode listNode = ListNode.valueOf(array[i]);
            if (head == null) {
                head = listNode;
            }
            if (prev != null) {
                if (prev.next != null) {
                    System.err.println("violates condition");
                }
                prev.next = listNode;
            }
            prev = listNode;
        }
        return head;
    }

    private static ListNode valueOf(int val) {
        return NODES.computeIfAbsent(val, key -> new ListNode(key));
    }
}
