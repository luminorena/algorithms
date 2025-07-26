package ru.otus.algos_03_algebraic_algorythms.fibanacci;

public class IterationFib {

    public static void main(String[] args) {
        System.out.println(iterative(10));
    }
    private static long iterative(int number) {
            long previous = 1, current = 1;

            for(int i = 2; i < number; i++)
            {
                long next = current + previous;
                previous = current;
                current = next;
            }
            return current;
        }
    }

