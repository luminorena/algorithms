package ru.otus.algos_09_milliard_digits_sort.rnd;


import java.util.Random;

public class Randomizer {
    public long[] getRandomArray(int countArray) {
        Random random = new Random();
        long[] randomArray = new long[countArray];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100, 999);
        }
        return randomArray;

    }

}
