package ru.otus.algos_16_deikstra;

public class Graph {
    int[][] matrix;
    int size;
    int WeightFull = Integer.MAX_VALUE / 2;

    public Graph(int[][] matrix, int size) {
        this.matrix = matrix;
        this.size = size;
    }

    static int getMin(int[] mas, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < mas.length; i++) {
            if (visited[i]) continue;
            if (min == -1)
                min = i;
            else if (mas[i] < mas[min])
                min = i;
        }
        return min;
    }

    public int[] Deikstra(int vertex) {
        int[] ways = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++)
            ways[i] = WeightFull;
        ways[vertex] = 0;
        int min;

        for(int k = 0; k < size; k++) {
            min = getMin(ways, visited);
            visited[min] = true;
            for(int i = 0; i < size; i++) {
                if (visited[i]) continue;
                if (matrix[min][i] == 0) continue;
                int weight = ways[min] + matrix[min][i];
                if(weight < ways[i])
                    ways[i] = weight;
            }
        }
        return ways;
    }
}
