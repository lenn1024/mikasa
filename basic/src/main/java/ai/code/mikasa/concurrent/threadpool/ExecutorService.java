package ai.code.mikasa.concurrent.threadpool;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface ExecutorService extends Executor {

    /**
     * shutdown ExecutorService，不再接受新的请求
     * 该方法会允许已提交的任务执行完毕
     * 比较友好
     */
    void shutdown();

    /**
     * shutdown ExecutorService，不再接受新的请求
     * 同时停止正在运行的任务（尽最大努力，不一定成功。因为有些任务对中断不友好）
     * @return 没有开始执行的任务列表
     */
    List<Runnable> shutdownNow();

    /**
     * 类似于execute方法，但它会返回一个Future对象
     * Future可以cancel任务的执行，也可以阻塞等待任务的完成
     * @param task
     * @param <T>
     * @return
     */
    <T> Future<T> submit(Callable<T> task);

    /**
     * 上述方法的重载
     * @param task
     * @param result
     * @param <T>
     * @return
     */
    <T> Future<T> submit(Runnable task, T result);

    /**
     * 上述方法的重载
     * @param task
     * @return
     */
    Future<?> submit(Runnable task);


}
