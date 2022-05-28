package main.java;

import main.java.excersices.circulararray.CircularArray;
import main.java.excersices.personfilter.Person;
import main.java.excersices.personfilter.PersonController;
import main.java.excersices.treeheight.Node;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;
import static main.java.excersices.commonword.CommonWordController.findMostCommonWordIn;
import static main.java.excersices.groupsinsecuence.GroupController.getLengthOfLargestGroupInSequence;
import static main.java.excersices.groupsinsecuence.GroupController.getNumberOfGroupsInSequence;
import static main.java.excersices.groupsinsecuence.GroupController.getNumberOfGroupsOfCustomSizeInSequence;
import static main.java.excersices.treeheight.TreeController.getTreeHeight;
import static main.java.excersices.wall.WallController.canWeBuildAWallOfSizeFrom;
import static main.java.excersices.wall.WallController.getNumberOfRequiredBricksToBuildAWallOfSize;

/**
 * This class is only the program runner. To see the implementation logic for each problem see the other classes in each
 * independent packages.
 */
public final class Main {
    private static final int TOP_AGE_FOR_YOUNG_PEOPLE = 30;

    private Main() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            err.println("Select a number from 1 to 8 to run an algorithm");
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
            case 1:
                runPersonProblem();
                break;
            case 2:
                runGetLargestGroupInNumberSequence();
                break;
            case 3:
                runGetNumberOfGroupsInNumberSequence();
                break;
            case 4:
                runGetNumberOfGroupsOfCustomSizeInSequence();
                break;
            case 5:
                runWallProblemVariant1();
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
            default:
                runWallProblemVariant2();
        }
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

    private static void runPersonProblem() {
        List<Person> people = Arrays.asList(
                new Person("Victor - Not young not cool", TOP_AGE_FOR_YOUNG_PEOPLE + 1, Person.Coolness.NOT_COOL),
                new Person("Victor - Not young cool", TOP_AGE_FOR_YOUNG_PEOPLE + 1, Person.Coolness.COOL),
                new Person("Victor- Not young very cool", TOP_AGE_FOR_YOUNG_PEOPLE + 1, Person.Coolness.VERY_COOL),
                new Person("Victor- In young threshold not cool", TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.NOT_COOL),
                new Person("Victor- In young threshold cool", TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.COOL),
                new Person("Victor- In young threshold very cool", TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.VERY_COOL),
                new Person("Victor- Young not cool", TOP_AGE_FOR_YOUNG_PEOPLE - 1, Person.Coolness.NOT_COOL),
                new Person("Victor- Young cool", TOP_AGE_FOR_YOUNG_PEOPLE - 1, Person.Coolness.COOL),
                new Person("Victor- Young very cool", TOP_AGE_FOR_YOUNG_PEOPLE - 1, Person.Coolness.VERY_COOL)
                                           );

        out.println("Young people: " + PersonController.getNameOfYoungPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE));
        out.println("Young people (min level of coolness: not cool): " + PersonController.getNameOfYoungCoolPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.NOT_COOL));
        out.println("Young people (min level of coolness: cool): " + PersonController.getNameOfYoungCoolPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.COOL));
        out.println("Young people (min level of coolness: very cool): " + PersonController.getNameOfYoungCoolPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE, Person.Coolness.COOL));
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

    private static void runWallProblemVariant1() {
        out.println("bb: 0, sm: 0, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(0, 0, 0));
        out.println("bb: 1, sm: 0, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(1, 0, 0));
        out.println("bb: 0, sm: 1, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(0, 1, 0));
        out.println("bb: 0, sm: 0, w: 1 (expected false): " + canWeBuildAWallOfSizeFrom(0, 0, 1));
        out.println("bb: 1, sm: 0, w: 4 (expected false): " + canWeBuildAWallOfSizeFrom(1, 0, 4));
        out.println("bb: 1, sm: 0, w: 5 (expected true): " + canWeBuildAWallOfSizeFrom(1, 0, 5));
        out.println("bb: 1, sm: 0, w: 6 (expected false): " + canWeBuildAWallOfSizeFrom(1, 0, 6));
        out.println("bb: 0, sm: 1, w: 1 (expected true): " + canWeBuildAWallOfSizeFrom(0, 1, 1));
        out.println("bb: 0, sm: 1, w: 2 (expected false): " + canWeBuildAWallOfSizeFrom(0, 1, 2));
        out.println("bb: 1, sm: 1, w: 4 (expected false): " + canWeBuildAWallOfSizeFrom(1, 1, 4));
        out.println("bb: 1, sm: 1, w: 6 (expected true): " + canWeBuildAWallOfSizeFrom(1, 1, 6));
        out.println("bb: 1, sm: 1, w: 7 (expected false): " + canWeBuildAWallOfSizeFrom(1, 1, 7));
        out.println("bb: 1, sm: 1, w: 5 (expected true): " + canWeBuildAWallOfSizeFrom(1, 1, 5));
        out.println("bb: 1, sm: 1, w: 1 (expected true): " + canWeBuildAWallOfSizeFrom(1, 1, 1));
    }

    private static void runWallProblemVariant2() {
        int bbSize = 10;
        int sbSize = 7;

        out.println("w: 0 (expected [0, 0]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 0)));
        out.println("w: 0 (expected [0, 0]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 0)));
        out.println("w: 0 (expected [0, 0]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 0)));
        out.println("w: 1 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 1)));
        out.println("w: 4 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 4)));
        out.println("w: 10 (expected [1, 0): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 10)));
        out.println("w: 11 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 11)));
        out.println("w: 7 (expected [0, 1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 7)));
        out.println("w: 2 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 2)));
        out.println("w: 4 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 4)));
        out.println("w: 17 (expected [1, 1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 17)));
        out.println("w: 18 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 18)));
        out.println("w: 10 (expected [1, 0]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 10)));
        out.println("w: 19 (expected [-1, -1]): " + Arrays.toString(getNumberOfRequiredBricksToBuildAWallOfSize(bbSize, sbSize, 19)));
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



