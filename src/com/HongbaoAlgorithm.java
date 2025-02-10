package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HongbaoAlgorithm {

    public static List<Double> hongbao(double total, int num) {
        List<Double> arr = new ArrayList<>();
        double restAmount = total;
        int restNum = num;
        Random random = new Random();

        for (int i = 0; i < num - 1; i++) {
            double amount = Math.round(random.nextDouble() * (restAmount / restNum * 2) * 100.0) / 100.0;
            restAmount -= amount;
            restNum--;
            arr.add(amount);
        }

        arr.add(Math.round(restAmount * 100.0) / 100.0);
        return arr;
    }

    public static void main(String[] args) {
        double totalAmount = 100.0;
        int numPeople = 5;
        int[] res = new int[5];

        for (int repeat = 0; repeat < 10000000; repeat++) {
            List<Double> result = hongbao(totalAmount, numPeople);

            for (int i = 0; i < result.size(); i++) {
                res[i] += result.get(i);
            }
        }
        double sum = 0;
        for (double amount : res) {
            System.out.println(amount);
            sum += amount;
        }

        // 求和
//        double sum = calculateSum(result);
        System.out.println("Sum: " + sum);

    }

    public static double calculateSum(List<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue).sum();
    }

}