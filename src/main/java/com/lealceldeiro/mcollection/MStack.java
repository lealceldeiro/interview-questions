package com.lealceldeiro.mcollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom Stack of integer where the 'max' element can be retrieved in O(1).
 */
public class MStack {
    private List<Integer> values;
    private List<Integer> orderedValues;

    public MStack(int capacity) {
        values = new ArrayList<>(capacity);
        orderedValues = new ArrayList<>(capacity);
    }

    public void push(Integer e) {
        var maxPosition = elementPositionInOrderedValues(e, 0, orderedValues.size() - 1);
        orderedValues.add(maxPosition, e);
        values.add(e);
    }

    private int elementPositionInOrderedValues(Integer e, int start, int end) {
        if (orderedValues.isEmpty()) {
            return 0;
        }
        if (start >= end) {
            return orderedValues.get(start) > e ? start : start + 1;
        }

        int middle = start + (end - start) / 2;
        return orderedValues.get(middle) > e
               ? elementPositionInOrderedValues(e, start, middle - 1)
               : elementPositionInOrderedValues(e, middle + 1, end);
    }

    public Integer peek() {
        return values.isEmpty() ? null : values.get(values.size() - 1);
    }

    public Integer pop() {
        if (values.isEmpty()) {
            return null;
        }
        Integer removed = values.remove(values.size() - 1);
        orderedValues.remove(removed);
        return removed;
    }

    public Integer getMax() {
        return orderedValues.isEmpty() ? null : orderedValues.get(orderedValues.size() - 1);
    }
}
