package practice;


public class FindOnceNumber {

    public static int findOnceNumber(int[] arr) {
        int result = 0;

        for (int i=0; i<=arr.length-1; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static  int[] fun(int []a){
        int n=0;
        int[] res = new int[2];
        for(int i=0;i<a.length;i++){
            n^=a[i];
        }
        int index = findFirst1(n);
        for(int i = 0; i < a.length; ++i){
            if(isBit1(a[i], index)){
                res[0] ^= a[i];
            }else{
                res[1] ^= a[i];
            }
        }
        return res;
    }
    //找出二进制表示中第一个为1的位数
    private static int findFirst1(int bitResult){
        int index = 0;
        boolean a = ((bitResult & 1) == 0);
        boolean b = index < 32;
        while(a && b){
            bitResult >>= 1;
            index++;
        }
        return index;
    }
    //对原数组进行分类
    private static boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 0;
    }
    public static void main(String[] args) {
        int[] a = {3, 2, 5, 8, 4, 2, 3, 7, 5, 8};
        for (int n : fun(a)) {
            System.out.println(n);
        }
    }








//    public static void main(String[] args) {
//        int[] arr = {1,2,1,3,2};
//        int onceNumber = FindOnceNumber.findOnceNumber(arr);
//        System.out.println(onceNumber);
//
//    }
}
