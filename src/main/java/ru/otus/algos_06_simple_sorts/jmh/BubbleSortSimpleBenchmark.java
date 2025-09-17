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
//public class BubbleSortSimpleBenchmark{
//
//    private long[] initialArray;
//
//    @Setup(Level.Invocation)
//    public void setUp() {
//        Randomizer randomizer = new Randomizer();
//        initialArray = randomizer.getRandomArray(10000);
//    }
//
//    @Benchmark
//    public void benchmarkSort() {
//        long[] arrayToSort = initialArray.clone();
//        sort(arrayToSort);
//    }
//
//        private static void sort(long[] initialArray) {
//            for (int i = 0; i < initialArray.length - 1; i++) {
//                for (int j = initialArray.length - 1; j > i; j--) {
//                    if (initialArray[j] < initialArray[j - 1]) {
//                        long tmp = initialArray[j];
//                        initialArray[j] = initialArray[j - 1];
//                        initialArray[j - 1] = tmp;
//                    }
//                }
//            }
//        }
//
//    }
//
