package com;

// import System.*;
public class TT {

    public static void main(String[] args) {
        int[] array = new int[]{1,4,2,3,0};

        sort(array);
        int sum = 0;
        for(int v : array){
            sum = sum *10 + v;
            // System.out.println(v);
        }
        System.out.print(sum);
    }

    private static void sort(int[] array){
        for(int i = 0; i< array.length; i++){
            for(int j = i+1 ; j < array.length; j++){
                if(array[i] < array[j]){
                    swap(array , i, j);
                }
            }
        }
    }

    private static void swap(int[] array, int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

}