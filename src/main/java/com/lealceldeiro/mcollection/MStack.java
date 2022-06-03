package com.lealceldeiro.mcollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Custom Stack of integer where the 'max' element can be retrieved in O(1).
 */
public class MStack {
    private List<Integer> values;
    private LinkedList<Integer> minToMax;

    public MStack(int capacity) {
        values = new ArrayList<>(capacity);
        minToMax = new LinkedList<>();
    }

    public void push(Integer e) {
        if (values.isEmpty()) {
            minToMax.add(e);
        } else {
            int i = 0;
            for (Integer max : minToMax) {
                if (max > e) {
                    break;
                }
                i++;
            }
            minToMax.add(i, e);
        }
        values.add(e);
    }

    public Integer peek() {
        return values.isEmpty() ? null : values.get(values.size() - 1);
    }
    public Integer pop() {
        if (values.isEmpty()) {
            return null;
        }
        Integer removed = values.remove(values.size() - 1);
        minToMax.remove(removed);
        return removed;
    }

    public Integer getMax() {
        return values.isEmpty() ? null : minToMax.getLast();
    }
}
