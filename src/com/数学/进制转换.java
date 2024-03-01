package com.数学;

public class 进制转换 {

    public static void main(String[] args) {
        String s = new 进制转换().decimalToOthers(123456, 8);
        System.out.println(s);
    }

    private String decimalToOthers(int number, int base) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int num = number % base;
            number = number / base;
            result.append(num);
        }
        return result.toString();
    }
}
