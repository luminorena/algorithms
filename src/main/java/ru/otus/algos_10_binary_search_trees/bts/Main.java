package ru.otus.algos_10_binary_search_trees.bts;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(100);

        int keyToFind = 1000;
        TreeNode foundNode = tree.search(keyToFind);
        if (foundNode != null) {
            System.out.println("Key " + keyToFind + " найден в дереве.");
        } else {
            System.out.println("Key " + keyToFind + " не найден в дереве.");
        }

        System.out.println("Root key: " + tree.getRoot().getKey());
        System.out.println("Left child key: " + tree.getRoot().left.getKey());
        System.out.println("Right child key: " + tree.getRoot().right.getKey());
        System.out.println(tree.getRoot().left.getKey());
        System.out.println(tree.getRoot().right.getRight().getKey());

        tree.remove(5);

        System.out.println("Left child key: " + (tree.getRoot().left != null ? tree.getRoot().left.getKey() : "null"));


    }
}

