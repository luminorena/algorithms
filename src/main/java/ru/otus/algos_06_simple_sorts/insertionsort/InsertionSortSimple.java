package ru.otus.algos_06_simple_sorts.insertionsort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

public class InsertionSortSimple {
    private static void sort(long[] initialArray){

        for (int i = 1; i < initialArray.length; i++){
            int index = i - 1;
            while (index >= 0) {
                if (initialArray[index] <= initialArray[index+1])
                    break;
                swap(initialArray, index, index+1);
                index--;

            }
        }
        System.out.println(Arrays.toString(initialArray));
    }

    private static void swap (long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }

}
