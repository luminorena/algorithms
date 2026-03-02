package ru.otus.algos_19_compression;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompressFile {
    public static void compressFile(String inputPath, String outputPath) throws IOException {
        String content = Files.readString(Path.of(inputPath));
        String compressed = CompressString.compress(content);
        Files.writeString(Path.of(outputPath), compressed);

        long origSize = Files.size(Path.of(inputPath));
        long compSize = Files.size(Path.of(outputPath));

        System.out.printf("Файл: %s → %s%n \n", inputPath, outputPath);
        System.out.printf("Размер: %d → %d байт \n", origSize, compSize);
    }

    public static void decompressFile(String inputPath, String outputPath) throws IOException {
        String compressed = Files.readString(Path.of(inputPath));
        String decompressed = CompressString.decompress(compressed);
        Files.writeString(Path.of(outputPath), decompressed);

        long compSize = Files.size(Path.of(inputPath));
        long decompSize = Files.size(Path.of(outputPath));

        System.out.printf("Файл: %s → %s%n \n", inputPath, outputPath);
        System.out.printf("Размер: %d → %d байт \n", compSize, decompSize);
    }
}
