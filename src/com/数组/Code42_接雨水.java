package com.数组;

public class Code42_接雨水 {
    public static void main(String[] args) {
        int[] array = {2, 0, 2};
        int trap = new Code42_接雨水().trap(array);
        System.out.println(trap);
    }

    public int trap(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int maxHeight = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int sum = 0;
        // 左边
        int currentMaxIndex = maxIndex;
        while (true) {
            int leftMaxHeight = Integer.MIN_VALUE;
            int leftMaxIndex = -1;
            for (int i = 0; i < currentMaxIndex; i++) {
                if (height[i] > leftMaxHeight) {
                    leftMaxHeight = height[i];
                    leftMaxIndex = i;
                }
            }
            if (leftMaxIndex == -1) {
                break;
            }
            for (int i = leftMaxIndex; i < currentMaxIndex; i++) {
                sum += (leftMaxHeight - height[i]);
            }
            currentMaxIndex = leftMaxIndex;
            if (currentMaxIndex == 0) {
                break;
            }

        }

//        System.out.println(sum);

        // 右边
        currentMaxIndex = maxIndex;
        while (true) {
            int rightMaxHeight = Integer.MIN_VALUE;
            int rightMaxIndex = -1;
            for (int i = currentMaxIndex + 1; i < height.length; i++) {
                if (height[i] > rightMaxHeight) {
                    rightMaxHeight = height[i];
                    rightMaxIndex = i;
                }
            }
            for (int i = currentMaxIndex + 1; i < rightMaxIndex; i++) {
                sum += (rightMaxHeight - height[i]);
            }
            currentMaxIndex = rightMaxIndex;
            if (currentMaxIndex == height.length - 1 || currentMaxIndex == -1) {
                break;
            }

        }
        return sum;
    }
}
