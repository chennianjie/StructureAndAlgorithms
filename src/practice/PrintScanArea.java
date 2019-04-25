package practice;

import java.util.Scanner;

public class PrintScanArea {


    /**
     *
     * @param a 行
     * @param b 每行多少数据
     * @param str
     */
    public static void printScanArea(int a, int b, char[] str) {
        int size = a*b;
        if (size > 10000) {
            System.out.println("Incorrect mesh size");
            return;
        }
        //判断是否存在无效字符
        if (isInValidStr(str)) {
            System.out.println("Invalid cell type");
            return;
        }

        if (size != str.length) {
            System.out.println("Data misMatch");
            return;
        }
        for (int i=1; i<=a; i++) {
            String result = new String(str, (i-1)*b, b);
            if (i%2 != 0) {//是奇数的时候，正序输出
                System.out.println(result);
            }else {//是偶数的时候
                System.out.println(new StringBuffer(result).reverse());
            }
        }
    }

    public static char[] generateRandomArray(int a, int b) {


        int size = a * b;
        System.out.println(a + " " + b);
        char[] arr = new char[size];
        char[] help = {'R', 'F', 'G'};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = help[(int)(Math.random()*3)] ;
        }
        return arr;
    }


    public static boolean isInValidStr(char[] str) {
        for (char s : str) {
            if (s != 'G' && s != 'F' && s != 'R') {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
          //第一种方式控制台输入
//        -------开始--------------
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        char[] str = scanner.nextLine().toCharArray();
        printScanArea(a, b, str);
//        -------结束--------------


          //第二种方式直接测试
//        -------开始--------------
//        int a = (int) ((101) * Math.random());
//        int b = (int) ((101) * Math.random());
//        char[] chars = generateRandomArray(a, b);
//        System.out.println(chars);
//        printScanArea(a, b, chars);
//        -------结束--------------
    }
}
