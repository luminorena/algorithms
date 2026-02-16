package ru.otus.algos_18_knut_morris_prat.KMP;

public class Main {
    public static void main(String[] args) {
        String text = "This is aa aa text to search aa";
        String needle = "aa";
        SearchKmp search = new SearchKmp();
        search.createPi(needle);
        System.out.println(search.search(text, needle));
    }
}
