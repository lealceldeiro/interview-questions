package main.java.excersices.commonword;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CommonWordController {
    private CommonWordController() {
    }

    /**
     * Finds and returns the most common word in a {@code string} which is not present in a {@code bannedWordsString}.
     * The most common word is the one which is repeated the most throughout the whole string. Words are separated by a
     * space or a comma in the string. The search for the word must be case insensitive.
     *
     * @param string            String containing a transcript with the words separated by space or comma.
     * @param bannedWordsString String containing a list of the words which are banned and should not be considered as
     *                          most common words, separated by space or comma.
     * @return A {@link String} with the most common word as per the previous description or null either if there are no
     * words in the string or all of them are banned.
     */
    public static String findMostCommonWordIn(String string, String bannedWordsString) {
        String regex = "\\W";

        Set<String> bannedWordsSet = new HashSet<>();
        Collections.addAll(bannedWordsSet, bannedWordsString.toLowerCase(Locale.ENGLISH).split(regex));

        String mostCommonWord = null;
        int numberOfMostRepetitions = 0;
        Map<String, Integer> appearancesByWord = new HashMap<>();

        String[] words = string.toLowerCase(Locale.ENGLISH).split(regex);

        for (String word : words) {
            if (!bannedWordsSet.contains(word)) {
                int numberOfAppearances = appearancesByWord.computeIfAbsent(word, wordAsKey -> 0) + 1;
                appearancesByWord.put(word, numberOfAppearances);

                if (numberOfMostRepetitions < numberOfAppearances) {
                    numberOfMostRepetitions = numberOfAppearances;
                    mostCommonWord = word;
                }
            }
        }

        return mostCommonWord;
    }

}
