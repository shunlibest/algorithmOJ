package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-19 10:01:51
 * 题目名称: 学生出勤记录 II
 * 题目类型:
 * 思考:
 */


public class Code552_studentAttendanceRecordIi {
    public static void main(String[] args) {
        Solution solution = new Code552_studentAttendanceRecordIi().new Solution();
        Object i0 = 2;
        Object i1 = 10101;
        int i = solution.checkRecord(2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int checkRecord(int n) {
            int[][] dp = new int[n][3];

            // 3: 迟到
            // 4: 到场
            for (int i = 0; i < dp.length; i++) {

//                switch ()
                // 缺勤0天
//                dp[i][0] = dp[i-1][]
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
