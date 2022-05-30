package com.lealceldeiro.fibonacci;

public class Fibonacci {
    private final int[] cache;
    private boolean startFromZero;

    public Fibonacci() {
        this(100);
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
