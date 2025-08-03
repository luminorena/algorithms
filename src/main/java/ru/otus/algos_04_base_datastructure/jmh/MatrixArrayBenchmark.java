package ru.otus.algos_04_base_datastructure.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
@Threads(1)
public class MatrixArrayBenchmark<T> {

    private MatrixArray<Integer> array;

    @Setup(Level.Invocation)
    public void setUp(){
        array = new MatrixArray<>(3);
        array.add(0, 0);
        array.add(1, 1);
        array.add(2, 2);

    }

    @Benchmark
    public void benchmarkAdd() {
        array.add(111, 1);
    }

    @Benchmark
    public Integer benchmarkRemove() {
        return array.remove(1);
    }

    public static class MatrixArray<T> {
        private static final int size = 10;
        protected int count;
        protected Object[][] values;
        public int realloc = 0;

        public MatrixArray(int capacity) {
            count = 0;
            values = new Object[capacity][];
            values[0] = new Object[size];
        }


        public void add(T item, int index) {
            int row = index / size;
            int col = index % size;

            if (row >= values.length) {
                realloc++;
                Object[][] newValues = new Object[row + 1][];
                System.arraycopy(values, 0, newValues, 0, values.length);

                for (int i = values.length; i <= row; i++) {
                    newValues[i] = new Object[size];
                }
                values = newValues;
            }

            values[row][col] = item;

            if (index >= count) {
                count = index + 1;
            }
        }

        @SuppressWarnings("unchecked")
        public T remove(int index) {
            if (index < 0 || index >= count) {
                throw new IndexOutOfBoundsException("Index " + index + " out of bounds, count=" + count);
            }

            int row = index / size;
            int col = index % size;

            T removed = (T) values[row][col];

            for (int i = index; i < count - 1; i++) {
                int currentRow = i / size;
                int currentCol = i % size;
                int nextRow = (i + 1) / size;
                int nextCol = (i + 1) % size;
                values[currentRow][currentCol] = values[nextRow][nextCol];
            }

            int lastIndexRow = (count - 1) / size;
            int lastIndexCol = (count - 1) % size;
            values[lastIndexRow][lastIndexCol] = null;

            count--;

            return removed;
        }


        public void printAll() {

            for (int i = 0; i < count; i++) {
                int row = i / size;
                int col = i % size;
                System.out.println(values[row][col] + " ");
            }
            System.out.println();
        }
    }

    /*
    MatrixArrayBenchmark<Integer> freeArray = new MatrixArrayBenchmark<>();
         freeArray.add(0, 0);
         freeArray.add(1, 1);
         freeArray.add(2, 2);

         freeArray.printAll();

        System.out.println("Deleted: " + freeArray.remove(2));

        freeArray.printAll();
     */
}
