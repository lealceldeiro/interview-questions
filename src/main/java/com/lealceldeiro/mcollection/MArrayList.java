package com.lealceldeiro.mcollection;

import java.util.Arrays;

public class MArrayList<E> {
    private E[] values;
    private int size;

    public MArrayList(int initialCapacity) {
        this.values = (E[]) new Object[initialCapacity];
        this.size = 0;
    }

    public void add(E s) {
        if (size == values.length) {
             values = Arrays.copyOf(values, (values.length + 1) * 2);
        }
        values[size] = s;
        size++;
    }

    public int getSize() {
        return size;
    }
}
