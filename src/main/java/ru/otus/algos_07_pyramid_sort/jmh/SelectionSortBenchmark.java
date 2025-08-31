package ru.otus.algos_07_pyramid_sort.jmh;


import org.openjdk.jmh.annotations.*;
import ru.otus.algos_07_pyramid_sort.utils.Randomizer;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
@Threads(1)
public class SelectionSortBenchmark {

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
        for (int i = 0; i < initialArray.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < initialArray.length; j++){
                if (initialArray[j] < initialArray[min]) {
                    min = j;
                }
            }
            swap(initialArray, i, min);
        }
    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        }
    }

