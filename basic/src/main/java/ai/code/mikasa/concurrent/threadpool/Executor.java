package ai.code.mikasa.concurrent.threadpool;

/**
 * 执行提交的Runnable任务
 * 提供一种机制，减少开发者工作量：不需要显示的创建线程，调度线程执行任务
 *
 */
public interface Executor {
    void execute(Runnable command);
}
