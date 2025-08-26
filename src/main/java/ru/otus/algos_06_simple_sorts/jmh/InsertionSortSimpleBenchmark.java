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
public class InsertionSortSimpleBenchmark {

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

    private static void sort(long[] initialArray){

        for (int i = 1; i < initialArray.length; i++){
            int index = i - 1;
            while (index >= 0) {
                if (initialArray[index] <= initialArray[index+1])
                    break;
                swap(initialArray, index, index+1);
                index--;

            }
        }
    }

    private static void swap (long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

