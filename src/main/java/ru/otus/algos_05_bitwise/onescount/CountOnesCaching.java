package ru.otus.algos_05_bitwise.onescount;

import java.util.Scanner;

public class CountOnesCaching {

    static int getOnesCaching(int num) {
        int[] ones = new int[16];
        for (int i = 0; i < 16; i++) {
            ones[i] = CountOnesSimple.getOnesSimpleNumberTheSame(i);
        }
        return ones[(num & 0xF0) >> 4] + ones[num & 0x0F];

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int count = getOnesCaching(number);
        System.out.println(count);
    }
}
