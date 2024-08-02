package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-19 17:17:46
 * 题目名称: 找出到每个位置为止最长的有效障碍赛跑路线
 * 题目类型:
 * 思考:
 */
public class Code1964_findTheLongestValidObstacleCourseAtEachPosition {
    public static void main(String[] args) {
        Solution solution = new Code1964_findTheLongestValidObstacleCourseAtEachPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

            int[] dp = new int[obstacles.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (obstacles[i] >= obstacles[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

            }
            return dp;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
