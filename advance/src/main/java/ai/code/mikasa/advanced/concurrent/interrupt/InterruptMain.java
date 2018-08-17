package ai.code.mikasa.advanced.concurrent.interrupt;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.ibm.com/developerworks/cn/java/j-jtp05236.html
 *
 * 每个线程都有一个与之相关联的 Boolean 属性，用于表示线程的中断状态（interrupted status）。
 * 中断状态初始时为 false；当另一个线程通过调用 Thread.interrupt() 中断一个线程时，会出现以下两种情况之一。
 *
 * 如果那个线程在执行一个低级可中断阻塞方法，例如 Thread.sleep()、 Thread.join() 或 Object.wait()，
 * 那么它将取消阻塞并抛出 InterruptedException。
 *
 * 否则， interrupt() 只是设置线程的中断状态。 在被中断线程中运行的代码以后可以轮询中断状态，看看它是否被请求停止正在做的事情。
 * 中断状态可以通过 Thread.isInterrupted() 来读取，并且可以通过一个名为 Thread.interrupted() 的操作读取和清除。
 *
 * 中断是一种协作机制。当一个线程中断另一个线程时，被中断的线程不一定要立即停止正在做的事情。
 * 相反，中断是礼貌地请求另一个线程在它愿意并且方便的时候停止它正在做的事情。
 * 有些方法，例如 Thread.sleep()，很认真地对待这样的请求，但每个方法不是一定要对中断作出响应。
 * 对于中断请求，不阻塞但是仍然要花较长时间执行的方法可以轮询中断状态，并在被中断的时候提前返回。
 * 您可以随意忽略中断请求，但是这样做的话会影响响应。
 *
 */
public class InterruptMain {
    public static void main(String[] args){
        Thread thread1 = new Thread(() -> {
            String threadName = getCurrentThreadName();
            try {
                System.out.println(threadName + "开始运行。");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(threadName + "被中断了。");
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            String threadName = getCurrentThreadName();
            System.out.println(threadName + "开始运行。");
            System.out.println(Thread.currentThread().isInterrupted());
            Arrays.asList(100, 101, 102, 103, 104, 105)
                    .stream()
                    .collect(Collectors.toSet());
            System.out.println(threadName + "运行结束。");
        });

        thread1.start();
        thread2.start();

        System.out.println("我要中断你了。");
        thread1.interrupt();
        thread2.interrupt();
    }

    public static String getCurrentThreadName(){
        return Thread.currentThread().getName();
    }
}
