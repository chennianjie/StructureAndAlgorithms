package linkedlist;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int[] MergeArrays(ArrayList<ArrayList<Integer>> seqs) {

        int N = seqs.size();
        int L;
        if (N == 0){
            return new int[0];
        } else {
            L = seqs.get(0).size();
            for (int i = 1; i < N; i++) {
                if (L != seqs.get(i).size()){
                    return new int[0];
                }
            }
        }
        int[] result = new int[N * L];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < L; j++){
                result[i * L + j] = seqs.get(i).get(j);
            }
        }
        Arrays.sort(result);
        return result;
    }

    int search(int[] a, int x) {

        if (a == null || a.length < 1){
            return -1;
        }
        int index = 0;
        for (int i=0; i<a.length; i++){
            if (a[i] > a[i+1]){
                index = i + 1;
            }
        }
        int[] a1 = new int[index];
        int[] a2 = new int[a.length - index];
        int a1x = biSearch(a1, x, 0, a1.length - 1);
        int a2x = biSearch(a2, x, 0, a2.length - 1);
        if (a1x != -1){
            return a1x;
        } else if (a2x != -1){
            return a2x+index;
        } else {
            return -1;
        }
    }


    public static int biSearch(int[] array, int a, int left, int right) {
        //第一步找出递归条件的base case
        if (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == a) {
                return mid + 1;
            }

            if (array[mid] > a) {
                return biSearch(array, a, left, mid-1);
            }

            if (array[mid] < a) {
                return biSearch(array, a, mid+1, right);
            }
        }
        return -1;
    }


}
