package top.byoung.demo.jar.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理工厂
 * @author: Yang Weixin
 * @create: 2019/12/05
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new InvocationHandler(){
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("----->这就是动态代理。");
                    Object result = method.invoke(target, args);
                    System.out.println("----->看完了吧，88。");

                    return result;
                }
            }
        );
    }
}
