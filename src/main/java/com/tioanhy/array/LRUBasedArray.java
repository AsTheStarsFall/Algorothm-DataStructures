package com.tioanhy.array;

import lombok.extern.slf4j.Slf4j;
import org.nutz.json.Json;

import java.util.*;

/**
 * {@link}
 *
 * @Desc: 基于数组实现LRU缓存
 * @Author: thy
 * @CreateTime: 2019/5/5
 **/
@Slf4j
public class LRUBasedArray<T> {

    //默认容量 8
    private static final int DEFAULT_CAPACITY = (1 << 3);
    //容量
    private int capacity;

    //元素个数
    private int count;

    //存储缓存的数组
    private T[] value;

    //记录缓存的位置
    private Map<T, Integer> holder;

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        count = 0;
        value = (T[]) new Object[capacity];
        holder = new HashMap<>(capacity);
    }

    /**
     * 访问某个值
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new IllegalArgumentException("不支持null缓存");
        }

        Integer index = holder.get(object);
        //未缓存
        if (index == null) {
            //如果缓存已满
            if (isFull()) {
                //删除并缓存
                removeAndCache(object);
            } else {
                //缓存不存在，缓存
                cache(object, count);
            }
        } else {
            //已被缓存，更新
            update(index);
        }
    }

    //缓存已满，删除并放入头部
    private void removeAndCache(T object) {
        //尾部元素
        //元素个数count 比 元素下标大1
        T key = value[--count];
        //删除此记录
        holder.remove(key);
        //相应的，元素个数count也要-1
        cache(object, count);
    }


    //如果缓存中有指定的值，更新
    public void update(int index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }

    /**
     * 先右移，缓存到头部
     *
     * @param object
     * @param end    数组右移边界
     */
    public void cache(T object, int end) {
        //先右移
        rightShift(end);
//        log.debug(Json.toJson(value));
        //缓存到头部
        value[0] = object;
//        log.debug(Json.toJson(value));
        //记录缓存
        holder.put(object, 0);
        //元素个数+1
        count++;
    }

    private void rightShift(int end) {
        //end的左边
        for (int i = end - 1; i >= 0; i--) {
            //end左边的数据下标+1，也就是说右移1位
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(value[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
