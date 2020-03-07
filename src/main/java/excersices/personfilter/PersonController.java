package main.java.excersices.personfilter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class PersonController {
    private PersonController() {
    }

    public static List<String> getNameOfYoungCoolPeople(Collection<? extends Person> people, int ageOfYoungPeople,
                                                        Person.Coolness howMuchCoolPersonShouldBe) {
        return getPropertyFromList(people, p -> p.isYoung(ageOfYoungPeople) && p.isCool(howMuchCoolPersonShouldBe),
                Person::getName);
    }

    public static List<String> getNameOfYoungPeople(Collection<? extends Person> people, int ageOfYoungPeople) {
        return getPropertyFromList(people, p -> p.isYoung(ageOfYoungPeople), Person::getName);
    }

    private static <R> List<R> getPropertyFromList(Collection<? extends Person> list,
                                                   Predicate<? super Person> predicate,
                                                   Function<? super Person, ? extends R> mapperFunction) {
        return list
                .stream()
                .filter(predicate)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

}
