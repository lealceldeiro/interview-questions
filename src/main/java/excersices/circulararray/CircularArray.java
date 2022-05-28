package main.java.excersices.circulararray;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularArray<E> implements Iterable<E> {
    private E[] values;
    private int head;

    @SuppressWarnings("unchecked")
    public CircularArray(int capacity) {
        this.values = (E[]) new Object[capacity];
    }

    @SafeVarargs
    public CircularArray(E... values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    protected E[] getValues() {
        return values;
    }

    public E get(int i) {
        if (i < 0 || i > values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return values[offsetIdx(i)];
    }

    public E set(int i, E value) {
        if (i < 0 || i > values.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int pos = offsetIdx(i);

        E prev = values[pos];
        values[pos] = value;

        return prev;
    }

    public void rotate(int offset) {
        head = offsetIdx(offset);
    }

    private int offsetIdx(int offset) {
        if (offset < 0) {
            offset += values.length;
        }
        return (head + offset) % values.length;
    }

    public static void print(Iterable<?> collection) {
        for (Object e : collection) {
            System.out.print(e.toString() + " ");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CIterator<>(this);
    }

    private static class CIterator<E> implements Iterator<E> {
        CircularArray<E> collection;
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
