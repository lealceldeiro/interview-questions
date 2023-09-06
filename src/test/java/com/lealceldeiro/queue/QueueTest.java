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
    void addingOneElementReturnsTheElement() {
        assertEquals(1, queue.add(1));
    }

    @Test
    void afterAddingOneElementTheQueueIsNotEmpty() {
        queue.add(1);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
    }

    @Test
    void addAndRemoveReturnsTheElement() {
        assertEquals(1, queue.add(1));
        assertEquals(1, queue.remove());
    }

    @Test
    void afterAddingOneElementAndRemovingItTheQueueIsEmpty() {
        queue.add(23);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        queue.remove();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void removeReturnsTheElement() {
        queue.add(99);
        assertEquals(99, queue.remove());
    }

    @Test
    void removingAnEmptyQueueThrowsEmptyException() {
        assertThrows(Queue.EmptyException.class, new Queue<>(0)::remove);
    }

    @Test
    void addingAFullQueueThrowsFullException() {
        Queue<Integer> fullQueue = new Queue<>(3);
        fullQueue.add(77);
        fullQueue.add(88);
        fullQueue.add(99);
        assertThrows(Queue.FullException.class, () -> fullQueue.add(11));
    }

    @Test
    void peekingAnEmptyQueueReturnsNull() {
        assertNull(queue.peek());
    }

    @Test
    void peekDoesNotRemoveTheElement() {
        queue.add(99);
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
    void afterAdding1And2And3ThenRemovingReturns1And2And3() {
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertEquals(3, queue.remove());
    }

    @Test
    void afterAddingXAndYAndZThenPeekingReturnsX() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(99);
        queue.add(88);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
        assertEquals(1, queue.peek());
    }

    @Test
    void afterAddingXAndYAndZThenRemovingReturnsReturnsXAndPeekingReturnsY() {
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(99);
        queue.add(88);

        assertEquals(1, queue.peek());
        assertEquals(1, queue.remove());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.peek());
        assertEquals(2, queue.peek());
    }
}
