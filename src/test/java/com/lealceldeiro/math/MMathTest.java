package com.lealceldeiro.math;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.RoundingMode;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MMathTest {
    private static Stream<Arguments> sqrtSrc() {
        var fixedTests = Stream.of(arguments(0, 2, 0),
                                   arguments(1, 3, 1),
                                   arguments(2, 4, 1.4142),
                                   arguments(3, 2, 1.73),
                                   arguments(4, 0, 2),
                                   arguments(5, 2, 2.23),
                                   arguments(9, 3, 3),
                                   arguments(16, 4, 4),
                                   arguments(25, 2, 5),
                                   arguments(36, 1, 6));

        Random random = new SecureRandom();

        var numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
        numberFormat.setRoundingMode(RoundingMode.DOWN);
        numberFormat.setGroupingUsed(false);

        var randomTests = IntStream.range(0, 100).mapToObj(i -> {
            int precision = random.nextInt(5);
            numberFormat.setMaximumFractionDigits(precision);

            double n = random.nextInt(1000000000);
            double expected = Double.parseDouble(numberFormat.format(Math.sqrt(n)));

            return arguments(n, precision, expected);
        });
        return Stream.concat(fixedTests, randomTests);
    }

    @ParameterizedTest
    @MethodSource("sqrtSrc")
    void sqrt(double number, int maximumFractionDigits, double expectedSrt) {
        assertEquals(expectedSrt, MMath.sqrt(number, maximumFractionDigits), "n was " + number);
    }

    @Test
    void sqrt() {
        assertEquals(7, MMath.sqrt(49, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -1453})
    void sqrtOfNegativeNumberReturnsMinus1(int n) {
        assertEquals(-1, MMath.sqrt(n, 0));
    }

    @Test
    void sqrtWithNegativeMaximumFractionDigitsThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> MMath.sqrt(49, -1));
    }
}