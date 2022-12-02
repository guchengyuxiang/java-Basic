package meeting;

/**
 * 输出 倒数第K个数据
 */
public class Coding001 {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        Node init = head;
        for (int i = 2; i <= 6; i++) {
            Node init1 = new Node(i, null);
            init.next = init1;
            init = init1;
        }
//      init.next = head;

        // 1 2 3 4 5 6   3
        if (isHoop(head)) {
            return;
        }
        int k = 6;
        Node first = head;
        for (int i = 1; i < k; i++) {
            if (first != null) {
                first = first.next;
            }
        }

        if (null == first) {
            System.out.println("k过大");
            return;
        }

        Node second = head;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("K:" + second.value);
    }

    private static boolean isHoop(Node head) {
        Node first = head.next;
        Node second = head;
        while (first != null) {
            if (first == second) {
                System.out.println("数据有环");
                return true;
            }
            if (first.next != null) {
                first = first.next.next;
            } else {
                return false;
            }
            second = second.next;
        }

        return false;
    }

    private static class Node {
        int value;
        Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
