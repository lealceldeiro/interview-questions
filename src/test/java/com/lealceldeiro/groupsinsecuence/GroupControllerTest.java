package com.lealceldeiro.groupsinsecuence;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GroupControllerTest {
    private static Stream<Arguments> getLengthOfLargestGroupInSequenceSrc() {
        return Stream.of(
                arguments(0, arr()),
                arguments(0, arr(1)),
                arguments(2, arr(1, 1)),
                arguments(2, arr(5, 1, 1)),
                arguments(0, arr(1, 5, 1)),
                arguments(2, arr(1, 1, 5)),
                arguments(2, arr(1, 1, 5, 5)),
                arguments(2, arr(3, 1, 1, 5, 5)),
                arguments(2, arr(1, 1, 3, 5, 5)),
                arguments(3, arr(1, 1, 5, 5, 3, 3, 3))
                         );
    }
    private static Integer[] arr(Integer... v) {
        return v;
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLargestGroupInSequenceSrc")
    void getLengthOfLargestGroupInSequence(int expectedLength, Integer[] sequence) {
        assertEquals(expectedLength, GroupController.getLengthOfLargestGroupInSequence(sequence));
    }

    private static Stream<Arguments> getNumberOfGroupsInSequenceSrc() {
        return Stream.of(
                arguments(0, arr()),
                arguments(0, arr(1)),
                arguments(1, arr(1, 1)),
                arguments(1, arr(5, 1, 1)),
                arguments(0, arr(1, 5, 1)),
                arguments(1, arr(1, 1, 5)),
                arguments(2, arr(1, 1, 5, 5)),
                arguments(2, arr(3, 1, 1, 5, 5)),
                arguments(2, arr(1, 1, 3, 5, 5)),
                arguments(2, arr(1, 1, 5, 5, 3)),
                arguments(3, arr(1, 1, 5, 5, 3, 3)),
                arguments(3, arr(1, 1, 5, 5, 3, 3, 3))
                        );
    }

    @ParameterizedTest
    @MethodSource("getNumberOfGroupsInSequenceSrc")
    void getNumberOfGroupsInSequence(int expectedNumber, Integer[] sequence) {
        assertEquals(expectedNumber, GroupController.getNumberOfGroupsInSequence(sequence));
    }

    private static Stream<Arguments> getNumberOfGroupsOfCustomSizeInSequenceWithLengthSrc() {
        return Stream.of(
                arguments(0, 0, arr()),
                arguments(1, 0, arr(1)),
                arguments(1, 0, arr(1, 1)),
                arguments(2, 0, arr(1, 1, 5)),
                arguments(3, 0, arr(1, 5, 1)),

                arguments(0, 1, arr()),
                arguments(1, 1, arr(1)),
                arguments(1, 1, arr(1, 1, 1)),

                arguments(0, 2, arr(1)),
                arguments(1, 2, arr(1, 1)),
                arguments(1, 2, arr(1, 1, 5)),
                arguments(0, 3, arr(1, 1)),
                arguments(1, 3, arr(1, 1, 1)),
                arguments(1, 3, arr(4, 1, 1, 1)),
                arguments(0, 3, arr(1, 4, 1, 1)),
                arguments(0, 3, arr(1, 1, 4, 1)),
                arguments(1, 3, arr(1, 1, 1, 4)),
                arguments(2, 3, arr(1, 1, 1, 4, 4, 4)),
                arguments(2, 3, arr(7, 1, 1, 1, 4, 4, 4)),
                arguments(2, 3, arr(1, 1, 1, 4, 4, 4, 7)),
                arguments(1, 3, arr(1, 1, 7, 1, 4, 4, 4)),
                arguments(1, 3, arr(1, 1, 1, 4, 7, 4, 4))
                        );
    }

    @ParameterizedTest
    @MethodSource("getNumberOfGroupsOfCustomSizeInSequenceWithLengthSrc")
    void getNumberOfGroupsOfCustomSizeInSequence(int expectedNumberOfGroups, int size, Integer[] sequence) {
        assertEquals(expectedNumberOfGroups, GroupController.getNumberOfGroupsInSequence(size, sequence));
    }
}