package ru.otus.algos_14_grafs_search.demukron;

public class Runner {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.initTestGraph();
        System.out.println(calculate.demukron());
    }
}
