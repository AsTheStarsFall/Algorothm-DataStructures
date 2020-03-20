package com.tioanhy.datastructure.greek.queue;

/**
 * {@link}
 *
 * @Desc: 循环链表
 * @Author: thy
 * @CreateTime: 2019/5/4
 **/
public class CircularQueue {

    //数组
    private String[] items;
    //数组大小
    private int n = 0;
    //队头下标
    private int head = 0;
    //队尾下标
    private int tail = 0;

    //capacity大小的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    //入队
    public void enqueue(String item){
        //(tail + 1) % n == head 成立，队满
        if ((tail + 1) % n == head) { return; }
        //放入tail的位置
        items[tail] = item;

        tail = (tail+1)%n;
    }

    //出队
    public String dequeue(){
        if(head == tail){return null;}
        String tem = items[head];
        head = (head+1)%n;
        return tem;
    }
}
