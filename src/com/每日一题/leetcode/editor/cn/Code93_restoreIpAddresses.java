package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-09-02 16:41:03
 * 题目名称: 复原 IP 地址
 * 题目类型:
 * 思考:
 */


public class Code93_restoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new Code93_restoreIpAddresses().new Solution();
        Object i0 = "25525511135";
        Object i1 = "101023";
        List<String> strings = solution.restoreIpAddresses("101023");

        Utils.printTable(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> result = new ArrayList<>();


            restoreIp(result, "", s, 4);

            return result;
        }


        private void restoreIp(List<String> result, String currentString, String remainString, int step) {
            if (step == 0) {
                if (remainString.equals("")) {
                    result.add(currentString.substring(0, currentString.length() - 1));
                }
                return;
            }

            if (remainString.equals("")) {
                return;
            }

            if (remainString.charAt(0) == '0') {
                restoreIp(result, currentString + "0.", remainString.substring(1), step - 1);
                return;
            }
            for (int i = 0; i < remainString.length(); i++) {

                String substring = remainString.substring(0, i + 1);
                int value = Integer.parseInt(substring);


                if (value <= 255) {
                    restoreIp(result, currentString + substring + ".", remainString.substring(i + 1), step - 1);
                } else {
                    break;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
