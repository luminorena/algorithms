package ru.otus.algos_09_milliard_digits_sort.sorts;

/*
    по факту, это как несколько запусков CountingSort, но для больших чисел по размеру и для большего кол-ва
    чисел по диапазону
     */

public class RadixSort {

    public static void sort(int[] array) {
        final int base = 10;
        final int digitCount = 3;

        int[] tempArray = new int[array.length];
        int divisor = 1;

        for (int digit = 0; digit < digitCount; digit++) {
            int[] count = new int[base];

            for (int value : array) {
                int digitValue = (value / divisor) % base;
                count[digitValue]++;

            }

            int cumulativeSum = 0;
            for (int i = 0; i < base; i++) {
                cumulativeSum += count[i];
                count[i] = cumulativeSum;
            }

            for (int i = array.length - 1; i >= 0; i--) {
                int digitValue = (array[i] / divisor) % base;
                count[digitValue]--;
                tempArray[count[digitValue]] = array[i];
            }

            System.arraycopy(tempArray, 0, array, 0, array.length);

            divisor *= base;
        }

    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 120, 152, 999, 798, 871, 290, 111, 666, 700};
        sort(arr);
        System.out.println("Отсортированный массив: " + java.util.Arrays.toString(arr));

    }
}


