package top.byoung.demo.jar.concurrency.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.loadClass("Hello");
        System.out.println(clazz.getClassLoader());

        Object hello = clazz.newInstance();
        System.out.println(hello);
        Method method = clazz.getMethod("welcome");
        String result = (String)method.invoke(hello);
        System.out.println(result);
    }
}
