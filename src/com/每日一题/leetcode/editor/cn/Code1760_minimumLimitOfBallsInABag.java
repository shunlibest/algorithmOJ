package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-12 10:26:34
 * 题目名称: 袋子里最少数目的球
 * 题目类型:
 * 思考:
 */


public class Code1760_minimumLimitOfBallsInABag {
    public static void main(String[] args) {
        Solution solution = new Code1760_minimumLimitOfBallsInABag().new Solution();
//        int[] i0 = {9};
        int[] i0 = {7, 17};
//        Object i1 = {2,4,8,2};
        int i = solution.minimumSize(i0, 2);
        System.out.println(i);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int maxValue = 0;
            for (int num : nums) {
                maxValue = Math.max(maxValue, num);
            }

            int leftValue = 1;
            int rightValue = maxValue;


            while (leftValue <= rightValue) {
                int centerValue = (leftValue + rightValue) / 2;
                // 1 2 3 4 5 6 7 8 9
                boolean canSplit = canSplit(nums, maxOperations, centerValue);
                if (canSplit) {
                    rightValue = centerValue - 1;
                } else {
                    leftValue = centerValue + 1;
                }

            }

//            for (int i = 1; i < maxValue; i++) {
//                boolean b = canSplit(nums, maxOperations, i);
//                if (b) {
//                    return i;
//                }
////                System.out.println("value:" + i + " , can:" + b);
//            }

            return leftValue;
        }

        private boolean canSplit(int[] nums, int maxOperations, int minValue) {

            int count = 0;
            for (int i = 0; i < nums.length; i++) {

                count += Math.max(Math.ceil(nums[i] * 1.0 / minValue) - 1, 0);

                if (count > maxOperations) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
