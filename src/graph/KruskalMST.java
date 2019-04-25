package graph;


import java.util.*;

public class KruskalMST {


    public static class UnionFindSet {
        public  HashMap<Node, Node> fatherMap; //表示当前节点的父节点
        public  HashMap<Node, Integer> sizeMap;  //表示当前节点下一共有多少节点（只有是代表节点时才有效）

        public UnionFindSet(Collection<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes){
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public  Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if (node != father) {
                father = fatherMap.get(father);
            }

            fatherMap.put(node, father);
            return father;
        }

        public  boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public  void union(Node a, Node b) {
            //先判断两节点是否在同一个集合里面
            Node aFather = findFather(a);
            Node bFather = findFather(b);

            if (aFather != bFather) {
                //不在一个集合里面，根据size大小进行合并，小的挂在大的下面
                Integer aSize = sizeMap.get(aFather);//这里只有是代表节点的时候才有效
                Integer bSize = sizeMap.get(bFather);
                if (aSize <= bSize) {
                    fatherMap.put(aFather, bFather);
                    sizeMap.put(bFather, aSize + bSize);
                }else {
                    fatherMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSize + bSize);
                }
            }
        }
    }

    public static class EdgeWeightAse implements Comparator<Edge> {

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    public static Set<Edge> kruskaMST(Graph graph) {
        //把图中所有的点都存在并查集里面，以此判断是否连接过
        //把图中所有的边都存在小根堆结构的优先级队列里面
        //每次从队列里面取出一个最小边，如果边联系这两个节点没有添加过即加入，直到队列为空
        UnionFindSet union = new UnionFindSet(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue(new EdgeWeightAse());
        for (Edge edge :  graph.edges) {
            priorityQueue.add(edge);
        }
        HashSet<Edge> result = new HashSet();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!union.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                union.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
