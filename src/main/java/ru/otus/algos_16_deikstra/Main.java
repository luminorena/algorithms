package ru.otus.algos_16_deikstra;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{0, 7, 0, 5}, {7, 0, 8, 9}, {0, 8, 0, 5}, {5, 9, 5, 0}};
        int size = matrix.length;
        Graph graph = new Graph(matrix, size);

        for (int vertex = 0; vertex < size; vertex++) {
            int[] ways = graph.Deikstra(vertex);
            System.out.println("Минимальные пути из вершины " +
                    (vertex + 1) + ":");

            for (int i = 0; i < size; i++)
                System.out.printf("%2d ", ways[i]);
            System.out.println();
        }
    }
}
