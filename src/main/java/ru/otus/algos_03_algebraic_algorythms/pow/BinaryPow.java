package ru.otus.algos_03_algebraic_algorythms.pow;

public class BinaryPow {
    public static void main(String[] args) {
        System.out.println(binary(2, 8));
    }

    private static double binary(double number, int pow) {
        if (pow == 0) return 1.0;

        int mask = 0x80000000;  // Маска для старшего бита в 32-битном int
        // Сдвигаем маску вправо, пока не дойдём до первого установленного бита числа n
        while ((pow & mask) == 0) {
            mask >>>= 1;  // Беззнаковый сдвиг вправо, иначе сдвиг распространяет знак
        }

        double p = 1.0;
        while (mask > 0) {
            if ((pow & mask) == 0) {
                // Если текущий бит 0, квадрат степени
                p = p * p;
            } else {
                // Если текущий бит 1, квадрат и умножение на основание
                p = p * p * number;
            }
            mask >>>= 1;
        }

        return p;
    }
}
