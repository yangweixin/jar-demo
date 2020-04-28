package top.byoung.demo.jar.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description: future test main
 * @author: Yang Weixin
 * @create: 2019/12/16
 */
public class FutureTest {

    public static void main(String[] args) {
        Callable<Chuju> onlineShopping = new Callable<Chuju>() {
            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                Thread.sleep(5000);  // 模拟送货时间
                System.out.println("第一步：快递送到");
                return new Chuju();
            }
        };

        FutureTask futureTask = new FutureTask<Chuju>(onlineShopping);

    }

    //  用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}
}
