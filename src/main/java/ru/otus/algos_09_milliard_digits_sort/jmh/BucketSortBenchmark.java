//package ru.otus.algos_09_milliard_digits_sort.jmh;
//
//
//import org.openjdk.jmh.annotations.*;
//import ru.otus.algos_09_milliard_digits_sort.rnd.Randomizer;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.Throughput)
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Thread)
//@Warmup(iterations = 3)
//@Measurement(iterations = 5)
//@Fork(1)
//@Threads(1)
//public class BucketSortBenchmark {
//
//    private long[] initialArray;
//
//    @Setup(Level.Invocation)
//    public void setUp() {
//        Randomizer randomizer = new Randomizer();
//        initialArray = randomizer.getRandomArray(100);
//    }
//
//    @Benchmark
//    public void benchmarkSort() {
//        long[] arrayToSort = initialArray.clone();
//        basketSort(arrayToSort);
//    }
//
//    public static void basketSort(long[] arr) {
//        int n = arr.length;
//        int numBaskets = (int) Math.ceil(Math.sqrt(n));
//
//        long max = arr[0];
//        for (long val : arr) {
//            if (val > max) max = val;
//        }
//
//        List<Long>[] baskets = new ArrayList[numBaskets];
//
//        for (int i = 0; i < n; i++) {
//            int m = (int) (arr[i] * numBaskets / (max + 1));
//            if (baskets[m] == null) {
//                baskets[m] = new ArrayList<>();
//            }
//            int j = 0;
//            while (j < baskets[m].size() && baskets[m].get(j) < arr[i]) {
//                j++;
//            }
//            baskets[m].add(j, arr[i]);
//        }
//
//        int index = 0;
//        for (List<Long> basket : baskets) {
//            if (basket != null) {
//                for (long val : basket) {
//                    arr[index++] = val;
//                }
//            }
//        }
//    }
//
//}
//
