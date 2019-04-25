package test;

import stucture.Node;

/**
 * 判断一个数组是不是一个搜索二叉树的后序遍历的结果
 * 已知一个数组是一个搜索二叉树后序遍历的结果，把它变成二叉树结构
 */
public class PosArrayToBST {

    public static boolean isPosOfBST(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        return isPost(array, 0, array.length - 1);
    }

    /**
     * 判断是否为BST的后序遍历结果
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static boolean isPost(int[] array, int start, int end) {
        if (start == end) {
            return true;
        }

        //< > = 这是后序遍历的顺序
        //找到小于区的最后一个位置leftEnd，找到大于区最左的一个位置rightStart，判断leftEnd + 1 == rightStart
        //分析除两个情况，当无左子树或者无右子树时候，进行单独判断
        int leftEnd = -1;
        int rightStart = end;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                //当前值是小于区的时候，一直更新
                leftEnd = i;
            } else {
                rightStart = rightStart == end ? i : rightStart;
            }
        }
        //找到这两个临界点之后
        if (leftEnd == -1 || rightStart == end) {
            return isPost(array, start, end - 1);//求左子树或者右子树
        }

        if (leftEnd != rightStart - 1) {
            return false;
        }

        return isPost(array, start, leftEnd) && isPost(array, rightStart, end - 1);
    }


    /**
     * 已知数组是后序遍历结果，把其变成一个搜索二叉树
     * @param array
     * @return
     */
    public static Node posArrayToBST(int[] array) {
        if (array == null || array.length == 0) {
            return new Node();
        }

        return posArrayToBST(array, 0, array.length - 1);
    }

    public static Node posArrayToBST(int[] array, int start, int end) {

        if (start > end) {
            return null;
        }

        Node head = new Node(array[end]);
        int leftEnd = -1;
        int rightStart = end;
        for (int i = start; i < end; i++) {
            if (array[i] < array[end]) {
                //当前值是小于区的时候，一直更新
                leftEnd = i;
            } else {
                rightStart = rightStart == end ? i : rightStart;
            }
        }
        head.left = posArrayToBST(array, start, leftEnd);
        head.right = posArrayToBST(array, rightStart, end - 1);
        return head;
    }
}
