package com.zk;

import java.util.Stack;

/**
 * @auther ZhangKe
 * @date 2019/7/26 15:16
 * 单调栈解决直方图最大矩形覆盖
 */
public class HumdrumStack {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] height) {
        if (height.length == 0 || height == null) {
            return 0;
        }
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 判断是否为空并且数是否小于栈顶的数
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                // 算每个矩形的面积
                int x = height[stack.pop()]
                        * (stack.isEmpty() ? i : i - (stack.peek() + 1));
                area = Math.max(area, x);
            }
            stack.push(i);
        }
        return area;
    }
}
