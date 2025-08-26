package ru.otus.algos_03_algebraic_algorythms.GCD;

public class Evclid {
    static long GCD(long m, long n)
    {
        if ((n == 0) || (m == 0)) return 1;
        if (m == n) return m;
        if (m > n) return GCD(m - n, n);
        else return GCD(n - m, m);
    }

    public static void main(String[] args) {
        System.out.println(GCD(123456, 7890));
    }

    /*
    В идеале, через остаток от деления, процесс занимает меньше шагов:
    123,456 % 7,890 = остаток 6,246
    7,890 % 6,246 = остаток 1,644
    6,246 % 1,644 = остаток 1,314
    1,644 % 1,314 = остаток 330
    1,314 % 330 = остаток 324
    330 % 324 = остаток 6
    324 % 6 = остаток 0

Как только получен остаток 0 — последний ненулевой остаток (6) и есть НОД.
     */

}
