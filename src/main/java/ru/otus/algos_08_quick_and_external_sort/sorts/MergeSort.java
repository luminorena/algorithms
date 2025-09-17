package ru.otus.algos_08_quick_and_external_sort.sorts;

import ru.otus.algos_08_quick_and_external_sort.utils.Randomizer;

import java.util.Arrays;

public class MergeSort {
    static Randomizer randomizer = new Randomizer();
    static long[] arr = randomizer.getRandomArray(10);
    static long[] mergedArr;

    private static void mergeSort(int left, int right){
        if (mergedArr == null) {
            mergedArr = new long[arr.length];  // выделяем один раз
        }
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    // mid - конец первой части
    private static void merge(int left, int mid, int right){
        int mergeLeft = left;
        int mergeRight = mid + 1;
        int mergedIndex = 0;

        while (mergeLeft <= mid && mergeRight <= right){
            if (arr[mergeLeft] >= arr[mergeRight]){
                mergedArr[mergedIndex++] = arr[mergeRight++];
            } else {
                mergedArr[mergedIndex++] = arr[mergeLeft++];
            }
        }
        while(mergeLeft <= mid){
            mergedArr[mergedIndex++] = arr[mergeLeft++];
        }
        while (mergeRight <= right){
            mergedArr[mergedIndex++] = arr[mergeRight++];
        }

        for (int j = left; j <= right; j++) {
            arr[j] = mergedArr[j - left];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        mergeSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

