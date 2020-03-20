package com.tianhy.datastructures.datatype;

/**
 * @Author: thy
 * @Date: 2020/2/21 16:44
 * @Desc: Long、Integer 包装类型缓存范围测试
 */
public class LongIntegerCacheTest {
    public static void main(String[] args) {
        lic();

    }

    public static void lic() {
/*
        Long a = 127L;
        Long b = 127L;
        System.out.println((a == b)); //true

        Long c = 128L;
        Long d = 128L;
        System.out.println("Long = 128 cache is " + (c == d));//false

        Long e = -128L;
        Long f = -128L;
        System.out.println("Long = -128 cache is " + (e == f));//true

        //Long 只缓存-128-127之间的数值
        Long a1 = -129L;
        Long b1 = -129L;
        System.out.println("Long = -129 cache is " + (a1 == b1));//false
*/

        //AutoBoxCacheMax 参数只对Integer对象有效
        Integer x = 1001;
        Integer y = 1001;
        System.out.println("Integer = 1001 cache is " + (x == y));//false
        //加入VM options参数 -XX:AutoBoxCacheMax=7777 结果为true

    }
}
