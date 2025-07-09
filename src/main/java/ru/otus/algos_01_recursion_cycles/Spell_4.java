package ru.otus.algos_01_recursion_cycles;

public class Spell_4 {
    public static void main(String[] args) {
        spell();
    }

    private static void spell() {
        int n = 25;
        for (int y = 0; y < n; y++) {
            for (int x = n; x > 0; x--) {
                System.out.print((x - 10 < y - 14) ? ". " : "# ");
            }
            System.out.println();
        }
    }
}

