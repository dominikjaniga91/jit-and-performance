package collections.people;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class People {

    static Set<Person> generate() {
        return Stream.iterate(1, i -> i + 1)
                .limit(100)
                .map(i -> new Person("Name" + i, "Suername" + i, 20))
                .collect(Collectors.toSet());
    }
}
