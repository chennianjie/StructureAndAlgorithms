package statck_queue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * 准备两个栈一个负责压入一个负责弹出
 * 压入栈找准时机不断向弹出栈压入数据，但需满足两点要求:
 * 1.压入栈必须一次性全部取出压入弹出栈  2.弹出栈只有为空的时候才可以对其进行压入
 */
public class TwoStackQueue {


    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();


    public void update(){
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
    }

    public void push(Integer v) {
        pushStack.push(v);
        update();
    }

    public Integer pop(){
        update();
        return popStack.pop();
    }

    public Integer peek(){
        update();
        return popStack.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        twoStackQueue.push(3);
        twoStackQueue.push(4);
        twoStackQueue.push(2);
        System.out.println(twoStackQueue.pushStack.size());
        System.out.println(twoStackQueue.popStack.size());
        System.out.print(twoStackQueue.pop());
        System.out.print(twoStackQueue.pop());
        System.out.print(twoStackQueue.pop());
        System.out.print(twoStackQueue.pop());
        System.out.print(twoStackQueue.pop());
    }
}
