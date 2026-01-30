package ru.otus.algos_15_min_skeleton.kruskal;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0, 7, 0, 5}, {7, 0, 8, 9}, {0, 8, 0, 5}, {5, 9, 5, 0}};
        Kruskal kruskal = new Kruskal(4, matrix);
        kruskal.kruskal();

        System.out.println("Min weight: " + kruskal.getWeightMin());
        for (int i = 0; i < kruskal.getEdgesCount(); i++) {
            Kruskal.Edge e = kruskal.getEdges()[i];
            System.out.println(e.begin + "-" + e.end + ":" + e.weight);
        }
    }
}
