package top.byoung.demo.jar.concurrency;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
    }
}
