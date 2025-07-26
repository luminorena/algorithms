package ru.otus.algos_03_algebraic_algorythms.prime;

public class OptimizedPrime {
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
    private static boolean isPrime(int number){
        if (number < 2) return false;
        if (number == 2) return true;
        if ((number % 2) == 0) return false;
        int sqrt = (int)Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2)
        {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
