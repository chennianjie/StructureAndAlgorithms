package test;


import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * 非递归实现N叉树的遍历
 */
public class NTreePosOrder {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static List<Integer> posOrder(Node head) {
        //准备两个栈，一个栈统计中右左的打印顺序，另一个倒序输出即可
        Stack<Node> stack = new Stack<>();
        Stack<Node> helpStack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            helpStack.push(node);
            if (node.children != null && node.children.size() != 0) {
                for (Node n : node.children) {
                    stack.push(n);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!helpStack.isEmpty()) {
            list.add(helpStack.pop().val);
        }
        return list;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public static List<Integer> posOrderDigui(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        if (root.children != null && !root.children.isEmpty()) {
            for (Node node : root.children) {
                posOrderDigui(node);
            }
        }
        list.add(root.val);
        return list;
    }


    /**
     * N叉树的层级遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        //利用队列把每一层的子节点放入其中，即可让顺序保持
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        int size;
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                list =new ArrayList<>();
                size = queue.size();
                for (int i=0; i < size; i++) {
                    Node node = queue.poll();
                    for (Node n : node.children) {
                        queue.offer(n);
                    }
                    list.add(node.val);
                }
                lists.add(list);
            }
        }
        return lists;
    }

    /**
     * 递归实现
     * @param result
     * @param root
     * @param depth
     */
    public void getResult(List<List<Integer>> result,Node root,int depth){
        if(root==null) return ;
        int size = root.children.size();

        if(result.size()<=depth){
            List<Integer> tempList = new ArrayList<>();
            result.add(tempList);
        }
        //按层级放入节点
        result.get(depth).add(root.val);
        //当前节点的子节点全部放一遍，直到root为空时候结束
        for(int i=0;i<size;++i ){
            getResult(result,root.children.get(i),depth+1);
        }
    }
    public List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(result,root,0);
        return result;
    }

}
