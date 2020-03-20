package com.tianhy.datastructures.fail_fast;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: thy
 * @Date: 2020/2/25 0:13
 * @Desc: 以ArrayList.subList 阐述 fail-fast机制
 */
public class SubListFailFast {

    public static void main(String[] args) {
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);
        //主列表的操作，会导致子列表操作出现异常
        masterList.remove(0);
        masterList.clear();
        masterList.add("six");

        //操作子列表
        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);

        //正常遍历，此时只剩一个元素: seven
        for (Object o : branchList) {
            System.out.println(o);
        }
        //子列表修改导致主列表被动改动
        System.out.println(masterList);// four five seven


    }
}
