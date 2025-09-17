package ru.otus.algos_08_quick_and_external_sort.utils;

import java.io.*;
import java.util.*;

public class ExternalSortUtils {

    public static void mergeSortedFiles(List<String> sortedFiles, String outputFileName) throws IOException {
        if (sortedFiles == null || sortedFiles.isEmpty()) {
            throw new IllegalArgumentException("Список файлов пуст");
        }

        Queue<String> filesQueue = new LinkedList<>(sortedFiles);

        int mergeIndex = 0;

        while (filesQueue.size() > 1) {
            String file1 = filesQueue.poll();
            String file2 = filesQueue.poll();

            String mergedFileName = "merged_" + (mergeIndex++) + ".txt";
            mergeTwoFiles(file1, file2, mergedFileName);

            new File(file1).delete();
            new File(file2).delete();

            filesQueue.add(mergedFileName);
        }

        String finalFile = filesQueue.poll();

        if (!new File(finalFile).renameTo(new File(outputFileName))) {
            try (BufferedReader reader = new BufferedReader(new FileReader(finalFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            new File(finalFile).delete();
        }
    }

    private static void mergeTwoFiles(String file1, String file2, String outputFile) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line1 = reader1.readLine();
            String line2 = reader2.readLine();

            while (line1 != null && line2 != null) {
                long val1 = Long.parseLong(line1);
                long val2 = Long.parseLong(line2);

                if (val1 <= val2) {
                    writer.write(line1);
                    writer.newLine();
                    line1 = reader1.readLine();
                } else {
                    writer.write(line2);
                    writer.newLine();
                    line2 = reader2.readLine();
                }
            }

            while (line1 != null) {
                writer.write(line1);
                writer.newLine();
                line1 = reader1.readLine();
            }
            while (line2 != null) {
                writer.write(line2);
                writer.newLine();
                line2 = reader2.readLine();
            }
        }
    }
}

