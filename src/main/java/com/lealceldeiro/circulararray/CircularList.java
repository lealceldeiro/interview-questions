package com.lealceldeiro.circulararray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CircularList<E> implements Iterable<E> {
    private List<E> values;
    private Class<?> type;

    public CircularList(Class<?> type) {
        this(type, 0);
    }

    public CircularList(Class<?> type, int capacity) {
        this.type = type;
        this.values = new ArrayList<>(capacity);
    }

    @SafeVarargs
    public CircularList(E... values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("For an empty collection you must specify the type");
        }
        type = values[0].getClass();
        this.values = new ArrayList<>();
        this.values.addAll(Arrays.asList(values));
    }

    public E[] getValues() {
        @SuppressWarnings("unchecked")
        E[] ref = (E[]) Array.newInstance(type, 0);
        return values.toArray(ref);
    }

    public E get(int i) {
        return values.get(i);
    }

    public E set(int i, E value) {
        return values.set(i, value);
    }
    public int size() {
        return values.size();
    }

    public void rotate(int number) {
        if (values.isEmpty()) {
            return;
        }

        // if `values` is `1 2 3` and `number` is `1` it means the rotation direction is like this `<--`
        // so `2` moves to position `0`, `3` moves to position `1` and since `1` is at position `0` it has to go to
        // the first position from the last: `values.size() - 1`
        var isRightToLeftMovement = number > 0;
        int i = number % values.size();

        while (i != 0) {
            int removePos = isRightToLeftMovement ? 0 : values.size() - 1;
            int insertPos = isRightToLeftMovement ? values.size() - 1 : 0;
            values.add(insertPos, values.remove(removePos));
            i = isRightToLeftMovement ? i - 1 : i + 1;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return values.listIterator();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
