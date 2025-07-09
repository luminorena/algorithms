package ru.otus.algos_01_recursion_cycles;

public class Spell_24 {
    public static void main(String[] args) {
        spell();
    }

    private static void spell(){
        int n = 25;
        for (int y = 0; y < n ; y++) {
            for (int x = 0; x < n; x++) {
                System.out.print((y == x)  ||( x == n - y) ? "# " : ". ");
            }
            System.out.println();
        }
    }
}


