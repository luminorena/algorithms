package ru.otus.algos_03_algebraic_algorythms.pow;

public class PowOptimized {
    public static void main(String[] args) {
        System.out.println(optimized(2, -3));
    }
    private static double optimized(double number, int pow) {
        // оптимизация, чтобы не идти в цикл
        if (pow == 0) {
            return 1.0;
        }
        // результат рекурсивного вызова
        double halfPower;
        double result;

        // обработка отрицательных чисел

        boolean isNegative = pow < 0;

        int checkedNumber = isNegative ? pow * -1 : pow;

        if (checkedNumber % 2 == 1) { // число нечётное
            halfPower = optimized(number,checkedNumber/2);
            result =  number * halfPower * halfPower;
        }
        else {
            halfPower = optimized(number,checkedNumber/2);
            result = halfPower * halfPower;
        }
        return isNegative ? 1.0 / result : result;
    }
}
