package test;

public class DigitCounts {

    public static int digitCounts(int k, int n) {
        // write your code here
        int count = 0;
        String v = "";
        while (n>=0) {
            v+=n;
            n--;
        }
        char[] chars = v.toCharArray();
        for (char a : chars) {
            if ((a - '0') == k) {
                count++;
            }
        }
        return count;
    }


    /**
     * 优化版本
     * @param k
     * @param n
     * @return
     */
    public static int digitCounts2(int k, int n) {
        // write your code here
        int res = 0;
        if (k>n) {
            return res;
        }
        //挨个遍历每一个k~n中的数，统计结果
        for (int i = k; i <= n; i++ ) {
            res += countSingleNum(i, k);//k指的是待查找的那个数
        }
        return res;
    }

    private static int countSingleNum(int i, int k) {
        //当i和k都等于0的时候
        //按个位十位依此比较
        int coun = 0;
        if (i == k && i == 0) {
            return 1;
        }
        while (i!=0) {
            if (i%10 == k) {
                coun++;
            }
            i /= 10;
        }
        return coun;
    }

    //继续优化，时间复杂度O（logn）
    //分k=0和k!=0讨论
    //举例：12345中3在千位出现的次数为：1*1000，3在百分位出现的次数为12*100+45+1=1246，3在十位出现的次数为123*10+10=1240
    public static void main(String[] args) {
        System.out.println(DigitCounts.digitCounts(1,1));
        System.out.println(DigitCounts.digitCounts(1,12));
        System.out.println(DigitCounts.digitCounts2(1,1));
        System.out.println(DigitCounts.digitCounts2(1,12));
    }
}
