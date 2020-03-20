package com.tianhy.datastructures.treemap;

import java.util.TreeMap;

/**
 * @Author: thy
 * @Date: 2020/2/25 6:18
 * @Desc:
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
    }

    public static void treeMapTest() {
        //如果是HashMap，size=1
        TreeMap map = new TreeMap();
        map.put(new Key(), "one");
        map.put(new Key(), "two");
        System.out.println(map.size()); //2
    }

    static class Key implements Comparable<Key> {
        //返回负的常数，表示此对象永远小于输入的的对象other，此处决定treeMap的size是2
        @Override
        public int compareTo(Key other) {
            return -1;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    //TreeMap是依赖Comparable或Comparator来实现key去重的
    //HashMap是使用hashcode和equals实现去重的
}
