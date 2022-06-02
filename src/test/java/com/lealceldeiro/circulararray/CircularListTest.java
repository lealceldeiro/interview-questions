package com.lealceldeiro.circulararray;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CircularListTest {
    @Test
    void getValues() {
        CircularList<Integer> array = new CircularList<>(1, 2, 3, 4, 5, 6, 7);
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, array.getValues());
    }

    @Test
    void get() {
        CircularList<Integer> array = new CircularList<>(13, 42, 73, 34, 95, 16, 87);
        assertEquals(34, array.get(3));
    }

    @Test
    void set() {
        CircularList<Integer> array = new CircularList<>(103, 482, 733, 234, 595, 216, 187);
        Integer expectedPrev = 216;
        Integer newVal = 987;
        int postSet = 5;

        Integer prev = array.set(postSet, newVal);

        assertEquals(expectedPrev, prev);
        assertEquals(newVal, array.get(postSet));
    }

    private static Stream<Arguments> rotateSrc() {
        return Stream.of(
                arguments(new CircularList<>(Integer.class, 0), 1, new Integer[]{}),
                arguments(new CircularList<>(Integer.class, 0), 5, new Integer[]{}),
                arguments(new CircularList<>(Integer.class, 0), -15, new Integer[]{}),
                arguments(new CircularList<>(Integer.class), -30, new Integer[]{}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 1, new Integer[]{2, 3, 4, 5, 6, 7, 1}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 3, new Integer[]{4, 5, 6, 7, 1, 2, 3}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 7, new Integer[]{1, 2, 3, 4, 5, 6, 7}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -1, new Integer[]{7, 1, 2, 3, 4, 5, 6}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -4, new Integer[]{4, 5, 6, 7, 1, 2, 3}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -7, new Integer[]{1, 2, 3, 4, 5, 6, 7})
                        );
    }

    @ParameterizedTest
    @MethodSource("rotateSrc")
    void rotate(CircularList<Integer> array, int numberToRotate, Integer[] expected) {
        array.rotate(numberToRotate);

        Integer[] actual = array.getValues();
        assertArrayEquals(expected, actual,
                          "expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    }

    private static Stream<Arguments> rotateMultipleTimesSrc() {
        return Stream.of(
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 1, 3, new Integer[]{5, 6, 7, 1, 2, 3, 4}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 3, -2, new Integer[]{2, 3, 4, 5, 6, 7, 1}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 3, -5, new Integer[]{6, 7, 1, 2, 3, 4, 5}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), 7, -7, new Integer[]{1, 2, 3, 4, 5, 6, 7}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -1, 5, new Integer[]{5, 6, 7, 1, 2, 3, 4}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -4, 2, new Integer[]{6, 7, 1, 2, 3, 4, 5}),
                arguments(new CircularList<>(1, 2, 3, 4, 5, 6, 7), -7, 7, new Integer[]{1, 2, 3, 4, 5, 6, 7})
                        );
    }

    @ParameterizedTest
    @MethodSource("rotateMultipleTimesSrc")
    void rotateMultipleTimes(CircularList<Integer> array, int number1ToRotate, int number2ToRotate,
                             Integer[] expected) {
        array.rotate(number1ToRotate);
        array.rotate(number2ToRotate);

        Integer[] actual = array.getValues();
        assertArrayEquals(expected, actual,
                          "expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    }

    @ParameterizedTest
    @MethodSource("rotateMultipleTimesSrc")
    void iterator(CircularList<Integer> array, int number1ToRotate, int number2ToRotate, Integer[] expected) {
        array.rotate(number1ToRotate);
        array.rotate(number2ToRotate);

        Integer[] actual = new Integer[array.size()];
        int i = 0;
        for (Integer v : array) {
            actual[i++] = v;
        }
        assertArrayEquals(expected, actual,
                          "expected: " + Arrays.toString(expected) + ", actual: " + Arrays.toString(actual));
    }
}