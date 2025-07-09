package ru.otus.algos_01_recursion_cycles;

public class Spell_12 {
    public static void main(String[] args) {
        spell();
    }

    private static void spell() {
        int n = 25;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                // x ^ 2 + y ^ 2 == r ^ 2 - окружность
               // x ^ 2 + y ^ 2 <= r ^ 2-  все точки внутри и на границе круга
                System.out.print(x*x + y*y <= 21*21  ? "# " : ". ");
            }
            System.out.println();
        }
    }
}

