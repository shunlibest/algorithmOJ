package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-21 09:43:10
 * 题目名称: 气温变化趋势
 * 题目类型:
 * 思考:
 */
public class CodeLCP61_sixCE719 {
    public static void main(String[] args) {
        Solution solution = new CodeLCP61_sixCE719().new Solution();
        int[] a = {21, 18, 18, 18, 31};
        int[] b = {34, 32, 16, 16, 17};
        int i = solution.temperatureTrend(a, b);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
//            boolean[] sameTrend = new boolean[temperatureA.length - 1];

            int result = 0;
            int sameCount = 0;
            for (int i = 0; i < temperatureA.length - 1; i++) {
                int trendA = temperatureA[i + 1] - temperatureA[i];
                int trendB = temperatureB[i + 1] - temperatureB[i];

                boolean allAdd = trendA > 0 && trendB > 0;
                boolean allSame = trendA == 0 && trendB == 0;
                boolean allSub = trendA < 0 && trendB < 0;
                boolean sameTrend = allAdd || allSame || allSub;
                if (sameTrend) {
                    sameCount++;
                    result = Math.max(result, sameCount);
                } else {
                    sameCount = 0;
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
