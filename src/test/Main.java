package test;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static class Node {
        Node next;
        Integer value;
        Integer size;
        Integer index;

        public void setIndex(Integer index) {
            this.index = index;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node(Integer value, Integer size, Integer index) {
            this.value = value;
            this.index = index;
            this.size = size;
        }

        public Integer getSize() {
            return size;
        }
    }
    Node[] nodes;
    Integer size;
    public void test(Integer hashSize, int[] keys) {
        nodes = new Node[hashSize];

        for (int i =0; i<keys.length; i++){
            int a = keys[i]%hashSize - 1;
            if (nodes[a] == null) {
                size = 1;
                nodes[a] = new Node(keys[i], size ,a);
            }else {
                nodes[a].next = new Node(keys[i],size+1, a);
            }
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String value = in.nextLine();
            String[] split = value.split("/");
            int hashSize = Integer.parseInt(split[0]);
            String[] s = value.split(",");
            int[] keys = new int[s.length];
            for (int i=0; i<s.length; i++){
                keys[i] = Integer.parseInt(s[i]);
            }
            main.test(hashSize, keys);
            Node[] nodes = main.nodes;
            Node maxLengthNode = new Node(-1,-1,-1);
            for (int i= 0; i<nodes.length; i++){
                maxLengthNode = nodes[i].getSize() > maxLengthNode.getSize() ? nodes[i] : maxLengthNode;
            }
            System.out.print(maxLengthNode.size + "-" + maxLengthNode.index + "-");
            while (maxLengthNode != null){
                System.out.print(maxLengthNode.value);
                maxLengthNode = maxLengthNode.next;
            }
        }

    }

    /**
     * 最大窗口值
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            //判断数组长度,为0即返回空数组
            //创建一个双端队列和存储结果的数组
            //把前三个值插入队列，然后遍历找最大，接下来，删除头部，插入尾部找最大，插入结果数组中，以此类推
            int length = nums.length;
            if (nums.length == 0){
                return new int[0];
            }
            int[] res = new int[nums.length - k + 1];
            int index = 0;
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                deque.addFirst(nums[i]);
                res[index] = getMax(deque);
            }
            for (int i = k; i < length; i++) {
                deque.addFirst(nums[k]);
                deque.removeLast();
                res[++index] = getMax(deque);
            }
            return res;
        }

        public int getMax(Deque<Integer> deque) {

            int max = Integer.MIN_VALUE;
            Iterator<Integer> iterator = deque.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                max = Math.max(max, next);
            }
            return max;
        }
    }
}
