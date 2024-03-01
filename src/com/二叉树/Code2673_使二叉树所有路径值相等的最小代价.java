package com.二叉树;

public class Code2673_使二叉树所有路径值相等的最小代价 {
    public static void main(String[] args) {
        int[] array = {764, 1460, 2664, 764, 2725, 4556, 5305, 8829, 5064, 5929, 7660, 6321, 4830, 7055, 3761};
        int i = new Code2673_使二叉树所有路径值相等的最小代价().minIncrements(array.length, array);
        System.out.println(i);
    }


    public int minIncrements(int n, int[] cost) {
        int kHeight = (int) (Math.log(n + 1) / Math.log(2));
        int allCount = 0;

        for (int i = kHeight - 2; i >= 0; i--) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                int index = (int) Math.pow(2, i) - 1 + j;
                int max = Math.max(cost[2 * index + 1], cost[2 * index + 2]);
                allCount += max - cost[2 * index + 1];
                allCount += max - cost[2 * index + 2];
                cost[index] += max;
            }
        }
        return allCount;
    }
}
