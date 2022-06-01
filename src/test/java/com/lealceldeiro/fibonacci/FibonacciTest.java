package com.lealceldeiro.fibonacci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FibonacciTest {
    private static Stream<Arguments> nThNumberStartingFrom1() {
        return Stream.of(
                arguments(0, 1),
                arguments(1, 1),
                arguments(2, 2),
                arguments(3, 3),
                arguments(4, 5),
                arguments(5, 8),
                arguments(6, 13),
                arguments(7, 21),
                arguments(8, 34),
                arguments(9, 55)
                        );
    }

    @ParameterizedTest
    @MethodSource("nThNumberStartingFrom1")
    void nThNumberStartingFrom1(int nth, int expected) {
        Fibonacci fibonacci = new Fibonacci(nth + 1);
        Assertions.assertEquals(expected, fibonacci.nThNumber(nth));
    }
    private static Stream<Arguments> nThNumberStartingFrom0() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 1),
                arguments(2, 1),
                arguments(3, 2),
                arguments(4, 3),
                arguments(5, 5),
                arguments(6, 8),
                arguments(7, 13),
                arguments(8, 21),
                arguments(9, 34),
                arguments(10, 55)
                        );
    }

    @ParameterizedTest
    @MethodSource("nThNumberStartingFrom0")
    void nThNumberStartingFrom0(int nth, int expected) {
        Fibonacci fibonacci = new Fibonacci(nth + 1, true);
        Assertions.assertEquals(expected, fibonacci.nThNumber(nth));
    }
}