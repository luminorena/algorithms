package ru.otus.algos_10_binary_search_trees.avl;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        AVLNode root = new AVLNode(10);
        tree.insert(10, root);

        AVLNode node5 = new AVLNode(5);
        AVLNode node15 = new AVLNode(15);
        AVLNode node3 = new AVLNode(3);
        AVLNode node7 = new AVLNode(7);

        root.setLeft(node5);
        root.setRight(node15);
        node5.setLeft(node3);
        node5.setRight(node7);

        tree.insert(5, root);
        tree.insert(15, root);
        tree.insert(3, root);
        tree.insert(7, root);

        System.out.println("Root key: " + root.getKey() +  root.getHeight());
        System.out.println("Left child key: " + root.getLeft().getKey() +  root.getLeft().getHeight());
        System.out.println("Right child key: " + root.getRight().getKey() +  root.getRight().getHeight());
    }
}
