package ru.otus.algos_02_lucky_tickets;

public class SimpleTask {
    public static void main(String[] args) {
        System.out.println(calc());
    }

    private static long calc() {
        long[] calcArray = new long[28];

        int totalAmount = 999;
        int sum;
        long result = 0;
        for (int i = 0; i <= totalAmount; i++) {
            int digit1 = (i / 100) % 10;
            int digit2 = (i / 10) % 10;
            int digit3 = i % 10;
            sum = digit1 + digit2 + digit3;
            calcArray[sum]++;

        }

        for (int i = 0; i < calcArray.length; i++) {
            result += calcArray[i] * calcArray[i];
        }

        return result;

    }
}
