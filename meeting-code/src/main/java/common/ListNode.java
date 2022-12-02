package common;


import java.util.List;

/**
 * 链表
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildNode(int[] arrays) {
        ListNode before = null, head = null;
        for (int i = 0; i < arrays.length; i++) {
            ListNode node = new ListNode(arrays[i]);
            if (i == 0) {
                head = node;
            } else {
                before.next = node;
            }
            before = node;
        }
        return head;
    }
}
