package test;


import java.util.LinkedList;

/**
 * 给定一个数组和常数k，求数组中有多少对子数组满足其中的最大值与最小值的差值小于等于k
 */
public class AllLessNumSubArray {

    public static int allLessNumSubArray(int[] nums, int k) {
        int res = 0;
        //结论：如果在一个数组范围内，其中最大值和最小值差值满足条件（小于等于k），则这个数组子数组也满足这个条件
        //设计一个最大值的窗口结构（双端链表）
        //设计一个最小值的窗口结构
        //先求出R满足条件所能达到的最大范围，然后L淘汰掉一个，再看R能不能继续扩展，直到R到达边界，最后L到达边界结束，在这过程中统计结果
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int L = 0;
        int R = 0;
        while (L < nums.length) {
            while (R < nums.length) {
                //填充最大范围的数组
                if (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[R]) {
                    maxQueue.pollLast();
                }
                maxQueue.addLast(R);
                if (!minQueue.isEmpty() && nums[minQueue.peekLast()] > nums[R]) {
                    minQueue.pollLast();
                }
                minQueue.addLast(R);
                //判断如果最大值与最小值差值不满足条件即跳出循环
                if (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > k) {
                    break;
                }
                R++;
            }

            res += R - L;
            L++;
        }

        return res;
    }
}
