package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-06-18 10:47:57
 * 题目名称: 构成整天的下标对数目 II
 * 题目类型:
 * 思考:
 */
public class Code3185_countPairsThatFormACompleteDayIi {
    public static void main(String[] args) {
        Solution solution = new Code3185_countPairsThatFormACompleteDayIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countCompleteDayPairs(int[] hours) {
            Map<Integer, Long> map = new HashMap<>();

            for (int hour : hours) {
                int formatHours = hour % 24;
                Long count = map.getOrDefault(formatHours, 0L);
                map.put(formatHours, count + 1);
            }
            long result = 0;
            for (int hour : hours) {
                int formatHours = hour % 24;
                long count = map.get(formatHours);
                if (count > 1) {
                    map.put(formatHours, count - 1);
                } else {
                    map.remove(formatHours);
                }
                result += map.getOrDefault(24 - formatHours, 0L);
                if (formatHours == 0) {
                    result += map.getOrDefault(0, 0L);
                }

            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
