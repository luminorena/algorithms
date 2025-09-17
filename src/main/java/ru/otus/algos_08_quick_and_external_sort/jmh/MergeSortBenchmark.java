package ru.otus.algos_08_quick_and_external_sort.jmh;

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
public class MergeSortBenchmark {

    private long[] initialArray;
    private long[] mergedArr;

    @Setup(Level.Invocation)
    public void setUp() {
        Randomizer randomizer = new Randomizer();
        initialArray = randomizer.getRandomArray(1000000);
    }

    @Benchmark
    public void benchmarkSort() {
        long[] arrayToSort = initialArray.clone();
        mergedArr = new long[arrayToSort.length];
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private void mergeSort(long[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(long[] array, int left, int mid, int right) {
        int mergeLeft = left;
        int mergeRight = mid + 1;
        int mergedIndex = 0;

        while (mergeLeft <= mid && mergeRight <= right) {
            if (array[mergeLeft] >= array[mergeRight]) {
                mergedArr[mergedIndex++] = array[mergeRight++];
            } else {
                mergedArr[mergedIndex++] = array[mergeLeft++];
            }
        }
        while (mergeLeft <= mid) {
            mergedArr[mergedIndex++] = array[mergeLeft++];
        }
        while (mergeRight <= right) {
            mergedArr[mergedIndex++] = array[mergeRight++];
        }

        for (int j = left; j <= right; j++) {
            array[j] = mergedArr[j - left];
        }
    }
}

