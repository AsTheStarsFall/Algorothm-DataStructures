package com.tioanhy;

import com.tioanhy.datastructure.greek.array.LRUBasedArray;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * {@link}
 *
 * @Desc: 基于数组实现的LRU缓存测试
 * @Author: thy
 * @CreateTime: 2019/5/5
 **/
@Slf4j
public class LRUBasedArrayTest {


    @Test
    public void testSpecifiedConstructor() {
        log.debug("*********有参测试");
        LRUBasedArray<Integer> lruBasedArray = new LRUBasedArray<>(5);
        lruBasedArray.offer(1);
        log.debug(lruBasedArray.toString());
        lruBasedArray.offer(2);
        log.debug(lruBasedArray.toString());
        lruBasedArray.offer(3);
        log.debug(lruBasedArray.toString());
        lruBasedArray.offer(4);
        log.debug(lruBasedArray.toString());
        lruBasedArray.offer(2);
        log.debug(lruBasedArray.toString());
//        lruBasedArray.offer(2);
//        log.debug(lruBasedArray.toString());
//        lruBasedArray.offer(3);
//        log.debug(lruBasedArray.toString());

        /**
         * DEBUG [main] - *********有参测试
         * DEBUG [main] - 1
         * DEBUG [main] - 2 1
         * DEBUG [main] - 3 2 1
         * DEBUG [main] - 4 3 2 1
         */

    }


}
