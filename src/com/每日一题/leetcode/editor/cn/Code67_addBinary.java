package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-09-02 15:11:14
 * 题目名称: 二进制求和
 * 题目类型:
 * 思考:
 */


public class Code67_addBinary {
    public static void main(String[] args) {
        Solution solution = new Code67_addBinary().new Solution();
        String i0 = "100";
        String i1 = "110010";
        String s = solution.addBinary(i0, i1);

        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a.equals("0")) {
                return b;
            }

            if (b.equals("0")) {
                return a;
            }

            int length = Math.max(a.length(), b.length());

            char[] charsA = a.toCharArray();
            char[] charsB = b.toCharArray();

            int lastBit = 0;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int aa = 0;
                if (charsA.length - i - 1 >= 0) {
                    aa = charsA[charsA.length - i - 1] - '0';
                }
                int bb = 0;
                if (charsB.length - i - 1 >= 0) {
                    bb = charsB[charsB.length - i - 1] - '0';
                }
//                System.out.println(aa + ", " + bb);


                int value = aa + bb + lastBit;

                if (value >= 2) {
                    lastBit = 1;
                } else {
                    lastBit = 0;
                }
                sb.append(value % 2);
            }

            if (lastBit % 2 == 1) {
                sb.append(1);
            }


            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
