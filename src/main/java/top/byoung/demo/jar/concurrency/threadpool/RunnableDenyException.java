package top.byoung.demo.jar.concurrency.threadpool;

public class RunnableDenyException extends RuntimeException{

    public RunnableDenyException(String message) {
        super(message);
    }
}
