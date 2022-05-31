package com.lealceldeiro;

import com.lealceldeiro.circulararray.CircularArray;
import com.lealceldeiro.fibonacci.Fibonacci;
import com.lealceldeiro.linkedlist.MLinkedList;
import com.lealceldeiro.treeheight.Node;

import static com.lealceldeiro.treeheight.TreeController.getTreeHeight;
import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;

/**
 * This class is only the program runner. To see the implementation logic for each problem see the other classes in each
 * independent packages.
 */
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            err.println("Select a number from 1 to 11 to run an algorithm");
            exit(1);
        }
        int option = 1;
        try {
            option = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            err.println("The option must be a number");
            exit(1);
        }

        switch (option) {
            case 7:
                runTreeHeightProblem();
                break;
            case 8:
                runCircularArray();
                break;
            case 9:
                runMLinkedList();
                break;
            case 10:
                runFibonacci();
                break;
        }
    }

    /**
     * There's a street with N spaces and there cars and buses can be parked.
     * A car takes 1 slot and a bus takes 2 slots.
     * Given the number of slots available in the street, how many combinations of cars and buses parked can be?
     * Data:
     * car: 1 slot
     * bus: 2 slot
     * street: N spaces
     * ====
     * Examples:
     * 1 slot   (1 combination)  : car
     * 2 slots  (2 combinations) : car car - bus
     * 3 slots  (3 combinations) : car car car - car bus - bus car
     * 4 slots  (5 combinations) : car car car car - car car bus - car bus car - bus car car - bus bus
     * 5 slots  (8 combinations) : car car car car car - car car car bus - car car bus car - car bus car car - bus car car car - bus bus car - bus car bus - car bus bus
     * 6 slots  (13 combinations)
     * So, as the series goes on, this is the fibonacci sequence, starting it from 1.
     * See: <a href="https://en.wikipedia.org/wiki/Fibonacci_number">Fibonacci Number</a>
     */
    private static void runFibonacci() {
        var f = new Fibonacci();
        out.println("expected: 1, actual: " + f.nThNumber(1));
        out.println("expected: 2, actual: " + f.nThNumber(2));
        out.println("expected: 3, actual: " + f.nThNumber(3));
        out.println("expected: 5, actual: " + f.nThNumber(4));
        out.println("expected: 8, actual: " + f.nThNumber(5));
        out.println("expected: 13, actual: " + f.nThNumber(6));
        out.println("expected: 21, actual: " + f.nThNumber(7));
        out.println("expected: 34, actual: " + f.nThNumber(8));
    }

    private static void runMLinkedList() {
        MLinkedList<Integer> linkedList = new MLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(7);
        linkedList.add(21);

        out.println("expected: 21, actual: " + linkedList.nElementFromTail(1));
        out.println("expected: 7, actual: " + linkedList.nElementFromTail(2));
        out.println("expected: null, actual: " + linkedList.nElementFromTail(51));
    }

    private static void runCircularArray() {
        CircularArray<Integer> array = new CircularArray<>(1, 2, 3, 4, 5, 6, 7);
        array.rotate(5);
        StringBuilder rotated = new StringBuilder();
        for (Integer integer : array) {
            rotated.append(integer);
        }
        out.println("case 1 - expected: 6712345,  actual: " + rotated);

        array = new CircularArray<>(1, 2, 3, 4, 5, 6, 7);
        array.rotate(-3);
        rotated = new StringBuilder();
        for (Integer integer : array) {
            rotated.append(integer);
        }
        out.println("case 2 - expected: 5671234, actual: " + rotated);

    }

    private static void runTreeHeightProblem() {
        Node<String> root = null;
        out.println("null (expected -1): " + getTreeHeight(root));

        root = new Node<>("");
        out.println("root with no children (expected 0): " + getTreeHeight(root));

        root = new Node<>("", new Node<>(""), null);
        out.println("root with a left child (expected 1): " + getTreeHeight(root));

        root = new Node<>("", null, new Node<>(""));
        out.println("root with a right child (expected 1): " + getTreeHeight(root));

        root = new Node<>("", null, new Node<>("", new Node<>(""), null));
        out.println("root with a right child with left child (expected 2): " + getTreeHeight(root));
    }
}



