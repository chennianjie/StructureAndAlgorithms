package test;

public class StringParseInt {


    /**
     * 把一个string的num转换成int类型
     * @param num
     * @return
     */
    public static int stringParseInt(String num) {

        if (num == null) {
            throw new RuntimeException("can not convert");
        }

         //把String转换成char数组，检查第一位数，正数负数的差别
        //先把数全部转换成他的负数形式，进行判断其是否越界，最后再变回原来的形式返回
        char[] chars = num.toCharArray();
        if (!isValid(chars)) {
            throw new RuntimeException("can not convert");
        }
        boolean positive = chars[0] == '-' ? false : true;//是否为正数
        //判定条件
        int minq = Integer.MIN_VALUE / 10;//检测高位
        int minr = Integer.MIN_VALUE % 10;//检测低位
        int res = 0;//结果
        int cur = 0;//当前值
        for (int i = positive ? 0 : 1; i<chars.length; i++) {
            cur = '0' - chars[i]; // '1'--'-1'  '2'--'-2'
            //res乘10之后超过最小界限或res*10等于最小界限加cur超过界限
            if (res < minq || res == minq && cur < minr){
                throw new RuntimeException("can not convert");
            }
            res = res * 10 + cur;//-327  -3 -32 -327
        }
        //如果res等于最小界限，但是它是一个正数，不符合要求
        if (res == Integer.MIN_VALUE && positive) {
            throw new RuntimeException("can not convert");
        }
        //按正负返回原来的形式
        res = positive ? -res : res;
        return res;
    }

    /**
     * 判断是否为有效字符
     * @param chars
     * @return
     */
    private static boolean isValid(char[] chars) {
        //首位不是-的时候
        if (chars[0] != '-' && chars[0] < '0' || chars[0] > '9') {
            return false;
        }
        //首位是-的时候,排除“-0”的情况
        if (chars[0] == '-' && chars.length == 1 && chars[1] == '0') {
            return false;
        }
        //首位是0，但是后面还有数字排除
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "2147483647"; // max in java
        System.out.println(stringParseInt(test1));

        String test2 = "-2147483648"; // min in java
        System.out.println(stringParseInt(test2));

        String test3 = "2147483648"; // overflow
        System.out.println(stringParseInt(test3));
//
//        String test4 = "-2147483649"; // overflow
//        System.out.println(stringParseInt(test4));

        String test5 = "-123";
        System.out.println(stringParseInt(test5));

    }
}
