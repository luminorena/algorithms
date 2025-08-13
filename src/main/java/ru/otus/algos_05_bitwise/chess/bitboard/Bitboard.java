package ru.otus.algos_05_bitwise.chess.bitboard;

public class Bitboard {
    protected long bb;

    public Bitboard(String s) {
        int point;
        s = s.toUpperCase();
        try {
            point = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            try {
                point = (s.charAt(0) - 'A') + (s.charAt(1) - '1') * 8;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        bb = 1L << point;
    }

    public void steps() {

    }

    public void print() {
        boolean color = false;
        for (int i = 8; i > 0; i--) {
            System.out.print(i + ":  ");
            for (int j = 0; j < 8; j++) {
                if (color) {
                    System.out.print("\u001B[47m");
                } else {
                    System.out.print("\u001B[107m");
                }
                if ((bb & (1L << ((i - 1) * 8 + j))) > 0) {
                    System.out.print("\u001B[41m\u001B[37m");
                }
                System.out.printf(" %2d ", (i - 1) * 8 + j);
                System.out.print("\u001B[0m");
                color = !color;
            }
            color = !color;
            System.out.println();
        }
        System.out.print("      ");
        for (int i = 0; i < 8; i++) {
            System.out.print((char) ('A' + i) + "   ");
        }
        System.out.println();
    }


}
