package top.byoung.demo.jar.concurrency.exception;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {

    public static void main(String[] args) {

//        ThreadGroup group = Thread.currentThread().getThreadGroup();
//        System.out.println(group.getName());
//        System.out.println(group.getParent().getName());
//        System.out.println(group.getParent().getParent().getName());

//        Thread.setDefaultUncaughtExceptionHandler(
//            ((t, e) -> {
//                System.out.println(">>>>>>2 "+ t.getName());
//                e.printStackTrace();
//            })
//        );

        new Thread(new ChildThread()).start();
    }
}

class ChildThread implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("thread");
            int i = 1/0;
        } catch (Exception e) {
            System.out.println(">>>>>>1 "+ Thread.currentThread().getName());
            e.printStackTrace();
        }
    }
}
