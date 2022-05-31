package com.lealceldeiro.commonword;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public final class CommonWordController {
    private CommonWordController() {
    }

    /**
     * Finds and returns the most common word in a {@code string} which is not present in a {@code bannedWordsString}.
     * The most common word is the one which is repeated the most throughout the whole string. Words are separated by a
     * space or a comma in the string. The search for the word must be case-insensitive.
     *
     * @param transcript                String containing a transcript with the words separated by space or comma.
     * @param bannedWordsFromTranscript String containing a list of the words which are banned and should not be considered as
     *                                  most common words, separated by space or comma.
     *
     * @return A {@link String} with the most common word as per the previous description or null either if there are no
     * words in the string or all of them are banned.
     */
    public static String findMostCommonWordIn(String transcript, String bannedWordsFromTranscript) {
        var regex = "\\W";
        var english = Locale.ENGLISH;
        var bannedWords = Arrays.stream(bannedWordsFromTranscript.toLowerCase(english).split(regex))
                                .collect(Collectors.toSet());
        var words = transcript.toLowerCase(english).split(regex);

        String mostCommonWord = null;
        int mostCommonWordCount = 0;
        Map<String, Integer> countByWord = new HashMap<>();

        for (var word : words) {
            if (!bannedWords.contains(word)) {
                int wordCount = countByWord.computeIfAbsent(word, wordAsKey -> 0) + 1;
                countByWord.put(word, wordCount);

                if (mostCommonWordCount < wordCount) {
                    mostCommonWordCount = wordCount;
                    mostCommonWord = word;
                }
            }
        }

        return mostCommonWord;
    }
}
