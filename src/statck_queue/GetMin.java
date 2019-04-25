package statck_queue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的结构，push pop getMin操作的时间复杂度都为O（1）
 */
public class GetMin {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer v){
        dataStack.push(v);
        if (minStack.empty()) {
            minStack.push(v);
        }

        if (v <= minStack.peek()) {
            minStack.push(v);
        }

        if (v > minStack.peek()) {
            minStack.push(minStack.peek());
        }
    }

    public Integer pop(){
        minStack.pop();
        return dataStack.pop();
    }

    public Integer getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        GetMin getMin = new GetMin();
        getMin.push(1);
        getMin.push(2);
        getMin.push(5);
        getMin.push(0);
        getMin.push(10);
        getMin.push(10);

        System.out.println(getMin.getMin());
        getMin.pop();getMin.pop();
        getMin.push(-1);
        System.out.println(getMin.getMin());
    }
}
