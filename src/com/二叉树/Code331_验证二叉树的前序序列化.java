package com.二叉树;

import java.util.Stack;

public class Code331_验证二叉树的前序序列化 {
    public static void main(String[] args) {
        String array = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = new Code331_验证二叉树的前序序列化().isValidSerialization(array);
        System.out.println(validSerialization);
    }

    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        Stack<String> visitNode = new Stack<>();
        Stack<Integer> visitNodeCount = new Stack<>();


        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            if (item.equals("#")) {
                while (true) {
                    if (visitNodeCount.isEmpty()) {
                        return i == split.length - 1;
                    }
                    Integer pop = visitNodeCount.pop() + 1;
                    if (pop == 2) {
                        visitNode.pop();
                    } else {
                        visitNodeCount.push(pop);
                        break;
                    }
                }

            } else {
                visitNode.push(item);
                visitNodeCount.push(0);
            }

            if (visitNodeCount.isEmpty()) {
                return i == split.length - 1;
            }
        }

        return visitNodeCount.isEmpty();
    }
}
