package com.lealceldeiro.circulararray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularList<E> implements Iterable<E> {
    private List<E> values;

    public CircularList(int capacity) {
        this.values = new ArrayList<>(capacity);
    }

    @SafeVarargs
    public CircularList(E... values) {
        this.values = new ArrayList<>(List.of(values));
    }

    public E get(int i) {
        return values.get(i);
    }

    public E set(int i, E value) {
        return values.set(i, value);
    }

    public void rotate(int number) {
        int i = 0;
        while (!values.isEmpty() && i++ < number % values.size()) {
            values.add(0, values.remove(values.size() - 1));
        }
    }

    public static void print(CircularList<?> collection) {
        for (Object e : collection) {
            System.out.print(e.toString() + " ");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return values.listIterator();
    }
}
