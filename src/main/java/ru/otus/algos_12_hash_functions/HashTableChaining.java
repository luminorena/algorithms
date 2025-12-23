package ru.otus.algos_12_hash_functions;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class HashTableChaining {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        String[] keys = {"milk", "bread", "eggs", "apple", "rice"};
        String[] values = {"100", "40", "80", "60", "120"};

        List<Map.Entry<String, String>>[] table = new List[SIZE];

        for (int i = 0; i < keys.length; i++) {
            byte[] msg = keys[i].getBytes(StandardCharsets.US_ASCII);
            int crc = getCRC(msg);
            int hash = Math.abs(crc % SIZE);

            if (table[hash] == null) {
                table[hash] = new ArrayList<>();
            }
            table[hash].add(Map.entry(keys[i], values[i]));
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            if (table[i] != null) {
                for (Map.Entry<String, String> entry : table[i]) {
                    System.out.print(entry.getKey() + " - " + entry.getValue() + "\t");
                }
            }
            System.out.println();
        }
    }

    private static int getCRC(byte[] message) {
        int CRC = 0xFFFF;
        for (byte b : message) {
            CRC ^= (b & 0xFF);
            for (int i = 8; i != 0; i--) {
                if ((CRC & 0x0001) != 0) {
                    CRC >>= 1;
                    CRC ^= 0xA001;
                } else {
                    CRC >>= 1;
                }
            }
        }
        return CRC;
    }
}

