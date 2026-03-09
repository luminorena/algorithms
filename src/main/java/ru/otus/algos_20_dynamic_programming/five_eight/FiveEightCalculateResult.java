package ru.otus.algos_20_dynamic_programming.five_eight;

public class FiveEightCalculateResult {
    public static long calculate(int n) {
        if (n <= 0) {
            return 0;
        }

        long[] h5 = new long[n + 1];
        long[] h55 = new long[n + 1];
        long[] h8 = new long[n + 1];
        long[] h88 = new long[n + 1];

        // Базовые случаи
        h5[1] = 1;   // 5
        h8[1] = 1;   // 8

        if (n >= 2) {
            h5[2] = h8[1] + h88[1];  // 85
            h55[2] = h5[1];          // 55
            h8[2] = h5[1] + h55[1];  // 58
            h88[2] = h8[1];          // 88
        }

        // Заполняем DP таблицу
        for (int i = 3; i <= n; i++) {
            h5[i] = h8[i - 1] + h88[i - 1];
            h55[i] = h5[i - 1];
            h8[i] = h5[i - 1] + h55[i - 1];
            h88[i] = h8[i - 1];
        }

        return h5[n] + h55[n] + h8[n] + h88[n];
    }
}
