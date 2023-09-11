package com.lealceldeiro.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AnagramsTest {
    private static Stream<Arguments> makeAnagramSrc() {
        return Stream.of(
                arguments(null, null, 0),
                arguments("", "", 0),
                arguments("a", "", 1),
                arguments("", "a", 1),
                arguments("a", "a", 0),
                arguments("a", "b", 2),
                arguments("b", "a", 2),
                arguments("ba", "a", 1),
                arguments("ab", "a", 1),
                arguments("a", "ab", 1),
                arguments("a", "ba", 1),
                arguments("ab", "ac", 2),
                arguments("ab", "ca", 2),
                arguments("ba", "ac", 2),
                arguments("ba", "ca", 2),
                arguments("ba cdf", "ab", 4),
                arguments("ba cdf", "fdc ab ioweklsdfr", 11),
                arguments("oikw eslfrdba cdf", "fdc ab ioweklsdfr", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("makeAnagramSrc")
    void makeAnagram(String a, String b, int expectedMinCharsToBeDeleted) {
        assertEquals(expectedMinCharsToBeDeleted, Anagrams.makeAnagram(a, b));
    }
}
