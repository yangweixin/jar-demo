package top.byoung.demo.jar.concurrency.monitor;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        final TaskLifeCycle<String> taskLifeCycle = new TaskLifeCycle.EmptyLifeCycle<String>() {
            @Override
            public void onFinish(Thread thread, String result) {
                System.out.println("finished. result = "+ result);
            }
        };

        Observer observerThread = new ObserverThread<String>( taskLifeCycle, () -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("finish.");

            return "event finished.";
        });

        observerThread.start();
    }
}
