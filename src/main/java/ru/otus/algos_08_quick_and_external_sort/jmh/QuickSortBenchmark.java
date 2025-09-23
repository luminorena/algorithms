//package ru.otus.algos_08_quick_and_external_sort.jmh;
//
//
//import org.openjdk.jmh.annotations.*;
//import ru.otus.algos_07_pyramid_sort.utils.Randomizer;
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
//public class QuickSortBenchmark {
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
//        sort(arrayToSort, 0, arrayToSort.length - 1);
//    }
//
//    static void sort(long[] array, int left, int right){
//        if (left >= right) return;
//        int i = split(array, left, right);
//        sort(array, left, i - 1);
//        sort(array, i + 1, right);
//    }
//
//    private static int split(long[] array, int left, int right){
//        long pivot = array[right];
//        int i = left - 1;
//        for (int j = left; j <= right ; j++) {
//            if (array[j] <= pivot)
//                swap(array, ++i, j);
//        }
//        return i;
//    }
//
//    private static void swap(long[] array, int i, int j) {
//        long temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//}
//
