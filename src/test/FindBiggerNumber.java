package test;


public class FindBiggerNumber {
    public static void main(String[] args) {
        int[] a = {1, 5, 11, 24, 25, 32, 32, 33, 49, 66, 68, 69, 70, 75, 88, 102, 114, 119, 120, 135, 146, 221, 294, 300, 302, 305, 333};

        int x = 25;
        int index = fun(a, x);
        System.out.println(index);
    }

    public static int fun(int[] a, int x) {
        if (x >= a[a.length - 1]) return -1;
        return fun(a, x, 0, a.length - 1);   //fun(a[], x, begin, end)  [0, a.length)
    }

    public static int fun(int[] a, int x, int begin, int end) {  //包含begin 不包含end  [begin, end)
        if (end - begin == 1) {
            if (a[begin] > x) return begin;
            return end;
        }

        int index = (begin + end)/2;
        if (x < a[index]) {
            return fun(a, x, begin, index);
        }
        return fun(a, x, index, end);
    }
}
