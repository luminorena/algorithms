package ru.otus.algos_06_simple_sorts.search;


public class ConsequentArraySort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3 ,4 ,5, 6};
        System.out.println("Найденное значение: " + indexSearch(array, -4));

    }

    public static Integer indexSearch(int[] arr, int key) {
        final int step = 8;
        int indexSize = arr.length/step+1;
        int[] index = new int[indexSize];    // ключи первых элементов блоков
        int[] pindex = new int[indexSize];   // индексы начала блоков

        int i = 0;
        for (int k = 0; k < arr.length; k += step) {
            index[i] = arr[k];
            pindex[i] = k;
            i++;
        }

        // Находим блок, где должен лежать ключ
        for (i = 0; i < index.length; i++) {
            if (key <= index[i]) {
                break;
            }
        }

        int beg = 0;
        int end = arr.length;

        if (i < index.length) {
            if (key == index[i]) {
                return arr[pindex[i]]; // нашли элемент сразу
            }
            end = pindex[i];
        }
        if (i > 0) {
            beg = pindex[i - 1];
        }

        // Перебираем элементы в блоке
        for (int j = beg; j < end; j++) {
            if (arr[j] == key) {
                return arr[j];
            }
        }
        return null; // элемент не найден
    }

}


