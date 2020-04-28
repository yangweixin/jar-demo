package top.byoung.demo.jar.functional;

/**
 * @description: band show
 * @author: Yang Weixin
 * @create: 2019/12/12
 */
public class BandShow implements AbstractShow, AbstractDrama {

    @Override
    public void play() {
        System.out.println("-----> 橘子海，orange ocean");
    }
}
