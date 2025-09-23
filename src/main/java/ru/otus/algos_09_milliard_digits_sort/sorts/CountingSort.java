package ru.otus.algos_09_milliard_digits_sort.sorts;

import java.util.Arrays;

public class CountingSort {
    /*
    используется, когда в массиве только числа, и их разнообразие ограничено несколькими
    разными элементами
     */

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7, 2, 7, 1, 2, 1, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int findMax(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }

    public static void sort(int[] array) {
        int maxValue = findMax(array);

        int[] count = new int[maxValue + 1];

        int[] sorted = new int[array.length];

        for (int value : array) {
            count[value]++;
        }

        int cumulativeCount = 0;
        for (int i = 0; i <= maxValue; i++) {
            cumulativeCount += count[i];
            count[i] = cumulativeCount;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            count[value]--;
            sorted[count[value]] = value;
        }

        System.arraycopy(sorted, 0, array, 0, array.length);
    }
}
