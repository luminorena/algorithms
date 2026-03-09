package ru.otus.algos_20_dynamic_programming.peas;

public class PeasCalculateResult {

    private static long gcd(long m, long n) {
        if (n == 0 || m == 0) return 1;
        if (m == n) return m;

        if (m % 2 == 0 && n % 2 == 0)
            return 2 * gcd(m / 2, n / 2);

        if (m % 2 == 1 && n % 2 == 1) {
            if (m > n)
                return gcd(n, (m - n) / 2);
            else
                return gcd(m, (n - m) / 2);
        }

        if (m % 2 == 1)
            return gcd(m, n / 2);

        if (n % 2 == 1)
            return gcd(m / 2, n);

        return 1;
    }

    public static String calculate(String input){
        String[] parts = input.split("\\+");

        // Парсим первую дробь a/b
        String[] first = parts[0].split("/");
        long a = Long.parseLong(first[0]);
        long b = Long.parseLong(first[1]);

        // Парсим вторую дробь c/d
        String[] second = parts[1].split("/");
        long c = Long.parseLong(second[0]);
        long d = Long.parseLong(second[1]);

        // 1. Складываем: (a*d + c*b) / (b*d)
        long numerator = a * d + c * b;
        long denominator = b * d;

        // 2. Сокращаем через НОД
        long g = gcd(numerator, denominator);
        numerator /= g;
        denominator /= g;

       return numerator + "/" + denominator;
    }
}
