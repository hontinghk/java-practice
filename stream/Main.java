import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // map - get a name list of people
        List<String> names = people.stream().map(Person::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        // reduce - get the sum of age of people
        int ageSum = people.stream().map(Person::getAge).reduce(0, (subtotal, age) -> subtotal + age);
        System.out.println(ageSum);

        // filter - get person list with all male
        List<Person> males = people.stream().filter(person -> person.getGender() == Gender.MALE)
                .collect(Collectors.toList());
        males.forEach(System.out::println);

        // sort - get the name list sorted by age
        List<String> namesSortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .map(person -> person.getName())
                .collect(Collectors.toList());
        namesSortedByAge.forEach(System.out::println);

        // min/max - get the oldest person
        Optional<Person> oldest = people.stream().max(Comparator.comparingInt(Person::getAge));
        oldest.ifPresent(System.out::println);

        // groupingBy - get the people grouping by gender
        Map<Gender, List<Person>> peopleByGender = people.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println(peopleByGender);

    }

    static List<Person> getPeople() {
        return List.of(
                new Person("Jakob Hawkins", 5, Gender.MALE),
                new Person("Sanaa Wall", 63, Gender.FEMALE),
                new Person("Amna Parker", 17, Gender.FEMALE),
                new Person("Callan Whitney", 47, Gender.MALE),
                new Person("Jason Cain", 86, Gender.MALE),
                new Person("Jannat Young", 46, Gender.FEMALE),
                new Person("Tessa Gonzalez", 33, Gender.FEMALE),
                new Person("Subhan Sosa", 13, Gender.MALE),
                new Person("Emily Whitaker", 77, Gender.FEMALE),
                new Person("Raihan Wilcox", 19, Gender.MALE));
    }

}
