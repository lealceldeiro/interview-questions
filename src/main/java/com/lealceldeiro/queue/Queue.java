package com.lealceldeiro.queue;

public final class Queue<T> {
    private final T[] elements;
    private final T nullValue;
    private int count;
    private int tailIndex;
    private int headIndex;

    public Queue(int capacity) {
        this(capacity, null);
    }

    public Queue(int capacity, T nullValue) {
        this.nullValue = nullValue;
        this.elements = (T[]) new Object[capacity];
        count = 0;
    }

    public T push(T element) {
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

    public T pop() {
        if (isEmpty()) {
            throw new EmptyException();
        }
        T e = elements[headIndex];
        elements[headIndex] = nullValue;
        headIndex = nextIndex(headIndex);
        --count;
        return e;
    }

    public T peek() {
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
