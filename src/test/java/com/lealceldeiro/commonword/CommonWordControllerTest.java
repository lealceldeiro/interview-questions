package com.lealceldeiro.commonword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CommonWordControllerTest {
    private static Stream<Arguments> findMostCommonWordInSrc() {
        return Stream.of(
                arguments(null, "", ""),
                arguments(null, "a", "a"),
                arguments(null, "A", "a"),
                arguments(null, "a", "A"),
                arguments("a", "a", "b"),
                arguments("a", "a,b", "b"),
                arguments(null, "a,b", "b,a"),
                arguments(null, "a,b", "a,b"),
                arguments(null, "a b", "a b"),
                arguments(null, "a, b", "a, b"),
                arguments("a", "a a b", "x y"),
                arguments("a", "a b a", "x y"),
                arguments("a", "b a a", "x y"),
                arguments("a", "a b", "x y")
                        );
    }

    @ParameterizedTest
    @MethodSource("findMostCommonWordInSrc")
    void findMostCommonWordIn(String expected, String transcript, String bannedWords) {
        assertEquals(expected, CommonWordController.findMostCommonWordIn(transcript, bannedWords));
    }
}