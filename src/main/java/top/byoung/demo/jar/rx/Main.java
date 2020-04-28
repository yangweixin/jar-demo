package top.byoung.demo.jar.rx;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = Stream.of(list, list2).flatMap(l -> l.stream()).collect(Collectors.toList());
        System.out.println(list2);
    }
}
