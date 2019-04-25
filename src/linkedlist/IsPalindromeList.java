package linkedlist;

public class IsPalindromeList {

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

    public static boolean isPalindromeList(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        //找到链表的中间节点
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //先把中间节点指向空
        fast = slow.next;//中间节点之后的第一个节点，fast变量复用
        slow.next = null;
        //中间节点之后的节点反转
        Node help;
        while (fast != null) {
            help = fast.next;
            fast.next = slow;
            slow = fast;
            fast = help;
        }
        //链表反转之后slow节点来到最后
        fast = head;
        help = slow;//记下slow节点的位置，为之后反转回来保留参数
        while (fast != null && slow != null) {
            if (fast.value != slow.value) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        //对比完成，将链表变回原来的样子,help节点是最后节点
         //辅助节点的作用（复用）
        slow = help.next;
        help.next = null;
        while (slow != null) {
            fast = slow.next;//辅助
            slow.next = help;
            help = slow;
            slow = fast;
        }

        return true;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(isPalindromeList(head1));
        while (head1 != null) {
            System.out.print(head1.value + " ");
            head1 = head1.next;
        }
    }
}
