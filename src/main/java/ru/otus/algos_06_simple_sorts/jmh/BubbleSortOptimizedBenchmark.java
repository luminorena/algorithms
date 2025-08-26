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
public class BubbleSortOptimizedBenchmark {

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
        boolean sorted = false;

        long temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < initialArray.length - 1; i++) {
                if (initialArray[i] > initialArray[i + 1]) {
                    temp = initialArray[i];
                    initialArray[i] = initialArray[i + 1];
                    initialArray[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }
}

