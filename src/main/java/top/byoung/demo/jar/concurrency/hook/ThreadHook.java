package top.byoung.demo.jar.concurrency.hook;

import java.util.concurrent.TimeUnit;

public class ThreadHook {

    public static void main(String[] args) {

        System.out.println("program started.");

        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                @Override
                public void run() {
                    System.out.println("hook 1 started.");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hook 1 ended");
                }
            }
        );


        Runtime.getRuntime().addShutdownHook(
            new Thread() {
                @Override
                public void run() {
                    System.out.println("hook 2 started.");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hook 2 ended");
                }
            }
        );

//        int i = 1/0;
//        System.out.println("program ended.");

        while(true) {
            System.out.println("program running...");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
