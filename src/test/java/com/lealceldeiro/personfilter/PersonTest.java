package com.lealceldeiro.personfilter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {
    private static final Random RANDOM = new SecureRandom();

    private static String name() {
        return UUID.randomUUID().toString();
    }

    private static int age() {
        return RANDOM.nextInt(150);
    }

    @Test
    void isCool() {
        Person person = new Person(name(), age(), Person.Coolness.COOL);

        assertTrue(person.isCool(Person.Coolness.COOL));
        assertFalse(person.isCool(Person.Coolness.VERY_COOL));
    }

    @Test
    void isYoung() {
        var ageRef = age();
        Person person = new Person(name(), ageRef, Person.Coolness.COOL);
        assertTrue(person.isYoung(ageRef + 1));
        assertTrue(person.isYoung(ageRef));
        assertFalse(person.isYoung(ageRef - 1));
    }

    @Test
    void testEquals() {
        var sameAge = age();
        var sameName = name();
        Person person1 = new Person(sameName, sameAge, Person.Coolness.NOT_COOL);
        Person person2 = new Person(sameName, sameAge, Person.Coolness.COOL);
        Person person3 = new Person(sameName, sameAge, Person.Coolness.VERY_COOL);
        Person person4 = new Person(sameName, age(), Person.Coolness.COOL);
        Person person5 = new Person(name(), sameAge, Person.Coolness.COOL);
        Object person6 = new Object();

        assertEquals(person1, person1);
        assertEquals(person1.hashCode(), person1.hashCode());
        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person1, person3);
        assertEquals(person1.hashCode(), person3.hashCode());
        assertNotEquals(person1, person4);
        assertNotEquals(person1.hashCode(), person4.hashCode());
        assertNotEquals(person1, person5);
        assertNotEquals(person1.hashCode(), person5.hashCode());
        assertNotEquals(person1, person6);
        assertNotEquals(person1.hashCode(), person6.hashCode());
    }
}