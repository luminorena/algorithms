package ru.otus.algos_10_binary_search_trees.avl;

public class AVLNode {
    int key;
    AVLNode left = null;
    AVLNode right = null;
    int height;

    public AVLNode(int key) {
        this.key = key;
        this.height = 0;
    }

    public int getKey() {
        return key;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
