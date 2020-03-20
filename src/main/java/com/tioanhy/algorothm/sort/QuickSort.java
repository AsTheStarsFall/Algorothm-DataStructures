package com.tioanhy.algorothm.sort;

/**
 * {@link}
 *
 * @Desc: 快速排序
 * @Author: thy
 * @CreateTime: 2020/3/12 2:04
 **/
public class QuickSort {

    public static void quickSort(int[] a, int n) {

        quickSortInternally(a, 0, n - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        //获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = 0; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i = "+ i);
        return i;
    }
}
