package com.lealceldeiro.personfilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.lealceldeiro.personfilter.Person.Coolness.COOL;
import static com.lealceldeiro.personfilter.Person.Coolness.NOT_COOL;
import static com.lealceldeiro.personfilter.Person.Coolness.VERY_COOL;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonControllerTest {
    public static final Random RANDOM = new SecureRandom();
    private static final int TOP_AGE_FOR_YOUNG_PEOPLE = RANDOM.nextInt();

    private static final Person notYoungNotCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE + 1, NOT_COOL);
    private static final Person notYoungCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE + 1, COOL);
    private static final Person notYoungVeryCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE + 1, VERY_COOL);
    private static final Person atYoungThresholdNotCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE, NOT_COOL);
    private static final Person atYoungThresholdCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE, COOL);
    private static final Person atYoungThresholdVeryCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE, VERY_COOL);
    private static final Person youngNotCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE - 1, NOT_COOL);
    private static final Person youngCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE - 1, COOL);
    private static final Person youngVeryCool = new Person(name(), TOP_AGE_FOR_YOUNG_PEOPLE - 1, VERY_COOL);

    private static final Collection<Person> youngPeople
            = asList(youngNotCool, youngCool, youngVeryCool, atYoungThresholdNotCool, atYoungThresholdCool,
                     atYoungThresholdVeryCool);
    private static final Collection<Person> notYoungPeople = asList(notYoungNotCool, notYoungCool, notYoungVeryCool);
    private static final Collection<Person> coolPeople = asList(notYoungCool, notYoungVeryCool, atYoungThresholdCool,
                                                                atYoungThresholdVeryCool, youngCool, youngVeryCool);
    private static final Collection<Person> notCoolPeople = asList(notYoungNotCool, atYoungThresholdNotCool,
                                                                   youngNotCool);
    private static final Collection<Person> people
            = asList(notYoungNotCool, notYoungCool, notYoungVeryCool, atYoungThresholdNotCool, atYoungThresholdCool,
                     atYoungThresholdVeryCool, youngNotCool, youngCool, youngVeryCool);

    private static String name() {
        return UUID.randomUUID().toString();
    }

    @Test
    void getNameOfYoungCoolPeople() {
        var nameOfYoungCoolPeople = PersonController.getNameOfYoungCoolPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE, COOL);
        assertTrue(youngPeople.stream().map(Person::getName).collect(toSet()).containsAll(nameOfYoungCoolPeople));
        assertTrue(coolPeople.stream().map(Person::getName).collect(toSet()).containsAll(nameOfYoungCoolPeople));

        assertTrue(notYoungPeople.stream().map(Person::getName).noneMatch(nameOfYoungCoolPeople::contains));
        assertTrue(notCoolPeople.stream().map(Person::getName).noneMatch(nameOfYoungCoolPeople::contains));
    }

    @Test
    void getNameOfYoungPeople() {
        var nameOfYoungPeople = PersonController.getNameOfYoungPeople(people, TOP_AGE_FOR_YOUNG_PEOPLE);
        assertTrue(youngPeople.stream().map(Person::getName).collect(toSet()).containsAll(nameOfYoungPeople));
        assertTrue(notYoungPeople.stream().map(Person::getName).noneMatch(nameOfYoungPeople::contains));
    }
}