//package ru.otus.algos_10_binary_search_trees.jmh;
//
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.infra.Blackhole;
//import ru.otus.algos_10_binary_search_trees.bts.Tree;
//import ru.otus.algos_10_binary_search_trees.bts.TreeNode;
//import ru.otus.algos_10_binary_search_trees.utlis.Sequence;
//
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Thread)
//@Warmup(iterations = 5, time = 2)
//@Measurement(iterations = 10, time = 2)
//@Fork(3)
//@Threads(1)
//public class RandomTreeBenchmark {
//
//    /*
//    Dead-code elimination (оптимизация удаления мертвого кода) — это процесс,
//     который JVM применяет для удаления в скомпилированном байт-коде участков кода,
//     результаты которых нигде не используются. Например, если в бенчмарке вычисляется
//     значение, но оно не используется и не возвращается, JVM может удалить этот код,
//      считая его ненужным. В результате замер будет не точным,
//    поскольку измеряется не реальный код операции, а "пустышка".
//     */
//
//    private int[] initialArray;
//    private Tree tree;
//
//
//    @Setup(Level.Iteration)
//    public void setUp() {
//        Sequence sequence = new Sequence();
//        initialArray = sequence.getRandomArray(1000);
//        tree = new Tree();
//        for (int value : initialArray) {
//            tree.insert(value);
//        }
//    }
//
//    @Benchmark
//    public void benchmarkInsert() {
//        Tree newTree = new Tree();
//        for (int j : initialArray) {
//            newTree.insert(j);
//        }
//    }
//
//    @Benchmark
//    public void benchmarkSearch(Blackhole blackhole) {
//        for (int i = 0; i < initialArray.length / 10; i++) {
//            TreeNode node = tree.search(initialArray[i]);
//            blackhole.consume(node);
//        }
//    }
//
//    /*
//    Blackhole — это специальный класс из библиотеки JMH (Java Microbenchmark Harness),
//    который используется для предотвращения оптимизации JVM, удаляющей код,
//    результат которого не используется (dead-code elimination).
//Когда в методах бенчмарка есть вычисления с возвращаемым значением,
//но это значение нигде не используется, JVM может решить, что эти вычисления бесполезны,
//и просто убрать их, что исказит замеры. Blackhole помогает «поглотить» результат,
//показывая JVM, что результат нужен,
// но сам по себе Blackhole не влияет на производительность.
//     */
//
//
//    @Benchmark
//    public void benchmarkDelete(Blackhole blackhole) {
//        Tree newTree = new Tree();
//        for (int value : initialArray) newTree.insert(value);
//        for (int i = 0; i < initialArray.length / 10; i++) {
//            newTree.remove(initialArray[i]);
//        }
//        blackhole.consume(newTree);
//    }
//
//
//    private TreeNode root;
//
//    public TreeNode getRoot() {
//        return root;
//    }
//
//    public RandomTreeBenchmark() {
//        root = null;
//    }
//
//    public void insert(int key) {
//        root = insert(key, root);
//    }
//
//    private TreeNode insert(int key, TreeNode curr) {
//        if (curr == null) {
//            return new TreeNode(key);
//        }
//        if (key < curr.getKey()) {
//            curr.left = insert(key, curr.left);
//        } else {
//            curr.right = insert(key, curr.right);
//        }
//        return curr;
//    }
//
//
//    public TreeNode search(int key) {
//        return search(key, root);
//    }
//
//    private TreeNode search(int key, TreeNode node) {
//        if (node == null) return null;
//        if (key == node.getKey()) return node;
//        if (key < node.getKey())
//            return search(key, node.getLeft());
//        return search(key, node.getRight());
//    }
//
//
//    private TreeNode searchParent(TreeNode node, TreeNode search)
//    {
//        if (node == null) return null;
//        if (search == null) return null;
//        if (node.getKey() == search.getKey()) return null;
//        if (search.getLeft() != null)
//            if (node.getKey() == search.getLeft().getKey())
//                return search;
//        if (search.getRight() != null)
//            if (node.getKey() == search.getRight().getKey())
//                return search;
//        if (node.getKey() < search.getKey())
//            return searchParent(node, search.getLeft());
//        return searchParent(node, search.getRight());
//    }
//
//    public void remove(int key)
//    {
//        TreeNode node = search(key);
//        if (node == null) return;
//        remove(node);
//    }
//
//
//    private void remove(TreeNode node) {
//        TreeNode parent = searchParent(node, root);
//        if (node.getRight() == null)
//        {
//            if (parent != null)
//            {
//                if (parent.getLeft() == node)
//                    parent.left = node.left;
//                else parent.right = node.right;
//            }
//            else
//                root = node.left;
//            return;
//        }
//
//        TreeNode min = node.right;
//        TreeNode minParent = node;
//        while (min.left != null)
//        {
//            minParent = min;
//            min = min.left;
//        }
//        if (parent != null)
//        {
//            if (parent.left == node)
//                parent.left = min;
//            else
//                parent.right = min;
//        }
//        else
//            root = min;
//        if (min != node.right)
//        {
//            minParent.left = min.right;
//            min.right = node.right;
//        }
//        min.left = node.left;
//    }
//
//
//
//}
