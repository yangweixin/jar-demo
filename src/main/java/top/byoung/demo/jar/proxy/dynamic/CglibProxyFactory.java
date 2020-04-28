package top.byoung.demo.jar.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description: cglib proxy factory
 * @author: Yang Weixin
 * @create: 2019/12/05
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("----->cglib proxy begin.");

        Object result = method.invoke(target, args);

        System.out.println("----->cglib proxy end.");

        return result;
    }
}
