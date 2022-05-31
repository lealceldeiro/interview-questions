package com.lealceldeiro;

import com.lealceldeiro.circulararray.CircularArray;
import com.lealceldeiro.fibonacci.Fibonacci;
import com.lealceldeiro.linkedlist.MLinkedList;
import com.lealceldeiro.treeheight.Node;

import static com.lealceldeiro.commonword.CommonWordController.findMostCommonWordIn;
import static com.lealceldeiro.groupsinsecuence.GroupController.getLengthOfLargestGroupInSequence;
import static com.lealceldeiro.groupsinsecuence.GroupController.getNumberOfGroupsInSequence;
import static com.lealceldeiro.groupsinsecuence.GroupController.getNumberOfGroupsOfCustomSizeInSequence;
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
            case 2:
                runGetLargestGroupInNumberSequence();
                break;
            case 3:
                runGetNumberOfGroupsInNumberSequence();
                break;
            case 4:
                runGetNumberOfGroupsOfCustomSizeInSequence();
                break;
            case 6:
                runMostCommonWordProblem();
                break;
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

    private static void runGetLargestGroupInNumberSequence() {
        out.println("[] (expected 0): " + getLengthOfLargestGroupInSequence());
        out.println("[1] (expected 0): " + getLengthOfLargestGroupInSequence(1));
        out.println("[1,1] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1));
        out.println("[2,1,1] (expected 2): " + getLengthOfLargestGroupInSequence(2, 1, 1));
        out.println("[1,2,1] (expected 0): " + getLengthOfLargestGroupInSequence(1, 2, 1));
        out.println("[1,1,2] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1, 2));
        out.println("[1,1,2,2] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1, 2, 2));
        out.println("[3,1,1,2,2] (expected 2): " + getLengthOfLargestGroupInSequence(3, 1, 1, 2, 2));
        out.println("[1,1,3,2,2] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1, 3, 2, 2));
        out.println("[1,1,2,2,3] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1, 2, 2, 3));
        out.println("[1,1,2,2,3,3] (expected 2): " + getLengthOfLargestGroupInSequence(1, 1, 2, 2, 3, 3));
        out.println("[1,1,2,2,3,3,3 (expected 3): " + getLengthOfLargestGroupInSequence(1, 1, 2, 2, 3, 3, 3));
    }

    private static void runGetNumberOfGroupsInNumberSequence() {
        out.println("[] (expected 0): " + getNumberOfGroupsInSequence());
        out.println("[1] (expected 0): " + getNumberOfGroupsInSequence(1));
        out.println("[1,1] (expected 1): " + getNumberOfGroupsInSequence(1, 1));
        out.println("[2,1,1] (expected 1): " + getNumberOfGroupsInSequence(2, 1, 1));
        out.println("[1,2,1] (expected 0): " + getNumberOfGroupsInSequence(1, 2, 1));
        out.println("[1,1,2] (expected 1): " + getNumberOfGroupsInSequence(1, 1, 2));
        out.println("[1,1,2,2] (expected 2): " + getNumberOfGroupsInSequence(1, 1, 2, 2));
        out.println("[3,1,1,2,2] (expected 2): " + getNumberOfGroupsInSequence(3, 1, 1, 2, 2));
        out.println("[1,1,3,2,2] (expected 2): " + getNumberOfGroupsInSequence(1, 1, 3, 2, 2));
        out.println("[1,1,2,2,3] (expected 2): " + getNumberOfGroupsInSequence(1, 1, 2, 2, 3));
        out.println("[1,1,2,2,3,3] (expected 3): " + getNumberOfGroupsInSequence(1, 1, 2, 2, 3, 3));
        out.println("[1,1,2,2,3,3,3] (expected 3): " + getNumberOfGroupsInSequence(1, 1, 2, 2, 3, 3, 3));
    }

    private static void runGetNumberOfGroupsOfCustomSizeInSequence() {
        out.println("0, [] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(0));
        out.println("0, [1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(0, 1));
        out.println("0, [1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(0, 1, 1));
        out.println("0, [1,1,2] (expected 2): " + getNumberOfGroupsOfCustomSizeInSequence(0, 1, 1, 2));
        out.println("0, [1,2,1] (expected 3): " + getNumberOfGroupsOfCustomSizeInSequence(0, 1, 2, 1));

        out.println("1, [] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(1));
        out.println("1, [1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(1, 1));
        out.println("1, [1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(1, 1, 1));

        out.println("2, [1] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(2, 1));
        out.println("2, [1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(2, 1, 1));
        out.println("2, [1,1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(2, 1, 1, 2));
        out.println("3, [1,1] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1));
        out.println("3, [1,1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1));
        out.println("3, [4,1,1,1] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(3, 4, 1, 1, 1));
        out.println("3, [1,4,1,1] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 4, 1, 1));
        out.println("3, [1,1,4,1] (expected 0): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 4, 1));
        out.println("3, [1,1,1,4] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1, 4));
        out.println("3, [1,1,1,4,4,4] (expected 2): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1, 4, 4, 4));
        out.println("3, [7,1,1,1,4,4,4] (expected 2): " + getNumberOfGroupsOfCustomSizeInSequence(3, 7, 1, 1, 1, 4, 4, 4));
        out.println("3, [1,1,1,7, 4,4,4] (expected 2): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1, 7, 4, 4, 4));
        out.println("3, [1,1,1,4,4,4,7] (expected 2): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1, 4, 4, 4, 7));
        out.println("3, [1,1,7,1,4,4,4] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 7, 1, 4, 4, 4));
        out.println("3, [1,1,1,4,4,7,4] (expected 1): " + getNumberOfGroupsOfCustomSizeInSequence(3, 1, 1, 1, 4, 4, 7, 4));
    }

    private static void runMostCommonWordProblem() {
        out.println("'', '' (expected null): " + findMostCommonWordIn("", ""));
        out.println("'a', 'a' (expected null): " + findMostCommonWordIn("a", "a"));
        out.println("'A', 'a' (expected null): " + findMostCommonWordIn("A", "a"));
        out.println("'a', 'A' (expected null): " + findMostCommonWordIn("a", "A"));
        out.println("'a', 'b' (expected a): " + findMostCommonWordIn("a", "b"));
        out.println("'a, b', 'b' (expected a): " + findMostCommonWordIn("a,b", "b"));
        out.println("'a, b', 'a,b' (expected null): " + findMostCommonWordIn("a,b", "a,b"));
        out.println("'a b', 'a b' (expected null): " + findMostCommonWordIn("a b", "a b"));
        out.println("'a, b', 'a, b' (expected null): " + findMostCommonWordIn("a, b", "a, b"));
        out.println("'a a b', 'x y' (expected a): " + findMostCommonWordIn("a a b", "x y"));
        out.println("'a b a', 'x y' (expected a): " + findMostCommonWordIn("a b a", "x y"));
        out.println("'b a a', 'x y' (expected a): " + findMostCommonWordIn("b a a", "x y"));
        out.println("'a b', 'x y' (expected a): " + findMostCommonWordIn("a b", "x y"));
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



