package ru.otus.algos_07_pyramid_sort.sorts;

import ru.otus.algos_07_pyramid_sort.utils.Randomizer;

import java.util.Arrays;

/*
Шейкер-сортировка является усовершенствованным методом пузырьковой сортировки.
минимальный элемент идет налево, максимальный - направо
 */
public class ShakerSort {

    private static void sort(long[] initialArray) {
        int left = 0;
        int right = initialArray.length - 1;
        boolean sorted = false;
        while (left < right && !sorted) {
            sorted = true;
            for (int i = right; i > left; i--) {
                if (initialArray[i] < initialArray[i - 1]) {
                    sorted = false;
                    swap(initialArray, i, i - 1);
                }
            }
            left++;

            for (int i = left; i < right; i++) {
                if (initialArray[i] > initialArray[i + 1]) {
                    sorted = false;
                    swap(initialArray, i, i + 1);
                }
            }
            right--;
        }

        System.out.println(Arrays.toString(initialArray));
    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        long[] arr = randomizer.getRandomArray(6);
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }
}
