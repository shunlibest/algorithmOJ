package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-06-18 17:06:32
 * 题目名称: 分糖果 II
 * 题目类型:
 * 思考:
 */
public class Code1103_distributeCandiesToPeople {
    public static void main(String[] args) {
        Solution solution = new Code1103_distributeCandiesToPeople().new Solution();

        int[] ints = solution.distributeCandies(7, 4);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int[] res = new int[num_people];
            int remind = candies;
            for (int i = 0; ; i++) {
                if (remind <= 0) {
                    break;
                }
                res[i % num_people] += Math.min(remind, i + 1);
                remind = remind - i - 1;
//                System.out.println(Arrays.toString(res));
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
