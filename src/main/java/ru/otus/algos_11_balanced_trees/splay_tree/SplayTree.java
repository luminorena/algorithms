package ru.otus.algos_11_balanced_trees.splay_tree;

class TreeNode {
    int key;
    TreeNode left, right, parent;

    TreeNode(int key) {
        this.key = key;
        left = right = parent = null;
    }

    @Override
    public String toString() {
        return "TreeNode{key=" + key + "}";
    }

}

public class SplayTree {
    private TreeNode root;

    // Вставка ключа: сначала обычная вставка как в BST, затем splay
    public void splayInsert(int key) {
        TreeNode node = insert(key);
        splay(node);
    }

    // Обычная вставка в BST
    private TreeNode insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null) {
            parent = curr;
            if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        TreeNode newNode = new TreeNode(key);
        newNode.parent = parent;
        if (key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return newNode;
    }

    // Метод splay - "всплывает" узел к корню с помощью поворотов
    private void splay(TreeNode node) {
        while (node.parent != null) {
            TreeNode parent = node.parent;
            TreeNode grand = parent.parent;

            if (grand == null) {
                // Zig case
                if (parent.left == node) {
                    rightRotate(parent);
                } else {
                    leftRotate(parent);
                }
            } else if (grand.left == parent && parent.left == node) {
                // Zig-Zig case
                rightRotate(grand);
                rightRotate(parent);
            } else if (grand.right == parent && parent.right == node) {
                // Zig-Zig case (mirror)
                leftRotate(grand);
                leftRotate(parent);
            } else if (grand.left == parent && parent.right == node) {
                // Zig-Zag case
                leftRotate(parent);
                rightRotate(grand);
            } else if (grand.right == parent && parent.left == node) {
                // Zig-Zag case (mirror)
                rightRotate(parent);
                leftRotate(grand);
            }
        }
        root = node; // По окончании узел становится корнем
    }

    // Правый поворот вокруг узла x
    private void rightRotate(TreeNode x) {
        TreeNode y = x.left;
        if (y == null) return; // Нельзя поворачивать, если нет левого ребенка

        x.left = y.right;
        if (y.right != null) y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.right = x;
        x.parent = y;
    }

    // Левый поворот вокруг узла x
    private void leftRotate(TreeNode x) {
        TreeNode y = x.right;
        if (y == null) return; // Нельзя поворачивать, если нет правого ребенка

        x.right = y.left;
        if (y.left != null) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    // Для проверки: обход дерева (прямой обход)
    public void preOrderPrint() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public TreeNode search(int key) {
        TreeNode curr = root;
        TreeNode last = null;       // Запоминаем последний посещённый узел (для splay, если точного совпадения нет)

        while (curr != null) {
            last = curr;
            if (key == curr.key) {
                splay(curr); // Поднимаем найденный узел к корню
                return curr;
            } else if (key < curr.key) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        // Если точного совпадения нет, поднимаем последний посещённый узел (ближайший по ключу)
        if (last != null) splay(last);
        return null; // Ключ не найден
    }


    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        int[] keys = {10, 20, 5, 15, 25};

        for (int key : keys) {
            tree.splayInsert(key);
            System.out.print("После вставки и сплея " + key + ": ");
            tree.preOrderPrint();
        }

        System.out.println(tree.search(50));
    }
}

