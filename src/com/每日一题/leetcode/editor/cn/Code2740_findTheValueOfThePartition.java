package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * [每日一题] 2024-07-26 09:42:54
 * 题目名称: 找出分区值
 * 题目类型:
 * 思考:
 */
public class Code2740_findTheValueOfThePartition {
    public static void main(String[] args) {
        Solution solution = new Code2740_findTheValueOfThePartition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findValueOfPartition(int[] nums) {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < nums.length; i++) {
                min = Math.min(min, nums[i] - nums[i - 1]);
            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
