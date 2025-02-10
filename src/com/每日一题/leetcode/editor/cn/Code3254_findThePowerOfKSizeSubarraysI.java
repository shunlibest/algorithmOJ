package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [每日一题] 2024-11-06 10:08:23
 * 题目名称: 长度为 K 的子数组的能量值 I
 * 题目类型:
 * 思考:
 */


public class Code3254_findThePowerOfKSizeSubarraysI {
    public static void main(String[] args) {
        Solution solution = new Code3254_findThePowerOfKSizeSubarraysI().new Solution();
        int[] i0 = {3, 2, 3, 2, 3, 2};
//        Object i1 = {2,2,2,2,2};
//        Object i2 = {3,2,3,2,3,2};
        int[] ints = solution.resultsArray(i0, 2);

        Utils.printTable(ints);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] resultsArray(int[] nums, int k) {

            int[] addArray = new int[nums.length];
            addArray[0] = 1;
            for (int i = 1; i < addArray.length; i++) {
                addArray[i] = nums[i] - nums[i - 1];
            }

            Set<Integer> map = new HashSet<>();
            int[] res = new int[nums.length - k + 1];
            for (int i = 0; i < addArray.length; i++) {
                if (addArray[i] != 1) {
                    map.add(i);
                }
                if (i < k - 1) {
                    continue;
                }
                map.remove(i - k + 1);
                if (map.isEmpty()) {
                    res[i - k + 1] = nums[i];
                } else {
                    res[i - k + 1] = -1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
