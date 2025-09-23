package ru.otus.algos_09_milliard_digits_sort.jmh;


import org.openjdk.jmh.annotations.*;
import ru.otus.algos_09_milliard_digits_sort.rnd.Randomizer;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
@Threads(1)
public class RadixSortBenchmark {

    private long[] initialArray;

    @Setup(Level.Invocation)
    public void setUp() {
        Randomizer randomizer = new Randomizer();
        initialArray = randomizer.getRandomArray(100);
    }

    @Benchmark
    public void benchmarkSort() {
        long[] arrayToSort = initialArray.clone();
        sort(arrayToSort);
    }

    public static void sort(long[] array) {
        final int base = 10;
        long max = 0;
        for (long value : array) {
            if (value > max) {
                max = value;
            }
        }

        long[] tempArray = new long[array.length];
        long divisor = 1;

        while (max / divisor > 0) {
            int[] count = new int[base];

            for (long value : array) {
                int digitValue = (int) ((value / divisor) % base);
                count[digitValue]++;
            }

            for (int i = 1; i < base; i++) {
                count[i] += count[i - 1];
            }

            for (int i = array.length - 1; i >= 0; i--) {
                int digitValue = (int) ((array[i] / divisor) % base);
                count[digitValue]--;
                tempArray[count[digitValue]] = array[i];
            }

            System.arraycopy(tempArray, 0, array, 0, array.length);

            divisor *= base;
        }
    }



}

