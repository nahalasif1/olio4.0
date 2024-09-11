import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", city='" + city + "'}";
    }
}

public class SortAndFilter {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mikko", 30, "Helsinki"));
        people.add(new Person("Sofia", 25, "Tampere"));
        people.add(new Person("Ville", 35, "Oulu"));
        people.add(new Person("Elsa", 28, "Turku"));

        Collections.sort(people, Comparator.comparingInt(Person::getAge));

        String cityToFilter = "Helsinki";
        List<Person> filteredPeople = new ArrayList<>();
        for (Person person : people) {
            if (person.getCity().equals(cityToFilter)) {
                filteredPeople.add(person);
            }
        }

        System.out.println("Sorted List by Age:");
        for (Person person : people) {
            System.out.println(person);
        }

        System.out.println("\nFiltered List by City (" + cityToFilter + "):");
        for (Person person : filteredPeople) {
            System.out.println(person);
        }
    }
}