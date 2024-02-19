package com.vm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VisibleCode {
    private static final String VERTICAL = "┃";

    public static void main(String[] args) {
        String[] stack = {"514229", "317811"," "};
        List<TableData> tableData = new ArrayList<>();
        tableData.add(new TableData("index", "name", "value"));

        tableData.add(new TableData("0", "n", "xxx"));
        tableData.add(new TableData("1", " ", " "));


        draw(reverseArray(stack), tableData);
    }

    private static void draw(String[] stack, List<TableData> tableData) {
        String stackString = drawStack(stack);
        String tableString = drawTable(tableData);
        System.out.println(stackString);

        String[] stackList = stackString.split("\n");
        String[] tableList = tableString.split("\n");
        int length = Math.max(stackList.length, tableList.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i < stackList.length) {
                sb.append(stackList[i]);
            } else {
                for (int j = 0; j < stackList[0].length(); j++) {
                    sb.append(" ");
                }
            }
            sb.append("    ┆     ");
            if (i < tableList.length) {
                sb.append(tableList[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
//        System.out.println(table);
    }

    private static String drawStack(String[] stack) {
        int drawNum = 0;
        int maxLength = 0;
        for (String value : stack) {
            maxLength = Math.max(maxLength, value.length());
        }

        StringBuilder sb = new StringBuilder();
        for (String value : stack) {
            sb.append(VERTICAL);
            sb.append(generateBlankText(maxLength, value));
            sb.append(VERTICAL);
            sb.append("\n");
        }
        sb.append("┗");
        for (int i = 0; i < maxLength + 2; i++) {
            sb.append("━");
        }
        sb.append("┛");
        return sb.toString();
    }

    private static String drawTable(List<TableData> tableData) {
        int maxIndexLength = 0;
        int maxNameLength = 0;
        int maxValueLength = 0;
        for (TableData data : tableData) {
            maxIndexLength = Math.max(maxIndexLength, data.index.length());
            maxNameLength = Math.max(maxNameLength, data.name.length());
            maxValueLength = Math.max(maxValueLength, data.value.length());
        }
        StringBuilder sb = new StringBuilder();
        for (TableData data : tableData) {
            sb.append(VERTICAL);
            sb.append(generateBlankText(maxIndexLength, data.index));
            sb.append(VERTICAL);
            sb.append(generateBlankText(maxNameLength, data.name));
            sb.append(VERTICAL);
            sb.append(generateBlankText(maxValueLength, data.value));
            sb.append(VERTICAL);
            sb.append("\n");
        }
        return sb.toString();
    }


    private static String generateBlankText(int maxLength, String drawText) {
        StringBuilder sb = new StringBuilder();
        maxLength += 2;
        for (int i = 0; i < maxLength; i++) {
            sb.append(" ");
        }
        int start = (maxLength - drawText.length()) / 2;
        sb.replace(start, start + drawText.length(), drawText);
        return sb.toString();
    }


    private static class TableData {
        public String index;
        public String name;
        public String value;

        public TableData(String index, String name, String value) {
            this.index = index;
            this.name = name;
            this.value = value;
        }
    }


    private static String[] reverseArray(String[] array) {
        String[] new_array = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            new_array[i] = array[array.length - i - 1];
        }
        return new_array;
    }

}
