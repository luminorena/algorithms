package ru.otus.algos_10_binary_search_trees.avl;


public class AVLTree {
    private AVLNode root;

    private void updateHeight(AVLNode node) {
        if (node == null) return;
        int leftHeight = (node.getLeft() == null) ? -1 : node.getLeft().getHeight();
        int rightHeight = (node.getRight() == null) ? -1 : node.getRight().getHeight();
        node.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    public void insert(int key, AVLNode curr) {
        if (curr == null) return;
        updateHeight(curr.getLeft());
        updateHeight(curr.getRight());
        curr.setLeft(balance(curr.getLeft()));
        curr.setRight(balance(curr.getRight()));
    }

    private AVLNode minLeftRotate(AVLNode a) {
        AVLNode b = a.getRight();
        a.setRight(b.getLeft());
        b.setLeft(a);
        if (root == a) root = b;
        updateHeight(a);
        updateHeight(b);
        return b;
    }

    private AVLNode maxLeftRotate(AVLNode a) {
        a.right = minRightRotate(a.right);
        a = minLeftRotate(a);
        updateHeight(a);
        return a;
    }

    private AVLNode maxRightRotate(AVLNode a) {
        a.left = minLeftRotate(a.left);
        a = minRightRotate(a);
        updateHeight(a);
        return a;
    }

    private AVLNode minRightRotate(AVLNode a) {
        AVLNode b = a.left;
        a.left = b.right;
        b.right = a;
        if (root == a) root = b;
        updateHeight(a);
        updateHeight(b);
        return b;
    }


    public AVLNode balance(AVLNode node) {
        if (node == null) return null;
        int leftHeight = node.left == null ? -1 : node.left.height;
        int rightHeight = node.right == null ? -1 : node.right.height;
        int balanceFactor = leftHeight - rightHeight;
        if (Math.abs(balanceFactor) < 2) return node;

        if (balanceFactor > 1) {
            AVLNode b = node.left;
            int bLeftHeight = b.left == null ? -1 : b.left.height;
            int bRightHeight = b.right == null ? -1 : b.right.height;
            if ((bLeftHeight - bRightHeight) >= 0)
                node = minRightRotate(node);
            else
                node = maxRightRotate(node);
        } else {
            AVLNode b = node.right;
            int bLeftHeight = b.left == null ? -1 : b.left.height;
            int bRightHeight = b.right == null ? -1 : b.right.height;
            if ((bLeftHeight - bRightHeight) <= 0)
                node = minLeftRotate(node);
            else
                node = maxLeftRotate(node);
        }
        return node;
    }
}
