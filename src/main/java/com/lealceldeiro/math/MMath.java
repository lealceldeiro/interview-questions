package com.lealceldeiro.math;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public final class MMath {
    private MMath() {
    }

    /**
     * Given a number {@code n}, find it's square root without using any library for this purpose (like {@link Math}).
     * The only math operators that can be used are: {@code + - / *}.
     *
     * @param n                     the number to find the square root of.
     * @param maximumFractionDigits number of digits up where set the precision. i.e.: {@code sqrt(2, 2)} must return
     *                              {@code 1.4142}
     *
     * @return the square root of the provided number up to {@code maximumFractionDigits} decimals.
     */
    public static double sqrt(double n, int maximumFractionDigits) {
        if (maximumFractionDigits < 0) {
            throw new IllegalStateException();
        }
        return n < 0 ? -1 : sqrt(n, maximumFractionDigits, 0, n);
    }

    public static double sqrt(double n, int maximumFractionDigits, double start, double end) {
        double candidate = (start + end) / 2;
        double product = candidate * candidate;

        if (areCloseEnough(n, product, maximumFractionDigits)) {
            return valueUptoMaximumFractionDigits(candidate, maximumFractionDigits);
        }

        start = product > n ? start : candidate;
        end = product > n ? candidate : end;
        return sqrt(n, maximumFractionDigits, start, end);
    }

    private static boolean areCloseEnough(double n, double product, int maximumFractionDigits) {
        if ((int) product == (int) n) {
            double diff = product > n ? product - n : n - product;
            return valueUptoMaximumFractionDigits(diff, maximumFractionDigits) <= 0;
        }
        return false;
    }

    private static double valueUptoMaximumFractionDigits(double candidate, int maximumFractionDigits) {
        var numberFormat = numberFormatInstance(maximumFractionDigits);
        return Double.parseDouble(numberFormat.format(candidate));
    }

    private static NumberFormat numberFormatInstance(int maximumFractionDigits) {
        var decimalFormat = NumberFormat.getInstance(Locale.ENGLISH);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        decimalFormat.setMaximumFractionDigits(maximumFractionDigits);
        decimalFormat.setGroupingUsed(false);
        return decimalFormat;
    }
}
