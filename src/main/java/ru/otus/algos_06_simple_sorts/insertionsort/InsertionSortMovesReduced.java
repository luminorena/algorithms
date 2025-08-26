package ru.otus.algos_06_simple_sorts.insertionsort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

public class InsertionSortMovesReduced {
    private static void sort(long[] initialArray){

        for (int i = 1; i < initialArray.length; i++){
            int index = i;
            long cachedValue = initialArray[i];
            while (index > 0) {
                if (initialArray[index - 1] <= cachedValue)
                    break;
                initialArray[index] = initialArray[index - 1];
                index--;
            }
            initialArray[index] = cachedValue;
        }
        System.out.println(Arrays.toString(initialArray));
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }

}
