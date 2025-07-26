package ru.otus.algos_03_algebraic_algorythms.fibanacci;

public class MatrixFib {
    public static long[][] matrixMultiplication(long[][] a, long[][] b) {

        if (a[0].length != b.length) {
            return null;
        }
        int rows = a.length;
        int cols = b[0].length;
        int common = a[0].length;

        long[][] res = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                long c = 0;
                for (int k = 0; k < common; k++) {
                    c += a[i][k] * b[k][j];
                }
                res[i][j] = c;
            }
        }
        return res;
    }

    // возведение матрицы в степень
    public static long[][] matrixPow(long[][] base, int n) {
        if (n == 0) {
            return new long[][] { {1, 0}, {0, 1} };
        }
        if (n == 1) {
            return base;
        }

        long[][] half = matrixPow(base, n / 2);
        long[][] halfSquared = matrixMultiplication(half, half);

        if (n % 2 == 0) {
            return halfSquared;
        } else {
            return matrixMultiplication(halfSquared, base);
        }
    }

    // Вычисление n-го числа Фибоначчи
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n < 0) throw new IllegalArgumentException("n должен быть >= 0");

        long[][] base = { {1, 1}, {1, 0} };
        long[][] result = matrixPow(base, n - 1);
        return result[0][0];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));
    }
}
