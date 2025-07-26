package ru.otus.algos_03_algebraic_algorythms.prime;


public class SimplePrime {
    public static void main(String[] args) {
        System.out.println(countPrimes(1000));
    }

    private static int countPrimes(int n){
        int count = 0;
        for (int i = 0; i <= n; i++){
            boolean intermediate = isPrime(i);
            if (intermediate)
                count++;
        }
        return count;

    }

    private static boolean isPrime(int number) {
        if (number < 2)
            return false;

        for (int i = 2; i < number ; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrimeSimple(int number){
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count == 2;
    }
}
