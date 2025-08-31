package ru.otus.algos_07_pyramid_sort.sorts;

import ru.otus.algos_07_pyramid_sort.utils.Randomizer;

import java.util.Arrays;

/*
выбирается элемент с минимальным ключом и меняется с начальным элементом
сначала находим минимум
 */
public class SelectionSort {
    private static void sort(long[] initialArray) {
        // Внешний цикл определяет позицию текущего элемента, который нужно заменить.
        for (int i = 0; i < initialArray.length - 1; i++) {
            int min = i;
          //  Внутренний цикл ищет минимальный элемент после этой позиции.
            for (int j = i + 1; j < initialArray.length; j++){
                if (initialArray[j] < initialArray[min]) {
                    min = j;
                }
            }
            swap(initialArray, i, min);
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
