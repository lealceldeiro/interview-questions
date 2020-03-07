package main.java;

import main.java.excersices.personfilter.Person;
import main.java.excersices.personfilter.PersonController;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.err;
import static java.lang.System.exit;
import static java.lang.System.out;
import static main.java.excersices.groupsinsecuence.GroupController.getLengthOfLargestGroupInSequence;
import static main.java.excersices.groupsinsecuence.GroupController.getNumberOfGroupsInSequence;
import static main.java.excersices.groupsinsecuence.GroupController.getNumberOfGroupsOfCustomSizeInSequence;
import static main.java.excersices.wall.WallController.canWeBuildAWallOfSizeFrom;

public final class Main {
    private static final int TOP_AGE_FOR_YOUNG_PEOPLE = 30;
    private Main() {
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            err.println("Select a number from 1 to 5 to run an algorithm");
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
                runGetNumberOfGroupInNumberSequence();
                break;
            case 4:
                runGetNumberOfGroupOfCustomSizeInSequence();
                break;
            default:
                runWallProblem();
        }
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

    private static void runGetNumberOfGroupInNumberSequence() {
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

    private static void runGetNumberOfGroupOfCustomSizeInSequence() {
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

    private static void runWallProblem() {
        int bbSize = 5;
        int sbSize = 1;

        out.println("bb: 0, sm: 0, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(0, bbSize, 0, sbSize, 0));
        out.println("bb: 1, sm: 0, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(1, bbSize, 0, sbSize, 0));
        out.println("bb: 0, sm: 1, w: 0 (expected true): " + canWeBuildAWallOfSizeFrom(0, bbSize, 1, sbSize, 0));
        out.println("bb: 0, sm: 0, w: 1 (expected false): " + canWeBuildAWallOfSizeFrom(0, bbSize, 0, sbSize, 1));
        out.println("bb: 1, sm: 0, w: 4 (expected false): " + canWeBuildAWallOfSizeFrom(1, bbSize, 0, sbSize, 4));
        out.println("bb: 1, sm: 0, w: 5 (expected true): " + canWeBuildAWallOfSizeFrom(1, bbSize, 0, sbSize, 5));
        out.println("bb: 1, sm: 0, w: 6 (expected false): " + canWeBuildAWallOfSizeFrom(1, bbSize, 0, sbSize, 6));
        out.println("bb: 0, sm: 1, w: 1 (expected true): " + canWeBuildAWallOfSizeFrom(0, bbSize, 1, sbSize, 1));
        out.println("bb: 0, sm: 1, w: 2 (expected false): " + canWeBuildAWallOfSizeFrom(0, bbSize, 1, sbSize, 2));
        out.println("bb: 1, sm: 1, w: 4 (expected false): " + canWeBuildAWallOfSizeFrom(1, bbSize, 1, sbSize, 4));
        out.println("bb: 1, sm: 1, w: 6 (expected true): " + canWeBuildAWallOfSizeFrom(1, bbSize, 1, sbSize, 6));
        out.println("bb: 1, sm: 1, w: 7 (expected false): " + canWeBuildAWallOfSizeFrom(1, bbSize, 1, sbSize, 7));
        out.println("bb: 1, sm: 1, w: 5 (expected true): " + canWeBuildAWallOfSizeFrom(1, bbSize, 1, sbSize, 5));
        out.println("bb: 1, sm: 1, w: 1 (expected true): " + canWeBuildAWallOfSizeFrom(1, bbSize, 1, sbSize, 1));
    }
}



