package practice;

/**
 * 一个数组中，只有两个数是单独出现的，其余数都是成对出现，找出这两个数，时间复杂度O(n) 空间复杂度O(1)
 */
public class FindOnceTwoNumber {

    public static int[] findTwoNumbers(int[] arr) {
        int[] nums = new int[2];
        //按位异或所有的数，最终结果就是单独两个数异或的结果
        int result = findOR(arr);
        //如果结果的二进制表达式中有一位是1，说明两个数异或之前一个值为1一个为0，找出这个为1的位置，
        //然后把数组中的数按二进制表达式中1在此位置的数进行分组，然后分别进行异或操作找出这两个数
        int index = findIndex(result); //1所在的位置
        for (int i=0; i<arr.length; i++) {
            if (group(arr[i], index)) {
                nums[0] ^= arr[i];
            }else {
                nums[1] ^= arr[i];
            }
        }
        return nums;
    }

    public static boolean group(int target, int index) {
        return (target>>index & 1) == 1;
    }

    public static int findIndex(int result) {
        int index = 0;
        while ( (result & 1)==0 && index < 32 ) {
            result >>= 1;
            index++;
        }
        return index;
    }

    public static int findOR(int[] arr) {
        int result = 0;
        for (int i=0; i<arr.length; i++) {
            result ^= arr[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,6,5,5};
        int[] nums = FindOnceTwoNumber.findTwoNumbers(arr);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
