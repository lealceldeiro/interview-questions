package com.lealceldeiro.treeheight;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TreeControllerTest {
    private static Stream<Arguments> getTreeHeightSrc() {
        return Stream.of(
                arguments(-1, null),
                arguments(0, new Node<>("")),
                arguments(1, new Node<>("", new Node<>(""), null)),
                arguments(1, new Node<>("", null, new Node<>(""))),
                arguments(1, new Node<>("", new Node<>(""), new Node<>(""))),
                arguments(2, new Node<>("", new Node<>(""), new Node<>("", new Node<>(""), null)))
                        );
    }

    @ParameterizedTest
    @MethodSource("getTreeHeightSrc")
    void getTreeHeight(int expected, Node<?> rootNode) {
        assertEquals(expected, TreeController.getTreeHeight(rootNode));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 9})
    void nodeGetDataReturnsOK(int data) {
        assertEquals(data, new Node<>(data).getData());
    }
}