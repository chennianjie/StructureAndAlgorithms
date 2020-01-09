package linkedlist;

public class LinkedList {

    public static Node findMidNode(Node head){
        if (head == null || head.next == null) {
            return null;
        }
        Node right = head;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        System.out.println("中间节点是："+ right.value + "下一个 " + right.next.value);
        return right;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node midNode = findMidNode(head);
        System.out.println(midNode.next.value);

    }

    static class Node {
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
