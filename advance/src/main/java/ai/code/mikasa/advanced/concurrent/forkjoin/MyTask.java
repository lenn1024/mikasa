package ai.code.mikasa.advanced.concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MyTask extends RecursiveAction {
    private List<Integer> list;
    private int low;
    private int high;

    public MyTask(List<Integer> list) {
        if(list == null || list.size() < 1){
            throw new IllegalArgumentException("empty list.");
        }
        this.list = list;
        this.low = 0;
        this.high = list.size();
    }

    public MyTask(List<Integer> list, int low, int high) {
        this.list = list;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
//        System.out.println(String.format("start compute: low(%s), high(%s)", this.low, this.high));
        if(this.high - this.low < 10){
            for(int i = this.low; i < this.high; i++){
                System.out.print(String.format("%s;", this.list.get(i)));
            }
            System.out.println("");
            return;
        }

        int middle = (this.high + this.low)/2;
        MyTask task1 = new MyTask(list, low, middle);
        MyTask task2 = new MyTask(list, middle, high);

        invokeAll(task1, task2);
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(i);
        }

        MyTask task = new MyTask(list);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        System.out.println(forkJoinPool.getParallelism());
//        System.out.println(forkJoinPool.getPoolSize());
//        System.out.println(Runtime.getRuntime().availableProcessors());
        forkJoinPool.invoke(task);
        forkJoinPool.shutdown();
    }
}
