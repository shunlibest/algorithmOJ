package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-06 15:06:04
 * 题目名称: 填充书架
 * 题目类型:
 * 思考:
 */
public class Code1105_fillingBookcaseShelves {
    public static void main(String[] args) {
        Solution solution = new Code1105_fillingBookcaseShelves().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minHeightShelves(int[][] books, int shelfWidth) {
            int[] dp = new int[books.length];

            for (int i = 0; i < dp.length; i++) {
                // 不换行
                int width = 0;
                int maxHeightIndex = i;
                for (int j = i; j >= 0; j--) {
                    width += books[i][0];
                    if (books[i][1] > books[maxHeightIndex][1]) {
                        maxHeightIndex = j;
                    }
                    if (width > shelfWidth) {
                        break;
                    }
                }
                dp[i] = Math.max(books[maxHeightIndex][0], books[maxHeightIndex][0] + books[i][1] - books[maxHeightIndex][1]);

                // 换行
                dp[i] = Math.min(dp[i], dp[i - 1] + books[i][1]);
            }

            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
