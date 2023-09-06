package com.lealceldeiro.queue;

public final class Queue<E> {
    private final E[] elements;
    private final E nullValue;
    private int count;
    private int tailIndex;
    private int headIndex;

    public Queue(int capacity) {
        this(capacity, null);
    }

    public Queue(int capacity, E nullValue) {
        this.nullValue = nullValue;
        this.elements = (E[]) new Object[capacity];
        count = 0;
    }

    public E add(E element) {
        if (isFull()) {
            throw new FullException();
        }
        elements[tailIndex] = element;
        tailIndex = nextIndex(tailIndex);
        ++count;
        return element;
    }

    private int nextIndex(int index) {
        return (index + 1) % elements.length;
    }

    public E remove() {
        if (isEmpty()) {
            throw new EmptyException();
        }
        E e = elements[headIndex];
        elements[headIndex] = nullValue;
        headIndex = nextIndex(headIndex);
        --count;
        return e;
    }

    public E peek() {
        return isEmpty() ? nullValue : elements[headIndex];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return count;
    }

    public boolean isFull() {
        return size() == elements.length;
    }

    public static class EmptyException extends RuntimeException {
    }

    public static class FullException extends RuntimeException {
    }
}
