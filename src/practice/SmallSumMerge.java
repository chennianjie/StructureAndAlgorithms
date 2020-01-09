package practice;

public class SmallSumMerge {

    public static int mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int m = (l+r) >> 1;
        return mergeSort(arr, l, m) + mergeSort(arr, m+1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r){
        //新建一个辅助数组
        int[] help = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;

        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        for (;p1 <= m; p1++){
            help[i++] = arr[p1];
        }

        for (;p2 <= r; p2++){
            help[i++] = arr[p2];
        }

        //把help数组替换回原数组
//        for (i = l; i<r; i++){
//            arr[i] = help[i-l];
//        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5, 6};
        int sort = mergeSort(arr, 0, arr.length - 1);
        for (int a : arr){
            System.out.print(a);
        }
        System.out.println();
        System.out.println(sort);
    }
}
