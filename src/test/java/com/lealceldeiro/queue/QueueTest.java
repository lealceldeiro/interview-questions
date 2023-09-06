package com.lealceldeiro.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private final Queue<Integer> queue = new Queue<>(99);

    @Test
    void newlyCreatedQueueIsEmpty() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void pushingOneElementReturnsTheElement() {
        assertEquals(1, queue.push(1));
    }

    @Test
    void afterPushingOneElementTheQueueIsNotEmpty() {
        queue.push(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    void pushAndPopReturnsTheElement() {
        queue.push(1);
        assertEquals(1, queue.pop());
    }

    @Test
    void afterPushingOneElementAndPoppingItTheQueueIsEmpty() {
        queue.push(23);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        queue.pop();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void popReturnsTheElement() {
        queue.push(99);
        assertEquals(99, queue.pop());
    }

    @Test
    void poppingAnEmptyQueueThrowsEmptyException() {
        assertThrows(Queue.EmptyException.class, new Queue<>(0)::pop);
    }

    @Test
    void pushingAFullQueueThrowsFullException() {
        Queue<Integer> fullQueue = new Queue<>(3);
        fullQueue.push(77);
        fullQueue.push(88);
        fullQueue.push(99);
        assertThrows(Queue.FullException.class, () -> fullQueue.push(11));
    }

    @Test
    void peekingAnEmptyQueueReturnsNull() {
        assertNull(queue.peek());
    }

    @Test
    void peekDoesNotRemoveTheElement() {
        queue.push(99);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        assertNotNull(queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    void newlyCreatedQueueWithCapacityIsNotFull() {
        assertFalse(queue.isFull());
    }

    @Test
    void newlyCreatedQueueWithoutCapacityReturnsFull() {
        assertTrue(new Queue<Integer>(0).isFull());
    }

    @Test
    void afterPushing1And2And3ThenPoppingReturns1And2And3() {
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        assertEquals(3, queue.pop());
    }

    @Test
    void afterPushingXAndYAndZThenPeekingReturnsX() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(99);
        queue.push(88);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
    }

    @Test
    void afterPushingXAndYAndZThenPoppingReturnsReturnsXAndPeekingReturnsY() {
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(99);
        queue.push(88);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.pop());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.peek());
    }
}
