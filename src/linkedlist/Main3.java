package linkedlist;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        int[] xs = new int[]{1, 3, 2, 3, 2, 2};
        Main3 m = new Main3();
        System.out.println(m.entropy(xs));
    }

    double entropy(int[] xs) {
        //数组中的value作为map的key，map的value代表重复次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < xs.length; i++) {
            Integer times = map.get(xs[i]);
            if (times == null) {
                map.put(xs[i], 1);
            } else {
                map.put(xs[i], times + 1);
            }
        }
        return calculate(map, xs.length);
    }

    public double calculate(Map<Integer, Integer> map, int total) {
        double res = 0;
        double p;
        Collection<Integer> values = map.values();
        for (Integer times : values) {
            p = (times + 0.0) / total;
            res -= p * log2(p);
        }
        return res;
    }

    public double log2(double N) {
        return Math.log(N) / Math.log(2);//Math.log的底为e
    }
}