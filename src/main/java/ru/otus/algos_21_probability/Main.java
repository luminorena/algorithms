package ru.otus.algos_21_probability;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(HyperLogLogEx
                .countUniqueFromFile("test-data.txt"));

        System.out.println(HyperLogLogEx.calculateError(14));
    }
}
