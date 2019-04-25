package practice;

public class PartitionTest {

    public static void swap(int[] arr, int a, int b){
        int c = arr[a];
        arr[a] = arr[b];
        arr[b] = c;
    }

    public static void partition(int[] arr, int l, int r){
        int p = arr[r];
        int less = l - 1;
        for (int i = l; i<= r; i++){
            if (arr[i] <= p){
                swap(arr, ++less, i);
            }
        }
    }

    /**
     * 荷兰国旗问题
     * 按最右边的数做划分值：
     * 1.当前数小于划分值，小于区下一个数与当前数交换，并且小于区扩一个位置，当前数++
     * 2.当前数等于划分值，当前数++
     * 3.当前数大于划分值，大于区下一个数与当前数交换，并且大于区扩一个位置，当前数位置不变
     * @param arr
     * @param l
     * @param r
     */
    public static int[] partition2(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }


    public static void quickSort(int[] arr, int l, int r){
        if (l < r){
            swap(arr, (int)(l + Math.random() * (r - l + 1)), r);
            int[] partition2 = partition2(arr, l, r);
            quickSort(arr, l, partition2[0] - 1);
            quickSort(arr, partition2[1] + 1, r);
        }
    }






    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2, 5, 2};
//        partition(arr, 0, arr.length - 1);
        int[] partition2 = partition2(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a);
        }
        System.out.println();
        for (int a : partition2) {
            System.out.print(a);
        }
        System.out.println();
        quickSort(arr, 0 ,arr.length - 1);
        for (int a : arr) {
            System.out.print(a);
        }
    }
}
