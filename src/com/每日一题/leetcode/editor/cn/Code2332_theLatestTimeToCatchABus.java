package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2024-09-18 14:02:14
 * 题目名称: 坐上公交的最晚时间
 * 题目类型:
 * 思考:
 */


public class Code2332_theLatestTimeToCatchABus {
    public static void main(String[] args) {
        Solution solution = new Code2332_theLatestTimeToCatchABus().new Solution();


//        int[] buses = {10, 20, 30};
//        int[] passengers = {19, 13, 26, 4, 25, 11, 21};

        int[] buses = {10, 20, 30,};
        int[] passengers = {4, 11, 13, 19, 21, 25, 26};
//        int[] buses = {2};
//        int[] passengers = {2};

//        int[] buses = {5};
//        int[] passengers = {7, 8};
        int i = solution.latestTimeCatchTheBus(buses, passengers, 2);

        System.out.println("结果:" + i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {

            Arrays.sort(buses);
            Arrays.sort(passengers);

//            Utils.printTable(passengers);

            Set<Integer> set = new HashSet<>();
            for (int passenger : passengers) {
                set.add(passenger);
            }

            int passIndex = 0;
            boolean finalBusFull = false;

            int finalBus = 0;
            for (int bus = 0; bus < buses.length; bus++) {
                int newPassIndex = getNextPassengers(buses[bus], passengers, passIndex, capacity);
                finalBusFull = newPassIndex - passIndex == capacity + 1;
                passIndex = newPassIndex;
                finalBus = bus;
            }

//            passIndex--;
            int lastCatchTime = 0;
            if (finalBusFull) {
                lastCatchTime = passengers[passIndex - 1];
            } else {
                if (passIndex >= passengers.length) {
                    lastCatchTime = buses[finalBus];
                } else {
                    lastCatchTime = Math.min(buses[finalBus], passengers[passIndex]);
                }
            }

//            if (passIndex - plus > passengers.length)

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                if (!set.contains(lastCatchTime - i)) {
                    return lastCatchTime - i;
                }
            }
            return -1;
        }

        public int getNextPassengers(int time, int[] passengers, int index, int capacity) {
            int returnIndex = index;

            for (int i = index; i < passengers.length && i <= index + capacity && passengers[i] <= time; i++) {
                returnIndex = i;
            }

            return returnIndex + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
