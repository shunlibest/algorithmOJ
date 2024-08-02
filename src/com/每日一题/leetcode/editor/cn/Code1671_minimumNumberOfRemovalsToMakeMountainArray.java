package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-19 16:45:12
 * 题目名称: 得到山形数组的最少删除次数
 * 题目类型:
 * 思考:
 */
public class Code1671_minimumNumberOfRemovalsToMakeMountainArray {
    public static void main(String[] args) {
        Solution solution = new Code1671_minimumNumberOfRemovalsToMakeMountainArray().new Solution();

//        int[] array = {1, 2, 3, 4, 5, 3, 2, 1};
//        int[] array = {2, 1, 1, 5, 6, 2, 3, 1};

        int[] array = {9, 8, 1, 7, 6, 5, 4, 3, 2, 1};
        int i = solution.minimumMountainRemovals(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMountainRemovals(int[] nums) {

            int[] preDp = new int[nums.length];
            int[] subDp = new int[nums.length];

            for (int i = 0; i < preDp.length; i++) {
                preDp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        preDp[i] = Math.max(preDp[i], preDp[j] + 1);
                    }
                }
            }


            for (int i = subDp.length - 1; i >= 0; i--) {
                subDp[i] = 1;
                for (int j = i + 1; j < subDp.length; j++) {
                    if (nums[i] > nums[j]) {
                        subDp[i] = Math.max(subDp[i], subDp[j] + 1);
                    }
                }
            }

//            Utils.printTable(preDp);
//            Utils.printTable(subDp);


            for (int i = 1; i < preDp.length; i++) {
                preDp[i] = Math.max(preDp[i], preDp[i - 1]);
            }

            for (int i = preDp.length - 2; i >= 0; i--) {
                subDp[i] = Math.max(subDp[i], subDp[i + 1]);
            }

            int max = 0;
            for (int i = 0; i < preDp.length; i++) {
                if (preDp[i] > 1 && subDp[i] > 1) {
                    max = Math.max(max, preDp[i] + subDp[i]);
                }
            }
//            max = Math.max(max, subDp[preDp.length - 1]);

//            Utils.printTable(preDp);
//            Utils.printTable(subDp);


            return nums.length - max + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
