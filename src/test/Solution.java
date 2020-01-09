package test;

import java.util.Scanner;

public class Solution {

    public boolean check(int[] arr) {
        int count = 0;
        for (int i=0; i < arr.length-1 && count <= 1; i++){
            if (arr[i] > arr[i+1]) {
                count++;
                if ( i-1 < 0 || arr[i-1] <= arr[i+1]){
                    arr[i] = arr[i+1];
                }else {
                    arr[i+1] = arr[i];
                }
            }
        }
        return count<=1;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();


        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String value = in.nextLine();
            String[] s = value.split(" ");
            int[] s1 = new int[s.length];
            for (int i=0; i<s.length; i++){
                s1[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solution.check(s1)?"YES":"NO");
        }
    }
}
