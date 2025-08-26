package ru.otus.algos_06_simple_sorts.bubblesort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

public class BubbleSortOptimized {

    private static void sort(long[] initialArray){
        boolean sorted = false;

        long temp;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < initialArray.length-1; i++){
                if (initialArray[i]> initialArray[i+1]){
                    temp = initialArray[i];
                    initialArray[i] = initialArray[i+1];
                    initialArray[i+1] = temp;
                    sorted = false;
                }

            }}
        System.out.print(Arrays.toString(initialArray));

    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }

}
