package ru.otus.algos_05_bitwise.chess.factory;

import ru.otus.algos_05_bitwise.chess.bitboard.King;


import java.util.Scanner;

public class KingFactory implements ChessFactory {

    @Override
    public void run() {
        System.out.println("Введите позицию короля (число 0-63, или клетку типа 'e2'):");
        Scanner scanner = new Scanner(System.in);
        King king = new King(scanner.nextLine());
        king.print();
        king.steps();
        System.out.println();
        king.print();
        scanner.close();
    }




}
