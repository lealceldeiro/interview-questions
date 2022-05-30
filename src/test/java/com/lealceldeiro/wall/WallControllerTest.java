package com.lealceldeiro.wall;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WallControllerTest {
    private static Stream<Arguments> canWeBuildAWallOfSizeFromTestCases() {
        return Stream.of(
                arguments(0, 0, 0, true),
                arguments(1, 0, 0, true),
                arguments(0, 1, 0, true),
                arguments(0, 0, 1, false),
                arguments(1, 0, 4, false),
                arguments(1, 0, 5, true),
                arguments(1, 0, 6, false),
                arguments(0, 1, 1, true),
                arguments(0, 1, 2, false),
                arguments(1, 1, 4, false),
                arguments(1, 1, 6, true),
                arguments(1, 1, 7, false),
                arguments(1, 1, 5, true),
                arguments(1, 1, 1, true)
                        );
    }

    @ParameterizedTest
    @MethodSource("canWeBuildAWallOfSizeFromTestCases")
    void canWeBuildAWallOfSizeFrom(int availableBigBrick, int availableSmallBrick, int wallSize, boolean expected) {
        assertEquals(expected,
                     WallController.canWeBuildAWallOfSizeFrom(availableBigBrick, availableSmallBrick, wallSize));
    }

    private static Stream<Arguments> getNumberOfRequiredBricksToBuildAWallOfSize() {
        int bbSize = 10;
        int sbSize = 7;
        return Stream.of(
                arguments(bbSize, sbSize, 0, arr(0, 0)),
                arguments(bbSize, sbSize, 1, arr(-1, -1)),
                arguments(bbSize, sbSize, 2, arr(-1, -1)),
                arguments(bbSize, sbSize, 6, arr(-1, -1)),
                arguments(bbSize, sbSize, 7, arr(0, 1)),
                arguments(bbSize, sbSize, 8, arr(-1, -1)),
                arguments(bbSize, sbSize, 10, arr(1, 0)),
                arguments(bbSize, sbSize, 11, arr(-1, -1)),
                arguments(bbSize, sbSize, 12, arr(-1, -1)),
                arguments(bbSize, sbSize, 13, arr(-1, -1)),
                arguments(bbSize, sbSize, 14, arr(0, 2)),
                arguments(bbSize, sbSize, 17, arr(1, 1)),
                arguments(bbSize, sbSize, 18, arr(-1, -1)),
                arguments(bbSize, sbSize, 19, arr(-1, -1)),
                arguments(bbSize, sbSize, 20, arr(2, 0)),
                arguments(bbSize, sbSize, 24, arr(1, 2)),
                arguments(bbSize, sbSize, 27, arr(2, 1)),
                arguments(bbSize, sbSize, 49, arr(0, 7)),
                arguments(bbSize, sbSize, 100, arr(10, 0))
                        );
    }

    private static int[] arr(int... v) {
        return v;
    }

    @ParameterizedTest
    @MethodSource("getNumberOfRequiredBricksToBuildAWallOfSize")
    void getNumberOfRequiredBricksToBuildAWallOfSize(int bigBrickSize, int smallBrickSize, int wallSize, int[] result) {
        var actual = WallController.getNumberOfRequiredBricksToBuildAWallOfSize(bigBrickSize, smallBrickSize, wallSize);
        assertArrayEquals(result,
                          actual, "Expected: " + Arrays.toString(result) + ", Actual: " + Arrays.toString(actual));
    }
}