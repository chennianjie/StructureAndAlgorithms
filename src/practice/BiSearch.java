package practice;

public class BiSearch {

    /**
     * 递归实现二分查找
     * @param array
     * @param a
     * @param left
     * @param right
     * @return 查找值在数组中的位置
     */
    public static int biSearch(int[] array, int a, int left, int right) {
        //第一步找出递归条件的base case
        if (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == a) {
                return mid + 1;
            }

            if (array[mid] > a) {
                return biSearch(array, a, left, mid-1);
            }

            if (array[mid] < a) {
                return biSearch(array, a, mid+1, right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 12};
        int result = BiSearch.biSearch(arr, 0, 0, arr.length - 1);
        System.out.println("二分查找的结果为：" + result);
    }

}
