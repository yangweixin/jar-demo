package top.byoung.demo.jar.functional;

/**
 * @description: abstract show
 * @author: Yang Weixin
 * @create: 2019/12/12
 */
public interface AbstractDrama {

    default void play() {
        System.out.println("-----> 话剧演起来，演员请就位");
    }
}
