package ru.otus.algos_05_bitwise.chess.bitboard;

public class Rook extends Bitboard {

    public Rook(String s) {
        super(s);
    }

    @Override
    public void steps() {
        long noColumnA  = 0xFEFEFEFEFEFEFEFEL;  // левая граница (столбец 'a')
        long noColumnAB = 0xFCFCFCFCFCFCFCFCL;
        long noColumnABC = 0xF8F8F8F8F8F8F8F8L;
        long noColumnABCD = 0xF0F0F0F0F0F0F0F0L;
        long noColumnABCDE = 0xE0E0E0E0E0E0E0E0L;
        long noColumnABCDEF = 0xC0C0C0C0C0C0C0C0L;
        long noColumnABCDEFG = 0x8080808080808080L;

        long noColumnH  = 0x7F7F7F7F7F7F7F7FL;  // правая граница (столбец 'h')
        long noColumnGH = 0x3F3F3F3F3F3F3F3FL;
        long noColumnFGH = 0x1F1F1F1F1F1F1F1FL;
        long noColumnEFGH = 0x0F0F0F0F0F0F0F0FL;
        long noColumnDEFGH = 0x0707070707070707L;
        long noColumnCDEFGH = 0x0303030303030303L;
        long noColumnBCDEFGH = 0x0101010101010101L;

        long mask = 0L;

        // Горизонтальные ходы вправо с ограничениями
        mask |= (bb & noColumnH) << 1;
        mask |= (bb & noColumnGH) << 2;
        mask |= (bb & noColumnFGH) << 3;
        mask |= (bb & noColumnEFGH) << 4;
        mask |= (bb & noColumnDEFGH) << 5;
        mask |= (bb & noColumnCDEFGH) << 6;
        mask |= (bb & noColumnBCDEFGH) << 7;

        // Горизонтальные ходы влево с ограничениями
        mask |= (bb & noColumnA) >>> 1;
        mask |= (bb & noColumnAB) >>> 2;
        mask |= (bb & noColumnABC) >>> 3;
        mask |= (bb & noColumnABCD) >>> 4;
        mask |= (bb & noColumnABCDE) >>> 5;
        mask |= (bb & noColumnABCDEF) >>> 6;
        mask |= (bb & noColumnABCDEFG) >>> 7;

        // Вертикальные ходы вверх (сдвиги влево)
        mask |= bb << 8;
        mask |= bb << 16;
        mask |= bb << 24;
        mask |= bb << 32;
        mask |= bb << 40;
        mask |= bb << 48;
        mask |= bb << 56;

        // Вертикальные ходы вниз (логический сдвиг вправо)
        mask |= bb >>> 8;
        mask |= bb >>> 16;
        mask |= bb >>> 24;
        mask |= bb >>> 32;
        mask |= bb >>> 40;
        mask |= bb >>> 48;
        mask |= bb >>> 56;

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
