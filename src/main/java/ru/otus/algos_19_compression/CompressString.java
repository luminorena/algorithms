package ru.otus.algos_19_compression;

public class CompressString {
    public static String compress(String str) {
        if (str == null || str.isEmpty()) return str;

        StringBuilder sb = new StringBuilder();
        char currentChar = str.charAt(0);
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            char next = str.charAt(i);
            if (next == currentChar && count < 9) {
                count++;
            } else {
                sb.append(currentChar);
                if (count > 1) sb.append((char)(count + '0'));
                currentChar = next;
                count = 1;
            }
        }
        sb.append(currentChar);
        if (count > 1) sb.append((char)(count + '0'));
        return sb.toString();
    }

    public static String decompress(String compressed) {
        if (compressed == null || compressed.isEmpty()) return compressed;

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < compressed.length()) {
            char curr = compressed.charAt(i);
            if (i + 1 < compressed.length() && Character.isDigit(compressed.charAt(i + 1))) {
                sb.append(curr);
                i++;
                continue;
            }

            i++;
            int count = 1;
            if (i < compressed.length()) {
                char next = compressed.charAt(i);
                if (next >= '1' && next <= '9') {
                    count = next - '0';
                    i++;
                }
            }
            sb.append(String.valueOf(curr).repeat(count));
        }
        return sb.toString();
    }
}
