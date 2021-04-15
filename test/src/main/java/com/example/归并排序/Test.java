package com.example.归并排序;

/**
 * @program: test
 * @description:
 * @author: JJH
 * @create: 2021-04-15 12:44
 **/
public class Test {


    public static void main(String[] args) {
        int [] arr = new int []{3,1,4,1,5,9,2,6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, tmp);
    }


    public static void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = 0;
        int j = low, k = mid + 1;  //左边序列和右边序列起始索引
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }

        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }

    public static void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, tmp); //对左边序列进行归并排序
            mergeSort(arr, mid + 1, high, tmp);  //对右边序列进行归并排序
            merge(arr, low, mid, high, tmp);    //合并两个有序序列
        }
    }


}
