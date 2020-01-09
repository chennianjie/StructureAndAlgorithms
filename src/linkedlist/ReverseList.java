package linkedlist;

public class ReverseList {

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

    public static Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node helpNode = new Node(-1);
        helpNode.next = head;
        Node pre = head;
        Node cur = pre.next;
        while (cur != null) {
            pre.next = cur.next;
            cur.next = helpNode.next;
            helpNode.next = cur;
            cur = pre.next;
        }
        return helpNode.next;
    }

    public static Node reverse2(Node head) {
        Node pre = null;//指的是每次反转之后开头那个节点
        Node next;//需要反转节点的下一个节点
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        Node head1 = head;
//        head = ReverseList.reverse1(head);
//        while (head != null) {
//            System.out.print(head.value);
//            head = head.next;
//        }
        System.out.println();
        head = ReverseList.reverse2(head1);
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }
    }
}
