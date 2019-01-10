package top.byoung.demo.jar.concurrency.threadpool;

public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();
}
