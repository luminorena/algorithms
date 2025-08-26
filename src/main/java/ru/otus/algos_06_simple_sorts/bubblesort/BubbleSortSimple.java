package ru.otus.algos_06_simple_sorts.bubblesort;

import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.Arrays;

public class BubbleSortSimple {

    private static void sort(long[] initialArray){
        for (int i = 0; i < initialArray.length - 1; i++) {
            // сравнение соседних элементов
            for (int j = initialArray.length - 1; j > i; j--) {
                if (initialArray[j] < initialArray[j - 1]) {
                    long tmp = initialArray[j];
                    initialArray[j] = initialArray[j - 1];
                    initialArray[j - 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(initialArray));
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        sort(randomizer.getRandomArray(6));
    }
}
