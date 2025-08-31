package ru.otus.algos_07_pyramid_sort.sorts;

import ru.otus.algos_07_pyramid_sort.utils.Randomizer;

import java.util.Arrays;

public class HeapSort {

    private static void heapify(long[] initialArray, int root, int size) {
        int parent = root;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        if (left < size && initialArray[left] > initialArray[parent])
            parent = left;
        if (right < size && initialArray[right] > initialArray[parent])
            parent = right;
        if (parent == root)
            return;
        swap(initialArray, root, parent);
        heapify(initialArray, parent, size);

    }

    private static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void heap(long[] initialArray) {
        for (int i = initialArray.length / 2 - 1; i >= 0; i--) {
            heapify(initialArray, i, initialArray.length);
        }
    }

    private static void sort(long[] initialArray) {
        heap(initialArray);
        for (int i = initialArray.length - 1; i >=0; i--){
            swap(initialArray, 0, i);
            heapify(initialArray, 0, i);
        }

        System.out.println(Arrays.toString(initialArray));
    }

    public static void main(String[] args) {
        Randomizer randomizer = new Randomizer();
        long[] arr = randomizer.getRandomArray(6);
        System.out.println(Arrays.toString(arr));
        sort(arr);
    }


}
