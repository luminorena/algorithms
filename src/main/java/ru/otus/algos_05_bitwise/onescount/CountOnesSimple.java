package ru.otus.algos_05_bitwise.onescount;

import java.util.Scanner;

public class CountOnesSimple {

    static int getOnesSimpleNumberChanged(int num){
        int count = 0;
        while (num > 0) {
            if ((num & 0x01) > 0) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }


    static int getOnesSimpleNumberTheSame(int num) {
        int count = 0;
        int mask = 0x01;
        for (int i = 0; i < 32; i++) {  // int 32 бита (4 байта)
            if ((num & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int countNumberChanged = getOnesSimpleNumberChanged(number);
        int countNumberTheSame = getOnesSimpleNumberTheSame(number);
        System.out.println(countNumberChanged);
        System.out.println(countNumberTheSame);
    }
}
