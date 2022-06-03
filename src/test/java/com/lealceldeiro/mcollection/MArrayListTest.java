package com.lealceldeiro.mcollection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MArrayListTest {
    @Test
    void add() {
        MArrayList<String> arrayList = new MArrayList<>(0);
        arrayList.add("a");
        arrayList.add("b");
        assertEquals(2, arrayList.getSize());
    }

    @Test
    void add2() {
        MArrayList<String> arrayList = new MArrayList<>(1);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        assertEquals(3, arrayList.getSize());
    }

    @Test
    void add3() {
        MArrayList<String> arrayList = new MArrayList<>(100);
        assertEquals(0, arrayList.getSize());
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("2");

        assertEquals(4, arrayList.getSize());
    }
}