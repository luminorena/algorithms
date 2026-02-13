package ru.otus.algos_17_Boyer_Moore.boyer_moore;

public class Main {
    public static void main(String[] args) {
        SearchBM searchBM = new SearchBM();
        String text = "AAAAABBBBBUTTERTTTEDFERERBERFGEE";
        String mask = "BUTTER";
        System.out.println(searchBM.run(text, mask));
    }
}
