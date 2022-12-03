package lambda1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

    public static class Person {
        private String name;
        private int age;
        private int count;

        public Person(String name, int age, int count) {
            this.name = name;
            this.age = age;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();

        for(int i=0; i<100; i++) {
            personList.add(new Person("name"+i, i, i*2));
        }

        List<Person> persons = personList.stream().filter(t -> t.getName().startsWith("name"))
                .filter(t -> t.getAge() > 20)
                .filter(t -> t.getCount() > 45)
                .collect(Collectors.toList());

        System.out.println("persons.size() = " + persons.size());

    }



}
