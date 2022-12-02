package meeting;

import common.ListNode;

import java.util.ArrayList;

public class Coding003 {

    public static void main(String[] args) {
        // 1, 2, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 9, 9, 11 -- > 1 2 5 6 8 11
        ListNode head = ListNode.buildNode(new int[]{1, 2, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 9, 9, 11});
        // 1, 1, 1, 1, 2 --> 2
//        ListNode head = ListNode.buildNode(new int[]{1, 1, 1, 1, 2});

//        ListNode head = ListNode.buildNode(new int[]{1, 1});

        head = delete(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode delete(ListNode head) {
        // O2 遍历统计 出现大于1次的 需要额外空间 Map key
        // 使用 2 个指针  排序链表--》 后续大于等于当前值
        ListNode leftNode = new ListNode(0);
        leftNode.next = head;

        ListNode rightNode = head, del = leftNode;
        if (null == rightNode || rightNode.next == null) {
            return head;
        }

        while (rightNode != null) {
            if (rightNode.next == null) {
                leftNode.next.val = rightNode.val;
                leftNode = leftNode.next;
                break;
            }
            if (rightNode.val != rightNode.next.val) {
                leftNode.next.val = rightNode.val;
                leftNode = leftNode.next;
                rightNode = rightNode.next;
                continue;
            }
            rightNode = next(rightNode);
        }
        if (leftNode == del) {
            return null;
        }
        leftNode.next = null;
        del.next = null;
        return head;
    }

    public static ListNode next(ListNode rightNode) {
        int val = rightNode.val;
        while (rightNode != null) {
            if (val >= rightNode.val) {
                rightNode = rightNode.next;
            } else {
                return rightNode;
            }
        }
        return null;
    }
}
