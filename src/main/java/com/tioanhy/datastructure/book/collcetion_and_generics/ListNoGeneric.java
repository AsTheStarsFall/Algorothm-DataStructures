package com.tioanhy.datastructure.book.collcetion_and_generics;

import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: thy
 * @Date: 2020/2/21 0:50
 * @Desc: 集合与泛型
 */
public class ListNoGeneric {
    public static void main(String[] args) {
        jsonObject();
    }

    public void listGeneric() {
        //泛型出现之前集合的定义方式，非泛型集合可以赋值给任何泛型限制的集合
        List list1 = new ArrayList();
        list1.add(new Object());
        list1.add(new Integer(1));
        list1.add(new String("str"));

        //增加泛型限制Object
        List<Object> list2 = list1;
        list2.add(new Object());
        list2.add(new Integer(2));
        list2.add(new String("str1"));

        //增加泛型限制Integer
        List<Integer> list3 = list1;
        list3.add(new Integer(3));
        //不允许添加非Integer的元素
/*
        list3.add(new Object());
        list3.add(new String("str2"));
*/

        //增加了通配符
        List<?> list4 = list1;
        //允许删除和清除元素
        list4.remove(0);
        list4.clear();
        //不允许添加任何元素
/*
        list4.add(new Object());
*/
    }

    //net.sf.json.JSONObject的问题代码
    public static void jsonObject() {
        JSONObject jsonObject = JSONObject.fromObject("{\"level\":[\"3\"]}");
        List<Integer> list = new ArrayList<>(10);
        if (jsonObject != null) {
            list.addAll(jsonObject.getJSONArray("level"));
            int a = 0;
            for (Integer integer : list) {
                //编译出错：java.lang.String cannot be cast to java.lang.Integer
                a = integer + a;
            }
        }
    }
}
