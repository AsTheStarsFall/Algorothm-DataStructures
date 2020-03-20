package com.tioanhy.algorothm.sort;

/**
 * {@link}
 *
 * @Desc: 归并排序
 * @Author: thy
 * @CreateTime: 2020/3/12 1:20
 **/
public class MergeSort {

    /**
     * @param a 数组
     * @param n 数组长度
     */
    public static void mergeSort(int[] a, int n) {

    }

    /**
     * @param a 数组
     * @param p 数组start
     * @param r 数组end
     */
    public static void mergeSortInternally(int[] a, int p, int r) {
        //终止条件
        if (p >= r) {
            return;
        }
        //去 p~r的中间值
        int q = p + (r - p) / 2;
        //分治递归
        //前一部分
        mergeSortInternally(a, p, q);
        //后一部分
        mergeSortInternally(a, q + 1, r);

        //将A[p...q]与A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p; //表示前一部分首下标
        int j = q; //表示后一部分首下标
        int k = 0;
        //申请一个与A[p...r]一样大小的数组
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        //判读子数组剩余数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        //将剩余数据拷贝到tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将tmp数据拷贝回a[p...r]
        for (int l = 0; l < r - p; l++) {
            a[p + l] = tmp[l];
        }
    }
}
