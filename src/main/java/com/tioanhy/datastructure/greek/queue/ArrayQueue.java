package com.tioanhy.datastructure.greek.queue;

/**
 * {@link}
 *
 * @Desc: 基于数组实现的顺序队列
 * @Author: thy
 * @CreateTime: 2019/5/3
 **/
public class ArrayQueue {

    //数组大小为n
    private String[] items;
    private int n = 0;
    //队头下标
    private int head = 0;
    //队尾下标
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        //如果tail == n 表示队尾没有空间
        if (tail == n) {
            //再如果head == 0,表示队列已满
            if(head == 0){
                return false;
            }
            //数据搬移,将head~tail之间的数据搬到 0~(tail-head)的位置
            for (int i = head; i <tail ; ++i) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        //将数据放入tail的位置
        items[tail] = item;
        //tail+1自增
        ++tail;
        return true;
    }

    //出队,1.队空时，出队失败 2.出队，head索引向右移动1
    public String dequeue() {
        //如果头下标==尾小标，表示队列为空
        if (tail == head) {
            return null;
        }
        //拿到head位置的数据
        String ret = items[head];
        items[head] = null;
        ++head;
        return ret;
    }
}
