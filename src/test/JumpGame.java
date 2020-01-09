package test;

public class JumpGame {



    public static int jumpGame(int[] arr) {
        int jump = 0;
        int cur = 0;
        int next = 0;

        for(int i= 0; i<arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(jumpGame(arr));
    }
}
