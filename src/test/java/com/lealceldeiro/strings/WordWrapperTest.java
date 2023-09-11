package com.lealceldeiro.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.lealceldeiro.strings.WordWrapper.wrap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordWrapperTest {
    private static Stream<Arguments> testWrapSrc() {
        return Stream.of(
                arguments(null, 1, null),
                arguments("", 1, ""),
                arguments("x", 1, "x"),
                arguments("xx", 1, "x\nx"),
                arguments("xx", 2, "xx"),
                arguments("xxx", 1, "x\nx\nx"),
                arguments("xxx", 2, "xx\nx"),
                arguments("xxx", 3, "xxx"),
                arguments("x x", 1, "x\nx"),
                arguments("x x", 2, "x\nx"),
                arguments("x x", 3, "x x"),
                arguments("x x x", 1, "x\nx\nx"),
                arguments("x x x", 2, "x\nx\nx"),
                arguments("x x x", 3, "x x\nx"),
                arguments("x x x", 4, "x x\nx"),
                arguments("x x x", 5, "x x x"),
                arguments("xx xx", 5, "xx xx"),
                arguments("xx xx xx", 1, "x\nx\nx\nx\nx\nx"),
                arguments("xx xx xx", 2, "xx\nxx\nxx"),
                arguments("xx xx xx", 3, "xx\nxx\nxx"),
                arguments("xx xx xx", 4, "xx\nxx\nxx"),
                arguments("xx xx xx", 5, "xx xx\nxx"),
                arguments("xx xx xx", 6, "xx xx\nxx"),
                arguments("xx xx xx", 7, "xx xx\nxx"),
                arguments("xx xx xx", 8, "xx xx xx"),

                arguments("xx xx", 1, "x\nx\nx\nx"),
                arguments("xx xx", 2, "xx\nxx"),
                arguments("xx xx", 3, "xx\nxx"),
                arguments("xx xx", 4, "xx\nxx"),
                arguments("Four", 7, "Four"),
                arguments("Four score", 7, "Four\nscore"),
                arguments("Four score and seven years ago our", 7,
                        "Four\nscore\nand\nseven\nyears\nago our"),
                arguments("to the", 7, "to the"),
                arguments(
                        "Four score and seven years ago our fathers brought forth upon this continent a new nation conceived in liberty and dedicated to the proposition that all men are created equal",
                        15,
                        "Four score and\nseven years ago\nour fathers\nbrought forth\nupon this\ncontinent a new\nnation\nconceived in\nliberty and\ndedicated to\nthe proposition\nthat all men\nare created\nequal"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testWrapSrc")
    void testWrap(String text, int lineLength, String expected) {
        assertEquals(expected, wrap(text, lineLength));
    }
}
