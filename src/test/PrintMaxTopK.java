package test;

import java.util.Arrays;

/**
 * 给定多组有序数组，从这几组数组中求top K
 */
public class PrintMaxTopK {

    static class Node{
        //当前节点值
        int value;
        //所属数组下标
        int arrNum;
        //在数组中的下标
        int arrIndex;

        public Node(int value, int arrNum, int arrIndex) {
            this.value = value;
            this.arrNum = arrNum;
            this.arrIndex = arrIndex;
        }

        public Node(){}
    }

    public static void printMaxTopK(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || k <= 0) {
            return;
        }

        int heapSize = matrix.length;
        //创建数组形成大根堆结构（长度为数组的个数）
        int index;
        Node[] heapNodes = new Node[heapSize];
        //往数组中插入值，并不断调整成大根堆
        for (int i = 0; i < heapSize; i++) {
            index = matrix[i].length - 1;
            heapNodes[i] = new Node(matrix[i][index], i, index);
            heapInsert(heapNodes, i);
        }
        System.out.println("TOP" + k + ":");
        //开始输出top k，并进行堆调整
        for (int i = 0; i < k; i++) {
            if (heapSize == 0) {
                break;
            }
            int num = heapNodes[0].value;

            System.out.print(num + " ");
            Node head = heapNodes[0];
            if (head.arrIndex != 0) {
                head.value = matrix[head.arrNum][--head.arrIndex];
            } else {
                //如果当前啊数组值已经取完，当前堆顶元素和最后一个交换，最后向下调整
                swap(heapNodes, 0, --heapSize);
            }
            //向下调整heapify
            heapify(heapNodes, 0, heapSize);
        }
    }

    /**
     * 向下调整，index -- heapSize范围调整
     * @param heapNodes
     * @param index
     * @param heapSize
     */
    private static void heapify(Node[] heapNodes, int index, int heapSize) {
        int left = 2 * index + 1;
        int right = left + 1;
        int largest;
        while (left < heapSize) {
            //从左右子节点和当前节点找出最大的节点
            largest = right < heapSize && heapNodes[left].value < heapNodes[right].value ? right : left;
            largest = heapNodes[index].value < heapNodes[largest].value ? largest : index;
            if (largest != index) {
                //记得交换位置
                swap(heapNodes, largest, index);
            } else {
                break;
            }
            index = largest;
            left = 2 * index + 1;
            right = left + 1;
        }

    }

    private static void heapInsert(Node[] heapNodes, int i) {
        int parent = (i - 1) / 2;
        while (heapNodes[i].value > heapNodes[parent].value) {
            swap(heapNodes, i, parent);
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public static void swap(Node[] heap, int index1, int index2) {
        Node tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    public static int[][] generateRandomMatrix(int maxRow, int maxCol,
                                               int maxValue) {
        if (maxRow < 0 || maxCol < 0) {
            return null;
        }
        int[][] matrix = new int[(int) (Math.random() * maxRow) + 1][];
        for (int i = 0; i != matrix.length; i++) {
            matrix[i] = new int[(int) (Math.random() * maxCol) + 1];
            for (int j = 0; j != matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * maxValue);
            }
            Arrays.sort(matrix[i]);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 10, 1000);
        printMatrix(matrix);
        System.out.println("===========================");
        printMaxTopK(matrix, 100);
    }

}
