package top.byoung.demo.jar.spi.impl;

import top.byoung.demo.jar.spi.ISearchSPI;

/**
 * @description: FileSearchImpl
 * @author: Yang Weixin
 * @create: 2020/04/29
 */
public class FileSearchImpl implements ISearchSPI {

    public FileSearchImpl() {
        System.out.println("init: this is FileSearchImpl.");
    }

    @Override
    public String search(String keyWork) {
        return "文件搜索";
    }
}
