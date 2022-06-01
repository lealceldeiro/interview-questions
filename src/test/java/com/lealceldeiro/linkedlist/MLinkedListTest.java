package com.lealceldeiro.linkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MLinkedListTest {

    @Test
    void add() {
        MLinkedList<Integer> linkedList = new MLinkedList<>();
        linkedList.add(5);

        assertEquals(5, linkedList.nElementFromTail(1));
    }

    private static Stream<Arguments> nElementFromTailSrc() {
        Random random = new SecureRandom();
        var size = random.nextInt(10000);
        var nElementFromTail = random.nextInt(size);

        String expected = null;
        MLinkedList<String> randomList = new MLinkedList<>();
        for (int i = 1; i <= size; i++) {
            var value = String.valueOf(i);
            randomList.add(value);
            if (size - nElementFromTail + 1 == i) {
                expected = value;
            }
        }

        return Stream.of(
                arguments(MLinkedList.of(), 0, null),
                arguments(MLinkedList.of(), 1, null),
                arguments(MLinkedList.of(7), 0, null),
                arguments(MLinkedList.of(7), 1, 7),
                arguments(MLinkedList.of(7), 2, null),
                arguments(MLinkedList.of(9, 7), 2, 9),
                arguments(randomList, nElementFromTail, expected)
                        );
    }

    @ParameterizedTest
    @MethodSource("nElementFromTailSrc")
    void nElementFromTail(MLinkedList<Object> list, int n, Object expected) {
        assertEquals(expected, list.nElementFromTail(n), "MList: " + list + ", n: " + n +  ", expected: " + expected);
    }
}