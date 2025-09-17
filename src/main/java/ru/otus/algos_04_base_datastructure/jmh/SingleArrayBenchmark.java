//package ru.otus.algos_04_base_datastructure.jmh;
//
//import org.openjdk.jmh.annotations.*;
//
//import java.util.concurrent.TimeUnit;
//
//@BenchmarkMode(Mode.Throughput)  // операции в секунду
//@OutputTimeUnit(TimeUnit.MILLISECONDS)
//@State(Scope.Thread)
//@Warmup(iterations = 3) // 3 итерации прогрева JVM
//@Measurement(iterations = 5)     // 5 итераций измерения результатов
//@Fork(1)                        // один запуск JVM
//@Threads(1)                     // один поток
//public class SingleArrayBenchmark {
//
//    private SingleArray<String> array;
//
//    @Setup(Level.Invocation)
//    public void setUp() {
//        array = new SingleArray<>(3);
//        array.add("Первый", 0);
//        array.add("Второй", 1);
//        array.add("Третий", 2);
//    }
//
//    @Benchmark
//    public void benchmarkAdd() {
//        array.add("Вставленный", 1);
//    }
//
//    @Benchmark
//    public String benchmarkRemove() {
//        return array.remove(1);
//    }
//
//    public static class SingleArray<T> {
//        private int count = 0;
//        private Object[] values;
//
//        public SingleArray(int capacity) {
//            values = new Object[capacity];
//        }
//
//        @SuppressWarnings("unchecked")
//        public void add(T item, int index) {
//            if (index < 0 || index > count) {
//                throw new IndexOutOfBoundsException();
//            }
//            if (count == values.length) {
//                Object[] newArray = new Object[count + 1];
//                System.arraycopy(values, 0, newArray, 0, index);
//                newArray[index] = item;
//                System.arraycopy(values, index, newArray, index + 1, count - index);
//                values = newArray;
//            } else {
//                System.arraycopy(values, index, values, index + 1, count - index);
//                values[index] = item;
//            }
//            count++;
//        }
//
//        @SuppressWarnings("unchecked")
//        public T remove(int index) {
//            if (index < 0 || index >= count) {
//                throw new IndexOutOfBoundsException();
//            }
//            T removedItem = (T) values[index];
//            System.arraycopy(values, index + 1, values, index, count - index - 1);
//            values[count - 1] = null;
//            count--;
//            return removedItem;
//        }
//    }
//}
//
