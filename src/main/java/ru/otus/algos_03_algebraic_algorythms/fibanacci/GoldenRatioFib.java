package ru.otus.algos_03_algebraic_algorythms.fibanacci;

public class GoldenRatioFib {
    public static void main(String[] args) {
        System.out.println(goldenRatio(10));
    }
    private static double goldenRatio(int number) {
        double fi = (1.0 + Math.sqrt(5)) / 2.0;
        return Math.floor(Math.pow(fi, number) / Math.sqrt(5) + 1.0 / 2.0);
    }
}
