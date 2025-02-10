package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-08-12 10:09:19
 * 题目名称: 实现一个魔法字典
 * 题目类型:
 * 思考:
 */


public class Code676_implementMagicDictionary {
    public static void main(String[] args) {
        MagicDictionary solution = new Code676_implementMagicDictionary().new MagicDictionary();
        String[] i = {"hello", "leetcode"};
        solution.buildDict(i);

        boolean hello = solution.search("hello");
        System.out.println(hello);

        boolean hhllo = solution.search("hhllo");
        System.out.println(hhllo);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MagicDictionary {
        String[] list;

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            list = dictionary;
        }

        public boolean search(String searchWord) {
            for (String s : list) {
                boolean find = isFind(s, searchWord);
                if (find) {
                    return true;
                }
            }

            return false;
        }

        private boolean isFind(String s, String searchWord) {
            if (s.length() != searchWord.length()) {
                return false;
            }
            if (s.equals(searchWord)) {
                return false;
            }
            int diffCharCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != searchWord.charAt(i)) {
                    diffCharCount++;
                }
                if (diffCharCount > 1) {
                    return false;
                }
            }
            return diffCharCount == 1;
        }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
