package com.lealceldeiro.stacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MStackTest {
    @Test
    void test1MStack() {
        MStack stack = new MStack(5);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(5);

        assertEquals(5, stack.getMax());
        assertEquals(5, stack.peek());
        assertEquals(5, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(1, stack.peek());
        assertEquals(1, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());

        assertNull(stack.getMax());
        assertNull(stack.peek());
        assertNull(stack.pop());
    }

    @Test
    void test2MStack() {
        MStack stack = new MStack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(100);
        stack.push(5);
        stack.push(100);
        stack.push(-1);
        stack.push(30);
        stack.push(36);

        assertEquals(36, stack.pop());
        assertEquals(30, stack.pop());
        assertEquals(-1, stack.pop());

        Random random = new SecureRandom();
        var top = random.nextInt(10);
        for (int i = 0; i < top; i++) {
            assertEquals(100, stack.peek());
        }

        assertEquals(100, stack.pop());

        for (int i = 0; i < top; i++) {
            assertEquals(100, stack.getMax());
            assertEquals(5, stack.peek());
        }

        assertEquals(5, stack.pop());

        assertEquals(100, stack.getMax());
        assertEquals(100, stack.peek());
        assertEquals(100, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());

        assertEquals(4, stack.getMax());
        assertEquals(4, stack.peek());
        assertEquals(4, stack.pop());

        assertEquals(3, stack.getMax());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());

        assertEquals(2, stack.getMax());
        assertEquals(2, stack.peek());
        assertEquals(2, stack.pop());
    }

    @Test
    void test3MStack() {
        MStack stack = new MStack(5);

        stack.push(1);
        assertEquals(1, stack.getMax());
        assertEquals(1, stack.peek());

        stack.push(-1);
        assertEquals(1, stack.getMax());
        assertEquals(-1, stack.peek());

        stack.push(10);
        assertEquals(10, stack.getMax());
        assertEquals(10, stack.peek());

        stack.push(6);
        assertEquals(10, stack.getMax());
        assertEquals(6, stack.peek());

        stack.push(9);
        assertEquals(10, stack.getMax());
        assertEquals(9, stack.peek());

        stack.push(11);
        assertEquals(11, stack.getMax());
        assertEquals(11, stack.peek());
        assertEquals(11, stack.pop());

        stack.push(9);
        assertEquals(10, stack.getMax());
        assertEquals(9, stack.peek());
    }
}