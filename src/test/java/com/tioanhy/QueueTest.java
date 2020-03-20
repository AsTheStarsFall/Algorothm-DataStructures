package com.tioanhy;

import com.tioanhy.datastructure.greek.queue.ArrayQueue;
import com.tioanhy.datastructure.greek.queue.CircularQueue;
import org.junit.Test;


/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/4
 **/
public class QueueTest {

    public static void main(String[] args) {
//        Queue<String> queue = new ConcurrentLinkedDeque<>();
//        String poll = queue.poll();
    }

    //基于数组实现的队列
    @Test
    public void ArrayQueueTest() {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue("thy" + i);

        }
//        System.out.println(Json.toJson(arrayQueue));

        String dequeue = arrayQueue.dequeue();

        System.out.println(dequeue);
//        System.out.println(Json.toJson(arrayQueue));
    }

    //循环链表
    @Test
    public void CircularQueueTest(){
        CircularQueue circularQueue = new CircularQueue(5);
        for (int i = 0; i < 10; i++) {
            circularQueue.enqueue("thy"+i);
        }
//        System.out.println(Json.toJson(circularQueue));

        String dequeue = circularQueue.dequeue();
        System.out.println(dequeue);
//        System.out.println(Json.toJson(circularQueue));

    }


}
