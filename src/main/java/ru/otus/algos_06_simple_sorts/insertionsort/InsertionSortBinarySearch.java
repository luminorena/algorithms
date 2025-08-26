package ru.otus.algos_06_simple_sorts.insertionsort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

/*
O(NLOG(N)) этот алгоритм отработает за квазилинейное время
*/

public class InsertionSortBinarySearch {
    private static void sort(long[] initialArray){

        for (int i = 1; i < initialArray.length; i++){
            long cachedValue = initialArray[i];
            int position = binarySearch(initialArray, cachedValue, 0, i - 1);  // позиция — int
            for (int j = i - 1; j >= position; j--) {
                initialArray[j + 1] = initialArray[j];
            }
            initialArray[position] = cachedValue;
        }
        System.out.println(Arrays.toString(initialArray));
    }

    private static int binarySearch(long[] array, long key, int left, int right) {
        if (left > right)
            return left;
        int mid = (left + right) / 2;
        if (key < array[mid])
            return binarySearch(array, key, left, mid - 1);
        return binarySearch(array, key, mid + 1, right);
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }

}
