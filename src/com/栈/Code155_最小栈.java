package com.栈;

import java.util.Stack;

public class Code155_最小栈 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
    }

    static class MinStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMin = new Stack<>();
        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
        }

        public void pop() {
            Integer pop = stack.pop();


        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return 0;
        }
    }
}
