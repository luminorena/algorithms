package ru.otus.algos_19_compression;

public class CompressStringImproved {
    private static final char COUNT_MARKER = 0x01;

    public static String compress(String str) {
        if (str == null || str.isEmpty()) return str;

        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char next = str.charAt(i);
            if (next == currentChar) {
                count++;
                if (count == 128) {
                    sb.append(currentChar);
                    sb.append(COUNT_MARKER);
                    sb.append((char)(127));
                    currentChar = next;
                    count = 1;
                }
            } else {
                sb.append(currentChar);
                if (count > 1) {
                    sb.append(COUNT_MARKER);
                    sb.append((char)(count - 1));
                }
                currentChar = next;
                count = 1;
            }
        }

        sb.append(currentChar);
        if (count > 1) {
            sb.append(COUNT_MARKER);
            sb.append((char)(count - 1));
        }

        return sb.toString();
    }

    public static String decompress(String compressed) {
        if (compressed == null || compressed.isEmpty()) return compressed;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char curr = compressed.charAt(i);
            i++;

            int repeat = 1;
            if (i < compressed.length() && compressed.charAt(i) == COUNT_MARKER) {
                i++;
                if (i < compressed.length()) {
                    int countByte = (int)compressed.charAt(i) & 0xFF;
                    repeat = Math.min(countByte + 1, 127);
                    i++;
                }
            }
            sb.append(String.valueOf(curr).repeat(repeat));
        }
        return sb.toString();
    }
}