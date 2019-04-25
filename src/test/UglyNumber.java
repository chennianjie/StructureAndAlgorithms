package test;

/**
 * 寻找第n个丑数
 * 规定1为丑数，其他数如果是1，2，3，5这三个数相乘得来即是丑数
 */
public class UglyNumber {


    public int uglyNumber1(int n) {
        int number = 1;
        while (true) {
            if (check(number)){
                n--;
                if (n == 0){
                    break;
                }
            }
            number++;
        }
        return number;
    }

    public boolean check(int number){
        while (number%2 == 0) {
            number = number/2;
        }
        while (number%3 == 0) {
            number = number/3;
        }
        while (number%5 == 0) {
            number = number/5;
        }
        return number == 1;
    }

    /**
     * 发现规律：下一个丑数等于它前面的丑数数乘以2，3，5的乘积取最小的值
     * @return
     */
    public int uglyNumber2(int n){
        //创建一个数组存储所有丑数，用于计算之后丑数
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        int i2 = 0;//乘2的索引
        int i3 = 0;//乘3
        int i5 = 0;//乘5
        int index = 1;
        while (n != 1) {
            uglyArr[index] = Math.min(uglyArr[i2] * 2, Math.min(uglyArr[i3] * 3, uglyArr[i5] * 5));
            if (uglyArr[index] == uglyArr[i2] * 2) {
                i2++;
            }
            if (uglyArr[index] == uglyArr[i3] * 3) {
                i3++;
            }
            if (uglyArr[index] == uglyArr[i5] * 5) {
                i5++;
            }
            index++;
            n--;
        }
        return uglyArr[index-1];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.uglyNumber1(8));
        System.out.println(uglyNumber.uglyNumber2(4));
    }
}
