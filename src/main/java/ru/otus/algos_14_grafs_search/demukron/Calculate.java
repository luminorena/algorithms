package ru.otus.algos_14_grafs_search.demukron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculate {
    private final List<Integer> path = new ArrayList<>();
    private int[][] matrix;
    private int size;

    public void initTestGraph() {
        size = 4;
        matrix = new int[][] {
                {0, 1, 1, 0},  // из 1: в 2,3
                {0, 0, 0, 1},  // из 2: в 4
                {0, 0, 0, 1},  // из 3: в 4
                {0, 0, 0, 0}   // из 4: вникуда
        };
    }

    public boolean demukron() {
        path.clear();
        int[] weight = new int[size];
        boolean[] removed = new boolean[size];
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                weight[i] += matrix[j][i];
                sum += matrix[j][i];
            }
        }

        List<Integer> removalOrder = new ArrayList<>();

        while (sum > 0) {
            boolean isAny = false;

            for (int i = 0; i < size; i++) {
                if (weight[i] == 0 && !removed[i]) {
                    removed[i] = true;
                    isAny = true;
                    removalOrder.add(i + 1);

                    for (int j = 0; j < size; j++) {
                        if (matrix[i][j] > 0) {
                            weight[j]--;
                            sum--;
                        }
                    }
                }
            }

            if (!isAny) return false;
        }

        Collections.reverse(removalOrder);
        path.addAll(removalOrder);
        System.out.println("Элементы топологической сортировки: " + path);

        return true;
    }
}
