package com.tianhy.datastructures.hashcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: thy
 * @Date: 2020/2/24 23:19
 * @Desc:
 */
public class EqualsTest {

    public static void main(String[] args) {

        listEquals();
    }

    public static void hashSetEquals() {
        Set<EqualsObject> hashSet = new HashSet<>();
        EqualsObject a = new EqualsObject(1, "one");
        EqualsObject b = new EqualsObject(1, "one");
        EqualsObject c = new EqualsObject(1, "one");

        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);

        System.out.println(hashSet.size());//3
    }

    public static void listEquals() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);

        if (linkedList.equals(arrayList)) {
            //输出equals，两个不同的集合，输出结果为相等，因为两个集合的equals方法只判断了是否是List的子类
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

    }
}
