package com.每日一题.leetcode.editor.cn;


import com.Utils;

import java.util.*;

/**
 * [每日一题] 2024-09-02 17:52:42
 * 题目名称: LRU 缓存
 * 题目类型:
 * 思考:
 */


public class Code146_lruCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new Code146_lruCache().new LRUCache(1);


        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1}

        lRUCache.print();

        lRUCache.get(2);

        lRUCache.put(1, 1);

        lRUCache.put(4, 1);

        lRUCache.get(2);


        lRUCache.print();
//        lRUCache.put(3, 2); // 缓存是 {1=1, 2=2}
//
//        lRUCache.get(2);
//
//        lRUCache.print();
//
//        lRUCache.get(3);


//        lRUCache.get(1); // 返回 1
//
//        lRUCache.print();
//        lRUCache.put(3, 3);

        lRUCache.print();
        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}

        lRUCache.print();
        System.out.println(lRUCache.get(2));


        // 返回 -1 (未找到) lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3} lRUCache.get(1); // 返回 -1 (未找到) lRUCache.get(3); // 返回 3 lRUCache.get(4); // 返回 4

//        long l = System.currentTimeMillis();
//
//        lRUCache.get(6);
//        lRUCache.get(8);
//        lRUCache.put(12, 1);
//
//        lRUCache.get(2);
//
//        lRUCache.put(15, 11);
//        lRUCache.put(5, 2);
//        lRUCache.put(1, 15);
//        lRUCache.put(4, 2);
//
//        lRUCache.get(5);
//        lRUCache.put(15, 15);


//        // 操作列表
//        String[] operations = {"LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"};
//        // 参数列表
//        int[][] values = Utils.convertStringTo2DArray("[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]");
//
//        // lRUCache 对象
//        LRUCache lRUCache = new Code146_lruCache().new LRUCache(1);
//
//        for (int i = 0; i < operations.length; i++) {
//            String operation = operations[i];
//            switch (operation) {
//                case "LRUCache":
//                    break;
//                case "put":
//                    lRUCache.put(values[i][0], values[i][1]);
//
//                    System.out.println("put:" + values[i][0]);
//
//                    lRUCache.print();
//
//                    break;
//                case "get":
//                    int result = lRUCache.get(values[i][0]);
//                    System.out.println("get " + values[i][0] + " ->" + result);
//                    lRUCache.print();
//
//                    break;
//            }
//        }

//        System.out.println(System.currentTimeMillis() - );


//
//        lRUCache.print();
//
//
//        lRUCache.get(1);
//
//        lRUCache.put(1, 5);
//
//        lRUCache.put(1, 2);
//
//        lRUCache.get(1);
//
//        lRUCache.print();
//
//        System.out.println( lRUCache.get(2));
//
//        lRUCache.put(3, 3);
        lRUCache.print();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        int capacity;
        Map<Integer, Node> map = new HashMap<>();

        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            // 哨兵节点
            this.head = new Node(-1, -1, null, null);
            this.tail = new Node(-1, -1, null, null);
            this.tail.prev = head;
            this.head.next = tail;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }

            removeNode(node);
            tailAddNode(node);

            return node.value;
        }

        private void removeNode(Node node) {
            Node next = node.next;
            Node prev = node.prev;
            next.prev = prev;
            prev.next = next;
        }

        private void tailAddNode(Node node) {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            tail.prev = node;
            node.next = tail;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                removeNode(node);

                node.value = value;
                tailAddNode(node);
            } else {
                Node newNode = new Node(key, value, null, null);
                map.put(key, newNode);
                tailAddNode(newNode);
            }


            if (map.size() > capacity) {
                Node removeNode = head.next;
                map.remove(removeNode.key);
                removeNode(removeNode);
            }

        }

        private void print() {

            Node current = head;

            StringBuilder sb = new StringBuilder();
            while (current != null) {
                sb.append(current.key).append(",");
                current = current.next;
            }
            System.out.println(sb);

        }


//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        Map<Integer, Integer> indexMap = new HashMap<>();
//        int capacity;
//
//        public LRUCache(int capacity) {
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            Integer integer = map.get(key);
//            if (integer == null) {
//                return -1;
//            }
//            map.put(key, integer);
//            list.remove((Integer) key);
//            list.add(key);
//            return integer;
//        }
//
//        public void put(int key, int value) {
//            map.put(key, value);
//            if (map.containsKey(key)) {
//                list.remove((int) indexMap.get(key));
//                list.add(key);
//                indexMap.put(key, list.size() - 1);
//            }
//
//
//            if (map.size() > capacity) {
//                map.remove(list.get(0));
//                list.remove(0);
//            }
//
//        }


        public class Node {
            public int key;
            public int value;
            public Node prev;
            public Node next;

            public Node(int key, int value, Node prev, Node next) {
                this.key = key;
                this.value = value;
                this.prev = prev;
                this.next = next;
            }
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
