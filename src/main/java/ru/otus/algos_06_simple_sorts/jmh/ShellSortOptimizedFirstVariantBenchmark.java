package ru.otus.algos_06_simple_sorts.jmh;


import org.openjdk.jmh.annotations.*;
import ru.otus.algos_06_simple_sorts.utils.Randomizer;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
@Threads(1)
public class ShellSortOptimizedFirstVariantBenchmark {

    private long[] initialArray;

    @Setup(Level.Invocation)
    public void setUp() {
        Randomizer randomizer = new Randomizer();
        initialArray = randomizer.getRandomArray(1000000);
    }

    @Benchmark
    public void benchmarkSort() {
        long[] arrayToSort = initialArray.clone();
        sort(arrayToSort);
    }

    private static void sort(long[] initialArray) {
        for (int gap = initialArray.length / 3; gap > 0; gap /= 2) {
            for (int j = gap; j < initialArray.length; j++) {
                for (int i = j; i >= gap; i -= gap) {

                    if (initialArray[i - gap] <= initialArray[i])
                        break;

                    swap(initialArray, i - gap, i);
                }
            }
        }
    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

