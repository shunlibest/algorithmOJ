package com.每日一题.leetcode.editor.cn;

import com.Heap;
import com.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * [每日一题] 2024-09-04 11:01:28
 * 题目名称: 滑动窗口最大值
 * 题目类型:
 * 思考:
 */


public class Code239_slidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new Code239_slidingWindowMaximum().new Solution();
        int[] i0 = {1, 3, -1, -3, 5, 3, 6, 7};
//        Object i1 = {1};
        int[] ints = solution.maxSlidingWindow(i0, 3);
        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public class Item {
            int value;
            int index;

            public Item(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
//

        public int[] maxSlidingWindow(int[] nums, int k) {

            PriorityQueue<Item> queue = new PriorityQueue<>((a, b) -> b.value - a.value);

            int[] result = new int[nums.length - k + 1];

            for (int i = 0; i < k; i++) {
                queue.add(new Item(nums[i], i));
            }
            result[0] = queue.peek().value;
            for (int i = k; i < nums.length; i++) {
                queue.add(new Item(nums[i], i));

                while (queue.peek().index < i - k + 1) {
                    queue.poll();
                }

                result[i - k + 1] = queue.peek().value;
            }
            return result;
        }


//        public int[] maxSlidingWindow(int[] nums, int k) {
//
//            List<Integer> array = new ArrayList<>();
//
//            for (int i = 0; i < nums.length; i++) {
//                addToHeap(array, nums[i]);
//            }
//
//            Heap.printHeap(array);
//
//
//            System.out.println("----");
//
//            while (!array.isEmpty()){
//                int i = removeFromHeap(array);
//                System.out.println(i);
//            }
//
//
//            return null;
//
//        }

        private void addToHeap(List<Integer> array, int value) {
            array.add(value);

            // 优化堆, 从底部到上面

            int currentIndex = array.size() - 1;
            while (true) {
                if (currentIndex <= 0) {
                    // 已经到达根节点了, 无需进行再次遍历了
                    break;
                }
                int parentIndex = (currentIndex - 1) / 2;
                int parentValue = array.get(parentIndex);
                int currentValue = array.get(currentIndex);
                if (currentValue < parentValue) {
                    break;
                }
                // 交换
                swap(array, currentIndex, parentIndex);
                currentIndex = parentIndex;
            }
        }

        private int removeFromHeap(List<Integer> array) {
            swap(array, 0, array.size() - 1);
            int removeValue = array.remove(array.size() - 1);


            int currentIndex = 0;
            int length = array.size();
            while (true) {
                // 判断节点 i, l, r 中值最大的节点，记为 ma
                int leftIndex = currentIndex * 2 + 1;
                int rightIndex = currentIndex * 2 + 2;

//                int currentValue =

                // 从父节点和两个儿子中, 找出最大的节点index
                int maxIndex = currentIndex;

                if (leftIndex < length && array.get(leftIndex) > array.get(maxIndex)) {
                    maxIndex = leftIndex;
                }

                if (rightIndex < length && array.get(leftIndex) > array.get(maxIndex)) {
                    maxIndex = leftIndex;
                }

                if (maxIndex == currentIndex) {
                    // 如果父节点是最大值, 则停止遍历
                    break;
                }
                // 交换两节点
                swap(array, currentIndex, maxIndex);
                // 循环向下堆化
                currentIndex = maxIndex;
            }
            return removeValue;
        }


        private void swap(List<Integer> array, int x, int y) {
            int temp = array.get(x);
            array.set(x, array.get(y));
            array.set(y, temp);
        }

        private void headSorted(int[] array) {


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
