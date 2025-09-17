package ru.otus.algos_08_quick_and_external_sort.filegen;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class FileGenerator {
    private static final Random random = new Random();

    public static void main(String[] args) {
        fileGen(50, 1000);
    }

    // random.nextInt(10) + 1

    public static void fileGen(int linesCount, int maxNumber)  {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("file" + "_initial" + ".txt"), StandardCharsets.UTF_8))) {
            for (int i = 0; i < linesCount; i++) {
                writer.write(String.valueOf(random.nextInt(maxNumber)) + 1);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
