package practice.string;

public class ReplaceSpaceStr {


    /**
     * 把字符串中的所有的空格替换成%20，不能使用现成的方法
     * @param str
     * @return
     */
    public static char[] replcaeSpaceStr(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return new char[0];
        }
        char[] chars1 = new char[chars.length + count*2];
        count=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                chars1[count++] = '%';
                chars1[count++] = '2';
                chars1[count++] = '0';
            }else {
                chars1[count++] = chars[i];
            }
        }
        return chars1;
    }

    public static void main(String[] args) {
        System.out.println(ReplaceSpaceStr.replcaeSpaceStr("we are a family"));
    }
}
