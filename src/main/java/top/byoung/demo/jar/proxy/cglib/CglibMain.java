package top.byoung.demo.jar.proxy.cglib;

import net.sf.cglib.util.ParallelSorter;
import org.junit.Test;

/**
 * @description: main
 * @author: Yang Weixin
 * @create: 2020/05/06
 */
public class CglibMain {

    @Test
    public void testMulticastDelegate() throws Exception{
        Integer[][] value = {
            {4, 3, 9, 0},
            {2, 1, 6, 0}
        };
        ParallelSorter.create(value).mergeSort(0);

        for(Integer[] row : value){
            int former = -1;
            for(int val : row){
                System.out.println(val);
            }
        }
    }
}
