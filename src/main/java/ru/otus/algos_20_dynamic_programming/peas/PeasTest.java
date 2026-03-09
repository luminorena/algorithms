package ru.otus.algos_20_dynamic_programming.peas;

import org.assertj.core.api.Assertions;

import static ru.otus.algos_20_dynamic_programming.utils.Utils.readFile;

public class PeasTest {
    private static void test() {
        for (int i = 0; i <=9 ; i++) {
            String inputStr = readFile("peas_tests",i, "in");
            String outputStr = readFile("peas_tests", i, "out");
            String calculated = PeasCalculateResult.calculate(inputStr);
            Assertions.assertThat(outputStr).isEqualTo(calculated);
        }
    }

    public static void main(String[] args) {
        test();
    }
}
