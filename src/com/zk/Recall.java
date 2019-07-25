package com.zk;

import java.util.Date;

/**
 * @auther ZhangKe
 * @date 2019/7/25 11:16
 * n皇后问题
 */
public class Recall {

    public static int Q = 8; //代表八皇后

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
        // 递归结束
        if (m == Q) {
           for (int i = 0; i < Q; i++) {
               for (int j = 0; j < Q; j++) {
                   System.out.println(dp[i][j] + " ");
               }
               System.out.println("\n");
           }
            System.out.println("**********************");
            num++;
       }
        // 开始递归
        for (int i = 0; i < Q; i++) {
            if (isCorrt(i,m,dp)) {
                dp[i][m] = 1;
                que(m+1,dp);
                dp[i][m] = 0;
            }
        }
    }

    //判断这个位置是否可以
    private static boolean isCorrt(int i, int j, int[][] dp) {
        // x代表行,y代表列
        int x,y;
        // 判断列
        for (y = 0; y < Q; y++) {
            if (dp[i][y] == 1 && y != j) {
                return false;
            }
        }
        // 判断行
        for (x = 0; x < Q; x++) {
            if (dp[x][j] == 1 && x != i) {
                return false;
            }
        }
        // 判断左上
        for (x = i - 1,  y = j - 1; x >= 0 && y >= 0; x--, y--) {
            if (dp[x][y] == 1) {
                return false;
            }
        }
        // 判断右上
        for (x = i - 1,  y = j + 1; x >= 0 && y < Q; x--, y++) {
            if (dp[x][y] == 1) {
                return false;
            }
        }
        // 判断左下
        for (x = i + 1,  y = j - 1; x < Q && y >= 0; x++, y--) {
            if (dp[x][y] == 1) {
                return false;
            }
        }
        // 判断右下
        for (x = i + 1,  y = j + 1; x < 0 && y < 0; x++, y++) {
            if (dp[x][y] == 1) {
                return false;
            }
        }
        return true;
    }
}
