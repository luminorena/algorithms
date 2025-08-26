package ru.otus.algos_06_simple_sorts.utils;


import java.util.Random;


public class Randomizer {
    public long[] getRandomArray(int countArray) {
        Random random = new Random();
        long[] randomArray = new long[countArray];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(1, 100);
        }
        return randomArray;
    }
}

