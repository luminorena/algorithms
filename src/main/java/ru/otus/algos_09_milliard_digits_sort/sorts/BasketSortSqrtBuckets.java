package ru.otus.algos_09_milliard_digits_sort.sorts;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("unchecked")
public class BasketSortSqrtBuckets {

    public static void basketSort(long[] arr) {
        int n = arr.length;
        int numBaskets = (int) Math.ceil(Math.sqrt(n));

        // максимум
        long max = arr[0];
        for (long val : arr) {
            if (val > max) max = val;
        }

        List<Long>[] baskets = new ArrayList[numBaskets];

        for (int i = 0; i < n; i++) {
            int m = (int) (arr[i] * numBaskets / (max + 1));
            if (baskets[m] == null) {
                baskets[m] = new ArrayList<>();
            }
            int j = 0;
            while (j < baskets[m].size() && baskets[m].get(j) < arr[i]) {
                j++;
            }
            baskets[m].add(j, arr[i]);
        }

        int index = 0;
        for (List<Long> basket : baskets) {
            if (basket != null) {
                for (long val : basket) {
                    arr[index++] = val;
                }
            }
        }
    }


    public static void main(String[] args) {
        Random rnd = new Random();
        int N = 20;
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = rnd.nextInt(10000);
        }
        System.out.println("До сортировки:");
        for (long v : arr) System.out.print(v + " ");
        System.out.println();

        basketSort(arr);

        System.out.println("После сортировки:");
        for (long v : arr) System.out.print(v + " ");
        System.out.println();
    }
}

