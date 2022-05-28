package main.java.excersices.treeheight;

public final class Node<E> {
    private final Node<E> left;
    private final Node<E> right;
    private final E data;

    public Node(E data) {
        this(data, null, null);
    }

    public Node(E data, Node<E> left, Node<E> right) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    Node<E> getLeft() {
        return left;
    }

    Node<E> getRight() {
        return right;
    }

    public E getData() {
        return data;
    }
}
