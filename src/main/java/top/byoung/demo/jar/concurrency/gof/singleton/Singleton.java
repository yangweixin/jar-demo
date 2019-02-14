package top.byoung.demo.jar.concurrency.gof.singleton;

public enum Singleton {

    INSTANCE;

    private byte[] data = new byte[2014];
    Singleton() {
        System.out.println("instance been initialized.");
    }

    public static void m() {
        System.out.println("method");
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}

class Test {
    public static void main(String[] args) {
        Singleton.m();
    }
}
