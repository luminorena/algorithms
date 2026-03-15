package ru.otus.algos_21_probability;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import net.agkn.hll.HLL;
import org.assertj.core.data.Offset;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;


public class HyperLogLogEx {
    private static void count(){
        HashFunction hashFunction = Hashing.murmur3_128();
        long numberOfElements = 100_000_000;
        long toleratedDifference = 1_000_000;
        HLL hll = new HLL(14, 5);

        LongStream.range(0, numberOfElements - 1)
                .forEach(element -> {
                    long hashedValue = hashFunction.newHasher()
                            .putLong(element)
                            .hash()
                            .asLong();
                    hll.addRaw(hashedValue);
                }
        );

        long cardinality = hll.cardinality();
        assertThat(cardinality)
                .isCloseTo(numberOfElements, Offset.offset(toleratedDifference));
    }

    public static long countUniqueFromFile(String filePath) throws IOException {
        HLL hll = new HLL(14, 5);
        HashFunction hash = Hashing.murmur3_128();

        Files.lines(Paths.get(filePath))
                .forEach(line -> {
                    long hashed = hash.newHasher()
                            .putString(line, StandardCharsets.UTF_8)
                            .hash().asLong();
                    hll.addRaw(hashed);
                });

        return hll.cardinality();
    }

    public static double calculateError(int log2m) {
        double m = Math.pow(2, log2m);
        return 1.04 / Math.sqrt(m);
    }

}
