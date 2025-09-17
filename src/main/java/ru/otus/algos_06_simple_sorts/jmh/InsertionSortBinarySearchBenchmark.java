//package ru.otus.algos_06_simple_sorts.jmh;
//
//
//import org.openjdk.jmh.annotations.*;
//import ru.otus.algos_06_simple_sorts.utils.Randomizer;
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
//public class InsertionSortBinarySearchBenchmark {
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
//    private static void sort(long[] initialArray){
//
//        for (int i = 1; i < initialArray.length; i++){
//            long cachedValue = initialArray[i];
//            int position = binarySearch(initialArray, cachedValue, 0, i - 1);
//            for (int j = i - 1; j >=position ; j--) {
//                initialArray[j + 1] = initialArray[j];
//            }
//            initialArray[position] = cachedValue;
//        }
//    }
//
//    private static int binarySearch (long[] array, long key, int left, int right) {
//        if (left > right)
//            return left;
//        int mid = (left + right) / 2;
//        if (key < array[mid])
//            return binarySearch(array, key, left, mid - 1);
//        return binarySearch(array, key, mid + 1, right);
//    }
//
//}
//
