package top.byoung.demo.jar;

import top.byoung.demo.jar.spi.ISearchSPI;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description:
 * @author: Yang Weixin
 * @create: 2020/01/15
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<ISearchSPI> load = ServiceLoader.load(ISearchSPI.class);
        Iterator<ISearchSPI> iterator = load.iterator();
        while (iterator.hasNext()){
            ISearchSPI next = iterator.next();
            String spiTest = next.search("测试spi");
            System.out.println(spiTest);
        }
    }
}
