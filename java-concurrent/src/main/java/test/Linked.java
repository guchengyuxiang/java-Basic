package test;

public class Linked {
    public static void main(String[] args) {
        // 俩个有序链表的头节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node4;
        node4.next = node5;

        node3.next = node6;
        node6.next = node7;

        /** 1 2 4 5
         3 6
         1 -> 2 -> 3 -> 4 -> 5
         */
        Node re = pj(node1, node3);
        while (re.next != null) {
            System.out.println(re.value);
            re = re.next;
        }
    }


    public static Node pj(Node node1, Node node2) {
        // 节点空
        if (null == node1 && null == node2) {
            return null;
        }
        if (null == node1) {
            return node2;
        }

        if (null == node2) {
            return node1;
        }

        //  遍历节点
        Node resul = node1.value < node2.value ? node1 : node2;
        Node h1 = node1.value < node2.value ? node1 : node2;
        Node h2 = node1.value >= node2.value ? node1 : node2;

        Node pre = h1;
        while (h1.next != null) {
            if (h1.value < h2.value) {
                pre = h1;
            } else {
                pre.next = h2;
                pre = h2;
                h2 = pre.next;
                pre.next = h1;
            }
            h1 = h1.next;
        }

        if (h2 != null) {
            h1.next = h2;
        }

        return resul;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
