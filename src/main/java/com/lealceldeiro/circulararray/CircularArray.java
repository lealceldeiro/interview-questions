package com.lealceldeiro.circulararray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<E> implements Iterable<E> {
    private E[] values;
    private int head;

    public CircularArray(Class<?> type) {
        this(type, 0);
    }

    @SuppressWarnings("unchecked")
    public CircularArray(Class<?> type, int capacity) {
        this.values = (E[]) Array.newInstance(type, capacity);
    }

    @SafeVarargs
    public CircularArray(E... values) {
         if (values.length == 0) {
             throw new IllegalArgumentException("For an empty collection you must specify the type");
         }
        this.values = Arrays.copyOf(values, values.length);
    }

    public E[] getValues() {
        if (values.length <= 0) {
            return values.clone();
        }

        @SuppressWarnings("unchecked")
        E[] copy = (E[]) Array.newInstance(values[0].getClass(), values.length);
        for (int i = 0; i < values.length; i++) {
            copy[i] = get(i);
        }

        return copy;
    }

    public E get(int i) {
        if (i < 0 || i > values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[offsetIdx(i)];
    }

    public E set(int i, E value) {
        E prev = get(i);
        values[offsetIdx(i)] = value;

        return prev;
    }

    public int size() {
        return values.length;
    }

    public void rotate(int offset) {
        head = offsetIdx(offset);
    }

    private int offsetIdx(int offset) {
        if (offset < 0) {
            offset += values.length;
        }
        return values.length > 0 ? (head + offset) % values.length : 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new CIterator<>(this);
    }

    private static class CIterator<E> implements Iterator<E> {
        private final CircularArray<E> collection;
        private int current = -1;

        CIterator(CircularArray<E> collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return current < collection.getValues().length - 1;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return collection.get(++current);
        }
    }
}
