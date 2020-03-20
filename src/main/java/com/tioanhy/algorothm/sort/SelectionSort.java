package com.tioanhy.algorothm.sort;

/**
 * {@link}
 *
 * @Desc: 选择排序
 * @Author: thy
 * @CreateTime: 2020/3/6 4:59
 **/
public class SelectionSort {

    public void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; ++i) {
            //从未排序区域找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            //与已排序区域的最后一个位置的数据交换
            int tmp = a[i]; //当前临时元素
            a[i] = a[minIndex]; //当前元素与末尾元素互换位置
            a[minIndex] = tmp; //恢复
        }
    }

    //分已排序区域和未排序区域。每次选择未排序区域的最小值，插入到已排序区域的末尾

}
