package statck_queue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作你许一个栈
 * 设计两个递归函数
 * 1.从栈中返回栈底元素并移除
 * 2.通过找出的栈底元素逆序栈
 */
public class ReverseStackByRecursion {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int i = getAndRemoveLastElement(stack);
            stack.push(result);
            return i;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(5);
        reverse(stack);
        for (Integer a : stack) {
            System.out.print(a);
        }
    }

}
