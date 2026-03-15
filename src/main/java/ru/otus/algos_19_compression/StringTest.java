package ru.otus.algos_19_compression;

public class StringTest {
    public static void main(String[] args) {
        String[] tests = {"A2B"};

        for (String test : tests) {
            String compressString = CompressStringImproved.compress(test);
            String decompressString = CompressStringImproved.decompress(compressString);

            System.out.println("Original string:  '" + test + "' (" + test.length() + ")");
            System.out.println("Compressed string: '" + compressString + "' (" + compressString.length() + ")");
            System.out.println("Decompressed string: '" + decompressString + "' (" + decompressString.length() + ")");
            System.out.println("Test success with string: " + test.equals(decompressString));
            System.out.println();
        }
    }
}
