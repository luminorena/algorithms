package ru.otus.algos_20_dynamic_programming.big_island;

import org.assertj.core.api.Assertions;
import ru.otus.algos_20_dynamic_programming.five_eight.FiveEightCalculateResult;

import static ru.otus.algos_20_dynamic_programming.utils.Utils.readFile;
import static ru.otus.algos_20_dynamic_programming.utils.Utils.readMatrixFile;

public class BigIslandTest {
    private static void test() {
        for (int i = 0; i <=9 ; i++) {
            Object[] result = readMatrixFile("big_island_tests", i, "in");
            int size = (Integer) result[0];
            int[][] map = (int[][]) result[1];
            String outputStr = readFile("big_island_tests", i, "out");

            int calculated = BigIslandCalculateResult.calculate(size, map);
            Assertions.assertThat(outputStr).isEqualTo(String.valueOf(calculated));
        }
    }

    public static void main(String[] args) {
        test();
    }
}
