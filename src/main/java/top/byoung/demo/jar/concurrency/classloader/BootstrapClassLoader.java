package top.byoung.demo.jar.concurrency.classloader;

public class BootstrapClassLoader {

    public static void main(String[] args) {
        System.out.println("Bootstrap: "+ String.class.getClassLoader());

        System.out.println("root: "+ System.getProperty("sun.boot.class.path"));

        System.out.println("ext: "+ System.getProperty("java.ext.dirs"));

        System.out.println("system: "+ System.getProperty("java.class.path"));
    }
}