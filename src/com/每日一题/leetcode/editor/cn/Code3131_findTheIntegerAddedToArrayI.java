package com.每日一题.leetcode.editor.cn;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * [每日一题] 2024-08-08 10:04:18
 * 题目名称: 找出与数组相加的整数 I
 * 题目类型:
 * 思考:
 */
public class Code3131_findTheIntegerAddedToArrayI {
    public static void main(String[] args) {
        Solution solution = new Code3131_findTheIntegerAddedToArrayI().new Solution();

        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        int i = solution.addedInteger(nums1, nums2);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            int min1 = Arrays.stream(nums1).min().getAsInt();
            int min2 = Arrays.stream(nums2).min().getAsInt();

//            System.out.println(min1);
//            System.out.println(min2);

            return min2 - min1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
