package benchmarks.collections.people;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Write a benchmark with JMH (already in class path) for the somethingIsNoYesBenchmark method.
 * 10 warmups, 10 iterations, 1 thread.
 * The method is horribly slow - try to figure out how to speed it up.
 *
 * @author Dominik_Janiga
 */

public class Main {

    public static void main(String[] args)  {

    }

    public void somethingIsNoYesBenchmark() {

        Set<Person> people = new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            people.add(new Person("Name" + i, "Surname" + i, 20));
        }
    }
}
