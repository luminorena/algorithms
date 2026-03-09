package ru.otus.algos_20_dynamic_programming.big_island;

public class BigIslandCalculateResult {

    private static void walk(int x, int y, int size, int[][] map) {
        if (x < 0 || x >= size) return;
        if (y < 0 || y >= size) return;
        if (map[x][y] == 0) return;
        map[x][y] = 0;

        walk(x, y - 1, size, map);  // вверх
        walk(x, y + 1, size, map);  // вниз
        walk(x - 1, y, size, map);  // влево
        walk(x + 1, y, size, map);  // вправо
    }

    public static int calculate(int size, int[][] map) {
        int maxIsland = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    walk(i, j, size, map);
                    maxIsland++;
                }
            }
        }
        return maxIsland;
    }

    public static void main(String[] args) {
        int[][] testMap = {
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 0, 1, 1}
        };

        System.out.println(calculate(4, testMap));
    }
}



