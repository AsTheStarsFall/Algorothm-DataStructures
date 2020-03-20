package com.tioanhy.datastructure.greek.array;


import com.alibaba.fastjson.JSON;


/**
 * {@link}
 *
 * @Desc: 数据
 * @Author: thy
 * @CreateTime: 2019/5/5
 **/
public class Array<T> {
    private int capacity;
    private T[] value;

    public Array(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
    }

    public void offer(T object) {
        value[0] = object;
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>(5);
        array.offer(1);
        System.out.println(JSON.toJSONString(array));



    }

}
