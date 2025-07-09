package ru.otus.algos_01_recursion_cycles;

public class Spell_14_error {
    public static void main(String[] args) {
        spell();
    }

    private static void spell() {
        int n = 25;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print(Math.pow(x - 25, 2) + Math.pow(y - 25, 2) <= Math.pow(20.615528135, 2)  ? ". " : "# ");
            }
            System.out.println();
        }
    }
}

