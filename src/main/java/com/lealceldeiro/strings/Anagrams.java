package com.lealceldeiro.strings;

import java.util.HashMap;
import java.util.Map;

final class Anagrams {
    Anagrams() {
    }

    /**
     * Two strings are anagrams of each other if the first string's letters can be rearranged to form the second
     * string. In other words, both strings must contain the same exact letters in the same exact frequency. This
     * method returns the minimum number of character deletions required to make two strings anagrams.
     *
     * <p>For example, {@code bacdc} and {@code dcbac} are anagrams, but {@code bacdc} and {@code dcbad} are not.</p>
     *
     * @param a First string.
     * @param b Second string.
     * @return An int, the minimum number of character deletions required to make the two strings arguments anagrams.
     */

    static int makeAnagram(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char c : a.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        return count.values().stream().mapToInt(Integer::intValue).map(Math::abs).sum();
    }
}
