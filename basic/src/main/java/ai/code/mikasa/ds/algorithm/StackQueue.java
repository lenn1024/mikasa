package ai.code.mikasa.ds.algorithm;

import java.util.Stack;

/**
 * 使用栈实现一个队列
 */
public class StackQueue {

    public static void main(String[] args){
        StackQueue queue = new StackQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private Stack<Integer> inStack;

    private Stack<Integer> outStack;

    public StackQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void enqueue(Integer element){
        inStack.push(element);
    }

    public Integer dequeue(){
        if(outStack.isEmpty()){
            transfer();
        }

        return outStack.pop();
    }

    public void transfer(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
