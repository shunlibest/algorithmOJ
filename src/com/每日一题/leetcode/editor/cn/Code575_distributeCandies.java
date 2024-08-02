package com.每日一题.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2024-06-18 16:57:43
 * 题目名称: 分糖果
 * 题目类型:
 * 思考:
 */
public class Code575_distributeCandies {
    public static void main(String[] args) {
        Solution solution = new Code575_distributeCandies().new Solution();
        int[] array = {1, 1, 2, 2, 3, 3};
        int i = solution.distributeCandies(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet<>();
            int n = candyType.length / 2;
            for (int type : candyType) {
                set.add(type);
            }
            return Math.min(set.size(), n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
