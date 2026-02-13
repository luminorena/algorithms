package ru.otus.algos_17_Boyer_Moore.boyer_moore_horspool;

import java.util.Arrays;

public class SearchBMH {

    private static int[] createShift(String mask) {
        int[] shift = new int[128];
        Arrays.fill(shift, mask.length());
        for (int i = 0; i < mask.length(); i++)
            shift[mask.charAt(i)] = 1;
        return shift;
    }

    private static int run(String text, String mask) {
        int[] shift = createShift(mask);
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while ((m >= 0) && (text.charAt(t + m) == mask.charAt(m))) {
                m--;
            }
            if (m < 0)
                return t;
            t += shift[text.charAt(t + mask.length() - 1)];
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "AAAAABBBBBUTTERTTTEDFERERBERFGEE";
        String mask = "BUTTER";
        System.out.println(run(text, mask));
    }
}
