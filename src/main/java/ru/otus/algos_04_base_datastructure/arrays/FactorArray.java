package ru.otus.algos_04_base_datastructure.arrays;

public class FactorArray<T> {
    private int count = 0;
    private T[] values;

    @SuppressWarnings("unchecked")
    public FactorArray(int capacity){
        values = (T[]) new Object[capacity];
    }
    public void add(T item, int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        if (count == values.length) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[count * 2]; // вот тут умножить на 2
            System.arraycopy(values, 0, newArray, 0, index);
            newArray[index] = item;
            System.arraycopy(values, index, newArray, index + 1, count - index);
            values = newArray;
        } else {
            System.arraycopy(values, index, values, index + 1, count - index);
            values[index] = item;
        }
        count++;
    }


    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        T removedItem = values[index];
        System.arraycopy(values, index + 1, values, index, count - index - 1);
        values[count - 1] = null;
        count--;

        return removedItem;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FactorArray<String> array = new FactorArray<>(3);

        array.add("Первый", 0);
        array.add("Второй", 1);
        array.add("Третий", 2);
        array.printAll();

        array.add("Вставленный", 1);
        array.printAll();

        System.out.println(array.remove(2));
        array.printAll();
    }
}
