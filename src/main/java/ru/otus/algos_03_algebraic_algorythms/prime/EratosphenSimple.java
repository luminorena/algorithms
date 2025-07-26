package ru.otus.algos_03_algebraic_algorythms.prime;

public class EratosphenSimple {
    public static void main(String[] args) {
        System.out.println(isPrime(1000));
    }

    private static int isPrime(int n){
        boolean [] prime = new boolean[n+1];
        int counter = 0;
        for(int i = 2; i<=n; i++)
        {
            if(!prime[i])
            {
                counter++;
                for(int j= i*i; j<=n; j+=i)
                    prime[j] = true;
            }
        }
        return counter;

    }


}
