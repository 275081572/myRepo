package com.cn.smart.calculate;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/22
 */

public class SelectSort {

    public static void sort(int[] arr) {
        int tmp = 0;
        for(int i = 0; i < arr.length -1; i++){
            int k = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[k]){
                    k = j;
                }
            }
            tmp = arr[k];
            arr[k] = arr[i];
            arr[i] = tmp;
        }
    }
}
