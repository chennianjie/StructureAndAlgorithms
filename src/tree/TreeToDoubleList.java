package tree;

public class TreeToDoubleList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node convert(Node head) {
        if (head == null) {
            return null;
        }

        return process(head)[0];
    }

    public static Node[] process(Node head) {
        if (head == null) {
            return new Node[2];
        }

        Node[] leftNode = process(head.left);
        Node[] rightNode = process(head.right);

        head.left = null;
        head.right = null;
        //判断左右节点是否为空，并把左右子树和头节点相连
        if (leftNode[1] != null) {
            leftNode[1].right = head;
            head.left = leftNode[1];
        }

        if (rightNode[0] != null) {
            rightNode[0].left = head;
            head.right = rightNode[0];
        }

        //因为头节点需要左子树最右的节点与之相连，右子树最左的节点与之相连
        Node left = leftNode[0] != null ? leftNode[0] : head;
        Node right = rightNode[1] != null ? rightNode[1] : head;
        //相连完成，设计返回值
        return new Node[]{left, right};
    }
    public static void printDoubleLinkedList(Node head) {
        System.out.print("Double Linked List: ");
        Node end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.right;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.left;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head;
        head = new Node(5);
        head.left = new Node(2);
        head.right = new Node(9);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.left.right.right = new Node(4);
        head.right.left = new Node(7);
        head.right.right = new Node(10);
        head.left.left = new Node(1);
        head.right.left.left = new Node(6);
        head.right.left.right = new Node(8);
        Node convert = TreeToDoubleList.convert(head);
        printDoubleLinkedList(convert);
    }
}
