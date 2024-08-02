package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-07-08 17:19:57
 * 题目名称: 寻找数组的中心下标
 * 题目类型:
 * 思考:
 */
public class Code724_findPivotIndex {
    public static void main(String[] args) {
        Solution solution = new Code724_findPivotIndex().new Solution();

        int[] array = {2, 1, -1};
        int i = solution.pivotIndex(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] preSum = new int[nums.length];
            int[] subSum = new int[nums.length];
            preSum[0] = nums[0];
            subSum[subSum.length - 1] = nums[subSum.length - 1];

            for (int i = 1; i < nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }

            for (int i = nums.length - 2; i >= 0; i--) {
                subSum[i] = subSum[i + 1] + nums[i];
            }



            for (int i = 0; i < nums.length; i++) {
                if (preSum[i] == subSum[i]) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
