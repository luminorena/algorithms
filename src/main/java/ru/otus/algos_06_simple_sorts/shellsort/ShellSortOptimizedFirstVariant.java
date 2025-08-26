package ru.otus.algos_06_simple_sorts.shellsort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

public class ShellSortOptimizedFirstVariant {

    private static void sort(long[] initialArray) {
        for (int gap = initialArray.length / 3; gap > 0; gap /= 2) {
            for (int j = gap; j < initialArray.length; j++) {
                for (int i = j; i >= gap; i -= gap) {

                    if (initialArray[i - gap] <= initialArray[i])
                        break;

                    swap(initialArray, i - gap, i);
                }
            }
        }

        System.out.print(Arrays.toString(initialArray));
    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }


}
