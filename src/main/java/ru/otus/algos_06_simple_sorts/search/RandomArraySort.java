package ru.otus.algos_06_simple_sorts.search;

import java.util.Arrays;

public class RandomArraySort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 80, 8, 1, 0, -4};
        System.out.println("Moved value: " + moveBegin(array, -4));
        System.out.println("Updated array: " + Arrays.toString(array));
    }

    public static Integer moveBegin(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                int cached = arr[i];
                /*
Копирование справа налево защищает от перезаписи и потери данных.
Поэтому цикл в методе moveBegin запускается с j = i и идёт вниз до j > 0.
                 */
                for (int j = i; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = cached;
                return cached;
            }
        }
        return null;
    }

}
