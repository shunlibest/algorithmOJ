package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-09-02 09:58:03
 * 题目名称: 考试的最大困扰度
 * 题目类型:
 * 思考:
 */


public class Code2024_maximizeTheConfusionOfAnExam {
    public static void main(String[] args) {
        Solution solution = new Code2024_maximizeTheConfusionOfAnExam().new Solution();
        Object i0 = "TTFF";
        Object i1 = "TFFT";
        Object i2 = "TTFTTFTT";
        int ttff = solution.maxConsecutiveAnswers("TTFTTFTT", 1);
        System.out.println(ttff);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maxConsecutiveAnswers(String answerKey, int k) {
            int[][] dpT = new int[answerKey.length() + 1][k + 1];
            int[][] dpF = new int[answerKey.length() + 1][k + 1];

            char[] chars = answerKey.toCharArray();

            int maxLen = 0;

            for (int i = 1; i < dpT.length; i++) {

                char answer = answerKey.charAt(i - 1);

                for (int j = 0; j < dpT[0].length; j++) {
                    if (answer == 'T') {
                        // case1: 如果是T, 则从
                        dpT[i][j] = dpT[i - 1][j] + 1;
                        dpF[i][j] = (j > 0) ? dpF[i - 1][j - 1] + 1 : dpF[i - 1][j];

                    } else {
                        dpF[i][j] = dpF[i - 1][j] + 1;
                        dpT[i][j] = (j > 0) ? dpT[i - 1][j - 1] + 1 : dpT[i - 1][j];

                    }

                    maxLen = Math.max(maxLen, Math.max(dpT[i][j], dpF[i][j]));

                }
            }

//            Utils.printTable(dpT);
            return maxLen;
        }


//        public int maxConsecutiveAnswers(String answerKey, int k) {
//            char[] chars = answerKey.toCharArray();
//
//            int t = _maxConsecutiveAnswers(answerKey, k, 'T');
//            int f = _maxConsecutiveAnswers(answerKey, k, 'F');
//
//            return Math.max(t, f);
//        }
//
//        private int _maxConsecutiveAnswers(String answerKey, int k, int needChar) {
//            char[] chars = answerKey.toCharArray();
//
//            int max = 0;
//
//            // T:
//
//
//            int left = 0;
//            int kCount = 0;
//            for (int right = 0; right < answerKey.length(); right++) {
//                if (chars[right] == needChar) {
//                    max = Math.max(max, right - left);
//                    continue;
//                } else {
//                    kCount++;
//                    while (kCount > k) {
//                        if (chars[left] != needChar) {
//                            kCount--;
//                        }
//                        left++;
//                    }
//                    max = Math.max(max, right - left);
//                }
//            }
//            return max + 1;
//        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
