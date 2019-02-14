package top.byoung.demo.jar.concurrency.monitor;

public interface TaskLifeCycle<T> {
    void onStart(Thread thread);

    void onRunning(Thread thread);

    void onFinish(Thread thread, T result);

    void onError(Thread thread);


    class EmptyLifeCycle<T> implements TaskLifeCycle<T> {
        @Override
        public void onStart(Thread thread) {
            System.out.println(">>>>>start...");
        }

        @Override
        public void onRunning(Thread thread) {
            System.out.println(">>>>>running...");
        }

        @Override
        public void onFinish(Thread thread, T result) {
            System.out.println(">>>>>finish...");
        }

        @Override
        public void onError(Thread thread) {
            System.out.println(">>>>>error...");
        }
    }
}
