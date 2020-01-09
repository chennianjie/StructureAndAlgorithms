package graph;

import java.util.*;

public class TopologySort {

    public static List<Node> toplologySort(Graph graph) {
        //生成一个hashmap统计各个节点的入度，生成一个队列存储入度为0的节点
        //将图中所有的节点遍历之后，把map和queue的信息初始化
        //遍历queue中的节点，弹出一个节点加入结果，并把他的字节入度减一进行不断调整操作
        HashMap<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }

        List<Node> result = new ArrayList<>();

        while (!zeroInQueue.isEmpty()) {
            Node node = zeroInQueue.poll();
            result.add(node);
            for (Node node1 : node.nexts) {
                inMap.put(node1, inMap.get(node1) - 1);
                if (inMap.get(node1) == 0) {
                    zeroInQueue.add(node1);
                }
            }
        }
        return result;
    }
}
