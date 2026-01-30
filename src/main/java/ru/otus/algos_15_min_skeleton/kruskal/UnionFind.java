package ru.otus.algos_15_min_skeleton.kruskal;

class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int v) {
        if (parent[v] == v) return v;
        return parent[v] = find(parent[v]);
    }

    public boolean union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) return false;
        parent[root2] = root1;
        return true;
    }
}

