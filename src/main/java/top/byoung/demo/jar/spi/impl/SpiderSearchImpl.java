package top.byoung.demo.jar.spi.impl;

import top.byoung.demo.jar.spi.ISearchSPI;

/**
 * @description: FileSearchImpl
 * @author: Yang Weixin
 * @create: 2020/04/29
 */
public class SpiderSearchImpl implements ISearchSPI{


    public SpiderSearchImpl() {
        System.out.println("init: this is SpiderSearchImpl.");
    }

    @Override
    public String search(String keyWork) {
        return "这是啥呀";
    }
}
