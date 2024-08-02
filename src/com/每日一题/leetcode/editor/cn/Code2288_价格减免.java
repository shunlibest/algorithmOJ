package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-06-18 09:53:38
 * 题目类型:
 * 思考:
 */
public class Code2288_价格减免 {
    public static void main(String[] args) {
        Solution solution = new Code2288_价格减免().new Solution();
        String s = solution.discountPrices("there are $1 $2 and 5$ candies in the shop", 50);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String discountPrices(String sentence, int discount) {
            String[] words = sentence.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                Long price = getOriginalPrice(word);
                if (sb.length() != 0) {
                    sb.append(" ");
                }
                if (price == null) {
                    sb.append(word);
                } else {
                    double newPrice = price * (1 - discount * 0.01);
                    String format = String.format("$%.2f", newPrice);
                    sb.append(format);
                }
            }
            return sb.toString();
        }

        private Long getOriginalPrice(String word) {
            if (!word.startsWith("$")) {
                return null;
            }
            long price = 0;
            char[] chars = word.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if ('0' <= chars[i] && chars[i] <= '9') {
                    price = price * 10 + (chars[i] - '0');
                } else {
                    return null;
                }
            }
            if (price == 0) {
                return null;
            }

            return price;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
