package com.zk;

/**
 * @auther ZhangKe
 * @date 2018/12/29 19:51
 */
public class ImproveInsertSort {
    public static void main(String[] args) {
        int[] a = {5, 8, 2, 4, 19, 2};
        improveInsertSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void improveInsertSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int x = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > x; j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;
        }
    }
}
