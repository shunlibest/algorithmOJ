package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-11 14:19:43
 * 题目名称: 搜索插入位置
 * 题目类型:
 * 思考:
 */


public class Code35_searchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Code35_searchInsertPosition().new Solution();
        int[] i0 = {1, 3, 5, 6};
//        Object i1 = {1, 3, 5, 6};
//        Object i2 = {1, 3, 5, 6};
        int i = solution.searchInsert(i0, 4);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {

            int leftIndex = 0;
            int rightIndex = nums.length - 1;

            while (leftIndex <= rightIndex) {
                int centerIndex = (leftIndex + rightIndex) / 2;
                // 1 2 3 4 5 6 7 8 9  >> 2
                if (nums[centerIndex] > target) {
                    rightIndex = centerIndex - 1;
                } else if (nums[centerIndex] < target) {
                    leftIndex = centerIndex + 1;
                } else {
                    return centerIndex;
                }
            }

//            System.out.println("left:" + leftIndex);
//            System.out.println("rightIndex:" + rightIndex);
            return leftIndex;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
