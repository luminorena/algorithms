package ru.otus.algos_04_base_datastructure.queue;

import java.util.Comparator;

public class PriorityQueueCustom<T> {
    private T[] queue;
    private int count;
    private int capacity;
    private Comparator<? super T> comparator;

    @SuppressWarnings("unchecked")
    public PriorityQueueCustom(int capacity, Comparator<? super T> comparator) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.count = 0;
        this.comparator = comparator;
    }

    public void enqueue(T item) {
        if (count == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        queue[count++] = item;
    }

    public T dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int maxIndex = 0;
        for (int i = 1; i < count; i++) {
            T current = queue[i];
            T maxItem = queue[maxIndex];

            int cmp;
            if (comparator != null) {
                cmp = comparator.compare(current, maxItem);
            } else {
                // Если компаратор не задан, элементы должны реализовать Comparable
                cmp = ((Comparable<? super T>) current).compareTo(maxItem);
            }

            if (cmp > 0) {
                maxIndex = i;
            }
        }

        T result = queue[maxIndex];
        System.arraycopy(queue, maxIndex + 1, queue, maxIndex, count - maxIndex - 1);
        queue[--count] = null;
        return result;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);
        PriorityQueueCustom<String> pq = new PriorityQueueCustom<>(10, lengthComparator);

        pq.enqueue("apple");
        pq.enqueue("banana");
        pq.enqueue("pear");
        pq.enqueue("grape");

        System.out.println("Размер очереди: " + pq.size());

        System.out.println("\nИзвлечение элементов по приоритету (по длине строки):");
        while (!pq.isEmpty()) {
            System.out.println(pq.dequeue());
        }
    }
}

