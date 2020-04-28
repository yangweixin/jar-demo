package top.byoung.demo.jar.proxy.dynamic;

/**
 * @description: userdao implements
 * @author: Yang Weixin
 * @create: 2019/12/05
 */
public class UserDaoImpl/* implements UserDao */{

//    @Override
    public String find() {
        System.out.println("----->我就是我");
        return "我就是我";
    }

//    @Override
    public String say() {
        System.out.println("----->say something");
        return "say something";
    }

    @Override
    public String toString() {
        System.out.println("----->tostring");
        return super.toString();
    }
}
