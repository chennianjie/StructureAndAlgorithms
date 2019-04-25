package linkedlist;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static int BinaryToDecimal(String binary){

        int binaryNumber = Integer.parseInt(binary);

        int decimal = 0;
        int p = 0;
        while(true){
            if(binaryNumber == 0){
                break;
            } else {
                int temp = binaryNumber%10;
                decimal += temp*Math.pow(2, p);
                binaryNumber = binaryNumber/10;
                p++;
            }
        }
        return decimal;
    }

    public static void main(String args[]){
        System.out.println("110 --> "+Test.BinaryToDecimal("110"));
        System.out.println("1101 --> "+Test.BinaryToDecimal("1101"));
        System.out.println("100 --> "+Test.BinaryToDecimal("100"));
        System.out.println("110111 --> "+Test.BinaryToDecimal("110111"));
        new CopyOnWriteArrayList();
    }
}
