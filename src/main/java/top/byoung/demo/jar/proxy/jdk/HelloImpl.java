package top.byoung.demo.jar.proxy.jdk;

/**
 * @description: HelloImpl
 * @author: Yang Weixin
 * @create: 2020/05/07
 */
public class HelloImpl implements IHello {

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }

    public void sayGoodbye() {
        System.out.println("Good Bye!");
    }
}
