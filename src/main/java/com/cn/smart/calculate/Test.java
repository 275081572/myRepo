package com.cn.smart.calculate;


/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/22
 */

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 2;

        System.out.print("[");
        for(int i = 0; i < 4; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");

        InsertSort.sort3(arr);

        System.out.print("[");
        for(int i = 0; i < 4; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    public static void sort1(int[] arr){
        //冒泡排序
        int tmp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void sort2(int[] arr){
        //选择排序
        int tmp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            int k = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[k]){
                   k = j;
                }
            }
            tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void sort3(int[] arr){
        //插入排序
        int tmp = 0;
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while (j > 0){
                if(arr[j] < arr[j - 1]){
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
                j--;
            }
        }
    }

}
