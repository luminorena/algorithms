package ru.otus.algos_02_lucky_tickets;

public class CommonTask {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++)
            System.out.println("N=" + i + " CNT=" + calc(i));
    }

    /** Метод вычисления количества счастливых билетов
     * @param n количество цифр в номере билета (от 0 до 10)
     * @return Количество возможных счастливых билетов
     */
    private static long calc(int n) {
        if (n < 0 || n > 10)
            throw new RuntimeException("Invalid input");
        long sum = 0;

        if (n > 0) {
            // получаем итоговую строку таблицы
            long[] line = getLine(n);
            // возводим в квадрат
            for (int i = 0; i < line.length; i++)
                sum += line[i] * line[i];
        }

        return sum;
    }

    /** Рассчитать итоговую строку для матрицы
     * @param n размерность матрицы
     * @return итоговая строка для подстановки в рекурсии
     */
    private static long[] getLine(int n) {
        // количество столбцов в матрице
        int cols = n * 9 + 1;
        // количество заполненных столбцов в строке
        int colsFillCnt = n == 1 ? 1 : (n - 1) * 9 + 1;

        // строка на выход
        long[] output = new long[cols];

        // рекурсивный расчёт строки матрицы
        long[] line = n == 1 ? new long[] { 1 } : getLine(n - 1);

        // подсчёт итоговой строки матрицы
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < colsFillCnt; x++) {
                output[x + y] += line[x];
            }
        }

        return output;
    }
}
