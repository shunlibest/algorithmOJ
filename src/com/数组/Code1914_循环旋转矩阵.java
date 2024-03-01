package com.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code1914_循环旋转矩阵 {

    public static void main(String[] args) {
//        int[][] grid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] grid = {{40, 10}, {30, 20}};
        int[][] grid = {{10, 1, 4, 8}, {6, 6, 3, 10}, {7, 4, 7, 10}, {1, 10, 6, 1}, {2, 1, 1, 10}, {3, 8, 9, 2}, {7, 1, 10, 10}, {7, 1, 4, 9}, {2, 2, 4, 2}, {10, 7, 5, 10}};
        int[][] res = new Code1914_循环旋转矩阵().rotateGrid(grid, 1);

        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int xLength = grid.length;
        int yLength = grid[0].length;
        int r = Math.min(grid.length / 2, grid[0].length / 2);
//        System.out.println(r);
        int[][] newArray = new int[xLength][yLength];

        for (int round = 0; round < r; round++) {
            List<Integer> temp = new ArrayList<>();
            //从左往右
            for (int i = round; i < yLength - round - 1; i++) {
                temp.add(grid[round][i]);
            }
            // 从上往下
            for (int i = round; i < xLength - round - 1; i++) {
                temp.add(grid[i][yLength - round - 1]);
            }

            // 从右往左
            for (int i = yLength - round - 1; i > round; i--) {
                temp.add(grid[xLength - 1 - round][i]);
            }

            // 从下往上
            for (int i = xLength - round - 1; i > round; i--) {
                temp.add(grid[i][round]);
            }
//            System.out.println(Arrays.toString(temp.toArray()));

            int index = 0;
            for (int i = round; i < yLength - round - 1; i++) {
                newArray[round][i] = temp.get((k + index) % temp.size());
                index++;
            }
            // 从上往下
            for (int i = round; i < xLength - round - 1; i++) {
                newArray[i][yLength - round - 1] = temp.get((k + index) % temp.size());
                index++;
            }

            // 从右往左
            for (int i = yLength - round - 1; i > round; i--) {
                newArray[xLength - 1 - round][i] = temp.get((k + index) % temp.size());
                index++;
            }

            // 从下往上
            for (int i = xLength - round - 1; i > round; i--) {
                newArray[i][round] = temp.get((k + index) % temp.size());
                index++;
            }


        }
        return newArray;
    }
}
