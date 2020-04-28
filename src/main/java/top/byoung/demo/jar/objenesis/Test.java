package top.byoung.demo.jar.objenesis;

import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

/**
 * @description: test
 * @author: Yang Weixin
 * @create: 2019/12/10
 */
public class Test {

    public static void main(String[] args) {
        ObjenesisStd objenesisStd = new ObjenesisStd();
        Object obj = objenesisStd.newInstance(User.class);
        if (obj instanceof User) {
            User user = (User)obj;
            System.out.println(user);
        }

        ObjectInstantiator<User> objectInstantiator = objenesisStd.getInstantiatorOf(User.class);
        User user1 = objectInstantiator.newInstance();
        User user2 = objectInstantiator.newInstance();
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
    }
}
