package com.lealceldeiro.math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.lealceldeiro.math.PrimeFactor.primeFactorsOf;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeFactorTest {
    @Test
    void primeFactors() {
        assertEquals(emptyList(), primeFactorsOf(-1));
        assertEquals(emptyList(), primeFactorsOf(0));
        assertEquals(emptyList(), primeFactorsOf(1));
        assertEquals(List.of(2), primeFactorsOf(2));
        assertEquals(List.of(3), primeFactorsOf(3));
        assertEquals(List.of(2, 2), primeFactorsOf(4));
        assertEquals(List.of(5), primeFactorsOf(5));
        assertEquals(List.of(2, 3), primeFactorsOf(6));
        assertEquals(List.of(7), primeFactorsOf(7));
        assertEquals(List.of(2, 2, 2), primeFactorsOf(8));
        assertEquals(List.of(3, 3), primeFactorsOf(9));
        assertEquals(List.of(2, 3, 3, 3, 5, 5, 7, 7, 7, 11, 13, 17),
                primeFactorsOf(2 * 3 * 3 * 3 * 5 * 5 * 7 * 7 * 7 * 11 * 13 * 17));
    }
}
