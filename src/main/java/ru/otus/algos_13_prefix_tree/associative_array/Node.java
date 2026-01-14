package ru.otus.algos_13_prefix_tree.associative_array;

public class Node {
    private static final int SIZE = 26;
    private final Node[] next;
    public boolean isEnd;
    public String value;

    public Node() {
        next = new Node[SIZE];
        isEnd = false;
    }

    public Node set(char c) {
        int index = c - 'a';
        if (next[index] == null) {
            next[index] = new Node();
        }
        return next[index];
    }

    public Node get(char c) {
        int idx = c - 'a';
        return next[idx];
    }
}


