package class_01;

public class Palindrome_Number {


    public static boolean isPalindrome(int num){
        if (num < 0){
            return false;
        }

        //找到一个数的最大位，例如num = 28582， help = 10000
        int help = 1;
        while ( num/help >= 10){
            help *= 10;
        }

        while (num != 0) {
            if (num/help != num%10){
                return false;
            }
            num = num % help / 10; //剥去前后两数
            help = help / 100; //help动态改变
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 1258521;
        boolean palindrome = Palindrome_Number.isPalindrome(num);
        System.out.println(palindrome);
    }
}
