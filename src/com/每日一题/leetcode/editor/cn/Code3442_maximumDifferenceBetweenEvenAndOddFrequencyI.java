package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2025-06-10 10:37:40
 * 题目名称: 奇偶频次间的最大差值 I
 * 题目类型:
 * 思考:
 */


public class Code3442_maximumDifferenceBetweenEvenAndOddFrequencyI {
    public static void main(String[] args) {
        Solution solution = new Code3442_maximumDifferenceBetweenEvenAndOddFrequencyI().new Solution();
        Object i0 = "aaaaabbc";
        int i = solution.maxDifference("mmsmsym");
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDifference(String s) {
            char[] charArray = s.toCharArray();

            int[] numCount = new int[26];

            for (char c : charArray) {
                numCount[c - 'a']++;
            }
            int oddMax = Integer.MIN_VALUE;
            int evenMin = Integer.MAX_VALUE;

//            Utils.printTable(numCount);

            for (int count : numCount) {
                if (count == 0) {
                    continue;
                }
                if (count % 2 == 0) {
                    evenMin = Math.min(evenMin, count);
                } else {
                    oddMax = Math.max(oddMax, count);
                }
            }
//            System.out.println(oddMax);
//            System.out.println(eventMax);
            return oddMax - evenMin  ;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
