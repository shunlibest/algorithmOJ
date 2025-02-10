package com.每日一题.leetcode.editor.cn;

import java.util.Stack;

/**
 * [每日一题] 2024-08-30 14:30:31
 * 题目名称: 有效的括号
 * 题目类型:
 * 思考:
 */


public class Code20_validParentheses {
    public static void main(String[] args) {
        Solution solution = new Code20_validParentheses().new Solution();
        Object i0 = "()";
        Object i1 = "(}";
        boolean valid = solution.isValid("([])");
        System.out.println(valid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(c);
                        break;
                    case ')': {
                        if (stack.isEmpty()){
                            return false;
                        }
                        Character peek = stack.pop();
                        if (peek != '(') {
                            return false;
                        }
                        break;
                    }

                    case '}': {
                        if (stack.isEmpty()){
                            return false;
                        }
                        Character peek = stack.pop();
                        if (peek != '{') {
                            return false;
                        }
                        break;
                    }

                    case ']':
                        if (stack.isEmpty()){
                            return false;
                        }
                        Character peek = stack.pop();
                        if (peek != '[') {
                            return false;
                        }
                        break;
                }

            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
