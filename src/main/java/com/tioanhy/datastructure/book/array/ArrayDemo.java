package com.tianhy.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: thy
 * @Date: 2020/2/24 4:46
 * @Desc: 数组
 */
public class ArrayDemo {

    public static void array1() {
        String[] strings = {"a", "b"};
        //数组引用赋值给obj
        Object obj = strings;
        //将obj强转并赋值， obj[0]="object"
        ((String[]) obj)[0] = "object";
    }

    public static void array2() {
        //静态初始化
        String[] strings = {"a", "b"};
        //动态初始化
        String[] strings1 = new String[2];
        strings1[0] = "a";
        strings1[1] = "b";

        //java8遍历
        Arrays.asList(strings).stream().forEach(x -> System.out.println(x));
        Arrays.asList(strings).stream().forEach(System.out::println);

    }

    //Arrays.asList方法
    public static void asListFunc() {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        //数组转为集合，并将第一个元素修改
        stringList.set(0, "oneList");
        //数组的值也随之改变
        System.out.println(stringArray[0]);

        //抛出运行时异常：AbstractList#add的异常：UnsupportedOperationException
        stringList.add("");
        stringList.remove(0);
        stringList.clear();

        /*---------------------------------------------------------------*/

        //应该使用这种方式转集合
        List<String> stringArrayList = new ArrayList<>(Arrays.asList(stringArray));
        stringArrayList.set(0, "1");
        stringArrayList.add("5");

        System.out.println(Arrays.toString(stringArray));
        System.out.println(stringArrayList.toString());

    }

    //集合转数组
    public static void list2Array() {
        List<String> list = new ArrayList<>(3);
        list.add("one");
        list.add("two");
        list.add("three");

        //泛型丢失
        Object[] array1 = list.toArray();

        //array2数组长度小于元素个数
        String[] array2 = new String[1];
        list.toArray(array2);
        System.out.println(Arrays.asList(array2)); //[null]

        //array3数组长度大于元素个数
        String[] array3 = new String[3];
        //成功将元素赋值到array3数组中
        list.toArray(array3);
        System.out.println(Arrays.asList(array3));
    }


    //集合转数组的三种情况
    private static final int COUNT = 100 * 100 * 100 * 10;
    public static void listToArray() {

        List<Double> list = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            list.add(i * 1.0);
        }

        long start = System.nanoTime();

        //数组容量不足
        Double[] notEnoughArray = new Double[COUNT - 1];
        list.toArray(notEnoughArray);
        long middle1 = System.nanoTime();
        //数组容量刚刚好
        Double[] equallArray = new Double[COUNT];
        list.toArray(equallArray);
        long middle2 = System.nanoTime();
        //数组容量大于集合大小
        Double[] doubleArray = new Double[COUNT * 2];
        list.toArray(doubleArray);
        long end = System.nanoTime();

        long notEnoughTime = middle1 - start;
        long equalTime = middle2 - middle1;
        long doubleTime = end - middle2;

        System.out.println("数组容量小于集合大小:" + notEnoughTime / (1000 * 1000) + "ms");
        System.out.println("数组容量等于集合大小:" + equalTime / (1000 * 1000) + "ms");
        System.out.println("数组容量大于集合大小:" + doubleTime / (1000 * 1000) + "ms");
    }

    public static void main(String[] args) {
//        asListFunc();
//        list2Array();
        listToArray();
    }
}
