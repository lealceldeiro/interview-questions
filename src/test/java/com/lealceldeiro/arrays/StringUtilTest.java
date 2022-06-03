package com.lealceldeiro.arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Stream.concat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringUtilTest {
    private static final Locale EN = Locale.ENGLISH;

    private static Stream<Arguments> isUniqueSrc() {
        var cornerCases = Stream.of(arguments("", true),
                                    arguments(null, false),
                                    arguments("a", true),
                                    arguments("ab", true),
                                    arguments("abc", true),
                                    arguments("aba", false),
                                    arguments("abb", false),
                                    arguments("abba", false),
                                    arguments("abcdef", true),
                                    arguments("12", true),
                                    arguments("aab", false),
                                    arguments("aa", false));

        String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                          "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        Stream<Arguments> dupes = stream(chars).flatMap(c -> Stream.of(c + c, c.toUpperCase(EN) + c.toUpperCase(EN)))
                                               .map(s -> arguments(s, false));
        Stream<Arguments> nonDupes = stream(chars).flatMap(c -> Stream.of(c, c.toUpperCase(EN)))
                                                  .map(s -> arguments(s, true));

        return concat(cornerCases, concat(dupes, nonDupes));
    }

    @ParameterizedTest
    @MethodSource("isUniqueSrc")
    void isUnique(String s, boolean expected) {
        assertEquals(expected, StringUtil.isUnique1(s));
        assertEquals(expected, StringUtil.isUnique2(s));
    }

    private static Stream<Arguments> isPermutationSrc() {
        return Stream.of(
                arguments("", "", true),
                arguments(null, "", false),
                arguments("", null, false),
                arguments(null, null, false),
                arguments("a", "a", true),
                arguments("a", "b", false),
                arguments("ab", "ab", true),
                arguments("ab", "ba", true),
                arguments("aba", "aba", true),
                arguments("aba", "aab", true),
                arguments("aba", "baa", true),
                arguments("baa", "aba", true),
                arguments("aab", "aba", true),
                arguments("ab", "bba", false),
                arguments("ab", "abb", false),
                arguments("abb", "ab", false),
                arguments("bba", "ab", false)
                        );
    }

    @ParameterizedTest
    @MethodSource("isPermutationSrc")
    void isPermutation(String source, String target, boolean expected) {
        assertEquals(expected, StringUtil.isPermutation(source, target));
    }

    private static Stream<Arguments> URLfySrc() {
        return Stream.of(
                arguments("Mr John Smith   ", "Mr%20John%20Smith"),
                arguments("   Mr John Smith   ", "Mr%20John%20Smith"),
                arguments("   Mr    John    Smith   ", "Mr%20John%20Smith"),
                arguments("Mr    John    Smith", "Mr%20John%20Smith"),
                arguments("", ""),
                arguments(null, null)
                        );
    }

    @ParameterizedTest
    @MethodSource("URLfySrc")
    void URLfy(String s, String expected) {
        assertEquals(expected, StringUtil.urlFromWithRegex(s));
        assertEquals(expected, StringUtil.urlFrom(s));
    }
}