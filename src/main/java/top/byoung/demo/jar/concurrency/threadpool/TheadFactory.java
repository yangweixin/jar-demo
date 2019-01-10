package top.byoung.demo.jar.concurrency.threadpool;

@FunctionalInterface
public interface TheadFactory {

    Thread createThread(Runnable runnable);
}
