package ru.otus.algos_05_bitwise.chess.bitboard;


public class King extends Bitboard {

    public King(String s) {
        super(s);
    }

    @Override
    public void steps() {
        long mask = (bb & 0x7F7F7F7F7F7F7F7FL) << 1;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) >>> 1;   // логический сдвиг вправо
        mask |= (bb << 8);
        mask |= (bb >>> 8);                        // логический сдвиг вправо
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) >>> 9;
        mask |= (bb & 0xFEFEFEFEFEFEFEFEL) << 7;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) << 9;
        mask |= (bb & 0x7F7F7F7F7F7F7F7FL) >>> 7;

        System.out.println("Битовая маска: " + Long.toUnsignedString(mask));

        bb = mask;

        int movesCount = 0;
        while (mask != 0)
        {
            mask &= (mask - 1);
            movesCount ++;
        }

        System.out.println("Количество ходов: " + movesCount);
    }
}
