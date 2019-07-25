package com.zk;

import java.util.Date;

/**
 * @auther ZhangKe
 * @date 2019/7/25 11:16
 * n皇后问题
 */
public class Recall {

    public static int Q = 15; //代表八皇后

    private static int num = 0; //代表次数

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] dp = new int[Q][Q];
        int i, j;
        //初始化
        for (i = 0; i < Q; i++) {
            for (j = 0; j < Q; j++) {
                dp[i][j] = 0;
            }
        }
        Date startTime = new Date();
        que(0, dp);
        Date endTime = new Date();
        System.out.println("耗时："+ (endTime.getTime() - startTime.getTime()) +"数量：" + num);
    }

    private static void que(int m, int[][] dp) {
        // TODO Auto-generated method stub

        if (m == Q) {//递归结束条件

            for (int i = 0; i < Q; i++) {
                for (int j = 0; j < Q; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println("\n");
            }
            System.out.println("**********************");
            num++;
        }
        //递归计算
        for (int i = 0; i < Q; i++) {
            if (isCorrt(i, m, dp)) {
                dp[i][m] = 1;
                que(m + 1, dp);
                dp[i][m] = 0;
            }
        }
    }

    //判断这个位置能不能放皇后
    private static boolean isCorrt(int i, int j, int[][] dp) {
        // TODO Auto-generated method stub
        int s, t;  //s代表行,t代表列
        for (s = i, t = 0; t < Q; t++) {
            if (dp[s][t] == 1 && t != j) {
                return false;//判断行
            }

        }
        for (t = j, s = 0; s < Q; s++) {
            if (dp[s][t] == 1 && s != i) {
                return false;//判断列
            }
        }
        for (s = i - 1, t = j - 1; s >= 0 && t >= 0; s--, t--) {
            if (dp[s][t] == 1) {
                return false;//判断左上方
            }

        }
        for (s = i + 1, t = j + 1; s < Q && t < Q; s++, t++) {
            if (dp[s][t] == 1){
                return false;//判断右下方
            }
        }
        for (s = i - 1, t = j + 1; s >= 0 && t < Q; s--, t++) {
            if (dp[s][t] == 1) {
                return false;//判断右上方
            }
        }
        for (s = i + 1, t = j - 1; s < Q && t >= 0; s++, t--){
            if (dp[s][t] == 1) {
                return false;//判断左下方
            }
        }
        return true;
    }

}
