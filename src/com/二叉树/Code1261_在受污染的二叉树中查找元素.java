package com.二叉树;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Code1261_在受污染的二叉树中查找元素 {
    public static void main(String[] args) {
        Integer[] array = {-1,null,3,4,null,5};
        TreeNode root = TreeNode.array2Tree(array);

        FindElements findElements = new FindElements(root);

    }


    static class FindElements {
        private Set<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            revert(root, 0);
            System.out.println(Arrays.toString(set.toArray()));
        }

        private void revert(TreeNode node, int currentValue) {
            set.add(currentValue);
            if (node.left != null) {
                revert(node.left, currentValue * 2 + 1);
            }
            if (node.right != null) {
                revert(node.right, currentValue * 2 + 2);
            }
        }


        public boolean find(int target) {
            return set.contains(target);
        }
    }

}
