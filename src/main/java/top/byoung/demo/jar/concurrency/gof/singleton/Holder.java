package top.byoung.demo.jar.concurrency.gof.singleton;

public class Holder {

    private byte[] data = new byte[1024];

    private Holder() {

    }

    private static class Inner {
        private static Holder instance = new Holder();
    }

    public static Holder getInstance() {
        return Inner.instance;
    }
}
