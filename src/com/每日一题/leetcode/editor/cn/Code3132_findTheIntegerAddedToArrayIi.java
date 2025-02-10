package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;

/**
 * [每日一题] 2024-08-09 10:18:52
 * 题目名称: 找出与数组相加的整数 II
 * 题目类型:
 * 思考:
 */


public class Code3132_findTheIntegerAddedToArrayIi {
    public static void main(String[] args) {
        Solution solution = new Code3132_findTheIntegerAddedToArrayIi().new Solution();
        int[] i0 = {4, 20, 16, 12, 8};
        int[] i1 = {3, 5, 5, 3};
        int i = solution.minimumAddedInteger(i0, i1);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

//            int[][] sub = new int[nums1.length][5];
//            for (int i = 0; i < nums1.length; i++) {
//
//                for (int j = 0; j < 5; j++) {
//                    sub[i][j] = nums1[i] - nums1[i - 2 + j];
//                }
//            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
