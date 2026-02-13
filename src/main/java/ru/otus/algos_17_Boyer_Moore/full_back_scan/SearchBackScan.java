package ru.otus.algos_17_Boyer_Moore.full_back_scan;

public class SearchBackScan {

    private static int run(String text, String mask) {
        int t = 0;
        while (t <= text.length() - mask.length())
        {
            int m = mask.length() - 1;
            while ((m >= 0) && (text.charAt(t + m) == mask.charAt(m))) {
                m--;
            }
            if (m < 0)
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
