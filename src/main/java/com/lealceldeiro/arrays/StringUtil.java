package com.lealceldeiro.arrays;

import java.util.Collection;
import java.util.HashSet;

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
}
