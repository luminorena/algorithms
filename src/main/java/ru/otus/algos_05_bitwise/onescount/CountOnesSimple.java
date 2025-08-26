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

    /*
Входной параметр — целочисленное число (int) num, которое обычно занимает 32 бита.
Инициализируется переменная count для подсчёта единичных битов, изначально 0.
Инициализируется маска mask равная 0x01 — это бинарный 00000001.
Далее цикл перебирает все 32 бита числа (от 0 до 31).
На каждой итерации происходит побитовое И (&) между num и маской mask.
Если результат не равен нулю, значит в этом бите у num стоит 1, и счетчик count увеличивается.
Маска смещается влево на один бит (mask <<= 1), чтобы проверить следующий бит числа.
После 32 итераций возвращается количество единичных битов в числе.
     */


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
