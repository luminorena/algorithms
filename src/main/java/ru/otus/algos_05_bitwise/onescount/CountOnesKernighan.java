package ru.otus.algos_05_bitwise.onescount;

import java.util.Scanner;

public class CountOnesKernighan {

    static int getOnesKernighan(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num &= (num - 1);
        }
        return count;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int count = getOnesKernighan(number);
        System.out.println(count);
    }
}
