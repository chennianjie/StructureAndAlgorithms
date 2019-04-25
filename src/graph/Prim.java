package graph;

import java.util.*;

public class Prim {

    public List<Edge> prim(Node node) {

        //创建一个hashset存储遍历过的点
        //创建一个优先级队列动态存储解锁的边
        //创建一个返回值集合

        HashSet<Node> set = new HashSet<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        List<Edge> result = new ArrayList<>();

        if (!set.contains(node)) {
            set.add(node);
            for (Edge edge : node.edges) {
                queue.add(edge);
            }
            while (!queue.isEmpty()) {
                Edge e = queue.poll();
                Node toNode = e.to;
                if (!set.contains(toNode)){
                    set.add(toNode);
                    result.add(e);
                    for (Edge edge : toNode.edges) {
                        queue.add(edge);
                    }
                }
            }
        }
        return result;
    }

    public class edgeCompare implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }
}
