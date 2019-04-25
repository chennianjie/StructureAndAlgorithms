package practice;

public class ReverseList<main> {

    public static Node reverstList(Node head){

        if (head == null){
            return head;
        }

        Node helpNode = new Node(-1);
        helpNode.next = head; //把辅助节点和头节点连接起来
        Node pre = helpNode.next; //连接下一次需要反转的节点
        Node cur = pre.next; //需要反转的节点

        while (cur != null) {
            //连接下一次需要反转的节点，把反转的那个节点放在头节点的位置
            pre.next = cur.next;
            cur.next = helpNode.next;
            helpNode.next = cur;
            //cur节点移动
            cur = pre.next;
        }


        return helpNode.next;
    }

    static class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void printList(Node node){
        System.out.print("List Node:");
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head = ReverseList.reverstList(head);
        ReverseList.printList(head);
    }
}
