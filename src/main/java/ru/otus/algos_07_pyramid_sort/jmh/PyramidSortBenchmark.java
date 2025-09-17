//package ru.otus.algos_07_pyramid_sort.jmh;
//
//
//import org.openjdk.jmh.annotations.*;
//import ru.otus.algos_07_pyramid_sort.utils.Randomizer;
//
//
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Thread)
//@Warmup(iterations = 3)
//@Measurement(iterations = 5)
//@Fork(1)
//@Threads(1)
//public class PyramidSortBenchmark {
//
//    private long[] initialArray;
//
//    @Setup(Level.Invocation)
//    public void setUp() {
//        Randomizer randomizer = new Randomizer();
//        initialArray = randomizer.getRandomArray(1000000);
//    }
//
//    @Benchmark
//    public void benchmarkSort() {
//        long[] arrayToSort = initialArray.clone();
//        sort(arrayToSort);
//    }
//
//    private static void heapify(long[] initialArray, int root, int size) {
//        int parent = root;
//        int left = 2 * parent + 1;
//        int right = 2 * parent + 2;
//        if (left < size && initialArray[left] > initialArray[parent])
//            parent = left;
//        if (right < size && initialArray[right] > initialArray[parent])
//            parent = right;
//        if (parent == root)
//            return;
//        swap(initialArray, root, parent);
//        heapify(initialArray, parent, size);
//
//    }
//
//    private static void swap(long[] array, int i, int j) {
//        long temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//
//    private static void heap(long[] initialArray) {
//        for (int i = initialArray.length / 2 - 1; i >= 0; i--) {
//            heapify(initialArray, i, initialArray.length);
//        }
//    }
//
//    private static void sort(long[] initialArray) {
//        heap(initialArray);
//        for (int i = initialArray.length - 1; i >=0; i--){
//            swap(initialArray, 0, i);
//            heapify(initialArray, 0, i);
//        }
//
//    }
//
//}
//
