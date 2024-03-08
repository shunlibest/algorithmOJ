package com.数组;

public class Code2834_找出美丽数组的最小和 {
    public static void main(String[] args) {
        int i = new Code2834_找出美丽数组的最小和().minimumPossibleSum(63623, 82276);
        System.out.println(i);
    }

    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;

        int sum = (1 + n) * n / 2;


        if (target > n * 2 - 1) {
            return sum;
        }

        int removeIndex = target / 2 + 1;
        int removeCount = target - removeIndex;

        long removeValue = (long) (removeIndex + target - 1) * removeCount / 2;

        long allSum = (long) (1 + n + removeCount) * (long) (n + removeCount) / 2;

        return (int) ((allSum - removeValue) % MOD);
    }
}
