package main.java.excersices.personfilter;

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
        return age <= ageThreshold;
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

}
