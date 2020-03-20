package com.tianhy.datastructures.fail_fast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: thy
 * @Date: 2020/2/25 0:26
 * @Desc: 在遍历时，使用删除测试 fail-fast
 */
public class ArrayListFailTest {


    public static void arrayListFail() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        for (String s : list) {
            if ("two".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list.size());
        System.out.println(list);//[one, three]


        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            synchronized (iterator) {
                String next = iterator.next();
                if (next.equals("two")) {
                    iterator.remove();
                }
            }
        }
    }

    public static void cow() {
/*
        List<Long> copy = new CopyOnWriteArrayList<>();
        long start = System.nanoTime();
        //如果在循环20万次的遍历中，直接对COW进行添加操作，是灾难性的
        for (int i = 0; i < 20 * 10000; i++) {
            copy.add(System.nanoTime());
        }
       //97s
*/
        //解决办法就是，可以先将数据填充到ArrayList中去，然后把ArrayList集合当做COW的参数
        List<Long> array = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 20 * 10000; i++) {
            array.add(System.nanoTime());
        }
        List<Long> cow = new CopyOnWriteArrayList<>(array);
        long end = System.nanoTime();
        System.out.println((end - start) / (1000 * 1000) + "ms");//48ms
        System.out.println(cow.size());
    }


    public static void main(String[] args) {
        cow();
    }
}
