package ru.otus.algos_05_bitwise.chess;

import ru.otus.algos_05_bitwise.chess.factory.ChessFactory;
import ru.otus.algos_05_bitwise.chess.factory.HorseFactory;
import ru.otus.algos_05_bitwise.chess.factory.KingFactory;
import ru.otus.algos_05_bitwise.chess.factory.RookFactory;

public class Main {
    public static void main(String[] args) {
        ChessFactory chessFactory = createPieceByName("horse");
        chessFactory.run();
    }

    static ChessFactory createPieceByName(String name) {
        return switch (name.toLowerCase()) {
            case "king" -> new KingFactory();
            case "horse" -> new HorseFactory();
            case "rook" -> new RookFactory();
            default -> throw new RuntimeException("Неверный параметр");
        };
    }



}
