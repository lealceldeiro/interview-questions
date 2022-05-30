package com.lealceldeiro.linkedlist;

public class MLinkedList<E> {
    private static class MNode<E> {
        E data;
        MNode<E> next;

        MNode(E data) { this.data = data; }
    }
    private MNode<E> head;

    public void add(E e) {
        MNode<E> node = new MNode<>(e);
        if (head == null) {
            head = node;
        } else {
            MNode<E> n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    public E nElementFromTail(int n) {
        if (head == null) {
            return null;
        }
        MNode<E> p1 = head;
        MNode<E> p2 = head;
        int i = n;

        while (i-- > 0) {
            p2 = p2.next;
            if (p2 == null) { return null; }
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1.data;
    }
}
