package ru.otus.algos_11_balanced_trees.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import ru.otus.algos_11_balanced_trees.utlis.Sequence;


import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5, time = 2)
@Measurement(iterations = 10, time = 2)
@Fork(3)
@Threads(1)
public class SplayTreeBenchmark {

    private int[] initialArray;

    private TreeNode root;
    private int index = 0;

    @Setup(Level.Iteration)
    public void setUp() {
        Sequence sequence = new Sequence();
        initialArray = sequence.getConsequentArray(1000);
        root = null;
        for (int key : initialArray) {
            splayInsertKey(key);
        }
    }


    @Benchmark
    public void splayInsert() {
        int key = initialArray[index];
        index = (index + 1) % initialArray.length;
        splayInsertKey(key);
    }

    @Benchmark
    public void search(Blackhole blackhole) {
        int key = initialArray[index];
        index = (index + 1) % initialArray.length;
        TreeNode result = searchKey(key);
        blackhole.consume(result);
    }

    private void splayInsertKey(int key) {
        TreeNode node = insert(key);
        splay(node);
    }


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

    private void splay(TreeNode node) {
        while (node.parent != null) {
            TreeNode parent = node.parent;
            TreeNode grand = parent.parent;

            if (grand == null) {
                if (parent.left == node) {
                    rightRotate(parent);
                } else {
                    leftRotate(parent);
                }
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


    private void leftRotate(TreeNode x) {
        TreeNode y = x.right;
        if (y == null) return;

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


    public void preOrderPrint() {
        preOrder(root);

    }

    private void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    private TreeNode searchKey(int key) {
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

}

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