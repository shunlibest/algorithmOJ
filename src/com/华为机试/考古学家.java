package com.华为机试;

import java.util.Scanner;
import java.util.TreeSet;

public class 考古学家 {
    static TreeSet<String> treeSet = new TreeSet<>();
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        String[] stringArray = new String[size];

        for (int i = 0; i < size; i++) {
            stringArray[i] = in.next();
        }

        array(stringArray, 0);
//        System.out.println("----");

        for (Object v: treeSet.toArray()) {
            String value = (String)v;
            System.out.println(value);
        }

    }

    private static void array(String[] inputString, int k) {

        if (k >= inputString.length) {
//            System.out.println(Arrays.toString(inputString));
             StringBuilder sb = new StringBuilder();
            for (String str : inputString) {
                sb.append(str);
            }
            treeSet.add(sb.toString());
            return;
        }

        for (int i = k; i < inputString.length; i++) {
            swap(inputString, i, k);
            array(inputString, ++k);
            swap(inputString, i, --k);
        }
    }

    private static void swap(String[] inputString, int i, int k) {
        final String temp = inputString[i];
        inputString[i] = inputString[k];
        inputString[k] = temp;
    }
}
