package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * [每日一题] 2024-06-11 15:56:55
 * 题目类型:
 * 思考:
 */
public class Code881_救生艇 {
    public static void main(String[] args) {
        Solution solution = new Code881_救生艇().new Solution();
        int[] input = {3,2,2,1};
        int i = solution.numRescueBoats(input, 3);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int start = 0;
            for (int i = people.length - 1; i > start; i--) {
                int remain = limit - people[i];
                if (remain >= people[start]) {
                    start++;
                }
            }
            return people.length - start;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
