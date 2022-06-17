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

    private static Stream<Arguments> isPalindromePermutationSrc() {
        return Stream.of(
                arguments(null, false),
                arguments("", true),
                arguments("Tact Coa", true),
                arguments("taco cat", true),
                arguments("atco cta", true),
                arguments("11", true),
                arguments("aa", true),
                arguments("abba", true),
                arguments("abcba", true),
                arguments("ab1ba", true),
                arguments("xab1bax", true),
                arguments("xabx1ba", true),
                arguments("xaxbx1 xba", true),
                arguments("somos o no somos", true),
                arguments("o somos no somos", true),
                arguments("somos no somoso ", true),
                arguments("o no somos somos", true),
                arguments("somos somoso no ", true),
                arguments("somossomos o no ", true),
                arguments("s1omossomos o no ", false),
                arguments("somossomosc o no ", false),
                arguments("somossomos o no o", false)
                        );
    }

    @ParameterizedTest
    @MethodSource("isPalindromePermutationSrc")
    void isPalindromePermutation(String s, boolean expected) {
        assertEquals(expected, StringUtil.isPalindromePermutation(s));
    }

    private static Stream<Arguments> isOneAwaySrc() {
        return Stream.of(
                arguments(null, null, true),
                arguments("", "", true),
                arguments("a", "", true),
                arguments("ab", "", false),
                arguments("ab", "ac", true),
                arguments("ab", "abc", true),
                arguments("ab", "ba", false),
                arguments("ab", "abcd", false),
                arguments("ab", "cd", false),
                arguments("ab", "ab", true),
                arguments("pale", "ple", true),
                arguments("pales", "pale", true),
                arguments("pale", "bale", true),
                arguments("ab", "cde", false),
                arguments("pale", "bae", false),
                // flip
                arguments("", "a", true),
                arguments("", "ab", false),
                arguments("ac", "ab", true),
                arguments("abc", "ab", true),
                arguments("ba", "ab", false),
                arguments("abcd", "ab", false),
                arguments("cd", "ab", false),
                arguments("ab", "ab", true),
                arguments("ple", "pale", true),
                arguments("pale", "pales", true),
                arguments("bale", "pale", true),
                arguments("cde", "ab", false),
                arguments("bae", "pale", false)
                        );
    }

    @ParameterizedTest
    @MethodSource("isOneAwaySrc")
    void isOneAway(String s1, String s2, boolean expected) {
        assertEquals(expected, StringUtil.isOneAway(s1, s2));
    }
}