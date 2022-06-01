package com.lealceldeiro.linkedlist;

public class MLinkedList<E> {
    private static class MNode<E> {
        E data;
        MNode<E> next;

        MNode(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
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
        if (n == 0 || head == null) {
            return null;
        }
        MNode<E> slow = head;
        MNode<E> fast = head;

        while (n-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static <T> MLinkedList<T> of(T... values) {
        MLinkedList<T> linkedList = new MLinkedList<>();
        for (T e : values) {
            linkedList.add(e);
        }
        return linkedList;
    }

    @Override
    public String toString() {
        StringBuilder elements = new StringBuilder();
        MNode<E> node = head;
        while (node != null) {
            elements.append(node);
            node = node.next;
        }
        return "[" + elements + "]";
    }
}
