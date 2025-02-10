package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-11-07 17:12:17
 * 题目名称: 颜色分类
 * 题目类型:
 * 思考:
 */


public class Code75_sortColors {
    public static void main(String[] args) {
        Solution solution = new Code75_sortColors().new Solution();
        int[] i0 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(i0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {


            int left = 0;
            int right = nums.length - 1;
            int oneCount = 0;

            while (left < right) {
                if (nums[left] == 0){
                    left++;
                }else if (nums[left] == 1){
                    oneCount++;
                }else {

                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
