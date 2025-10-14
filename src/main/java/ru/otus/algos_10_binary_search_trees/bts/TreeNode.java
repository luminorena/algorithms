package ru.otus.algos_10_binary_search_trees.bts;

public class TreeNode {
    private final int key;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
