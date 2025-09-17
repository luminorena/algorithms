package ru.otus.algos_08_quick_and_external_sort.sorts;

import ru.otus.algos_08_quick_and_external_sort.utils.Randomizer;

import java.util.Arrays;

public class QuickSort {
    static Randomizer randomizer = new Randomizer();
    static long[] arr = randomizer.getRandomArray(10);

    static void sort(int left, int right){
        if (left >= right) return;
        int i = split(left, right);
        sort(left, i - 1);
        sort(i + 1, right);
    }

    private static int split(int left, int right){
        long pivot = arr[right];
        int i = left - 1;
        for (int j = left; j <= right ; j++) {
            if (arr[j] <= pivot)
                swap(++i, j);
        }
        return i;
    }

    private static void swap(int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        sort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

