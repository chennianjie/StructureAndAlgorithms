package practice;

public class IsMirrorTree {


    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归的思想做
     * @param node
     * @return
     */
    public static boolean isMirrorTree(Node node) {

        if (node == null) {
            return true;
        }
        return isMirror(node.left, node.right);
    }

    private static boolean isMirror(Node left, Node right) {

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.value == right.value) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

        return false;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(5);
        head.left.right = new Node(3);
        head.right.left = new Node(3);
        head.right.right = new Node(5);
        boolean mirrorTree = isMirrorTree(head);
        System.out.println(mirrorTree);
    }
}
