package com.栈;

import java.util.ArrayList;
import java.util.List;

public class Code225_用队列实现栈 {


    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());         // 返回 2
        System.out.println(myStack.top());         // 返回 2
        System.out.println(myStack.pop());         // 返回 2
        System.out.println(myStack.pop());         // 返回 2
        myStack.empty(); // 返回 False
    }

    static class MyStack {
        private List<Integer> list1 = new ArrayList<>();
        private List<Integer> list2 = new ArrayList<>();
        private boolean useList1 = true;

        public MyStack() {

        }

        public void push(int x) {
            getCurrentOperateList().add(x);
        }

        public int pop() {
            while (getCurrentOperateList().size() > 1) {
                getOtherList().add(getCurrentOperateList().remove(0));
            }
            Integer remove = getCurrentOperateList().remove(0);
            swapList();
            return remove;
        }

        public int top() {
            while (getCurrentOperateList().size() > 1) {
                getOtherList().add(getCurrentOperateList().remove(0));
            }
            Integer remove = getCurrentOperateList().get(0);
            getOtherList().add(getCurrentOperateList().remove(0));
            swapList();
            return remove;
        }

        public boolean empty() {
            return getCurrentOperateList().isEmpty();
        }

        private List<Integer> getCurrentOperateList() {
            return useList1 ? list1 : list2;
        }

        private List<Integer> getOtherList() {
            return useList1 ? list2 : list1;
        }

        private void swapList() {
            useList1 = !useList1;
        }
    }

}
