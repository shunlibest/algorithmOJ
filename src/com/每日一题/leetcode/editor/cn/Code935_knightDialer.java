package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [每日一题] 2024-08-02 11:17:05
 * 题目名称: 骑士拨号器
 * 题目类型:
 * 思考:
 */
public class Code935_knightDialer {
    public static void main(String[] args) {
        Solution solution = new Code935_knightDialer().new Solution();

        int i = solution.knightDialer(3131);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int knightDialer(int n) {
            long[][] dp = new long[n][10];

//            List<List<Integer>> jumpMap = new ArrayList<>();

            int[][] jumpMap = {{4, 6, -1}, {6, 8, -1}, {7, 9, -1}, {4, 8, -1}, {0, 3, 9}, {-1, -1, -1}, {0, 1, 7}, {2, 6, -1}, {1, 3, -1}, {2, 4, -1}};


            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    Arrays.fill(dp[0], 1);
                    continue;
                }

                for (int j = 0; j < jumpMap.length; j++) {

                    for (int k = 0; k < jumpMap[0].length; k++) {
                        if (jumpMap[j][k] == -1) {
                            continue;
                        }
                        dp[i][j] += dp[i - 1][jumpMap[j][k]];

                        dp[i][j] %= 1_000_000_007;
                    }
                }
            }

            long sum = 0;

            for (long value : dp[dp.length - 1]) {
                sum += value;
            }


//            Utils.printTable(dp);
            return (int) (sum % 1_000_000_007);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
