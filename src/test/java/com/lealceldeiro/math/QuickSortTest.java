package com.lealceldeiro.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.lealceldeiro.math.QuickSort.sort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {
    @Test
    void sortEmpty() {
        int[] array = array();
        sort(array());
        assertArrayEquals(array(), array, print(array));
    }

    @Test
    void sortOneElement() {
        var array = array(1);
        sort(array);
        assertArrayEquals(array(1), array, print(array));
    }

    @Test
    void sortTwoOrderedElements() {
        var array = array(1, 2);
        sort(array);
        assertArrayEquals(array(1, 2), array, print(array));
    }

    @Test
    void sortTwoUnorderedElements() {
        var array = array(2, 1);
        sort(array);
        assertArrayEquals(array(1, 2), array, print(array));
    }

    @Test
    void sortThreeOrderedElements() {
        var array = array(1, 2, 3);
        sort(array);
        assertArrayEquals(array(1, 2, 3), array, print(array));
    }

    @Test
    void sortThreeElementsFirstTwoUnordered() {
        var array = array(2, 1, 3);
        sort(array);
        assertArrayEquals(array(1, 2, 3), array, print(array));
    }

    @Test
    void sortThreeElementsLastTwoUnordered() {
        var array = array(1, 3, 2);
        sort(array);
        assertArrayEquals(array(1, 2, 3), array, print(array));
    }

    @Test
    void sortThreeElementsEdgesUnordered() {
        var array = array(3, 2, 1);
        sort(array);
        assertArrayEquals(array(1, 2, 3), array, print(array));
    }

    @Test
    void sortFourElementsOrdered() {
        var array = array(1, 2, 3, 4);
        sort(array);
        assertArrayEquals(array(1, 2, 3, 4), array, print(array));
    }

    @Test
    void sortFourElementsEdgesUnordered() {
        var array = array(4, 2, 3, 1);
        sort(array);
        assertArrayEquals(array(1, 2, 3, 4), array, print(array));
    }

    @Test
    void sortFourElementsUnordered() {
        var array = array(2, 4, 1, 3);
        sort(array);
        assertArrayEquals(array(1, 2, 3, 4), array, print(array));
    }

    @Test
    void sortElementsUnorderedAndRepeated() {
        var array = array(2, 4, 1, 1, 3, 3, 7, 0, 12, 12, 12, 12, 43, 54, 12, 76, 213);
        sort(array);
        assertArrayEquals(
                array(0, 1, 1, 2, 3, 3, 4, 7, 12, 12, 12, 12, 12, 43, 54, 76, 213),
                array,
                print(array)
        );
    }

    private static String print(int[] array) {
        return "Actual : " + Arrays.toString(array);
    }

    private static int[] array(int... values) {
        return values;
    }
}
