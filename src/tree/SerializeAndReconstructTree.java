package tree;

import stucture.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化过程
 */
public class SerializeAndReconstructTree {


    /**
     * 二叉树序列化成字符串的过程，空用#代替，每个字符连接用“_”
     * @param head
     * @return
     */
    public static String serializeTreePre(Node head) {
        if (head == null) {
            return "#_";
        }
        //当前头节点值拼上左节点，再拼右节点的值，先序序列化
        String res = head.value + "_";
        res += serializeTreePre(head.left);
        res += serializeTreePre(head.right);
        return res;
    }


    /**
     * 先序方式的反序列化
     * @param res
     * @return
     */
    public static Node reconTreePre(String res) {
        //判断字符串是否为空
        //将字符串按照规则拆分，放进一个队列里面
        //从队列里面挨个弹出，按照先序反序列化，先生成头节点，再拼左节点，最后右节点
        if (res == null) {
            return null;
        }
        String values[] = res.split("_");
        Queue<String> queue = new LinkedList();
        for (String v : values) {
            queue.offer(v);
        }
        return reconTreePreContinue(queue);
    }

    /**
     * 先序反序列化
     * @param queue
     * @return
     */
    private static Node reconTreePreContinue(Queue<String> queue) {
       //每次从队列里面弹出一个数，如果当前数表示空，则返回null（base case）
        //生成一个头节点，拼接左节点，拼接右节点
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        Node head = new Node(Integer.parseInt(value));
        head.left = reconTreePreContinue(queue);
        head.right = reconTreePreContinue(queue);
        return head;
    }


    /**
     * 层级序列化
     * @param head
     * @return
     */
    public static String serializeByLevel(Node head) {
        if (head == null) {
            return "#_";
        }
        //需要一个队列，先放入头节点，拼接好头节点，然后循环检查这个队列是否有值
        //如果有左节点，则把左节点放入队列并拼接；右节点同理
        //注意，如果节点为空，还需要拼接上“#”，空字符串的标记
        String res = head.value + "_";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                res += node.left.value;
            }else {
                res += "#_";
            }
            if (node.right != null) {
                queue.offer(node.right);
                res += node.right.value;
            }else {
                res += "#_";
            }
        }
        return res;
    }


    /**
     * 层级反序列化
     * @param value
     * @return
     */
    public static Node reconByLevel(String value) {
        //参考层级序列化的规则反序列化
        //使用一个队列，存储所有拆分的序列化字符串
        //如果字符串不是空，则生成一个节点，然后根据队列的规律按层拼接
        String[] values = value.split("_");
        int index = 0;//数组下标辅助索引
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            Node left = generateNodeByString(values[index++]);
            Node right = generateNodeByString(values[index++]);
            if (left != null) {
                node.left = left;
                //把左节点放入队列
                queue.offer(node.left);
            }
            if (right != null) {
                node.right = right;
                //把有节点放入队列
                queue.offer(node.right);
            }
        }
        return head;//这里返回head，请仔细分析循环中的赋值过程
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
     * 根据字符串生成一个节点
     * @param val
     * @return
     */
    public static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

    public static void main(String[] args) {
        System.out.println(5+5+'5'+"5"+5+5);
        System.out.println('5' + 0);
    }

}
