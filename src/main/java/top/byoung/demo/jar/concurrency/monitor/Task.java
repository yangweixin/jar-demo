package top.byoung.demo.jar.concurrency.monitor;

@FunctionalInterface
public interface Task<T> {

    T call();
}
