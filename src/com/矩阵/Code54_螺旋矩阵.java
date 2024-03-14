package com.矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code54_螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integers = new Code54_螺旋矩阵().spiralOrder(matrix);

        System.out.println(Arrays.toString(integers.toArray()));

    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>(matrix[0].length * matrix.length);

        int x = 0;
        int y = 0;

        int width = matrix[0].length;
        int height = matrix.length;

        int round = Math.min(matrix.length / 2, matrix[0].length / 2);
        for (int i = 0; i <= round; i++) {
            // 横线
            for (int j = i; j < width - 1; j++) {
                res.add(matrix[i][j]);
            }
            // 竖线
            for (int j = i + 1; j < height -1 ; j++) {
                res.add(matrix[j][width - i - 1]);
            }

            // 回来的横线
            for (int j = width - round - 2; j >= round; j--) {
                res.add(matrix[height - i - 1][j]);
            }

            // 上去的竖线
            for (int j = height - round - 1; j >= round; j--) {
                res.add(matrix[j][i]);
            }

        }

        return res;

    }
}
