package ru.otus.algos_20_dynamic_programming.utils;

import ru.otus.algos_20_dynamic_programming.five_eight.FiveEightTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {
    public static String readFile(String findPrefix, int testNumber, String postfix) {
        try {
            String filename = findPrefix + "/test." + testNumber + "." + postfix;
            InputStream is = FiveEightTest.class.getClassLoader()
                    .getResourceAsStream(filename);

            if (is == null) {
                System.err.println("Файл " + filename + " не найден");
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            reader.close();

            if (line == null || line.trim().isEmpty()) {
                System.err.println("Файл " + filename + " пустой");
                return null;
            }

            return line.trim();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

        public static Object[] readMatrixFile(String findPrefix, int testNumber, String postfix) {
            try {
                String filename = findPrefix + "/test." + testNumber + "." + postfix;
                InputStream is = FiveEightTest.class.getClassLoader()
                        .getResourceAsStream(filename);

                if (is == null) {
                    System.err.println("Файл " + filename + " не найден");
                    return null;
                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String sizeLine = reader.readLine().trim();
                int size = Integer.parseInt(sizeLine);

                int[][] map = new int[size][size];
                for (int i = 0; i < size; i++) {
                    String line = reader.readLine().trim();
                    String[] numbers = line.split("\\s+");

                    for (int j = 0; j < size; j++) {
                        map[i][j] = Integer.parseInt(numbers[j]);
                    }
                }

                reader.close();

                return new Object[]{size, map};

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

