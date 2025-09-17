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
//public class ShakerSortBenchmark {
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
//    private static void sort(long[] initialArray) {
//        int left = 0;
//        int right = initialArray.length - 1;
//        boolean sorted = false;
//        while (left < right && !sorted) {
//            sorted = true;
//            for (int i = right; i > left; i--) {
//                if (initialArray[i] < initialArray[i - 1]) {
//                    sorted = false;
//                    swap(initialArray, i, i - 1);
//                }
//            }
//            left++;
//
//            for (int i = left; i < right; i++) {
//                if (initialArray[i] > initialArray[i + 1]) {
//                    sorted = false;
//                    swap(initialArray, i, i + 1);
//                }
//            }
//            right--;
//        }
//    }
//
//    private static void swap(long[] array, int i, int j) {
//        long temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
//}
//
