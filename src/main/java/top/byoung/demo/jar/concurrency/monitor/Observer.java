package top.byoung.demo.jar.concurrency.monitor;

public interface Observer {

    enum Cycle {
        STARTED, RUNNING, DONE, ERROR
    }

    Cycle getCycle();

    void start();

    void interrupt();
}
