package ru.otus.algos_04_base_datastructure.queue;

public class QueueCustom<T> {

    private T[] queue;
    private int head;
    private int tail;
    private int count;
    private int capacity = 100;

    @SuppressWarnings("unchecked")
    public QueueCustom(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) new Object[capacity];
        this.count = 0;
        this.head = 0;
        this.tail = 0;
    }


    public void enqueue(T item) {
        if (count == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[tail] = item;
        tail = (tail + 1) % queue.length;
        count++;
    }

    public T dequeue() {
        if (count == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = queue[head];
        queue[head] = null;
        head = (head + 1) % queue.length;
        count--;
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public static void main(String[] args) {
     int size = 3;
     QueueCustom<Integer> queue = new QueueCustom<>(size);

        System.out.println("Добавляем элементы:");
        for (int i = 1; i <= size; i++) {
            queue.enqueue(i);
            System.out.println("Enqueue: " + i);
        }

        System.out.println("\nИзвлекаем элементы:");
        while (!queue.isEmpty()) {
            int item = queue.dequeue();
            System.out.println("Dequeue: " + item);
        }

    }
}


