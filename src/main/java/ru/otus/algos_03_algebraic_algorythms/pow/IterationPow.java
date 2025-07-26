package ru.otus.algos_03_algebraic_algorythms.pow;

public class IterationPow {
    public static void main(String[] args) {
        System.out.println(iterative(2, -3));
    }

    private static double iterative(double number, int pow) {
        // оптимизация, чтобы не идти в цикл
        if (pow == 0) {
            return 1.0;
        }
        double result = 1;

        // возведение в степень отрицательных чисел
        boolean isNegative = pow < 0;

        double checkedNumber = isNegative ? pow * -1 : pow;

        for (int i = 0; i < checkedNumber; i++) {
            result *= number;
        }
        return isNegative ? 1.0 / result : result;
    }
}
