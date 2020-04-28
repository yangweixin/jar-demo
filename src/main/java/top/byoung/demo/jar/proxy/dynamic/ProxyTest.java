package top.byoung.demo.jar.proxy.dynamic;

/**
 * @description: 动态代理测试
 * @author: Yang Weixin
 * @create: 2019/12/05
 */
public class ProxyTest {

    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();

        UserDaoImpl proxy = (UserDaoImpl) new CglibProxyFactory(userDao).getProxyInstance();

        proxy.say();
        proxy.say();
    }
}
