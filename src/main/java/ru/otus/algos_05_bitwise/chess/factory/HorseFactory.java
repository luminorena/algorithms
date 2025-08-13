package ru.otus.algos_05_bitwise.chess.factory;

import ru.otus.algos_05_bitwise.chess.bitboard.Horse;
import java.util.Scanner;

public class HorseFactory implements ChessFactory {

    @Override
    public void run() {
        System.out.println("Введите позицию коня (число 0-63, или клетку типа 'e2'):");
        Scanner scanner = new Scanner(System.in);
        Horse horse = new Horse(scanner.nextLine());
        horse.print();
        horse.steps();
        System.out.println();
        horse.print();
        scanner.close();
    }




}
