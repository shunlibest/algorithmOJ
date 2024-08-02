package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * [每日一题] 2024-07-22 17:00:37
 * 题目名称: 统计作战单位数
 * 题目类型:
 * 思考:
 */
public class Code1395_countNumberOfTeams {
    public static void main(String[] args) {
        Solution solution = new Code1395_countNumberOfTeams().new Solution();

        int[] array = {2, 5, 3, 4, 1};
        int i = solution.numTeams(array);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numTeams(int[] rating) {
            int value = _numTeams(rating);
            for (int i = 0, j = rating.length - 1; i < j; i++, j--) {
                int temp = rating[i];
                rating[i] = rating[j];
                rating[j] = temp;
            }
            return value + _numTeams(rating);


        }

        private int _numTeams(int[] rating) {
            int[][] dp = new int[rating.length][2];


            // 0: 只考虑 i, j 的组合数
            // 1: 考虑j, k 的组合数
            int sum = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (rating[i] > rating[j]) {
                        dp[i][0] += 1;
                    }
                }

                for (int j = 0; j < i; j++) {
                    if (rating[i] > rating[j]) {
                        dp[i][1] += dp[j][0];
                    }
                }


                sum += dp[i][1];
            }
//            Utils.printTable(dp);
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
