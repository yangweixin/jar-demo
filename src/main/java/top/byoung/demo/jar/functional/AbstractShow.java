package top.byoung.demo.jar.functional;

/**
 * @description: abstract show
 * @author: Yang Weixin
 * @create: 2019/12/12
 */
public interface AbstractShow {

    default void play() {
        System.out.println("-----> live house 燥起来");
    }
}
