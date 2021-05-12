package benchmarks.collections.people;

import java.util.Objects;

class Person {

   private final String name;
   private final String surname;
   private final int age;

   Person(String name, String surname, int age) {
      this.name = name;
      this.surname = surname;
      this.age = age;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return age == person.age
              && Objects.equals(name, person.name)
              && Objects.equals(surname, person.surname);
   }

   @Override
   public int hashCode() {
      return Objects.hash(age);
   }
}
