package class_01;

/**
 * 从数组中找两个数相加等于某个数
 * 返回那两个数的下标
 */
public class GetTwoNumberAdd {

    //双指针法   先排序

    public static int[] getTwoNum(int[] m, int target){

        if (m == null || m.length < 2) {
            return null;
        }
        //设置一个定位下标的数组
        int[] index = new int[m.length];
        for (int i = 0; i < index.length ;i++) {
            index[i] = i;
        }
        //先排序
        sort(m, index);
        for (int a : m) {
            System.out.print(a + " ");
        }
        System.out.println("index:");
        for (int a : index) {
            System.out.print(a + " ");
        }
        System.out.println();
        int l = 0;
        int r = m.length - 1;
        int sum;
        while (l<r) {
            sum = m[l] + m[r];
            if (sum < target) {
                l++;
            } else if(target < sum) {
                r--;
            } else {
                return new int[]{index[l], index[r]};
            }
        }
        return null;
    }

    public static void sort(int[] m, int[] index){
        //堆排序，先组成大根堆
        for (int i = 0; i < index.length ;i++) {
            heapInsert(m, index, i);
        }
        for (int a : m) {
            System.out.print(a + " ");
        }
        System.out.println();
        //把堆顶元素与堆底元素交换并堆顶向下调整为大根堆
        //size指的是数组的最大索引长度
        for (int size = m.length - 1; size >= 0; size--){
            swap(m, index, 0, size);
            heapify(m, index, size);
        }
    }

    public static void heapify(int[] m, int[] index, int size) {
        int i = 0;
        int left = 1;
        int right = 2;
        int largest;
        while (left < size) {
            largest = right < size && m[left] < m[right] ? right : left;
            largest = m[largest] > m[i] ? largest : i;
            if (largest == i){
                break;
            }
            swap(m, index, largest, i);
            i = largest;
            left = 2*i + 1;
            right = left + 1;
        }
    }

    /**
     * 这是一个向上调整为大根堆的过程
     */
    public static void heapInsert(int[] m, int[] index, int i){
        int father = (i-1)/2;
        while (m[i] > m[father] ){
            swap(m, index, i, father);
            i = father;
            father = (i-1)/2;
        }
    }

    public static void swap(int[] m, int[] index, int i1, int i2){
        int tmp = m[i1];
        m[i1] = m[i2];
        m[i2] = tmp;
        tmp = index[i1];
        index[i1] = index[i2];
        index[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] m = {13, 5, 4, 6, 10};
        int[] twoNum = GetTwoNumberAdd.getTwoNum(m, 9);
        for (int a : twoNum) {
            System.out.print(a + " ");
        }




        }
    //hash表法  空间n 时间n
    //暴力遍历法  n^2
}
