package com.lealceldeiro.personfilter;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;
    private final Coolness coolness;

    public Person(String name, int age, Coolness coolness) {
        this.name = name;
        this.age = age;
        this.coolness = coolness;
    }

    String getName() {
        return name;
    }

    boolean isCool(Coolness coolnessLevel) {
        return coolness.isCool(coolnessLevel);
    }

    boolean isYoung(int ageThreshold) {
        return getAge() <= ageThreshold;
    }

    public int getAge() {
        return age;
    }

    public enum Coolness {
        NOT_COOL(0),
        COOL(1),
        VERY_COOL(2);

        final int coolnessIndicator;

        Coolness(int coolnessIndicator) {
            this.coolnessIndicator = coolnessIndicator;
        }

        boolean isCool (Coolness coolnessLevel) {
            // I am cool if my level of coolness is equals or bigger than the requested level
            return coolnessIndicator >= coolnessLevel.coolnessIndicator;
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return getAge() == person.getAge() && getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }
}
