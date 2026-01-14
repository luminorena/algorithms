package ru.otus.algos_13_prefix_tree.associative_array;

public class PrefixTree {
    private final Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String key, String val) {
        Node node = root;
        for (char c : key.toCharArray()) {
            node = node.set(c);
        }
        node.isEnd = true;
        node.value = val;
    }

    public Node startsWith(String key) {
        Node node = root;
        for (char c : key.toCharArray()) {
            node = node.get(c);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public Node search(String key) {
        Node node = startsWith(key);
        if (node == null) return null;
        if (!node.isEnd) return null;
        return node;
    }

    public void delete(String key) {
        Node node = search(key);
        if (node == null) return;
        node.isEnd = false;
        node.value = null;
    }
}
