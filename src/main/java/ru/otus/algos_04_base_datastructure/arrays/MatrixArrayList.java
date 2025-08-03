package ru.otus.algos_04_base_datastructure.arrays;

import java.util.ArrayList;
import java.util.List;

public class MatrixArrayList<T> {
    private static final int size = 10;
    protected int count;
    protected List<T>[] values;  // массив списков строк
    public int realloc = 0;

    @SuppressWarnings("unchecked")
    public MatrixArrayList() {
        count = 0;
        values = new ArrayList[1];
        values[0] = new ArrayList<>(size);
    }

    public void add(T item, int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index must be >= 0");

        int row = index / size;
        int col = index % size;

        if (row >= values.length) {
            realloc++;
            @SuppressWarnings("unchecked")
            List<T>[] newValues = new ArrayList[row + 1];

            System.arraycopy(values, 0, newValues, 0, values.length);

            for (int i = values.length; i <= row; i++) {
                newValues[i] = new ArrayList<>(size);
            }
            values = newValues;
        }

        List<T> currentRowList = values[row];

        while (currentRowList.size() <= col) {
            currentRowList.add(null);
        }

        currentRowList.set(col, item);

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

        List<T> currentRowList = values[row];
        T removed = currentRowList.get(col);

        for (int i = index; i < count - 1; i++) {
            int currentRow = i / size;
            int currentCol = i % size;
            int nextRow = (i + 1) / size;
            int nextCol = (i + 1) % size;

            T nextItem = values[nextRow].get(nextCol);
            values[currentRow].set(currentCol, nextItem);
        }

        // Удаляем последний элемент, чтобы не дублировать
        int lastIndexRow = (count - 1) / size;
        int lastIndexCol = (count - 1) % size;
        values[lastIndexRow].set(lastIndexCol, null);

        count--;

        return removed;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            int row = i / size;
            int col = i % size;
            List<T> currentRowList = values[row];
            T item = col < currentRowList.size() ? currentRowList.get(col) : null;
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MatrixArrayList<Integer> freeArray = new MatrixArrayList<>();
        freeArray.add(0, 0);
        freeArray.add(1, 1);
        freeArray.add(2, 2);

        freeArray.printAll();

        System.out.println("Deleted: " + freeArray.remove(2));

        freeArray.printAll();
    }
}
