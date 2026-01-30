package ru.otus.algos_15_min_skeleton.kruskal;

public class Kruskal {
    private int size;
    private int[][] matrix;

    private Edge[] edges;
    private int edgesCount;
    private int weightMin;

    public int getWeightMin() { return weightMin; }
    public Edge[] getEdges() { return edges; }
    public int getEdgesCount() { return edgesCount; }

    static class Edge {
        int begin, end, weight;
        Edge(int b, int e, int w) {
            begin = b; end = e; weight = w;
        }
    }

    public Kruskal(int size, int[][] matrix) {
        this.size = size;
        this.matrix = matrix;
        this.edges = new Edge[size - 1];
    }

    public void kruskal() {
        weightMin = 0;
        edgesCount = 0;

        Edge[] edgeList = new Edge[size * (size - 1) / 2];
        int edgeCount = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][j] != 0) {
                    edgeList[edgeCount++] = new Edge(i, j, matrix[i][j]);
                }
            }
        }

        bubbleSort(edgeList, edgeCount);
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < edgeCount; i++) {
            Edge edge = edgeList[i];
            if (uf.union(edge.begin, edge.end)) {
                edges[edgesCount++] = edge;
                weightMin += edge.weight;
            }
        }
    }

    private void bubbleSort(Edge[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].weight > arr[j + 1].weight) {
                    Edge temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
