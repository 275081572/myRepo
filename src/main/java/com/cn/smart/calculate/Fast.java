package com.cn.smart.calculate;

/**
 * TODO
 *
 * @author xuwei
 * @date 2023/7/23
 */

public class Fast {

    public static void main(String[] args) {
        int arr[]= {3,1,2,4,2,1,5};
        System.out.println("排序前的数组：");
        printArr(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println("排序后的数组：");
        printArr(arr);

    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if(lo>=hi) return ;
        int partition=partition(arr,lo,hi);
        quickSort(arr,lo,partition-1);
        quickSort(arr,partition+1,hi);
    }


    private static int partition(int[] arr, int lo, int hi) {
        //把最左边的元素当作基准值
        int key=arr[lo];
        int left=lo; //
        int right=hi+1;
        while(true) {
            //左指针遇到>=key的值，才停下
            while(arr[++left] < key) {
                if(left==hi) break;
            }

            //右指针遇到<=key的值，才停下
            while(key < arr[--right]) {
                if(right==lo) break;
            }



            if(left>=right) {
                //扫描了所有元素，结束循环
                break;
            }else {
                //交换左右指针
                swap(arr,left,right);
            }
        }
        //right指向的值一定是小于或等于key值，所以交换key和右指针的值
        swap(arr,lo,right);
        return right;
    }


    /**
     * 交换数组两个元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
