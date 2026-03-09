package ru.otus.algos_20_dynamic_programming.five_eight;

import org.assertj.core.api.Assertions;

import static ru.otus.algos_20_dynamic_programming.utils.Utils.readFile;

public class FiveEightTest {

    private static void test() {
        for (int i = 0; i <=9 ; i++) {
            String inputStr = readFile("five_eight_tests",i, "in");
            String outputStr = readFile("five_eight_tests", i, "out");
            int inputValue = Integer.parseInt(inputStr);
            long calculated = FiveEightCalculateResult.calculate(inputValue);
            Assertions.assertThat(outputStr).isEqualTo(String.valueOf(calculated));
        }
    }

    public static void main(String[] args) {
        test();
    }
}

