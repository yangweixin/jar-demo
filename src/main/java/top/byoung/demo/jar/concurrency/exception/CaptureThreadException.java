package top.byoung.demo.jar.concurrency.exception;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {

    public static void main(String[] args) {

        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println(group.getName());
        System.out.println(group.getParent().getName());
        System.out.println(group.getParent().getParent().getName());
//
//        Thread.setDefaultUncaughtExceptionHandler(
//            ((t, e) -> {
//                System.out.println(t.getName());
//                e.printStackTrace();
//            })
//        );
//
//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            int i = 1/0;
//        }).start();
    }
}
