package com.cn.smart.calculate;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/22
 */

public class InsertSort {

    public static void sort1(int[] arr){
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
        int tmp = 0;
        for(int i = 1; i < arr.length; i++){
            int j = i;
           while(j > 0 && arr[j - 1] > arr[j]){
               tmp = arr[j - 1];
               arr[j - 1] = arr[j];
               arr[j] = tmp;
               j--;
           }
        }
    }

}
