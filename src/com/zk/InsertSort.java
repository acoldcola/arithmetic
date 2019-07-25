package com.zk;

/**
 * @auther ZhangKe
 * @date 2018/12/29 19:37
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 2, 4, 19, 2};
        insertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void insertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;
            }
        }
    }
}
