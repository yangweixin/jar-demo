package top.byoung.demo.jar.proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: jdk proxy test
 * @author: Yang Weixin
 * @create: 2020/05/07
 */
public class JdkProxyTest {

    public static void main(String[] args) throws Exception {
        Class proxyClazz = Proxy.getProxyClass(IHello.class.getClassLoader(), IHello.class);
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);

//        IHello h1 = (IHello)constructor.newInstance(new MyInvocationHandler(new HelloImpl()));

        Object h2 = Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class, IGoodbye.class}, new MyInvocationHandler(new HelloImpl()));

//        h1.sayHello();
        h2.getClass().getMethod("sayGoodbye").invoke(h2);
//        h2.sayHello();
//        h2.sayGoodbye();
    }
}
