package com.每日一题.leetcode.editor.cn;

import cn.hutool.core.lang.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-06-27 10:30:54
 * 题目名称: 删除并获得点数
 * 题目类型:
 * 思考:
 */
public class Code740_deleteAndEarn {
    public static void main(String[] args) {
        Solution solution = new Code740_deleteAndEarn().new Solution();
        int[] array = {3,3};
        int i = solution.deleteAndEarn(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);
//            int[][] value =
            List<Pair> numList = new ArrayList<>();

            int currentValue = nums[0];
            int currentCount = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != currentValue) {
                    numList.add(new Pair(currentValue, currentCount));
                    currentValue = nums[i];
                    currentCount = 1;
                } else {
                    currentCount++;
                }
            }
            numList.add(new Pair(currentValue, currentCount));

            int[] dp = new int[numList.size()];
            dp[0] = numList.get(0).getValue();


            for (int i = 1; i < dp.length; i++) {
                if (numList.get(i).key - 1 == numList.get(i - 1).key) {
                    if (i == 1) {
                        dp[i] = Math.max(dp[0], numList.get(1).getValue());
                    } else {
                        dp[i] = Math.max(dp[i - 1], dp[i - 2] + numList.get(i).getValue());
                    }
                } else {
                    dp[i] = dp[i - 1] + numList.get(i).getValue();
                }

            }
            return dp[dp.length - 1];


        }

        private class Pair {
            public int key;
            public int count;

            Pair(int key, int count) {
                this.key = key;
                this.count = count;
            }

            int getValue() {
                return key * count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
