package tree;

/**
 * 有序数组变平衡搜索二叉树
 */
public class SortedArrayToBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node convert(int[] arr){
        if (arr == null || arr.length < 1) {
            return null;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static Node process(int[] arr, int L, int R) {

        if ( L > R) {
            return null;
        }
        int mid = (L + R) / 2;
        Node head = new Node(arr[mid]);
        head.left = process(arr, L, mid);
        head.right = process(arr, mid + 1, R);
        return head;
    }
}
