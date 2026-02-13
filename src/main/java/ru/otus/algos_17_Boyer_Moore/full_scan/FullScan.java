package ru.otus.algos_17_Boyer_Moore.full_scan;

public class FullScan {

    private static int run(String text, String mask) {
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = 0;
            while ((m < mask.length()) && (text.charAt(t + m) == mask.charAt(m))) {
                m++;
            }
            if (m == mask.length())
                return t;
            t++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "AAAAABBBBBUTTERTTTEDFERERBERFGEE";
        String mask = "BUTTER";
        System.out.println(run(text, mask));
    }
}
