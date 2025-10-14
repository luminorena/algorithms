package ru.otus.algos_10_binary_search_trees.utlis;


import java.util.Random;

public class Sequence {

    public int[] getRandomArray(int countArray) {
        Random random = new Random();
        int[] randomArray = new int[countArray];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(1, 1000);
        }
        return randomArray;
    }

    public int[] getConsequentArray(int countArray) {
        int[] randomArray = new int[countArray];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = i;
        }
        return randomArray;
    }

}

