package test;

/**
 * 网易：求一个数组中和为target但是乘积最大的组合
 */
public class MaxDamage {

    public static int progress(int[] arr, int index, int sum){
        //base case
        if (sum < 0) {
            return -1;
        }
        if (index == arr.length) {
            return sum == 0 ? 1 : -1;
        }


        int include = progress(arr, index, sum);
        int notinclude = arr[index] * progress(arr, index + 1, sum - arr[index]);
        return Math.max(include, notinclude);
    }
}
