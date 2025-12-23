package ru.otus.algos_12_hash_functions;

import java.util.*;

public class OpenAddrHash {
    private final int tableSize;
    private final int[] hash;
    private final boolean[] isDelete;
    private final int step;
    private int probing;

    public int getProbing() {
        return probing;
    }

    public OpenAddrHash(int size, int step) {
        this.tableSize = size;
        this.step = step;
        this.hash = new int[tableSize];
        this.isDelete = new boolean[tableSize];

        Arrays.fill(hash, -1);
        probing = 0;
    }

    // Линейный пробинг: h(k,i) = (h(k) + i * step) % m
    private int getHash(int key, int i) {
        return (key + i * step) % tableSize;
    }

    public void insert(int key) {
        for (int i = 0; i < tableSize; i++) {
            int hashIndex = getHash(key, i);
            probing++;

            if (isDelete[hashIndex]) {
                continue;
            }

            if (hash[hashIndex] == -1) {
                hash[hashIndex] = key;
                break;
            }
        }
    }

    public int search(int key) {
        for (int i = 0; i < tableSize; i++) {
            int hashIndex = getHash(key, i);
            if (hash[hashIndex] == key) {
                return hashIndex;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = search(key);
        if (index == -1) {
            return;
        }
        hash[index] = -1;
        isDelete[index] = true;
    }

    public static void main(String[] args) {
        int N = 1000;
        Random rnd = new Random(12345);
        OpenAddrHash openAddr = new OpenAddrHash(N * 2, 1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int key = rnd.nextInt(65535);
            openAddr.insert(key);

            int req = rnd.nextInt(N / 10);
            if (req == 0) {
                queue.offer(key);
            }
        }

        System.out.println("Пробинг: " + openAddr.getProbing() + " попыток");
        System.out.println("ИНДЕКС    КЛЮЧ");
        System.out.println("----------------");

        int half = queue.size() / 2;
        for (int i = 0; i < half; i++) {
            openAddr.remove(queue.poll());
        }

        while (!queue.isEmpty()) {
            int key = queue.poll();
            int hashIndex = openAddr.search(key);
            System.out.printf("%-5d - %d%n", hashIndex, key);
        }
    }
}

