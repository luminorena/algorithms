package ru.otus.algos_05_bitwise.chess.bitboard;

public class Horse extends Bitboard {
    public Horse(String s) {
        super(s);
    }

    @Override
    public void steps() {
        long noColumnA  = 0xFeFeFeFeFeFeFeFeL;
        long noColumnAB = 0xFcFcFcFcFcFcFcFcL;
        long noColumnH  = 0x7f7f7f7f7f7f7f7fL;
        long noColumnGH = 0x3f3f3f3f3f3f3f3fL;

        long mask = noColumnGH & (bb <<  6 | bb >>> 10)
                |  noColumnH & (bb << 15 | bb >>> 17)
                | noColumnA  & (bb << 17 | bb >>> 15)
                | noColumnAB & (bb << 10 | bb >>>  6);

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
