package ru.otus.algos_05_bitwise.chess.factory;

import ru.otus.algos_05_bitwise.chess.bitboard.Rook;
import java.util.Scanner;

public class RookFactory implements ChessFactory {
    @Override
    public void run() {
        System.out.println("Введите позицию ладьи (число 0-63, или клетку типа 'e2'):");
        Scanner scanner = new Scanner(System.in);
        Rook rook = new Rook(scanner.nextLine());
        rook.print();
        rook.steps();
        System.out.println();
        rook.print();
        scanner.close();
    }




}
