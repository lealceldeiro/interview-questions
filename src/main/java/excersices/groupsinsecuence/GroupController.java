package main.java.excersices.groupsinsecuence;

public final class GroupController {
    private GroupController() {
    }

    /**
     * Returns the length of the largest group of numbers in a given sequence. A group is any subsequence of 2 or more
     * equals numbers. i.e.: in the sequence {@code 1,2,2,3,7,7,4,4,4,3} there are 3 groups {@code 2,2}, {@code 7,7,7}
     * and {@code 4,4,4} and the largest length of these three groups is {@code 3} (from {@code 7,7,7}).
     *
     * @param sequence Sequence of numbers.
     * @return An {@code int} indicating the length of the largest group.
     */
    public static int getLengthOfLargestGroupInSequence(int... sequence) {
        int lengthOfLargestGroup = 0;

        int i = 0;
        while (i < sequence.length) {
            int lengthOfNthGroup = 0;

            while (i < sequence.length - 1 && sequence[i] == sequence[i + 1]) {
                lengthOfNthGroup++;
                i++;
            }

            if (lengthOfLargestGroup < lengthOfNthGroup) {
                lengthOfLargestGroup = lengthOfNthGroup;
            }
            i++;
        }

        return lengthOfLargestGroup == 0 ? 0 : lengthOfLargestGroup + 1;
    }

    /**
     * Returns the number of groups of numbers in a given sequence. A group is any subsequence of 2 or more
     * equals numbers. i.e.: in the sequence {@code 1,2,2,3,7,7,4,4,4,3} there are 3 groups {@code 2,2}, {@code 7,7,7}
     * and {@code 4,4,4}.
     *
     * @param sequence Sequence of numbers.
     * @return An {@code int} indicating the number of groups.
     */
    public static int getNumberOfGroupsInSequence(int... sequence) {
        int numberOfGroups = 0;

        int i = 0;
        while (i < sequence.length) {
            int previousIndex = i;

            while (i < sequence.length - 1 && sequence[i] == sequence[i + 1]) {
                i++;
            }

            if (previousIndex != i) {
                numberOfGroups++;
            }
            i++;
        }

        return numberOfGroups;
    }

    /**
     * Returns the number of groups of numbers of a given {@code groupSize} in a given sequence. A group is any
     * subsequence of {@code groupSize} or more equals numbers. i.e.: for a given {@code groupSize 4} in the sequence
     * {@code 1,2,2,2,2,3,2,7,7,4,4,4,4,4,4,3} there are 2 groups {@code 2,2,2,2} and {@code 4,4,4,4,4,4}.
     *
     * @param groupSize Min number of consecutive equals numbers in the sequence, so they can be count as a group.
     * @param sequence  Sequence of numbers.
     * @return An {@code int} indicating the number of groups.
     */
    public static int getNumberOfGroupsOfCustomSizeInSequence(int groupSize, int... sequence) {
        int numberOfGroups = 0;

        int i = 0;
        while (i < sequence.length) {
            int previousIndex = i;

            while (i < sequence.length - 1 && sequence[i] == sequence[i + 1]) {
                i++;
            }
            i++;

            if (i - previousIndex >= groupSize) {
                numberOfGroups++;
            }
        }

        return numberOfGroups;
    }

}
