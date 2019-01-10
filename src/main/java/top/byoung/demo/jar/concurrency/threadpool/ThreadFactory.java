package top.byoung.demo.jar.concurrency.threadpool;

@FunctionalInterface
public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
