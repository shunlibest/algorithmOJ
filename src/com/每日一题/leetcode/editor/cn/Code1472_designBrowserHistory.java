package com.每日一题.leetcode.editor.cn;

import java.util.LinkedList;

/**
 * [每日一题] 2025-02-26 10:03:23
 * 题目名称: 设计浏览器历史记录
 * 题目类型:
 * 思考:
 */


public class Code1472_designBrowserHistory {
    public static void main(String[] args) {
        BrowserHistory solution = new Code1472_designBrowserHistory().new BrowserHistory("leetcode.com");
        String[] i0 = {"BrowserHistory", "visit", "visit", "visit", "back", "back", "forward", "visit", "forward", "back", "back"};
        solution.visit("google.com");
        solution.visit("facebook.com");
        solution.visit("youtube.com");
//        solution.visit("google.com");

//        String back = ;
        System.out.println(solution.back(1));
        System.out.println(solution.back(1));

        System.out.println(solution.forward(1));

        solution.visit("Linkedin.com");

        System.out.println(solution.forward(2));

        System.out.println(solution.back(2));
        System.out.println(solution.back(7));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class BrowserHistory {
        Node currentPage;

        public BrowserHistory(String homepage) {
            currentPage = new Node(homepage);
        }

        public void visit(String url) {
            Node nextPage = new Node(url);
            nextPage.pre = currentPage;
            currentPage.next = nextPage;
            currentPage = currentPage.next;
        }

        public String back(int steps) {

            while (currentPage.pre != null && steps > 0) {
                currentPage = currentPage.pre;
                steps--;
            }
            return currentPage.url;
        }

        public String forward(int steps) {
            while (currentPage.next != null && steps > 0) {
                currentPage = currentPage.next;
                steps--;
            }
            return currentPage.url;
        }

         class Node {
            public String url;
            public Node pre;
            public Node next;

            public Node(String url) {
                this.url = url;
            }
        }

    }



/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
