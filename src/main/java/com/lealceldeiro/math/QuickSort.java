package com.lealceldeiro.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class QuickSort {
    private QuickSort() {
    }

    public static void sort(int[] array) {
        List<Integer> sorted = sort(Arrays.stream(array).boxed().toList());
        for (int i = 0; i < sorted.size(); i++) {
            array[i] = sorted.get(i);
        }
    }

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) {
            return new ArrayList<>(list);
        }

        int pivot = list.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> same = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();
        for (Integer e : list) {
            if (e < pivot) {
                lower.add(e);
            } else if (e > pivot) {
                higher.add(e);
            } else {
                same.add(e);
            }
        }
        List<Integer> sorted = new ArrayList<>(sort(lower));
        sorted.addAll(same);
        sorted.addAll(sort(higher));

        return sorted;
    }
}
