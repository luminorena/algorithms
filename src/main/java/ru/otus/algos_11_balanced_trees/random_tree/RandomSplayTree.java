package ru.otus.algos_11_balanced_trees.random_tree;

import ru.otus.algos_11_balanced_trees.splay_tree.SplayTree;


import java.util.Random;

public class RandomSplayTree {
    private TreeNode root;
    private final Random random = new Random();
    private final double p = 0.5; // вероятность сплея

    class TreeNode {
        int key;
        TreeNode left, right, parent;
        TreeNode(int key) {
            this.key = key;
        }
        @Override
        public String toString() {
            return "Node{" + key + "}";
        }
    }

    // Вставка с вероятностным сплеем
    public void insert(int key) {
        TreeNode node = insertNode(key);
        // С вероятностью p вызываем splay (поднятие узла)
        if (random.nextDouble() < p) {
            splay(node);
        }
    }

    private TreeNode insertNode(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        TreeNode curr = root, parent = null;
        while (curr != null) {
            parent = curr;
            if (key < curr.key) curr = curr.left;
            else curr = curr.right;
        }
        TreeNode newNode = new TreeNode(key);
        newNode.parent = parent;
        if (key < parent.key) parent.left = newNode;
        else parent.right = newNode;
        return newNode;
    }


    private void splay(TreeNode node) {
        while (node.parent != null) {
            TreeNode parent = node.parent;
            TreeNode grand = parent.parent;

            if (grand == null) {
                if (parent.left == node) rightRotate(parent);
                else leftRotate(parent);
            } else if (grand.left == parent && parent.left == node) {
                rightRotate(grand);
                rightRotate(parent);
            } else if (grand.right == parent && parent.right == node) {
                leftRotate(grand);
                leftRotate(parent);
            } else if (grand.left == parent && parent.right == node) {
                leftRotate(parent);
                rightRotate(grand);
            } else if (grand.right == parent && parent.left == node) {
                rightRotate(parent);
                leftRotate(grand);
            }
        }
        root = node;
    }

    private void rightRotate(TreeNode x) {
        TreeNode y = x.left;
        if (y == null) return;
        x.left = y.right;
        if (y.right != null) y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.right = x;
        x.parent = y;
    }

    private void leftRotate(TreeNode x) {
        TreeNode y = x.right;
        if (y == null) return;
        x.right = y.left;
        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    public TreeNode search(int key) {
        TreeNode curr = root;
        TreeNode last = null;

        while (curr != null) {
            last = curr;
            if (key == curr.key) {
                splay(curr);
                return curr;
            } else if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (last != null) splay(last);
        return null;
    }

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        int[] keys = {10, 20, 5, 15, 25};

        for (int key : keys) {
            tree.splayInsert(key);
            System.out.print("После вставки и сплея " + key + ": ");
            tree.preOrderPrint();
        }

        System.out.println(tree.search(5));
    }
}

