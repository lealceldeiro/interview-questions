package com.lealceldeiro.arrays;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class StringUtil {
    private StringUtil() {
    }

    /**
     * Determines if a string has all unique characters.
     *
     * @return {@code true} if {@code s} has all unique characters, {@code false} otherwise.
     */
    public static boolean isUnique1(String s) {
        if (s == null) {
            return false;
        }
        var length = s.length();
        Collection<Character> chars = new HashSet<>(length);
        for (int i = 0; i < length; i++) {
            if (!chars.add(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Determines if a string has all unique characters without using any additional data structures.
     *
     * @return {@code true} if {@code s} has all unique characters, {@code false} otherwise.
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operation">Wikipedia</a>
     * @see <a href="https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html">Oracle tutorial</a>
     * @see <a href="https://stackoverflow.com/a/12811293/5640649">StackOverflow post</a>
     * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.22">JLS 15.22. Bitwise and Logical Operators</a>
     * @see <a href="https://docs.oracle.com/javase/specs/jls/se11/html/jls-15.html#jls-15.19">JLS 15.19. Shift Operators</a>
     */
    public static boolean isUnique2(String s) {
        if (s == null) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < s.length(); ++i) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

    /**
     * Given two strings, returns if one is a permutation of the other.
     *
     * @param source The source string to check if it's a permutation of {@code target}.
     * @param target The target string to check if {@code source} is a permutation of this value.
     *
     * @return {@code true} if {@code source} is a permutation of {@code target}, {@code false} otherwise.
     */
    public static boolean isPermutation(String source, String target) {
        if (source == null || target == null || source.length() != target.length()) {
            return false;
        }
        Map<Character, Integer> wordsCount = wordsCount(source);

        for (int i = 0; i < target.length(); i++) {
            Character c = target.charAt(i);
            Integer wCount = wordsCount.get(c);
            if (wCount == null) {
                return false;
            }
            wordsCount.put(c, wCount - 1);
            if (wordsCount.get(c) == 0) {
                wordsCount.remove(c);
            }
        }
        return wordsCount.isEmpty();
    }

    private static Map<Character, Integer> wordsCount(final String source) {
        Map<Character, Integer> wordsCount = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            Character c = source.charAt(i);
            Integer wCount = wordsCount.getOrDefault(c, 0);
            wordsCount.put(c, wCount + 1);
        }
        return wordsCount;
    }

    /**
     * Replaces all spaces in a string with {@code %20}.
     * <p>
     * Example:
     * <p>
     * {@code urlFrom("   Mr John Smith   ")} will return {@code "Mr%20John%20Smith"}
     *
     * @param s String to URLfy.
     *
     * @return The String with all spaces replaced by {@code %20};
     */
    public static String urlFromWithRegex(String s) {
        if (s == null) {
            return null;
        }
        return s.trim().replaceAll(" +", "%20");
    }

    /**
     * Replaces all spaces in a string with {@code %20} without using regex.
     * <p>
     * Example:
     * <p>
     * {@code urlFrom("   Mr John Smith   ")} will return {@code "Mr%20John%20Smith"}
     *
     * @param s String to URLfy.
     *
     * @return The String with all spaces replaced by {@code %20};
     */
    public static String urlFrom(String s) {
        if (s == null) {
            return null;
        }
        String trimmed = s.trim();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < trimmed.length(); i++) {
            var c = trimmed.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
            i = newPointerIfSpaceChar(i, c, trimmed);
        }
        return sb.toString();
    }

    private static int newPointerIfSpaceChar(int i, char c, String s) {
        int prevI = i;
        while (c == ' ' && i < s.length()) {
            c = s.charAt(i++);
        }
        if (prevI != i) {
            i -= 2;
        }
        return i;
    }
}
