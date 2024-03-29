package com.lealceldeiro.fibonacci;

public class Fibonacci {
    private static final int TOP_DEFAULT_NTH_NUMBER = 100;
    private final int[] cache;
    private final boolean startFromZero;

    public Fibonacci() {
        this(TOP_DEFAULT_NTH_NUMBER);
    }

    public Fibonacci(int topNthNumber) {
        this(topNthNumber, false);
    }

    public Fibonacci(int topNthNumber, boolean startFromZero) {
        cache = new int[topNthNumber + 1];
        this.startFromZero = startFromZero;
    }

    public int nThNumber(int n) {
        if (startFromZero && n <= 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (n >= cache.length) {
            throw new IllegalArgumentException("n must be lest than or equal than the top number");
        }
        if (cache[n] > 0) {
            return cache[n];
        }
        cache[n] = nThNumber(n - 1) + nThNumber(n - 2);
        return cache[n];
    }
}
