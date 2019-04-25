package practice;
import java.util.Stack;

public class PreInPosTraverSal {


    //recursive递归实现二叉树的先中后序遍历
    public static void preOrderRecursive(Node node) {
        //base case
        if (node == null){
            return;
        }

        System.out.print(node.value + " ");
        preOrderRecursive(node.left);
        preOrderRecursive(node.right);

    }


    /**
     * 非递归实现二叉树的先序遍历  中左右
     * @param node
     */
    public static void preOrderUnRecursive(Node node) {
        System.out.print("Pre-Order: ");

        if (node != null) {
            //初始化一个栈辅助空间
            Stack<Node> nodeStack = new Stack<>();
            nodeStack.push(node);//第一次先把头节点放进去
            while (!nodeStack.empty()){
                node = nodeStack.pop();
                System.out.print(node.value + " ");

                if (node.right != null) {
                    nodeStack.push(node.right);
                }

                if (node.left != null) {
                    nodeStack.push(node.left);
                }
            }
        }
        System.out.println();
    }


    /**
     * 非递归中序遍历 左中右
     * @param head
     */
    public static void inOrderUnRecursive(Node head) {
        System.out.print("In-Order: ");
        if (head != null) {
            //准备一个辅助栈
            Stack<Node> nodeStack = new Stack<>();
            while (!nodeStack.empty() || head != null) {
                if (head != null) {//把左子树上的节点全部压入栈
                    nodeStack.push(head);
                    head = head.left;
                }else {//如果head为空了表示左子树已全部压入栈
                    //从栈中弹出一个节点
                    head = nodeStack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * 非递归方式实现二叉树后序遍历
     * @param node
     */
    public static void posOrderUnRecursive(Node node){

        System.out.print("Pos-Order: ");
        if (node != null) {
            //一个辅助栈装实现先序遍历节点
            //一个栈用来倒叙输出
            Stack<Node> nodeStack = new Stack<>();
            Stack<Node> helpStack = new Stack<>();
            nodeStack.push(node);

            while (!nodeStack.empty()) {
                node = nodeStack.pop();
                helpStack.push(node);

                if (node.left != null){
                    nodeStack.push(node.left);
                }

                if (node.right != null) {
                    nodeStack.push(node.right);
                }
            }

            while (!helpStack.empty()) {
                System.out.print(helpStack.pop().value + " ");
            }
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(1);
        head.left.right.left = new Node(5);
        head.left.right.right = new Node(6);
        PreInPosTraverSal.preOrderRecursive(head);
        System.out.println();
        PreInPosTraverSal.preOrderUnRecursive(head);
        PreInPosTraverSal.inOrderUnRecursive(head);
        System.out.println();
        PreInPosTraverSal.posOrderUnRecursive(head);
    }
}
