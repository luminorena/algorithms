package ru.otus.algos_18_knut_morris_prat.KMP;

public class SearchKmp {
    int[] pi;
    private int length;

    public void createPi(String needle) {
        this.length = needle.length();
        pi = new int[needle.length() + 1];
        pi[0] = 0;
        pi[1] = 0;
        for (int i = 1; i < needle.length(); i++) {
            int len = pi[i];
            while (len > 0 && needle.charAt(len) != needle.charAt(i)) {
                len = pi[len];
            }
            if (needle.charAt(len) == needle.charAt(i)) {
                len++;
            }
            pi[i + 1] = len;
        }
    }

    public int search(String text, String needle){
        if (needle.isEmpty() || text.isEmpty()) return 0;

        int count = 0;
        int k = 0;
        for (int i = 0; i < text.length(); i++) {
            while (k > 0 && needle.charAt(k)!= text.charAt(i)){
                k = pi[k];
            }
            if (needle.charAt(k) == text.charAt(i))
                k++;
            if (k == length){
                count++;
                k = pi[k];
            }
        }
        return count;
    }
}
