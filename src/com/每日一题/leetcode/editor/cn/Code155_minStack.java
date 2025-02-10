package com.每日一题.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * [每日一题] 2024-10-18 16:49:58
 * 题目名称: 最小栈
 * 题目类型:
 * 思考:
 */


public class Code155_minStack {
    public static void main(String[] args) {
        MinStack solution = new Code155_minStack().new MinStack();
        String[] i0 = {"MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"};
        solution.push(-2);
        solution.push(0);
        solution.push(-1);

        System.out.println(solution.getMin());
        System.out.println(solution.top());

        solution.pop();

        System.out.println(solution.getMin());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        public MinStack() {

        }

        public void push(int val) {
            Integer value = val;
            stack.push(value);
            queue.add(value);
        }

        public void pop() {
            Integer pop = stack.pop();
            queue.remove(pop);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return queue.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
