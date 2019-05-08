package com.tioanhy.array;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/5/5
 **/
public class findIndexByKey {

    //根据给定的key返回其所在位置
    public static int findValueByKey(int key, int n, int... args) {

        if (args == null || n < 0) {
            return -1;
        }
        int i = 0;
        while (i < n) {
            if (key == args[i]) {
                return i;
            }
            ++i;
        }
        return -1;
    }


    // 在数组 a 中，查找 key，返回 key 所在的位置
    // 其中，n 表示数组 a 的长度
    // 我举 2 个例子，你可以拿例子走一下代码
    // a = {4, 2, 3, 5, 9, 6}  n=6 key = 7
    // a = {4, 2, 3, 5, 9, 6}  n=6 key = 6
    public static int find(int n, int key, int... a) {
        if (a == null || n <= 0) {
            return -1;
        }

        // 这里因为要将 a[n-1] 的值替换成 key，所以要特殊处理这个值
        //哨兵
        if (a[n - 1] == key) {
            return n - 1;
        }

        // 把 a[n-1] 的值临时保存在变量 tmp 中，以便之后恢复。tmp=6。
        // 之所以这样做的目的是：希望 find() 代码不要改变 a 数组中的内容
        int tmp = a[n - 1];
        // 把 key 的值放到 a[n-1] 中，此时 a = {4, 2, 3, 5, 9, 7}
        a[n - 1] = key;

        int i = 0;
        // while 循环比起代码一，少了 i<n 这个比较操作
        while (a[i] != key) {
            ++i;
        }

        // 恢复 a[n-1] 原来的值, 此时 a= {4, 2, 3, 5, 9, 6}
        a[n - 1] = tmp;

        if (i == n - 1) {
            // 如果 i == n-1 说明，在 0...n-2 之间都没有 key，所以返回 -1
            return -1;
        } else {
            // 否则，返回 i，就是等于 key 值的元素的下标
            return i;
        }
    }
}
