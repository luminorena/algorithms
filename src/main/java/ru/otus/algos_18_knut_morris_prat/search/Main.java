package ru.otus.algos_18_knut_morris_prat.search;

public class Main {
    public static void main(String[] args) {
        String text = "This is aa aa text to search";
        Search search = new Search("aa");
        System.out.println(search.search(text));
    }
}
