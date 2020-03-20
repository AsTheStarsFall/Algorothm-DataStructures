package com.tioanhy.algorothm.sort;

/**
 * {@link}
 *
 * @Desc: 插入排序
 * @Author: thy
 * @CreateTime: 2020/3/6 4:32
 **/
public class InsertionSort {


    /**
     * @param arrys 待排序数组
     * @param n     数组长度
     */
    public void insertionSort(int[] arrys, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; ++i) {
            int value = arrys[i];
            int j = i - 1;
            _flag:
            //查找插入位置
            for (; j > 0; --j) {
                if (arrys[j] > value) {
                    arrys[j + 1] = arrys[j]; //数据移动
                } else {
                    break _flag;
                }
            }
            arrys[j] = value; //插入数据
        }
    }

    /**
     * 插入排序核心思想：分为两部分，一部分是已排序的区域，另一部分是未排序的区域。
     * 当要将一个数据a插入到已排序的区域时，先跟已排序区域的数据进行比较，找到合适的位置插入。
     * 插入后，将插入点之后的数据后移一位
     */

}
