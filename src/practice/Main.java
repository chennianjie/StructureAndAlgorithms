package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Main {

    //设计大根堆和小根堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapCompararot());
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());

    public static class MinHeapCompararot implements Comparator<Integer> {

        //返回正数o2放在前面，负数o1放在前面
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static class MaxHeapComparator implements Comparator<Integer> {
        //返回正数o1放在前面，负数o2放在前面
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1){
                return -1;
            }else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        new ArrayList<>();
        new Stack<>();

        Main main = new Main();
        main.minHeap.add(1);
        main.minHeap.add(2);
        main.minHeap.add(5);
        main.minHeap.add(3);
        main.minHeap.add(3);
        main.minHeap.remove(3);
        while (!main.minHeap.isEmpty()) {
            System.out.print(main.minHeap.poll());
        }
    }
}
