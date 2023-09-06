package com.lealceldeiro.math;

import java.util.ArrayList;
import java.util.List;

public final class PrimeFactor {
    private PrimeFactor() {
    }

    public static List<Integer> primeFactorsOf(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for (int divisor = 2; n > 1; divisor++) {
            for (; n % divisor == 0; n /= divisor) {
                primeFactors.add(divisor);
            }
        }
        return primeFactors;
    }
}
