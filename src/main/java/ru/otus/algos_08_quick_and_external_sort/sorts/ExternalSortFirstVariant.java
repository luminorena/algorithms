package ru.otus.algos_08_quick_and_external_sort.sorts;

import ru.otus.algos_08_quick_and_external_sort.utils.ExternalSortUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExternalSortFirstVariant {

    public static void main(String[] args) throws IOException {
        List<String> sortedFiles = splitAndSortBlocks("file81.txt", 5);
        ExternalSortUtils.mergeSortedFiles(sortedFiles, "file_sorted.txt");
    }

    public static List<String> splitAndSortBlocks(String inputFileName, int maxLines) {
        List<String> tempFileNames = new ArrayList<>();
        int count = 0;
        long[] arr = new long[maxLines];
        int fileIndex = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                arr[count++] = Long.parseLong(line);

                if (count == maxLines) {
                    sort(arr);
                    String tempFileName = "temp_sorted_" + fileIndex++ + ".txt";
                    writeArrayToFile(arr, maxLines, tempFileName);
                    tempFileNames.add(tempFileName);
                    count = 0;
                }
            }

            if (count > 0) {
                long[] remainder = Arrays.copyOf(arr, count);
                sort(remainder);
                String tempFileName = "temp_sorted_" + fileIndex++ + ".txt";
                writeArrayToFile(remainder, count, tempFileName);
                tempFileNames.add(tempFileName);
            }

        } catch ( IOException e) {
            e.printStackTrace();
        }
        return tempFileNames;
    }

    public static void writeArrayToFile(long[] arr, int length, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < length; i++) {
                writer.write(Long.toString(arr[i]));
                writer.newLine();
            }
        }
    }

    private static void sort(long[] initialArray){
        for (int i = 1; i < initialArray.length; i++){
            int index = i;
            long cachedValue = initialArray[i];
            while (index > 0) {
                if (initialArray[index - 1] <= cachedValue)
                    break;
                initialArray[index] = initialArray[index - 1];
                index--;
            }
            initialArray[index] = cachedValue;
        }
    }
}
