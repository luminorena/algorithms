//package ru.otus.algos_09_milliard_digits_sort.jmh;
//
//
//import org.openjdk.jmh.annotations.*;
//import ru.otus.algos_09_milliard_digits_sort.rnd.Randomizer;
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
//public class CountingSortBenchmark {
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
//        sort(arrayToSort);
//    }
//
//    private static long findMax(long[] array) {
//        long maxValue = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] > maxValue) {
//                maxValue = array[i];
//            }
//        }
//        return maxValue;
//    }
//
//
//
//    public static void sort(long[] array) {
//        long maxValue = findMax(array);
//
//        int maxInt = (int) maxValue;
//        int[] count = new int[maxInt + 1];
//
//        long[] sorted = new long[array.length];
//
//        for (long value : array) {
//            count[(int)value]++;
//        }
//
//        int cumulativeCount = 0;
//        for (int i = 0; i <= maxInt; i++) {
//            cumulativeCount += count[i];
//            count[i] = cumulativeCount;
//        }
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            int value = (int) array[i];
//            count[value]--;
//            sorted[count[value]] = array[i];
//        }
//
//        System.arraycopy(sorted, 0, array, 0, array.length);
//    }
//
//}
//
