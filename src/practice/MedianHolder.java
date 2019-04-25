package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 随时取出中位数，有序情况下（n个数）：奇数（n/2 + 1） 偶数（n/2 + n/2 +1）/2
 * 添加一个数时间复杂度 O（logN）
 * 取出中位数 O（1）
 */
public class MedianHolder {


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

    private void adjustHeapSize(){
        if (minHeap.size() + 2 == maxHeap.size()) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    //设计一个大根堆，一个小根堆，一边放n/2个数，默认第一个数放大根堆，大于大根堆的放小根堆
    //控制两堆size，相差超过1就从一个堆弹出一个数放进另一个堆
    public void addNumber(Integer number){
        if (maxHeap.isEmpty()) {
            maxHeap.add(number);
        }else if (number > maxHeap.peek()) {
            minHeap.add(number);
        }else {
            maxHeap.add(number);
        }

        //调整两堆的数量，使其均衡
        adjustHeapSize();
    }

    public Integer getMedian(){

        if (maxHeap.isEmpty()) {
            return null;
        }

        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }else {//数量一致的时候
            return (minHeap.peek() + maxHeap.peek())/2;
        }
    }
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) { //判断条件，数组长度是偶数时成立
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printHeap(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()){
            System.out.print(heap.poll() + " ");
        }
    }


    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 1;
        for (int i = 0; i != testTimes; i++) {
            int len = 10;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            printArray(arr);
            System.out.print("maxHeap:");
            printHeap(medianHold.maxHeap);
            System.out.println();
            System.out.print("minHeap:");
            printHeap(medianHold.minHeap);
//            System.out.println("中位数：" + medianHold.getMedian());
//            if (medianHold.getMedian() != getMedianOfArray(arr)) {
//                err = true;
//                printArray(arr);
//                System.out.println(getMedianOfArray(arr));
//                System.out.println(medianHold.getMedian());
//                break;
//            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
