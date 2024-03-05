package com.栈;


import java.util.Stack;

public class Code232_用栈实现队列 {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int peek = obj.peek();
        System.out.println(peek);
        int pop = obj.pop();
        System.out.println(pop);
        boolean empty = obj.empty();
        System.out.println(empty);
    }

    public static class MyQueue {
        private Stack<Integer> stackInput = new Stack<>();
        private Stack<Integer> stackOut = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stackInput.push(x);
        }

        public int pop() {
            if (stackOut.empty()) {
                moveToOutStack();
            }
            return stackOut.pop();
        }

        public int peek() {
            if (stackOut.empty()) {
                moveToOutStack();
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackOut.empty() && stackInput.empty();
        }

        private void moveToOutStack() {
            while (!stackInput.isEmpty()) {
                stackOut.push(stackInput.pop());
            }
        }
    }

}
