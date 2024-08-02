package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

/**
 * [每日一题] 2024-06-18 10:54:01
 * 题目名称: 施咒的最大总伤害
 * 题目类型:
 * 思考:
 */
public class Code3186_maximumTotalDamageWithSpellCasting {
    public static void main(String[] args) {
        Solution solution = new Code3186_maximumTotalDamageWithSpellCasting().new Solution();
        int[] array = {5, 9, 2, 10, 2, 7, 10, 9, 3, 8};
        long l = solution.maximumTotalDamage(array);
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumTotalDamage(int[] power) {
            int[] dp = new int[power.length];
            Arrays.sort(power);
            System.out.println(Arrays.toString(power));

            dp[0] = power[0];
            for (int i = 1; i < power.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (power[i] == power[j] || power[i] - power[j] > 2) {
                        dp[i] = Math.max(dp[i - 1], dp[j] + power[i]);
                        break;
                    }
                }
                dp[i] = Math.max(dp[i], dp[i - 1]);
                dp[i] = Math.max(dp[i], power[i]);
            }

            System.out.println(Arrays.toString(dp));

            return dp[dp.length - 1];

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
