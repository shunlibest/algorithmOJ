package com.数组;

import java.util.HashMap;
import java.util.Map;

public class Code560_和为K的子数组 {

    public static void main(String[] args) {
        int[] array = {1};
        int i = new Code560_和为K的子数组().subarraySum(array, 0);

        System.out.println(i);
    }

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length];

        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // sum(i,j) = preSum[j] - preSum[i-1];
        // preSum[i] == preSum[j] - sum(i,j)

        map.put(0, 1); // 初始化前缀和为0的次数为1

        for (int i = 0; i < nums.length; i++) {

            int needValue = preSum[i] - k;
            if (map.containsKey(needValue)) {
                Integer num = map.get(needValue);
                count += num;
            }

            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return count;

    }

    public int subarraySumError(int[] nums, int k) {
        int leftIndex = 0;
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while (currentSum >= k && leftIndex <= i) {
                if (currentSum == k) {
                    count++;
                }
                currentSum -= nums[leftIndex];
                leftIndex++;
            }
        }
        return count;
    }

//    blic
//
//    static int subarraySum(int[] nums, int k) {
//        int count = 0;
//        int sum = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1); // 初始化前缀和为0的次数为1
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if (map.containsKey(sum - k)) {
//                count += map.get(sum - k);
//            }
//            map.put(sum, map.getOrDefault(sum, 0) + 1);
//        }
//        return count;
//    }
}
