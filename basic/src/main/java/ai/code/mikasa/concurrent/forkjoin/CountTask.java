package ai.code.mikasa.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

    private static int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start < THRESHOLD){
            int sum = 0;
            for(int i = start; i <= end; i++){
                sum += i;
            }
            return sum;
        }else {
            int middle = (end + start) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args){
        CountTask countTask = new CountTask(1, 100);
        countTask.fork();
        int result = countTask.join();
        System.out.println("最后计算的结果为：" + result);
    }
}
