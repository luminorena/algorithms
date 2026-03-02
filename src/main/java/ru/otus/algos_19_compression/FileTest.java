package ru.otus.algos_19_compression;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTest {
    public static void main(String[] args) throws IOException {

        String inputPath = "for_compress.txt";
        String compressedPath = "compressed.zip";
        String decompressedPath = "decompressed.txt";

        CompressFile.compressFile(inputPath, compressedPath);
        CompressFile.decompressFile(compressedPath, decompressedPath);

        String decompressTest = Files.readString(Path.of(decompressedPath));
        String compressTest = Files.readString(Path.of(inputPath));

        System.out.println("Test with files success: " + decompressTest.equals(compressTest));
    }
}
