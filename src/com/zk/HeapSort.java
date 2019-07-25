package com.zk;

import java.util.Arrays;

/**
 * @auther ZhangKe
 * @date 2019/7/25 14:39
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 4, 3, 6, 5, 8, 7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * @param
     * @return
     * @description 本方法只有一个参数，那就是待排序的array
     */
    public static void sort(int[] array) {
        // 建立大定堆
        for (int i = array.length/2 - 1; i >= 0; i--) {
            adjustHeap(array,i,array.length);
        }
        for (int j = array.length - 1; j > 0; j--) {
            swap(array,0,j);
            adjustHeap(array,0,j);
        }
    }

    /**
     * @description 调整
     * @param array
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] array, int i, int length) {
        for (int k = 2 * i + 1; k < length; k = 2 * i + 1) {
            if (k + 1 < length && array[k] < array[k+1]) {
                k++;
            }
            if(array[k] > array[i]) {
                swap(array, i, k);
                i = k;
            }else {
                break;
            }
        }
    }

    /**
     * 交换元素
     * @param arr
     * @param a   元素的下标
     * @param b   元素的下标
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
