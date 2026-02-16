package ru.otus.algos_18_knut_morris_prat.search;

public class Search {

    private final String needle;
    private int[][] delta;
    private final int length;
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public Search(String needle) {
        this.needle = needle;
        length = needle.length();
        createDelta();
    }

    private static String left(String line, int x) {
        return line.substring(0, x);
    }

    private static String right(String line, int x) {
        return line.substring(line.length() - x);
    }

    private void createDelta() {
        delta = new int[length + 1][alphabet.length()];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                char c = alphabet.charAt(j);
                int k = i + 1;
                if (k > length) k--;
                String line = left(needle, i) + c;
                while (k >= 0 && !left(needle, k).equals(right(line, k))) {
                    k--;
                }
                delta[i][j] = k;
            }
        }
    }

    public int search(String text) {
        int count = 0;
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int charIndex = alphabet.indexOf(ch);
            if (charIndex >= 0) {
                k = delta[k][charIndex];
            } else {
                k = 0;
            }
            if (k == length)
                count++;
        }
        return count;
    }
}
