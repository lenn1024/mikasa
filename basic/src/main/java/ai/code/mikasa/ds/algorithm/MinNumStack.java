package ai.code.mikasa.ds.algorithm;

import java.util.Stack;

/**
 * 在O(1)的时间复杂度内，能够获取最小值的栈
 */
public class MinNumStack {

    public static void main(String[] args){
        MinNumStack instance = new MinNumStack();

        instance.push(5);
        instance.push(2);
        instance.push(1);
        instance.push(3);
        instance.push(4);

        System.out.println(instance.getMin());

        instance.pop();
        instance.pop();
        instance.pop();
        System.out.println(instance.getMin());
    }

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minNumStack = new Stack<>();

    private Integer minNum;


    public void push(int num){
        if(minNum == null){
            minNum = num;
        }

        stack.push(num);
        if(minNum >= num){
            minNumStack.push(num);
            minNum = num;
        }
    }

    public int pop(){
        int val = stack.pop();
        if(val == minNum){
            minNumStack.pop();
            minNum = minNumStack.peek();
        }

        return val;
    }

    public Integer getMin(){
        return minNum;
    }

}
