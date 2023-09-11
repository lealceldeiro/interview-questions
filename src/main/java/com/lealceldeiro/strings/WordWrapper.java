package com.lealceldeiro.strings;

public final class WordWrapper {
    private static final String br = "\n";

    private WordWrapper() {
    }

    /**
     * Given a string of text without any line breaks, inserts appropriate line breaks so that the text
     * will fit in a column {@code width} characters wide. It breaks at words if at all possible.
     *
     * @param text  Text without line breaks.
     * @param width Line width.
     */
    public static String wrap(String text, int width) {
        if (text == null) {
            return null;
        }
        if (text.length() <= width) {
            return text;
        }
        int lastSpaceIndex = text.lastIndexOf(" ", width);
        lastSpaceIndex = lastSpaceIndex != -1 ? lastSpaceIndex : width;
        return text.substring(0, lastSpaceIndex).trim() + br + wrap(text.substring(lastSpaceIndex).trim(), width);
    }
}
