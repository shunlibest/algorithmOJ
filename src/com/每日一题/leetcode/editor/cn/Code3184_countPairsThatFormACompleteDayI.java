package com.每日一题.leetcode.editor.cn;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-06-18 10:29:33
 * 题目名称: 构成整天的下标对数目 I
 * 题目类型:
 * 思考:
 */
public class Code3184_countPairsThatFormACompleteDayI {
    public static void main(String[] args) {
        Solution solution = new Code3184_countPairsThatFormACompleteDayI().new Solution();
        int[] array = {72,48,24,3};
        int i = solution.countCompleteDayPairs(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteDayPairs(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int hour : hours) {
                int formatHours = hour % 24;
                Integer count = map.getOrDefault(formatHours, 0);
                map.put(formatHours, count + 1);
            }
            int result = 0;
            for (int hour : hours) {
                int formatHours = hour % 24;
                int count = map.get(formatHours);
                if (count > 1) {
                    map.put(formatHours, count - 1);
                } else {
                    map.remove(formatHours);
                }
                result += map.getOrDefault(24 - formatHours, 0);
                if (formatHours == 0) {
                    result += map.getOrDefault(0, 0);
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
