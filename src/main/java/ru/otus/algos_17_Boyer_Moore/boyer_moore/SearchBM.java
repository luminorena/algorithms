package ru.otus.algos_17_Boyer_Moore.boyer_moore;

class SearchBM  {

    int[] suffix;

    public void prepare(String mask) {
        suffix = new int[mask.length()];
        suffix[0] = 1;
        for (int i = 1; i < mask.length(); i++) {
            for (int k = 1; k <= mask.length(); k++) {
                int cnt = 0;
                for (int j = 0; j < i; j++) {
                    if ((j + k + 1) > mask.length())
                        break;
                    if (mask.charAt(mask.length() - 1 - j) != mask.charAt(mask.length() - 1 - j - k))
                        break;
                    cnt++;
                }
                if (cnt < i) {
                    if ((k + cnt) == mask.length()) {
                        suffix[i] = k;
                        break;
                    }
                    else continue;
                }
                suffix[i] = k;
                break;
            }
        }
    }

    protected int run(String text, String mask) {
        prepare(mask);
        int t = 0;
        while (t <= text.length() - mask.length()) {
            int m = mask.length() - 1;
            while ((m >= 0) && (text.charAt(t + m) == mask.charAt(m))) {
                m--;
            }
            if (m < 0)
                return t;
            int c = mask.length() - 1 - m;
            t += suffix[c];
        }
        return -1;
    }
}

