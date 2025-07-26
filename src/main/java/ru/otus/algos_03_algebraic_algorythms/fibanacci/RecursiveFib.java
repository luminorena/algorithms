package ru.otus.algos_03_algebraic_algorythms.fibanacci;

public class RecursiveFib {
    public static void main(String[] args) {
        System.out.println(recursive(10));
    }
    private static long recursive(int number) {
        if (number == 1 || number == 2) return 1;
        return recursive(number - 1) + recursive(number - 2);
    }
}
