package tree;

/**
 * 判断一棵树是否是平衡二叉树
 */
public class isAVL {

    class Node {
        Integer value;
        Node left;
        Node right;

        public Node(Integer value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isAVL(Node tree) {
        //一颗空树就是平衡二叉树
        if (tree == null) {
            return true;
        }

        //判断左右子树的高度差是否大于1
        if (Math.abs(getDeepth(tree.left) - getDeepth(tree.right)) <= 1) {
            //如果左右子树的深度差小于1，再判断左右子树是否为一个平衡二叉树
            return isAVL(tree.left) && isAVL(tree.right);
        } {
            //如果深度差超1即不是平衡二叉树
            return false;
        }

    }

    public static int getDeepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getDeepth(node.left);
        int right = getDeepth(node.right);
        return ((left - right) > 0 ? left : right) + 1;
    }
}
