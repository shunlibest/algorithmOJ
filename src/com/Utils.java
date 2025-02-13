package com;

import com.每日一题.leetcode.editor.cn.Code743_networkDelayTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static int[][] convertStringTo2DArray(String arrayString) {

        if (arrayString.equals("[]")) {
            return new int[0][0];
        }

        arrayString = arrayString.replace(" ", "");
        // Remove the leading and trailing brackets
        arrayString = arrayString.substring(1, arrayString.length() - 1);

        // Split the string by '],[' to get individual row strings
        String[] rowStrings = arrayString.split("],\\[");

        List<int[]> rowsList = new ArrayList<>();
        for (String rowString : rowStrings) {
            // Clean up each row string and split by commas to get individual numbers
            rowString = rowString.replaceAll("[\\[\\]]", "");

            if (rowString.equals("")) {
                int[] row = new int[0];
                rowsList.add(row);
                continue;
            }

            String[] numberStrings = rowString.split(",");
            // Parse the numbers into an array
            int[] row = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                row[i] = Integer.parseInt(numberStrings[i].trim());
            }
            // Add the row to the list of rows
            rowsList.add(row);
        }

        // Convert the list of rows into a 2D array
        int[][] resultArray = new int[rowsList.size()][];
        for (int i = 0; i < rowsList.size(); i++) {
            resultArray[i] = rowsList.get(i);
        }

        return resultArray;
    }


    /**
     * Prints a 2D integer array in a readable format.
     *
     * @param array the 2D integer array to print
     */
    public static void print2DArray(int[][] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty or null");
            return;
        }

        for (int[] row : array) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }


    public static void print2DArray(long[][] array) {
        if (array == null || array.length == 0) {
            System.out.println("Array is empty or null");
            return;
        }

        for (long[] row : array) {
            for (long elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    /**
     * Converts a string representation of a 2D array into a List<List<Integer>> object.
     *
     * @param arrayString the string representation of the 2D array, e.g. "[[2],[3,4],[6,5,7],[4,1,8,3]]"
     * @return the converted List<List<Integer>> object
     */
    public static List<List<Integer>> convertStringToList(String arrayString) {
        // Remove the leading and trailing brackets
        arrayString = arrayString.substring(1, arrayString.length() - 1);

        // Split the string by '],[' to get individual row strings
        String[] rowStrings = arrayString.split("\\],\\[");

        List<List<Integer>> resultList = new ArrayList<>();
        for (String rowString : rowStrings) {
            // Clean up each row string and split by commas to get individual numbers
            rowString = rowString.replaceAll("[\\[\\]]", "");
            String[] numberStrings = rowString.split(",");

            // Parse the numbers into a list
            List<Integer> row = new ArrayList<>();
            for (String numberStr : numberStrings) {
                if (!numberStr.isEmpty()) { // Ensure the string is not empty
                    row.add(Integer.parseInt(numberStr));
                }
            }

            // Add the row to the result list
            resultList.add(row);
        }

        return resultList;
    }

    public static List<List<String>> convertStringToStringList(String arrayString) {
        // Remove the leading and trailing brackets
        arrayString = arrayString.substring(1, arrayString.length() - 1);

        // Split the string by '],[' to get individual row strings
        String[] rowStrings = arrayString.split("\\],\\[");

        List<List<String>> resultList = new ArrayList<>();
        for (String rowString : rowStrings) {
            // Clean up each row string and split by commas to get individual numbers
            rowString = rowString.replaceAll("[\\[\\]]", "");
            String[] numberStrings = rowString.split(",");

            // Parse the numbers into a list
            List<String> row = new ArrayList<>();
            for (String numberStr : numberStrings) {
                if (!numberStr.isEmpty()) { // Ensure the string is not empty
                    row.add(numberStr);
                }
            }

            // Add the row to the result list
            resultList.add(row);
        }

        return resultList;
    }


    public static void printTable(boolean[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printTable(double[] array) {
        System.out.println(Arrays.toString(array));
    }


    public static void printTable(List array) {
        System.out.println(array);
    }


    public static void printTable(int[] array) {
        System.out.println(Arrays.toString(array));
    }



    public static void printTable(long[][] booleanArray) {
        int[][] intArray = new int[booleanArray.length][booleanArray[0].length];
        for (int i = 0; i < booleanArray.length; i++) {
            for (int j = 0; j < booleanArray[i].length; j++) {
                intArray[i][j] = (int) booleanArray[i][j];
            }
        }
        printTable(intArray);
    }


    public static void printTable(char[][] charArray) {
        // 外层循环遍历行
        for (int i = 0; i < charArray.length; i++) {
            // 内层循环遍历列
            for (int j = 0; j < charArray[i].length; j++) {
                // 打印当前元素，避免换行
                System.out.print(charArray[i][j] + " ");
            }
            // 打印完一行后换行
            System.out.println();
        }
    }

    public static void printTable(boolean[][] booleanArray) {
        int[][] intArray = new int[booleanArray.length][booleanArray[0].length];
        for (int i = 0; i < booleanArray.length; i++) {
            for (int j = 0; j < booleanArray[i].length; j++) {
                intArray[i][j] = booleanArray[i][j] ? 1 : 0;
            }
        }
        printTable(intArray);
    }

    public static void printTable(int[][] intArray) {
        String[][] stringArray = new String[intArray.length][];
        for (int i = 0; i < intArray.length; i++) {
            stringArray[i] = new String[intArray[i].length];
            for (int j = 0; j < intArray[i].length; j++) {
                stringArray[i][j] = String.valueOf(intArray[i][j]);
            }
        }
        String[] width = generateStringArray(intArray[0].length);

        String[] height = generateStringArray(intArray.length);

        String[][] table = new String[intArray.length + 1][intArray[0].length + 1];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (i == 0 && j == 0) {
                    table[0][0] = "good\\size";

                } else if (i == 0) {
                    table[i][j] = width[j - 1];
                } else if (j == 0) {
                    table[i][j] = height[i - 1];
                } else {
                    table[i][j] = stringArray[i - 1][j - 1];
                }

            }
        }

        printTable(table);
    }


    private static void printTable(String[][] table) {
        // 获取每列的最大宽度，用于对齐
        int[] columnWidths = new int[table[0].length];
        for (int i = 0; i < table[0].length; i++) {
            int maxWidth = 0;
            for (int j = 0; j < table.length; j++) {
                maxWidth = Math.max(maxWidth, table[j][i].length());
            }
            columnWidths[i] = maxWidth;
        }

        // 构建和打印表格
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            // 打印行
            for (int j = 0; j < table[i].length; j++) {
                sb.append("| ").append(padCenter(table[i][j], columnWidths[j])).append(" ");
            }
            sb.append("|").append("\n");

            // 打印行分隔符
            if (i == 0) {
                sb.append("|");
                for (int width : columnWidths) {
                    sb.append(repeat("-", width + 2)).append("|");
                }
                sb.append("\n");
            }
        }
        // 输出结果
        System.out.println(sb.toString());
    }

    private static String padCenter(String s, int width) {
        int padding = width - s.length();
        int paddingLeft = padding / 2;
        int paddingRight = padding - paddingLeft;
        return repeat(" ", paddingLeft) + s + repeat(" ", paddingRight);
    }

    private static String repeat(String str, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }

    private static String[] generateStringArray(int N) {
        return generateStringArray(N, 0);
    }

    private static String[] generateStringArray(int N, int start) {
        String[] stringArray = new String[N];  // 为包含 0 和 N，数组大小为 N + 1
        for (int i = 0; i < N; i++) {
            stringArray[i] = String.valueOf(i + start);  // 将整数转换为字符串
        }
        return stringArray;
    }

    // 将边列表转换为邻接矩阵
    public static int[][] convertToAdjacencyMatrix(List<List<Integer>> edges) {

        int n = edges.size();

        int[][] adjacencyMatrix = new int[n][n];
        // 遍历每一条边并填充邻接矩阵
        for (int i = 0; i < edges.size(); i++) {
            for (int edge : edges.get(i)) {
                adjacencyMatrix[i][edge] = 1;  // 如果有权重，可以替换1为权重值
            }
        }

        return adjacencyMatrix;
    }

    private static int[][] convertToAdjacencyMatrixDistance(List<List<Edge>> edges) {

        int n = 0;
        for (List<Edge> edge : edges) {
            for (Edge e : edge) {
                n = Math.max(n, e.target + 1);
            }
        }


        int[][] adjacencyMatrix = new int[n][n];
        // 遍历每一条边并填充邻接矩阵
        for (int i = 0; i < edges.size(); i++) {
            for (Edge edge : edges.get(i)) {
                adjacencyMatrix[i][edge.target] = edge.weight;  // 如果有权重，可以替换1为权重值
            }
        }

        return adjacencyMatrix;
    }

    public static void printDrawMap(String string) {
        List<List<Integer>> lists = Utils.convertStringToList(string);
        Utils.printDrawMap(Utils.convertToAdjacencyMatrix(lists));
    }

    public static void printDrawMapDistance(int[][] times) {

        List<List<Edge>> edges = new ArrayList<>(times.length);
        for (int i = 0; i < times.length; i++) {
            edges.add(i, new ArrayList<>());
        }
        for (int[] connection : times) {
            edges.get(connection[0] - 1).add(new Edge(connection[1] - 1, connection[2]));
        }

        Utils.printDrawMap(Utils.convertToAdjacencyMatrixDistance(edges));
    }

    //[[2,1,1],[2,3,1],[3,4,1]]
    public static void printDrawMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                sb.append(ints[j]).append(",");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void printDrawMap(List<List<Integer>> edges) {
        printDrawMap(Utils.convertToAdjacencyMatrix(edges));
    }

    public static class Edge {
        public int target;
        public int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

//    public static int getDpFinial(int[][] dp){
//        return dp[dp.length-1][dp.length]
//    }
}
